package cn.com.BaseFrame.Controller;

import cn.com.BaseFrame.BaseUtils.BeanUtils.BeanUtils;
import cn.com.BaseFrame.BaseUtils.StringUtils.StringUtils;
import cn.com.BaseFrame.Pojo.BaseControllerContext;
import cn.com.BaseFrame.Pojo.BaseServiceParamModel;
import cn.com.BaseFrame.Pojo.BaseServiceResultModel;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * controller基础类
 *
 * @author xyh
 * @create 2018-02-23 22:18
 **/
public class BaseController extends BaseDispatcherController {
    /**
     *  在每次执行方法之前,都要先来调用这里,这里就需要考虑要传递哪些参数.
     *      1.要执行的方法。
     *          参数 : 执行方法的类 : Class clazz : 需要执行方法类的Class
     *                要执行的方法名称 ： String methodName
     *                可能方法重载了,所以要通过参数来确定 : paramModel（因为所有的参数类都继承自BaseParamModel,所以传递一个BaseParamModel即可）
     *
     *      2.在方法执行前要进行哪些判断
     *          A.判断用户是否有权限执行该方法
     *              只接从Redis缓存中取值
     *
     *
     */

    public BaseServiceResultModel invokeMethod(Class clazz, String methodName, BaseServiceParamModel paramModel){
        //获取到需要执行方法的实体类
        Object object = BeanUtils.getBean(clazz);

        beforeInvoke();

        try {
            //获取到对应的方法
            Method method = clazz.getMethod(methodName,paramModel.getClass());

            /**
             *  执行service中的方法
             */
            BaseServiceResultModel srModel = (BaseServiceResultModel) method.invoke(object,paramModel);

            afterInvoke();

            return srModel;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     *  @Description: 在方法调用之前执行
     *  @author xyh
     *  @Date 22:57 2018/3/5
     *  @method beforeInvoke
     *  params  
     *  @return 
     *  @exception 
     **/
    public void beforeInvoke() {
    
    }
    
    /**
     *  @Description: 在方法调用之后执行
     *  @author xyh
     *  @Date 22:57 2018/3/5
     *  @method afterInvoke
     *  params  
     *  @return 
     *  @exception 
     **/
    public void afterInvoke() {

    }

    public <T extends BaseServiceParamModel> T getSpModel(HttpServletRequest request,Class<T> clazz) {
        /**
         *  这里就需要把request传递过来的参数封装到spModel里面
         */
        try {
            if(clazz.isAssignableFrom(BaseServiceParamModel.class)) {
                //获取到类中的属性
                Field[] fields = clazz.getFields();

                //创建一个实例化对象
                T t = clazz.newInstance();
                t.setRequest(request);

                //获取到request中的所有参数
                Map<String, Object> parameterMap = request.getParameterMap();

                if (fields != null && fields.length > 0) {
                    for(Field field : fields) {

                        String fieldName = field.getName(); //获取到属性的名称

                        if(parameterMap.containsKey(fieldName)) {
                            String methodName = "set" + StringUtils.subString(fieldName);

                            Method method = clazz.getMethod(methodName,field.getType()); //获取到方法对象

                            method.invoke(t,parameterMap.get(fieldName));//执行赋值
                        }else {
                            continue;
                        }
                    }
                    return t;
                }else {
                    return clazz.newInstance();
                }
            }else {
                throw new RuntimeException("传递的不是一个BaseServiceParamModel");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
