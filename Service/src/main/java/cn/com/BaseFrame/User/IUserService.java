package cn.com.BaseFrame.User;

import cn.com.BaseFrame.Api.User;
import cn.com.BaseFrame.Vo.UserVo;

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
     *  params  [userVo] 用户查询对象
     *  @return 用户集合
     *  @exception
     **/
    List<User> getUsers(UserVo userVo);

    /**
     *  @Description: 获取用户记录的总条数
     *  @author huangy
     *  @Date 2018/4/5
     *  @method getUserCount
     *  params  [userVo] 用户查询对象
     *  @return java.lang.Integer 总条数
     *  @exception
     **/
    Integer getUserCount(UserVo userVo);

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

    /**
     *  @Description: 通过 user对象获取用户
     *  @author huangy
     *  @Date 2018/4/12
     *  @method getUserByAccount
     *  params  [userVo] 用户对象
     *  @return List<User>用户集合
     *  @exception
     **/
    List<User> getUser(User user);
}
