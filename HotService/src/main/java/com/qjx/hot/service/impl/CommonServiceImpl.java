package com.qjx.hot.service.impl;

import com.qjx.hot.dao.UserDao;
import com.qjx.hot.entrty.User;
import com.qjx.hot.service.CommonService;
import com.qjx.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo class
 *
 * @author junxiangquan
 * @date 2018/9/26
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private UserDao userDao;

    @Override
    public User loginIn(User user) {
        String password = MD5Utils.getStrrMD5(user.getPassword()+user.getUsername());
        user.setPassword(password);
        User currentUser = userDao.userLogin(user);
        return currentUser;
    }

    @Override
    public int register(User user) {
        String password = MD5Utils.getStrrMD5(user.getPassword()+user.getUsername());
        user.setPassword(password);
        int result = userDao.insertSelective(user);
        return result;
    }

    @Override
    public int usernameIsExist(String username) {
        int result = userDao.selectByUsername(username);
        return  result;
    }

    @Override
    public List<User> getUserList() {
       return userDao.selectAllUser();
    }

}
