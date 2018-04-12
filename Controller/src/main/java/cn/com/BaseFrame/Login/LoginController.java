package cn.com.BaseFrame.Login;
/**
 * 登录的controller
 *
 * @author xyh
 * @create 2018-02-22 13:08
 **/

import cn.com.BaseFrame.Api.User;
import cn.com.BaseFrame.Controller.BaseController;
import cn.com.BaseFrame.Pojo.constant.Constant;
import cn.com.BaseFrame.User.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/login/")
public class LoginController extends BaseController {

    @Autowired
    @Qualifier("userService")
    IUserService userService;

    /**
     * 提交测试
     *
     * @return
     * @throws
     * @Description: 跳转到登录页面
     * @author xyh
     * @Date 17:21 2018/2/23
     * @method handlerLogin
     * params
     **/
    @RequestMapping("loginHandler")
    public String loginHandler() {

        return "login";
    }

    /**
     *  @Description:
     *  @author huangy
     *  @Date 2018/4/12
     *  @method executeLogin
     *  params  [User]用户对象，帐号，密码
     *  @return Map 用户登录信息
     *  @exception
     **/
    @RequestMapping("login")
    @ResponseBody
    public Map<String, String> executeLogin(@RequestBody User user) {
        //登录状态
        String status;
        //登录信息
        String message;
        Map<String, String> msgMap = new HashMap<String, String>();
        try{
            User userInfo = userService.getUserByAccount(user);
            if (userInfo != null) {
                if (user.getPassword().equals(userInfo.getPassword())){
                    status = Constant.AjaxStatus.AJAX_SUCCESS;
                    message = "登录成功";
                    msgMap.put("userType", user.getUserType());
                } else {
                    status = Constant.AjaxStatus.AJAX_FAIL;
                    message = "密码错误";
                }
            } else {
                status = Constant.AjaxStatus.AJAX_FAIL;
                message = "当前用户不存在";
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = Constant.AjaxStatus.AJAX_FAIL;
            message = "登录异常，请联系管理员";
        }

        msgMap.put("status",status);
        msgMap.put("msg",message);

        return msgMap;

    }

}
