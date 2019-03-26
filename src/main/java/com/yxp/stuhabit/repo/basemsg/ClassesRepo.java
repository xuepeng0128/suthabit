package com.yxp.stuhabit.repo.basemsg;

import com.yxp.stuhabit.entity.Classes;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClassesRepo extends MongoRepository<Classes, ObjectId> {
}
