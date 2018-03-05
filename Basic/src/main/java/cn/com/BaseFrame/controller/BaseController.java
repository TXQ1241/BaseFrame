package cn.com.BaseFrame.controller;

import cn.com.BaseFrame.BaseUtils.BeanUtils.BeanUtils;
import cn.com.BaseFrame.pojo.BaseParamModel;
import cn.com.BaseFrame.pojo.BaseResultModel;
import java.lang.reflect.Method;

/**
 * controller基础类
 *
 * @author xyh
 * @create 2018-02-23 22:18
 **/
public class BaseController extends BaseDispatcherController {

    public BaseResultModel invokeMethod(Class clazz, String methodName, BaseParamModel paramModel){
        //获取到实体类
        Object object = BeanUtils.getBean(clazz);

        //在执行service中的方法之前执行一些方法
        System.out.print("方法执行之前执行");
        try {
            //获取到对应的方法
            Method method = clazz.getMethod(methodName,paramModel.getClass());

            try {
                BaseResultModel resultModel = (BaseResultModel) method.invoke(object,paramModel);
                System.out.print("方法执行完成执行");
                return resultModel;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
