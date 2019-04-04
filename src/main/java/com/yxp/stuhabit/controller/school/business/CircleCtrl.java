package com.yxp.stuhabit.controller.school.business;

import com.yxp.stuhabit.entity.Circle;
import com.yxp.stuhabit.entity.Habit;
import com.yxp.stuhabit.entity.TeacherHabit;
import com.yxp.stuhabit.service.business.CircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/school/buisness/circle", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class CircleCtrl {
    @Autowired
    private CircleService svr;

    @PostMapping(value="/insertCircle")
   public Circle insertCircle(@RequestBody Circle circle){
       return svr.insertCircle(circle);
   }
    @PostMapping(value="/updateCircle")
    public Circle updateCircle(@RequestBody Circle circle){
        return svr.updateCircle(circle);
    }
    @GetMapping(value="/deleteCircle")
    public String deleteCircle(String circleId){
        try{
            svr.deleteCircle(circleId);
            return "ok";
        }catch (Exception ex){
            return "fail" + ex.toString();
        }

    }







}
