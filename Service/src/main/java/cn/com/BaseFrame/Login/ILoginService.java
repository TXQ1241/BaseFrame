package cn.com.BaseFrame.Login;

import cn.com.BaseFrame.pojo.BaseParamModel;
import cn.com.BaseFrame.pojo.BaseResultModel;
import cn.com.BaseFrame.service.IBaseService;
/**
 * 登录的service接口
 *
 * @author xyh
 * @create 2018-03-01 13:19
 **/
public interface ILoginService extends IBaseService {
    public BaseResultModel login(BaseParamModel paramModel);
}
