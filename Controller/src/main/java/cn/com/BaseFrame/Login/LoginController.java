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

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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
    public Map<String, String> executeLogin(HttpServletRequest request,@RequestBody User user) {
        //登录状态
        String status;
        //登录信息
        String message;
        Map<String, String> msgMap = new HashMap<String, String>();
        User userInfo = null;
        try{
            List<User> userList = userService.getUserByAccount(user);
            if(userList!=null && userList.size() > 0) {
                userInfo = userList.get(0);
            }
            if (userInfo != null) {
                if (user.getPassword().equals(userInfo.getPassword())){
                    status = Constant.AjaxStatus.AJAX_SUCCESS;
                    message = "登录成功";
                    //将用户信息放入session域中
                    request.getSession().setAttribute(Constant.CURRENT_USER, userInfo);
                    msgMap.put("userType", userInfo.getUserType());
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

    /**
     *  @Description: 注销/退出
     *  @author huangy
     *  @Date 2018/4/13
     *  @method logout
     *  params  [request]
     *  @return String 登录页面
     *  @exception
     **/
    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        //将session中用户的登录信息设置为空
        request.getSession().setAttribute(Constant.CURRENT_USER,null);
        return "login";
    }

    /**
     *  @Description: 跳转到主页
     *  @author huangy
     *  @Date 2018/4/13
     *  @method goToIndex
     *  params  []
     *  @return String
     *  @exception
     **/
    @RequestMapping("home")
    public String goToIndex() {
        return "index";
    }

}
