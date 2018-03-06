package cn.com.BaseFrame.Login;
/**
 * 登录的controller
 *
 * @author xyh
 * @create 2018-02-22 13:08
 **/
import cn.com.BaseFrame.Login.impl.LoginService;
import cn.com.BaseFrame.controller.BaseController;
import cn.com.BaseFrame.pojo.BaseControllerContext;
import cn.com.BaseFrame.pojo.BaseServiceParamModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/Login")
public class LoginController extends BaseController {
    /**
     *  提交测试
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
    public String loginHandler(BaseControllerContext context) {
        //直接跳转到对应的jsp,返回登录页面
        System.out.print("login------------------**********");
        return "login";
    }

    public String executeLogin(BaseControllerContext context) {
        invokeMethod(LoginService.class,"executeLogin",new BaseServiceParamModel(),context);
        return ""; //返回到主页
    }

}
