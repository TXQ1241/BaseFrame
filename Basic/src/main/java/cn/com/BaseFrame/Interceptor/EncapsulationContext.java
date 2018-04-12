package cn.com.BaseFrame.Interceptor;

import cn.com.BaseFrame.Api.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 封装BaseControllerContext的拦截器
 *
 * @author xyh
 * @create 2018-03-05 23:25
 **/
public class EncapsulationContext implements HandlerInterceptor {

    /**
     * @return
     * @throws
     * @Description: 在进入Handler方法之前执行, 判断是否登录.
     * @author xyh
     * @Date 23:26 2018/3/5
     * @method params
     **/
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            return true;
        } else {
            //如果没有登录,就返回到登录的页面
            response.sendRedirect("http://localhost:8080/user-manager/login.html");
            return false;
        }


    }

    /**
     * @return
     * @throws
     * @Description: 进入Handler方法之后，返回ModelAndView之前执行
     * @author xyh
     * @Date 23:27 2018/3/5
     * @method params
     **/
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /**
         *  在进入方法之后,返回页面之前执行,这个方法一定会执行Controller里面的内容,所以在上面不能去执行,只能设置好BaseControllerContext
         *      其实就是在controller里面的方法执行完毕,在return之前执行
         */
    }

    /**
     * @return
     * @throws
     * @Description: 在执行Handler完成后执行此方法，使用于统一的异常处理
     * @author xyh
     * @Date 23:27 2018/3/5
     * @method params
     **/
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        /**
         *  在controller的return之前执行
         *      在这里适合做一个日志的记录,记录下用户的所有操作,但是这样日志就会显得很大,不方便查看
         */
    }
}


