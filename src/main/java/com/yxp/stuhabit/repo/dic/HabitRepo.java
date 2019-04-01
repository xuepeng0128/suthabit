package com.yxp.stuhabit.repo.dic;

import com.yxp.stuhabit.entity.Habit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRepo extends MongoRepository<Habit,String> {
}
