package cn.com.BaseFrame.Api;

import cn.com.BaseFrame.Vo.UserVo;
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
     *  @Description: 通过用户对象获取用户
     *  @author huangy
     *  @Date 2018/4/12
     *  @method getUserByAccount
     *  params  [user] 用户对象
     *  @return List<User> 用户列表
     *  @exception
     **/
    List<User> getUser(User user);
}