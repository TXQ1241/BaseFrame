package cn.com.BaseFrame.controller;

import cn.com.BaseFrame.BaseUtils.BeanUtils.BeanUtils;
import cn.com.BaseFrame.pojo.BaseParamModel;
import cn.com.BaseFrame.pojo.BaseResultModel;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

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
     *              如何判断,在数据库里面进行配置,然后再session中取值
     *
     *          B.用户是不是直接通过url直接来访问,跳过了登录这一步
     *
     */

    public BaseResultModel invokeMethod(Class clazz, String methodName, BaseParamModel paramModel, HttpServletRequest request, HttpServletResponse response){
        //获取到需要执行方法的实体类
        Object object = BeanUtils.getBean(clazz);

        //用户在登录成功之后,把数据库的配置取出来,存放进session中


        try {
            //获取到对应的方法
            Method method = clazz.getMethod(methodName,paramModel.getClass());

            BaseResultModel resultModel = (BaseResultModel) method.invoke(object,paramModel);

            /**
             * 由于session中存放的是配置表里面的值,不会发生变,所以不用刷新session的值
             *      如果改了其他数据库的值,那么直接通过数据库的flushSession刷新即可
             */

            return resultModel;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean checkRole(HttpServletRequest request,HttpServletResponse response) {
        /*
         * 当用户通过地址或者页面上的某一个按钮进入到登录的页面时，不创建Session
         *      在用户点击登录那个按钮时创建Session
         */
        request.getSession();
        ServletContext context = request.getSession().getServletContext();

        //不存在

        return true;
    }
}
