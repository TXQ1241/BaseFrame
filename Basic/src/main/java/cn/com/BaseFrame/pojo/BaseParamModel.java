package cn.com.BaseFrame.pojo;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础参数类
 *
 * @author xyh
 * @create 2018-02-23 22:15
 **/
public class BaseParamModel extends BaseModel {
    private HttpServletRequest request;

    public BaseParamModel() {
        super();
    }

    public HttpServletRequest getRequest() {
       return super.getRequest();
    }
}
