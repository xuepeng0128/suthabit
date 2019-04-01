package com.yxp.stuhabit.controller.dic;

import com.yxp.stuhabit.entity.Habit;
import com.yxp.stuhabit.repo.dic.HabitRepo;
import com.yxp.stuhabit.service.dic.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dic/habittemplate", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class HabitTemplateCtrl {
    @Autowired
    HabitService svr;
    //习惯资源池所有习惯
    public List<Habit> habitList(){
       return svr.habitList();
    }
    // 插入习惯资源
    public Habit insertHabit(Habit habit){
      return svr.insertHabit(habit);
    }
    // 修改习惯
    public Habit updateHabit(Habit habit){
       return svr.updateHabit(habit);
    }
    //删除
    public String deleteHabit(String habitId){
        try{
            svr.deleteHabit(habitId);
            return "ok";
        }catch (Exception ex){
            return "fail" + ex.toString();
        }
    }
}
