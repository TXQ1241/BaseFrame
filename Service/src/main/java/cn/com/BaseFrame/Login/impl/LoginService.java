package cn.com.BaseFrame.Login.impl;

import cn.com.BaseFrame.Login.ILoginService;
import cn.com.BaseFrame.pojo.BaseParamModel;
import cn.com.BaseFrame.pojo.BaseResultModel;
import cn.com.BaseFrame.service.impl.BaseService;

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
    public BaseResultModel login(BaseParamModel paramModel) {
        System.out.print("欢迎登录");
        return new BaseResultModel();
    }
}
