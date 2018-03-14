package cn.com.BaseFrame.BaseUtils.BeanUtils;

import cn.com.BaseFrame.BaseUtils.StringUtils.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * POJO工具类
 *
 * @author xyh
 * @create 2018-02-22 12:35
 **/
public class BeanUtils implements Serializable {
    private static Object target;

    /**
     * @return 单例的实例化
     * @throws InstantiationException,IllegalAccessException
     * @Description: 获取到某个类的实例化
     * @author xyh
     * @Date 13:38 2018/2/22
     * @method getBean
     * params  clazz 需要获取实例化的class
     **/
    public static Object getBean(Class clazz) {
        return compare(target, clazz, true); //默认为true
    }

    /**
     * @return
     * @throws
     * @Description: 获取到类的实例化.flag为true表示为单例
     * @author xyh
     * @Date 16:47 2018/3/5
     * @method params
     **/
    public static Object getBean(Class clazz, boolean flag) {
        return compare(target, clazz, flag);
    }

    /**
     * @return 实例化对象
     * @throws
     * @Description: 判断需要实例化的对象是否已经存在
     * @author xyh
     * @Date 13:39 2018/2/22
     * @method compare
     * params  target 目标对象,clazz 需要实例化的class
     **/
    public static Object compare(Object target, Class clazz, boolean flag) {
        String className = clazz.getName();
        //判断这个对象是不是已经存在,如果存在,那么返回,不存在则新建对象
        try {
            if (clazz.isInterface()) {
                //如果是接口,返回接口的实现类
                throw new RuntimeException("需要传递一个class而非一个interface");
            } else {
                if (flag) {
                    //表明是单例
                    if (target != null) {
                        if (className.equals(target.getClass().getName())) {
                            return target;
                        }
                    }
                    return clazz.newInstance();
                }
                return clazz.newInstance();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * @return 目标对象
     * @throws
     * @Description: 复制
     * @author xyh
     * @Date 13:40 2018/2/22
     * @method coprProperties
     * params  sourceModel 源对象,targetModel 目标对象,flag 判断如果目标对象原来有值,是否需要继续赋值
     **/
    public static Object coprProperties(Object sourceModel, Object targetModel, boolean flag) {
        Class sourceClass = sourceModel.getClass();
        Class targetClass = targetModel.getClass();

        Field[] sourceFields = sourceClass.getFields();

        for (Field sourceField : sourceFields) {
            String fieldName = sourceField.getName();
            Class fieldType = sourceField.getType();

            String getMethodName = "get" + StringUtils.subString(fieldName);
            String setMethodName = "set" + StringUtils.subString(fieldName);

            try {
                Method getMethod = sourceClass.getMethod(getMethodName);

                Method setMethod = targetClass.getMethod(setMethodName, fieldType); //根据类型去查找,如果类型不对,那么就不赋值

                //如果找到了,那么就执行
                try {
                    if (flag) {
                        //判断原来的是否有值,有值那么就不赋值,跳过
                        if (getMethod.invoke(targetModel) != null) {
                            continue;
                        } else {
                            setMethod.invoke(targetModel, getMethod.invoke(sourceModel));
                        }
                    } else {
                        setMethod.invoke(targetModel, getMethod.invoke(sourceModel));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                //如果没找到
                System.out.print("方法在执行中出问题 : " + e.getMessage());
                continue; //跳过这次循环,进行下一次
            }
        }
        return targetModel;
    }

    public static Object coprProperties(Object sourceModel, Object targetModel) {
        boolean flag = true;
        return coprProperties(sourceModel, targetModel, flag);
    }
}
