package com.yxp.stuhabit.serviceImp.dic;

import com.yxp.stuhabit.entity.TeacherDuty;
import com.yxp.stuhabit.repo.dic.TeacherDutyRepo;
import com.yxp.stuhabit.service.dic.TeacherDutyService;
import io.netty.util.internal.SuppressJava6Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class TeacherDutyServiceImp implements TeacherDutyService {
    @Autowired
    private TeacherDutyRepo repo;
    @Override
    public List<TeacherDuty> teacherDutyList() {
        return repo.findAll();
    }

    @Override
    public TeacherDuty findTeacherDutyById(String teacherDutyId) {
        return repo.findById(teacherDutyId).orElse(null);
    }

    @Override
    public TeacherDuty insertTeacherDuty(TeacherDuty teacherDuty) {
        return repo.insert(teacherDuty);
    }

    @Override
    public TeacherDuty updateTeacherDuty(TeacherDuty teacherDuty) {
        return repo.save(teacherDuty);
    }

    @Override
    public void deleteTeacherDuty(String teacherDutyId) {
        repo.deleteById(teacherDutyId);
    }
}
