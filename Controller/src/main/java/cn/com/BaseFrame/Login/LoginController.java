package cn.com.BaseFrame.Login;
/**
 * 登录的controller
 *
 * @author xyh
 * @create 2018-02-22 13:08
 **/
import cn.com.BaseFrame.Login.impl.LoginService;
import cn.com.BaseFrame.controller.BaseController;
import cn.com.BaseFrame.pojo.BaseParamModel;
import cn.com.BaseFrame.pojo.BaseResultModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/Login")
public class LoginController extends BaseController {
    /**
     *  @Description: 跳转到登录页面
     *  @author xyh
     *  @Date 17:21 2018/2/23
     *  @method handlerLogin
     *  params  HttpServletRequest request 请求, HttpServletResponse response 响应
     *  @return 
     *  @exception 
     **/
    @RequestMapping(value = "/loginHandler", method = RequestMethod.GET)
    @ResponseBody
    public String loginHandler(HttpServletRequest request, HttpServletResponse response) {
        //直接跳转到对应的jsp,返回登录页面
        return "login";
    }

    public String executeLogin(HttpServletRequest request,HttpServletResponse response) {
        invokeMethod(LoginService.class,"executeLogin",new BaseParamModel(),request,response);
        return ""; //返回到主页
    }

}
