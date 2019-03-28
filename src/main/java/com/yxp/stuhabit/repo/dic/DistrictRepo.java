package com.yxp.stuhabit.repo.dic;

import com.yxp.stuhabit.entity.District;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepo extends MongoRepository<District,String> {
}
