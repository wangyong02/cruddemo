package com.example.demo.Service;

import com.example.demo.bean.User;

import java.util.List;

public interface UserService {
    /**
     * 获取所有用户
     * @return
     */
    List<User> findAllUser();

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);
    /**
     * 根据ID查询用户
     * @param id 用户ID
     * @return
     */
    User getUser(Integer id);

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Integer id);
}
