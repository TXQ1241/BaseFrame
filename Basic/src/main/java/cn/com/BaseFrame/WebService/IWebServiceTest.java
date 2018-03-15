package cn.com.BaseFrame.WebService;

import cn.com.BaseFrame.Service.IBaseService;

import javax.jws.WebService;

/**
 * @author xyh
 * @create 2018-03-14 11:01
 **/
@WebService
public interface IWebServiceTest extends IBaseService{
    public String sayHello(String str);
}
