package com.example.demo;
import com.example.demo.Service.UserService;
import com.example.demo.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    UserService userService;
    /*
    * 测试添加方法
    * */
    @Test
    void addUser() {
        User user = new User();
        user.setId(10);
        user.setName("Lx");

        userService.addUser(user);
        System.out.println(userService.findAllUser());
    }
    /*
    * 测试修改方法
    * */
    @Test
    void updateUser(){
        User user =new User();
        user.setId(10);
        user.setName("XX");

        userService.updateUser(user);

        System.out.println(userService.getUser(10));
    }
    /*
    * 测试删除方法
    * */
    @Test
    void deleteUser(){
        User user =new User();
        userService.deleteUser(15);
        System.out.println(userService.findAllUser());
    }
    /*
    * 测试通过id查询方法
    * */
    @Test
    void getUserById(){
        User user = new User();
//        userService.getUser(4);
        System.out.println(userService.getUser(11));
    }
    /*
    * 测试查询所有方法
    * */
    @Test
    void getAllUser(){
        userService.findAllUser();
        System.out.println("查询所有用户成功");
        System.out.println(userService.findAllUser());
    }

}
