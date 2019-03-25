package com.yxp.stuhabit.repo.basemsg;

import com.yxp.stuhabit.entity.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends MongoRepository<Teacher,String> {

}
