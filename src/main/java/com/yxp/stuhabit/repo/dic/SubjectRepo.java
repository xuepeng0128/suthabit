package com.yxp.stuhabit.repo.dic;

import com.yxp.stuhabit.entity.StudySubject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SubjectRepo extends MongoRepository<StudySubject,String> {
}
