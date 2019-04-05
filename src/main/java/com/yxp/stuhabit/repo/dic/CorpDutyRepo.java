package com.yxp.stuhabit.repo.dic;

import com.yxp.stuhabit.entity.CorpDuty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorpDutyRepo extends MongoRepository<CorpDuty, String> {
}
