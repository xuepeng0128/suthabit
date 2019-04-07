package com.yxp.stuhabit.serviceImp.dic;

import com.yxp.stuhabit.entity.Habit;
import com.yxp.stuhabit.repo.dic.HabitRepo;
import com.yxp.stuhabit.service.dic.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitServiceImp implements HabitService {
    @Autowired
    private HabitRepo repo;
    @Override
    public List<Habit> habitList() {
        return repo.findAll();
    }

    @Override
    public Habit findHabitById(String HabitId) {
        return repo.findById(HabitId).orElse(null);
    }

    @Override
    public Habit insertHabit(Habit habit) {
        return repo.insert(habit);
    }

    @Override
    public Habit updateHabit(Habit habit) {
        return repo.save(habit);
    }

    @Override
    public void deleteHabit(String habitId) {
        repo.deleteById(habitId);
    }
}
