package cn.com.BaseFrame.Login;
/**
 * 登录的controller
 *
 * @author xyh
 * @create 2018-02-22 13:08
 **/

import cn.com.BaseFrame.Controller.BaseController;
import cn.com.BaseFrame.Login.impl.LoginService;
import cn.com.BaseFrame.Login.pojo.LoginServiceParamModel;
import cn.com.BaseFrame.Pojo.BaseServiceParamModel;
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
     * 提交测试
     *
     * @return
     * @throws
     * @Description: 跳转到登录页面
     * @author xyh
     * @Date 17:21 2018/2/23
     * @method handlerLogin
     * params  HttpServletRequest request 请求, HttpServletResponse response 响应
     **/
    @RequestMapping(value = "/loginHandler", method = RequestMethod.GET)
    @ResponseBody
    public String loginHandler(HttpServletRequest request, HttpServletResponse response) {
        return "login";
    }

    public String executeLogin(HttpServletRequest request, HttpServletResponse response) {
        LoginServiceParamModel spModel = this.getSpModel(request, LoginServiceParamModel.class);
        invokeMethod(LoginService.class, "executeLogin", new BaseServiceParamModel());
        return ""; //返回到主页
    }

}
