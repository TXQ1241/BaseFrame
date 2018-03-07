package cn.com.BaseFrame.Login.cn.com.BaseFrame.User.impl;

import cn.com.BaseFrame.Login.cn.com.BaseFrame.User.inter.IUserService;
import cn.com.BaseFrame.User.User;
import cn.com.BaseFrame.User.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    @Qualifier("userMapper")
    UserMapper userMapper;

    public List<User> getUsers(User user) {
        return userMapper.getUsers(user);
    }

}
