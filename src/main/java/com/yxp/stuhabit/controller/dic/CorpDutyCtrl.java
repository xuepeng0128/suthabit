package com.yxp.stuhabit.controller.dic;

import com.yxp.stuhabit.entity.CorpDuty;
import com.yxp.stuhabit.service.dic.CorpDutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dic/corpduty", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class CorpDutyCtrl {
    @Autowired
    private CorpDutyService svr;

    @GetMapping(value="/corpDutyList")
    public List<CorpDuty> corpDutyList(){
        List<CorpDuty> list= svr.corpDutyList();
        return list;
    }

    @GetMapping(value="/findById")
    public CorpDuty findById(String corpDutyId){
        return svr.findCorpDutyById(corpDutyId);
    }


    @PostMapping(value="/insertCorpDuty")
    public CorpDuty insertCorpDuty(@RequestBody CorpDuty corpDuty){
        CorpDuty d = svr.insertCorpDuty(corpDuty);
        return d;
    }

    @PostMapping(value="/updateCorpDuty")
    public CorpDuty updateCorpDuty(@RequestBody CorpDuty corpDuty){
        CorpDuty d = svr.updateCorpDuty(corpDuty);
        return d;
    }

    @GetMapping(value="/deleteCorpDuty")
    public String deleteCorpDuty(String corpDutyId){
        try{
            svr.deleteCorpDuty(corpDutyId);
            return "ok";
        }catch (Exception ex){
            return "fail" + ex.toString();
        }
    }


}
