package com.yxp.stuhabit.repo.system;

import com.yxp.stuhabit.entity.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface MenuRepo extends MongoRepository<Menu,String> {
    public List<Menu> findMenuByKind(int kind);
}
