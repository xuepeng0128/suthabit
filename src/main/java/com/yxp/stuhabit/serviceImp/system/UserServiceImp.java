package com.yxp.stuhabit.serviceImp.system;

import com.yxp.stuhabit.common.Md5Tool;
import com.yxp.stuhabit.entity.User;
import com.yxp.stuhabit.repo.system.UserRepo;
import com.yxp.stuhabit.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<User> userList(String account, String employeeName, String teacher,String schoolId,String kind,String schoolAdmin, String pageSize, String pageNo) {
        Criteria criteria = new Criteria();
        if (account!=null && !account.equals(""))
        {
            criteria=criteria.and("account").regex(".*" +account +"*.");
        }
        if (employeeName!=null && !employeeName.equals(""))
        {
            criteria=criteria.and("employee.employeeName").regex(".*" +employeeName +"*.");
        }
        if (teacher!=null && !teacher.equals(""))
        {
            criteria=criteria.and("teacher.teacherName").regex(".*" +teacher +"*.");
        }
        if (kind.equals("1"))
        {
            criteria=criteria.and("teacher").exists(false);
            criteria=criteria.orOperator(new Criteria().and("supperAdmin").is(true));
        }else if (kind.equals("2"))
        {
            criteria=criteria.and("employee").exists(false);
            criteria=criteria.and("manageSchool.schoolId").is(schoolId);
            criteria=criteria.orOperator(new Criteria().and("schoolAdmin").is(true));
        }
        if (schoolAdmin != null && !schoolAdmin.isEmpty()){
            criteria=criteria.and("schoolAdmin").is(true);
        }
        Query query= new Query();
        query.addCriteria(criteria).skip( (Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize)).limit(Integer.parseInt(pageSize));
        List<User> list = mongoTemplate.find(query,User.class);
        return list;
    }

    @Override
    public User userLogin(User user) {
        return userRepo.findUserByAccountAndPassWord(user.getAccount(), Md5Tool.string2MD5(user.getPassWord()));
    }

    @Override
    public User insertUser(User user) {
        return userRepo.insert(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(String  account) {
             userRepo.deleteById(account);
    }
}
