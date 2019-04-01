package com.yxp.stuhabit.repo.dic;

import com.yxp.stuhabit.entity.TeacherDuty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDutyRepo extends MongoRepository<TeacherDuty,String> {
}
