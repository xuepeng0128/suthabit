package com.yxp.stuhabit.service.dic;

import com.yxp.stuhabit.entity.Habit;

import java.util.List;

public interface HabitService {
    public List<Habit> habitList();
    public Habit insertHabit(Habit habit);
    public Habit updateHabit(Habit habit);
    public void  deleteHabit(String habitId);
}
