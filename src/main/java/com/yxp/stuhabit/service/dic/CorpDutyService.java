package com.yxp.stuhabit.service.dic;

import com.yxp.stuhabit.entity.CorpDuty;

import java.util.List;

public interface CorpDutyService {
    public List<CorpDuty> corpDutyList();
    public CorpDuty findCorpDutyById(String corpDutyId);
    public CorpDuty insertCorpDuty(CorpDuty corpDuty);
    public CorpDuty updateCorpDuty(CorpDuty corpDuty);
    public void deleteCorpDuty(String corpDutyId);

}
