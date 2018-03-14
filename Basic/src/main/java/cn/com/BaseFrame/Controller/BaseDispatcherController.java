package cn.com.BaseFrame.Controller;

import java.io.Serializable;

/**
 * 返回基础类    封装一个返回到jsp页面的方法,把所有参数都封装到BaseResultModel
 *
 * @author xyh
 * @create 2018-02-23 22:18
 **/
public class BaseDispatcherController implements Serializable {
    //把jsp存放在一个单独的model,然后根据classpath去查找对应的jsp
    //提交测试
    private String path = "";

    //返回到jsp页面
    public String forwardJsp(String jspName) {
        //拼接页面链接
        return jspName;
    }

}
