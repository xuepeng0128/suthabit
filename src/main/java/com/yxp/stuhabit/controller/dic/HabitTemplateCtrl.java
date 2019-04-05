package com.yxp.stuhabit.controller.dic;

import com.yxp.stuhabit.entity.Habit;
import com.yxp.stuhabit.repo.dic.HabitRepo;
import com.yxp.stuhabit.service.dic.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dic/habittemplate", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class HabitTemplateCtrl {
    @Autowired
    HabitService svr;
    //习惯资源池所有习惯
    @GetMapping(value="/habitList")
    public List<Habit> habitList(){
       return svr.habitList();
    }
    // 插入习惯资源
    @PostMapping(value="/insertHabit")
    public Habit insertHabit( @RequestBody  Habit habit){
        Habit h =svr.insertHabit(habit);
        return h;
    }
    // 修改习惯
    @PostMapping(value="/updateHabit")
    public Habit updateHabit( @RequestBody  Habit habit){
       return svr.updateHabit(habit);
    }
    //删除
    @GetMapping(value="deleteHabit")
    public String deleteHabit(String habitId){
        try{
            svr.deleteHabit(habitId);
            return "ok";
        }catch (Exception ex){
            return "fail" + ex.toString();
        }
    }
}
