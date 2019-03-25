package com.yxp.stuhabit.repo.basemsg;

import com.yxp.stuhabit.entity.School;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// 学校repo
@Repository
public interface SchoolRepo extends MongoRepository<School,String> {
}
