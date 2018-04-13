package cn.com.BaseFrame.User.impl;

import cn.com.BaseFrame.Api.User;
import cn.com.BaseFrame.Api.UserMapper;
import cn.com.BaseFrame.User.IUserService;
import cn.com.BaseFrame.Vo.UserVo;
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

    public List<User> getUsers(UserVo userVo) {
        return userMapper.getUsers(userVo);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void save(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public void deleteUsersByIds(String[] userIds) {
        userMapper.deleteUsersByIds(userIds);
    }

    @Override
    public List<User> getUser(User user) { return userMapper.getUser(user);}

    @Override
    public Integer getUserCount(UserVo userVo) {
        return userMapper.getUserCount(userVo);
    }

}
