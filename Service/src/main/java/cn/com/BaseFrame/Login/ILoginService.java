package cn.com.BaseFrame.Login;

import cn.com.BaseFrame.Pojo.BaseServiceParamModel;
import cn.com.BaseFrame.Pojo.BaseServiceResultModel;
import cn.com.BaseFrame.Service.IBaseService;
/**
 * 登录的service接口
 *
 * @author xyh
 * @create 2018-03-01 13:19
 **/
public interface ILoginService extends IBaseService {
    public BaseServiceResultModel executeLogin(BaseServiceParamModel paramModel);
}
