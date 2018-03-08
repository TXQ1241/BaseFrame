package cn.com.BaseFrame.User;

import cn.com.BaseFrame.Api.User;
import cn.com.BaseFrame.Controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author xyh
 * @create 2018-03-08 11:00
 **/
@Controller
@RequestMapping("/user/")
public class UserController extends BaseController {

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
