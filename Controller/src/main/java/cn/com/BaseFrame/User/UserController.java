package cn.com.BaseFrame.User;

import cn.com.BaseFrame.Api.User;
import cn.com.BaseFrame.BaseUtils.StringUtils.StringUtils;
import cn.com.BaseFrame.Controller.BaseController;
import cn.com.BaseFrame.Pojo.constant.Constant;
import cn.com.BaseFrame.Vo.DataVo;
import cn.com.BaseFrame.Vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     *  @Description: 跳转到用户管理页面
     *  @author huangy
     *  @Date 2018/3/20
     *  @method toUsers
     *  params  []
     *  @return java.lang.String
     *  @exception
     **/
    @RequestMapping("view")
    public String toUsers() {
        return "admin";
    }

    /**
     *  @Description: 通过用户对象获取用户数据
     *  @author huangy
     *  @Date 2018/3/20
     *  @method getUsers
     *  params  [user] 用户对象
     *  @return DataVo 用户集对象
     *  @exception
     **/
    @RequestMapping("userList")
    @ResponseBody
    public DataVo getUsers(UserVo userVo) {
        DataVo dataVo = new DataVo();
        Integer pageNum = userVo.getPageNum();
        //设置查询开始的条数(就是从哪条开始查询)
        if(pageNum != null) {
            userVo.setPageNum((pageNum-1)*10);
        }
        try {
            List<User> userList = userService.getUsers(userVo);
            dataVo.setDatalist(userList);
            dataVo.setCode(Constant.DataCode.SUCCESS);
            dataVo.setMsg("数据获取成功");
            if (userList != null) {
                dataVo.setCount(userService.getUserCount(userVo));
            } else {
                dataVo.setCount(Constant.ZERO_NUM);
            }
        } catch (Exception e) {
            dataVo.setCode(Constant.DataCode.FAIL);
            dataVo.setMsg("数据获取失败");
            e.printStackTrace();
        }
        return dataVo;
    }

    /**
     *  @Description: 保存用户
     *  @author huangy
     *  @Date 2018/3/20
     *  @method saveUsers
     *  params  [user] 用户对象
     *  @return 操作信息
     *  @exception
     **/
    @RequestMapping("save")
    @ResponseBody
    public Map<String, String> saveUser(User user) {
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

    /**
     *  @Description: 删除用户
     *  @author huangy
     *  @Date 2018/3/20
     *  @method deleteUsers
     *  params  [user] 用户对象
     *  @return 操作信息
     *  @exception
     **/
    @RequestMapping("delete")
    @ResponseBody
    public Map<String, String> deleteUsers(@RequestBody User user) {
        Map<String, String> msgMap = new HashMap<String, String>();
        String [] userIds = null;
        if(StringUtils.isNotBlank(user.getIds())){
            userIds = user.getIds().split(",");
        }
        try {

            if(userIds != null && userIds.length > 0) {
                userService.deleteUsersByIds(userIds);
            }
            msgMap.put(Constant.AjaxStatus.AJAX_SUCCESS,"删除用户信息成功");
        } catch (Exception e) {
            msgMap.put(Constant.AjaxStatus.AJAX_FAIL,"删除用户信息失败");
        }
        return msgMap;
    }

}
