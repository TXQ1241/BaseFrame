package cn.com.BaseFrame.User;

import cn.com.BaseFrame.User.User;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("userMapper")
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 获取用户集合
     * @param user 用户对象
     * @return 用户集合
     */
    List<User> getUsers(User user);
}