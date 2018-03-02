package cn.com.BaseFrame.controller.impl;


import cn.com.BaseFrame.controller.IBaseController;
import org.springframework.stereotype.Controller;

import java.lang.annotation.Annotation;

/**
 * 返回基础类
 *
 * @author xyh
 * @create 2018-02-23 22:18
 **/
public class BaseDispatcherController implements IBaseController,Controller {

    public BaseDispatcherController() {
        super();
    }

    private String path = "";

    //返回到jsp页面
    public String forwardJsp(String jspName) {
        //拼接页面链接
        return jspName;
    }

    public String value() {
        return null;
    }

    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
