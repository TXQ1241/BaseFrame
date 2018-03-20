package cn.com.BaseFrame.User;

import cn.com.BaseFrame.Api.User;
import cn.com.BaseFrame.BaseUtils.StringUtils.StringUtils;
import cn.com.BaseFrame.Controller.BaseController;
import cn.com.BaseFrame.Pojo.constant.Constant;
import cn.com.BaseFrame.Vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    public String getUsers() {
        return "userList";
    }

    @RequestMapping("userList")
    @ResponseBody
    public DataVo getUsers(User user) {
        DataVo dataVo = new DataVo();
        List<User> userList = userService.getUsers(user);
        dataVo.setDatalist(userList);
        return dataVo;
    }

    @RequestMapping("save")
    @ResponseBody
    public Map<String, String> saveUsers(User user) {
        Map<String, String> msgMap = new HashMap<String, String>();
        try {
            if (StringUtils.isNotBlank(user.getId())) {
                user.setUpdateTime(new Date());
                userService.update(user);
            } else {
                user.setId(StringUtils.getUUID());
                user.setCreateTime(new Date());
                userService.save(user);
            }
            msgMap.put(Constant.AjaxStatus.AJAX_SUCCESS,"保存用户信息成功");
        } catch (Exception e) {
            msgMap.put(Constant.AjaxStatus.AJAX_FAIL,"保存用户信息失败");
        }
        return msgMap;
    }

}
