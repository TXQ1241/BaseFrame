package cn.com.BaseFrame.User;

import cn.com.BaseFrame.Api.User;

import java.util.List;

/**
 * @author xyh
 * @create 2018-03-08 10:57
 **/
public interface IUserService {
    /**
     *  @Description: 通过用户对象获取用户
     *  @author huangy
     *  @Date 2018/3/20
     *  @method getUsers
     *  params  [user]
     *  @return java.util.List<cn.com.BaseFrame.Api.User>
     *  @exception
     **/
    List<User> getUsers(User user);

    /**
     *  @Description: 更新用户
     *  @author huangy
     *  @Date 2018/3/20
     *  @method update
     *  params  [user]
     *  @return void
     *  @exception
     **/
    void update(User user);

    /**
     *  @Description: 保存用户
     *  @author huangy
     *  @Date 2018/3/20
     *  @method save
     *  params  [user] 用户对象
     *  @return void
     *  @exception
     **/
    void save(User user);

    /**
     *  @Description: 批量删除用户信息
     *  @author huangy
     *  @Date 2018/3/20
     *  @method deleteUsersByIds
     *  params  [userIds] 用户id集合
     *  @return void
     *  @exception
     **/
    void deleteUsersByIds(String[] userIds);
}
