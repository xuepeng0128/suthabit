package com.yxp.stuhabit.service.business;

import com.yxp.stuhabit.entity.Circle;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CircleService {

    public Map<String,Object> allcircleList(String schoolstyle,String circleName, String schoolName,
                                          Date buildDateBegin , Date buildDateEnd,String queryPaperId,
                                         String pageSize, String pageNo , String getTotal);

    public Map<String,Object> schoolCircleList(String circleName, String schoolId, String schoolName,  String teacherPaperId,
                                         String teacharName, String studentName, String studentPaperId,Date buildDateBegin , Date buildDateEnd,
                                         String pageSize, String pageNo , String getTotal);

    public Map<String,Object> trainSchoolCircleList(String circleName,  String trainSchoolId, String trainSchoolName, String teacherPaperId,
                                               String teacharName, String studentName, String studentPaperId, Date buildDateBegin , Date buildDateEnd,
                                               String pageSize, String pageNo , String getTotal);
    public Circle insertCircle(Circle circle);
    public Circle updateCircle(Circle circle);
    public void   deleteCircle(String circleId);
}
