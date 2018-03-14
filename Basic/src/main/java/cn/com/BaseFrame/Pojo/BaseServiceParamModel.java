package cn.com.BaseFrame.Pojo;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础参数类
 *
 * @author xyh
 * @create 2018-02-23 22:15
 **/
public class BaseServiceParamModel extends BaseControllerContext {
    private HttpServletRequest request;


    public BaseServiceParamModel() {
        super();
    }

    public HttpServletRequest getRequest() {
        return super.getRequest();
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
}
