package cn.com.BaseFrame.Api;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userMapper")
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    /**
     *  @Description: 保存用户
     *  @author huangy
     *  @Date 2018/3/20
     *  @method insert
     *  params  [user] 用户对象
     *  @return int
     *  @exception
     **/
    int insert(User user);

    /**
     *  @Description: 保存用户
     *  @author huangy
     *  @Date 2018/3/20
     *  @method insertSelective
     *  params  [user] 用户对象
     *  @return int
     *  @exception
     **/
    int insertSelective(User user);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User user);

    /**
     * 更新用户
     *
     * @param user 用户对象
     */
    int updateByPrimaryKey(User user);

    /**
     *  @Description: 通过用户对象获取用户集合
     *  @author huangy
     *  @Date 2018/3/20
     *  @method getUsers
     *  params  [user] 用户对象
     *  @return 用户集合
     *  @exception
     **/
    List<User> getUsers(User user);

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