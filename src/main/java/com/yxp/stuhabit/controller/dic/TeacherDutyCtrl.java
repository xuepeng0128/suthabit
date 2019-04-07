package com.yxp.stuhabit.controller.dic;

import com.yxp.stuhabit.entity.TeacherDuty;
import com.yxp.stuhabit.service.dic.TeacherDutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 import java.util.List;
@RestController
@RequestMapping(value = "/api/dic/teacherduty", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class TeacherDutyCtrl {
    @Autowired
    private TeacherDutyService svr;

    @GetMapping(value="/teacherDutyList")
    public List<TeacherDuty> teacherDutyList(){
        List<TeacherDuty> list= svr.teacherDutyList();
        return list;
    }
    @PostMapping(value="/insertTeacherDuty")
    public TeacherDuty insertTeacherDuty(@RequestBody TeacherDuty TeacherDuty){
        TeacherDuty d = svr.insertTeacherDuty(TeacherDuty);
        return d;
    }

    @PostMapping(value="/updateTeacherDuty")
    public TeacherDuty updateTeacherDuty(@RequestBody TeacherDuty TeacherDuty){
        TeacherDuty d = svr.updateTeacherDuty(TeacherDuty);
        return d;
    }

    @GetMapping(value="/deleteTeacherDuty")
    public String deleteTeacherDuty(String TeacherDutyId){
        try{
            svr.deleteTeacherDuty(TeacherDutyId);
            return "ok";
        }catch (Exception ex){
            return "fail" + ex.toString();
        }
    }


}
