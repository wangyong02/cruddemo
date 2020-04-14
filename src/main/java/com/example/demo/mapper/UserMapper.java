package com.example.demo.mapper;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    /**
     * 获取所有的用户
     */
    @Select("select * from user")
    List<User> getuser();

    /**
     * 添加用户
     */
    @Insert("insert into user values(#{id},#{name})")
    void addUser(User user);

    /**
     * 根据ID查询用户
     */
    @Select("select * from user where id = #{id}")
    User getUserById(User user);

    /**
     * 修改用户

     */
    @Update("update user set  name = #{name} where id = #{id}")
    void updateUser(User user);

    /**
     * 删除用户
     */
    @Delete("delete from user where id = #{id}")
    void deleteUser(User user);
}
