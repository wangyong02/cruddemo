package com.example.demo.controller;

import com.example.demo.Service.UserService;
import com.example.demo.bean.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 添加用户
     */
    @ApiOperation(value = "添加用户",notes = "添加用户")
    @ApiImplicitParam(paramType = "body", name = "user", dataType = "User", required = true, value = "添加用户", defaultValue = "")
    @RequestMapping(value="addUser",method = {RequestMethod.POST})
    public List<User> addUser(@RequestBody User user){
        userService.addUser(user);
        System.out.println(userService.findAllUser());
        return userService.findAllUser();
    }
    /*
    修改用户
    * */
    @ApiOperation(value = "修改用户信息",notes = "修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "修改用户信息", required = true, dataType = "User")

    })
    @RequestMapping(value="updateUser",method =RequestMethod.POST)
    public List<User> updateUser(@RequestBody User user){
        userService.updateUser(user);
        System.out.println(userService.findAllUser());
        return userService.findAllUser();

    }

   /*
   删除用户
   */
    @ApiOperation(value = "删除用户信息",notes = "删除用户信息")

    @RequestMapping(value="deleteUser/{id}",method = RequestMethod.DELETE)
    public List<User> deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        System.out.println(userService.findAllUser());
        return userService.findAllUser();
    }
   /*
   通过id查询用户
   */
    @ApiOperation(value = "通过id查询用户信息",notes = "根据url的id来获取用户基本信息")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "string",paramType = "path")
    @RequestMapping(value = "getUserById/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Integer id){
        return userService.getUser(id);
    }
    /*
    查询所有用户
    */
    @ApiOperation(value = "查询所有用户信息")
    @RequestMapping(value="getAllUser",method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public List<User> getAllUser(ModelMap modelMap){
        List<User> userList = userService.findAllUser();
        modelMap.addAttribute("userList",userList);
        System.out.println("查询成功");
        System.out.println(userList);
        return userList;
    }
}
