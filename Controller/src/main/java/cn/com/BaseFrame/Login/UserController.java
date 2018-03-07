package cn.com.BaseFrame.Login;

import cn.com.BaseFrame.Controller.BaseController;
import cn.com.BaseFrame.Login.cn.com.BaseFrame.User.inter.IUserService;
import cn.com.BaseFrame.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserController extends BaseController{

    @Autowired
    @Qualifier("userService")
    IUserService userService;

    @RequestMapping("view")
    public String getUsers(HttpServletRequest request, User user) {
        List<User> userList = userService.getUsers(user);
        request.setAttribute("userList", userList);
        return "/user/view";
    }

}
