package com.qjx.hot.service;

import com.qjx.hot.entrty.User;

import java.util.List;

/**
 * 公共接口
 *
 * @author junxiangquan
 * @date 2018/10/31
 */
public interface CommonService {
    /**
     * 用户登录的方法
     *
     * @param user 登录用户名和密码
     * @return 登录成功返回用户失败返回null
     */
    User loginIn(User user);

    /**
     * 用户注册的方法
     *
     * @param user 用户名和密码
     * @return 注册成功返回1失败返回0
     */
    int register(User user);

    /**
     * 判断用户名
     * @param username 用户名
     * @return 不存在返回0 否则不存在
     */
    int usernameIsExist(String username);

    /**
     * 获取用户列表
     * @return 用户列表
     */
    List<User> getUserList();
}
