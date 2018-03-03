package cn.com.BaseFrame.controller;

import java.io.Serializable;

/**
 * 返回基础类    封装一个返回到jsp页面的方法,把所有参数都封装到BaseResultModel
 *
 * @author xyh
 * @create 2018-02-23 22:18
 **/
public class BaseDispatcherController implements Serializable{
    private String path = "";

    //返回到jsp页面
    public String forwardJsp(String jspName) {
        //拼接页面链接
        return jspName;
    }

}
