package com.yxp.stuhabit.service.business;

import com.yxp.stuhabit.entity.Teacher;
import com.yxp.stuhabit.entity.TeacherHabit;

import java.util.List;

public interface TeacherHabitService {

   public List<TeacherHabit> teacherHabitList(String circleIds,String paperId,String habitName, String habitClass);
   public TeacherHabit insertTeacherHabit(TeacherHabit teacherHabit);
}
