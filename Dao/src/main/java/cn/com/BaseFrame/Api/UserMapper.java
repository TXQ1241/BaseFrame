package cn.com.BaseFrame.Api;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userMapper")
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    /**
     * 保存用户
     *
     * @param user 用户对象
     */
    int insert(User user);

    /**
     * 通过判断保存用户
     *
     * @param user 用户对象
     */
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
     * 获取用户集合
     *
     * @param user 用户对象
     * @return 用户集合
     */
    List<User> getUsers(User user);
}