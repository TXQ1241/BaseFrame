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

    public BaseResultModel login(BaseParamModel paramModel) {
        System.out.print("欢迎登录");
        return new BaseResultModel();
    }
}
