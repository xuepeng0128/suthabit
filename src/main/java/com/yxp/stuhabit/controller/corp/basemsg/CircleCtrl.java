package com.yxp.stuhabit.controller.corp.basemsg;

import com.yxp.stuhabit.entity.Circle;
import com.yxp.stuhabit.service.business.CircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/corp/basemsg/circle", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class CircleCtrl {
   @Autowired
   private CircleService svr;

    public List<Circle> circleList(String circleName,String schoolId,String schoolName, String trainSchoolId,String trainSchoolName,String teacherPaperId,
                                   String teacharName,String studentName,String studentPaperId,String buildDateBegin ,String buildDateEnd,
                                   String pageSize,String pageNo) {
          List<Circle> clist = svr.circleList( circleName, schoolId,schoolName, trainSchoolId,trainSchoolName,teacherPaperId,
                  teacharName, studentName,studentPaperId, buildDateBegin , buildDateEnd,
                  pageSize,pageNo);

        return  clist;
    }




}
