package com.yxp.stuhabit.service.dic;

import com.yxp.stuhabit.entity.TeacherDuty;

import java.util.List;

public interface TeacherDutyService {
    public List<TeacherDuty> teacherDutyList();
    public TeacherDuty findTeacherDutyById(String teacherDutyId);
    public TeacherDuty insertTeacherDuty(TeacherDuty teacherDuty);
    public TeacherDuty updateTeacherDuty(TeacherDuty teacherDuty);
    public void deleteTeacherDuty(String teacherDutyId);
}
