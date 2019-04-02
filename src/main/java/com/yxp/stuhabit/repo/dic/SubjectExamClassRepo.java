package com.yxp.stuhabit.repo.dic;

import com.yxp.stuhabit.entity.SubjectExamClass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectExamClassRepo extends MongoRepository<SubjectExamClass,String> {
}
