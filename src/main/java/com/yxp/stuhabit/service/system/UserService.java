package com.yxp.stuhabit.service.system;

import com.yxp.stuhabit.entity.User;

import java.util.List;

public interface UserService {
    // kind =1 corp kind=2 school
    public List<User>  userList(String account,String employeeName,String teacher,String schoolId,String kind,String schoolAdmin ,String pageSize,String pageNo);
    public User userLogin(User user);
    public User insertUser(User user);
    public User updateUser(User user);
    public void deleteUser(String userId);
}
