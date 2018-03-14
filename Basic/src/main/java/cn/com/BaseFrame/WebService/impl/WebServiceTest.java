package cn.com.BaseFrame.WebService.impl;

import cn.com.BaseFrame.WebService.IWebServiceTest;
import org.springframework.stereotype.Component;

/**
 * @author xyh
 * @create 2018-03-14 11:02
 **/
@Component("webServiceTest")
public class WebServiceTest extends IWebServiceTest {
    @Override
    public void sayHello() {
        System.out.println("hello cxf");
        System.out.println("Hello world");
    }
}
