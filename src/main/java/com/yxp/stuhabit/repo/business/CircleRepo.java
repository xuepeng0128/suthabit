package com.yxp.stuhabit.repo.business;

import com.yxp.stuhabit.entity.Circle;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CircleRepo extends MongoRepository<Circle,ObjectId> {
}
