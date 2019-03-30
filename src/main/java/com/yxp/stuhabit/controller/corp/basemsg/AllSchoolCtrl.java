package com.yxp.stuhabit.controller.corp.basemsg;

import com.yxp.stuhabit.entity.School;
import com.yxp.stuhabit.service.basemsg.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/corp/basemsg/school", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class AllSchoolCtrl {
     @Autowired
    private SchoolService svr;

     @GetMapping(value="/schoolList")
     public Map<String,Object> schoolList(String schoolId, String schoolName, String cityId, String districtId,
                                          String address, String employeeName, String pageSize, String pageNo, String getTotal) {
         return svr.schoolList( schoolId,  schoolName,  districtId,  address, employeeName,pageSize, pageNo,getTotal);

     }

     @PostMapping(value = "/insertSchool")
     public School insertSchool(@RequestBody School school){
         return svr.insertSchool(school);
     }

    @PostMapping(value = "/updateSchool")
    public School updateSchool(@RequestBody School school){
        return svr.updateSchool(school);
    }

    @GetMapping(value="/deleteSchool")
    public String deleteSchool(String schoolId){
         try{
             svr.deleteSchool(schoolId);
             return "ok";
         }catch (Exception ex){
             return "fail" +ex.toString();
         }
    }

}
