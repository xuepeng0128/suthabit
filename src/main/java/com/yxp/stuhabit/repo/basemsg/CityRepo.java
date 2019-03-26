package com.yxp.stuhabit.repo.basemsg;

import com.yxp.stuhabit.entity.City;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepo extends MongoRepository<City,String> {
}
