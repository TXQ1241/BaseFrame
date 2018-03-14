package cn.com.BaseFrame.User;

import cn.com.BaseFrame.Api.User;

import java.util.List;

/**
 * @author xyh
 * @create 2018-03-08 10:57
 **/
public interface IUserService {
    /**
     * 获取用户列表
     *
     * @param user 用户对象
     * @return 用户集合
     */
    List<User> getUsers(User user);
}
