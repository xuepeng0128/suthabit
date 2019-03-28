package com.yxp.stuhabit.service.business;

import com.yxp.stuhabit.entity.Circle;

import java.util.List;

public interface CircleService {

    public List<Circle> circleList(String circleName,String schoolId,String schoolName, String trainSchoolId,String trainSchoolName,String teacherPaperId,
                                   String teacharName,String studentName,String studentPaperId,String buildDateBegin ,String buildDateEnd,
                                   String pageSize,String pageNo);
    public Circle insertCircle(Circle circle);
    public Circle updateCircle(Circle circle);
    public void   deleteCircle(String circleId);
}
