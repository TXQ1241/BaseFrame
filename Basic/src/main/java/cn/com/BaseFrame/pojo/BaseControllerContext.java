package cn.com.BaseFrame.pojo;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 一个封装的context
 *
 * @author xyh
 * @create 2018-03-05 23:11
 **/
public class BaseControllerContext {
    /**
     * 这个类是基础类,里面封装context、session、request
     *      注意 :
     *          1.这个类在什么时候创建?
     *              在通过url访问的时候,就可以直接创建一个BaseModel对象,但是里面的所有值为空
     *          2.类是单例还是有多个?
     *
     *          3.里面的request保存的是一个,还是多个?
     */
    private HttpServletRequest request;
    private HttpSession session;
    private ServletContext context;

    public BaseControllerContext() {
        super();
    }

    public BaseControllerContext(HttpServletRequest request, HttpSession session, ServletContext context) {
        this.session = session;
        this.context = context;
        this.request = request;
    }

    //里面只提供get方法,不提供set方法
    public HttpSession getSession() {
        return session;
    }

    public ServletContext getContext() {

        return context;
    }

    public HttpServletRequest getRequest() {
        return request;
    }
}
