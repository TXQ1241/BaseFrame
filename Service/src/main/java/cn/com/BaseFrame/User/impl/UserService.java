package cn.com.BaseFrame.User.impl;

import cn.com.BaseFrame.User.UserMapper;
import cn.com.BaseFrame.User.IUserService;
import cn.com.BaseFrame.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xyh
 * @create 2018-03-08 10:57
 **/
@Service("userService")
@Transactional
public class UserService implements IUserService {
    @Autowired
    @Qualifier("userMapper")
    UserMapper userMapper;

    public List<User> getUsers(User user) {
        return userMapper.getUsers(user);
    }

}
