package com.yxp.stuhabit.controller.school.business;

import com.yxp.stuhabit.entity.Habit;
import com.yxp.stuhabit.entity.TeacherHabit;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/school/buisness/habit", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class HabitCtrl {

    // 老师发布习惯
    @PostMapping(value="/publishTeacherHabit")
    public TeacherHabit publishTeacherHabit(@RequestBody TeacherHabit teacherHabit){
        return null;
    }





}
