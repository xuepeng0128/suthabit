package com.yxp.stuhabit.repo.system;

import com.yxp.stuhabit.entity.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MenuRepo extends MongoRepository<Menu,String> {
}
