package cn.com.BaseFrame.pojo;

import cn.com.BaseFrame.BaseUtils.BeanUtils.BeanUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * 基础类
 *
 * @author xyh
 * @create 2018-02-23 22:15
 **/
public class BaseModel implements Serializable {
    /**
     * 这个类是基础类,里面封装context、session、request
     *      注意 :
     *          1.这个类在什么时候创建?
     *          2.类是单例还是有多个?
     *          3.里面的request保存的是一个,还是多个?
     *
     */
    private HttpSession session;
    private ServletContext context;
    private HttpServletRequest request;

    public BaseModel() {
        super();
    }

    public BaseModel(HttpSession session, ServletContext context, HttpServletRequest request) {
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