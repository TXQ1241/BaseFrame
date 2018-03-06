package cn.com.BaseFrame.Interceptor;

import cn.com.BaseFrame.pojo.BaseControllerContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * 封装BaseControllerContext的拦截器
 *
 * @author xyh
 * @create 2018-03-05 23:25
 **/
public class EncapsulationContext extends HandlerInterceptorAdapter {

    /**
     *  @Description: 在进入Handler方法之前执行,判断是否登录.
     *  @author xyh
     *  @Date 23:26 2018/3/5
     *  @method
     *  params
     *  @return
     *  @exception
     **/
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String UUID = (String)session.getAttribute("UUID");
        UUID = "123";
        if(UUID != null && !"".equals(UUID)) {
            /**
             * 一个类Class1和另一个类Class2是否相同或是另一个类的子类或接口。
             *      判断handler和HandlerMethod是否相同,或者handler是不是HandlerMethod的子类或者接口
             */
            if(handler.getClass().isAssignableFrom(HandlerMethod.class)) {
                //强转
                HandlerMethod handlerMethod = (HandlerMethod)handler;


                //获取到要执行的方法
                Method method = handlerMethod.getMethod();

                //要执行方法的参数
                Class[] ParameterTypes = method.getParameterTypes();

                //获取到参数的类
                Class clazz = ParameterTypes[0];

                if("BaseControllerContext".equals(clazz.getName())) {
                    //就把这个对象实例化,然后传递过去
                    BaseControllerContext context = (BaseControllerContext) clazz.getConstructor(clazz).newInstance(request,session,session.getServletContext());

                }
            }
            return true;
        }else {
            //如果没有登录,就返回到登录的页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return false;
        }


    }

    /**
     *  @Description: 进入Handler方法之后，返回ModelAndView之前执行
     *  @author xyh
     *  @Date 23:27 2018/3/5
     *  @method
     *  params
     *  @return
     *  @exception
     **/
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /**
         *  在进入方法之后,返回页面之前执行
         *      其实就是在controller里面的方法执行完毕,在return之前执行
         */
        System.out.print(handler.toString());
    }

    /**
     *  @Description: 在执行Handler完成后执行此方法，使用于统一的异常处理
     *  @author xyh
     *  @Date 23:27 2018/3/5
     *  @method
     *  params
     *  @return
     *  @exception
     **/
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        /**
         *  在controller的return之前执行
         *      在这里适合做一个日志的记录,记录下用户的所有操作,但是这样日志就会显得很大,不方便查看
         */
    }
}
