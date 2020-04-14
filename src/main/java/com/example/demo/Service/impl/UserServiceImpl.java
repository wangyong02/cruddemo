package com.example.demo.Service.impl;

import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Service.UserService;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    /*
    * 查询所有用户
    * */
    @Override
    public List<User> findAllUser() {
        return userMapper.getuser();
    }
    /*
    * 添加用户
    * */
    @Override
    public void addUser(User user){
        try {
            User existId = userMapper.getUserById(user);
            if (existId != null){
                System.out.println("该用户信息已存在");
            }else {
                userMapper.addUser(user);
                System.out.println("添加成功");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ;
    }
    /*
    * 通过id查询用户
    * */
    @Override
    public User getUser(Integer id) {
        User user = new User();
        user.setId(id);
        try {
            User existId = userMapper.getUserById(user);
            if (existId != null){
                userMapper.getUserById(user);
                System.out.println("查询成功");
            }else {

                System.out.println("该用户信息不存在");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return userMapper.getUserById(user);
//        User user = new User();
//        user.setId(id);
//        return userMapper.getUserById(user);
    }
    /*
    * 修改用户
    * */
    @Override
    public void updateUser(User user) {
        try {
            User existId = userMapper.getUserById(user);
            if (existId != null){
                userMapper.updateUser(user);
                System.out.println("修改成功");
            }else {

                System.out.println("该用户信息不存在");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    /*
    * 删除用户
    * */
    @Override
    public void deleteUser(Integer id) {
        User user = new User();
        user.setId(id);
        try {
            User existId = userMapper.getUserById(user);
            if (existId != null){
                userMapper.deleteUser(user);
                System.out.println("删除成功");
            }else {

                System.out.println("该用户信息不存在");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
