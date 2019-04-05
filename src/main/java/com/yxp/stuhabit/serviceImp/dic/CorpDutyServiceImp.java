package com.yxp.stuhabit.serviceImp.dic;

import com.yxp.stuhabit.entity.CorpDuty;
import com.yxp.stuhabit.repo.dic.CorpDutyRepo;
import com.yxp.stuhabit.service.dic.CorpDutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorpDutyServiceImp implements CorpDutyService {
    @Autowired
    private CorpDutyRepo repo;
    @Override
    public List<CorpDuty> corpDutyList() {
        return repo.findAll();
    }

    @Override
    public CorpDuty insertCorpDuty(CorpDuty corpDuty) {
        return repo.insert(corpDuty);
    }

    @Override
    public CorpDuty updateCorpDuty(CorpDuty corpDuty) {
        return repo.save(corpDuty);
    }

    @Override
    public void deleteCorpDuty(String corpDutyId) {
        repo.deleteById(corpDutyId);
    }
}
