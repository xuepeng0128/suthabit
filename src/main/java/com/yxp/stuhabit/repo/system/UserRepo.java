package com.yxp.stuhabit.repo.system;

import com.yxp.stuhabit.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User,String> {
    public User findUserByAccountAndPassWord(String account,String password);
}
