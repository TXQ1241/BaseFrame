package cn.com.BaseFrame.Login.cn.com.BaseFrame.User.inter;

import cn.com.BaseFrame.User.User;

import java.util.List;

public interface IUserService {

    /**
     * 获取用户列表
     * @param user 用户对象
     * @return 用户集合
     */
    List<User> getUsers(User user);

}
