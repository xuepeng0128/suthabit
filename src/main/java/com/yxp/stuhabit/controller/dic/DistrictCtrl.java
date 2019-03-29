package com.yxp.stuhabit.controller.dic;

import com.yxp.stuhabit.entity.District;
import com.yxp.stuhabit.service.dic.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dic/district", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class DistrictCtrl {
    @Autowired
    private DistrictService svr;

    @GetMapping(value="/districtList")
    public List<District> districtList(){
        return svr.districtList();
    }

    @GetMapping(value="/singleDistrict")
    public District singleDistrict(String districtId){
           return svr.singleDistrict(districtId);
    }

}
