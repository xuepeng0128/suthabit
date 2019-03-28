package com.yxp.stuhabit.controller.school.basemsg;

import com.yxp.stuhabit.entity.School;
import com.yxp.stuhabit.service.basemsg.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/school/basemsg/school", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class SchoolCtrl {

    @Autowired
    private SchoolService svr;

    @GetMapping(value="/schoolList")
    public Map<String,Object> schoolList(String schoolId, String schoolName, String districtId, String address, String employeeName, String pageSize, String pageNo,String getTotal) {
        return  svr.schoolList( schoolId,  schoolName,   districtId,  address, employeeName,pageSize, pageNo,getTotal);
    }

    @PostMapping(value = "/updateSchool")
    public School updateSchool(@RequestBody School school){
        return svr.updateSchool(school);
    }


}
