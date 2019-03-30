package com.yxp.stuhabit.controller.corp.system;

import com.yxp.stuhabit.entity.User;
import com.yxp.stuhabit.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/corp/system/user", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class AllUserCtrl {
    @Autowired
    private UserService svr;

    @GetMapping(value="/userList")
    public List<User> userList(String account,String employeeName ,String teacher, String schoolId ,String kind ,String pageSize,String pageNo ){
           List<User> userlist = svr.userList(account,employeeName,teacher,schoolId,kind,pageSize,pageNo);
           return userlist;
    }



    @PostMapping(value="/validateUser")
    public User validateUser(User user){
           User ruser = svr.userLogin(user);
           return ruser;
    }



    @PostMapping(value="/insertUser")
    public User insertUser(@RequestBody User user){
         return svr.insertUser(user);
    }
    @PostMapping(value="/updateUser")
    public User updateUser(@RequestBody User user){
        return svr.updateUser(user);
    }

    @GetMapping(value="/deleteUser")
    public String deleteUser(String account){
        try {
              svr.deleteUser(account);
              return "ok";
        }catch (Exception ex){
              return "fail" + ex.toString();
        }
    }
}
