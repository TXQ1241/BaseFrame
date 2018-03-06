package cn.com.BaseFrame.Login.impl;

import cn.com.BaseFrame.BaseUtils.StringUtils.StringUtils;
import cn.com.BaseFrame.Login.ILoginService;
import cn.com.BaseFrame.pojo.BaseServiceParamModel;
import cn.com.BaseFrame.pojo.BaseServiceResultModel;
import cn.com.BaseFrame.service.impl.BaseService;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录的servcie实现
 *
 * @author xyh
 * @create 2018-03-01 13:18
 **/
public class LoginService extends BaseService implements ILoginService {
    /**
     *  在登录时把配置表里面所有配置的值从表中取出来,然后存放进session中
     *      session里面这一块儿的值受保护,不提供修改
     */
    public BaseServiceResultModel executeLogin(BaseServiceParamModel paramModel) {
        String UUID = StringUtils.getUUID();
        HttpServletRequest request = paramModel.getRequest();
        request.setAttribute("UUID",UUID);

        paramModel.getRequest().getAttribute("UUID");
        System.out.print("欢迎登录");
        return new BaseServiceResultModel();
    }
}
