package cn.com.BaseFrame.Login.pojo;

import cn.com.BaseFrame.Pojo.BaseServiceParamModel;

/**
 * 登录的参数对象类
 *
 * @author xyh
 * @create 2018-03-07 10:49
 **/
public class LoginServiceParamModel extends BaseServiceParamModel {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
