package com.yxp.stuhabit.repo.business;

import com.yxp.stuhabit.entity.TeacherHabit;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeacherHabitRepo extends MongoRepository<TeacherHabit,ObjectId> {
}
