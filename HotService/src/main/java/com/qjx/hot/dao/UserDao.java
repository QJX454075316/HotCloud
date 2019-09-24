package com.qjx.hot.dao;

import com.qjx.annotation.DataSource;
import com.qjx.hot.entrty.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@SuppressWarnings("ALL")
@Mapper
/**
 *
 * @author jucxiangquan
 */
@DataSource("slave1")
public interface UserDao {
    /**
     *  删除用户
     * @param id
     * @return 返回影响的条数
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新建用户
     * @param record
     * @return 返回影响的行数
     */
    int insert(User record);

    /**
     * 动态新建用户
     * @param record 需要添加的
     * @return 影响的行数
     */
    int insertSelective(User record);

    /**
     * 根据id查找用户
     * @param id
     * @return 返回用户对象
     */
    User selectByPrimaryKey(Long id);

    /**
     * 动态更新用户的属性
     * @param record
     * @return 影响的行数
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 更新用户信息
     * @param record
     * @return 影响的行数
     */
    int updateByPrimaryKey(User record);

    /**
     * 根据用户名查找的用户
     * @param user
     * @return 返回用户对象
     */
    @DataSource("slave1")
    User userLogin(User user);

    /**
     * 根据用户名查找用户
     * @param username
     * @return 不存在返回0 存在返回1
     */
    @DataSource("slave1")
    int selectByUsername(String username);


    /**
     * 查询用户
     * @return 返回所有的用户
     */
    List<User> selectAllUser();
}