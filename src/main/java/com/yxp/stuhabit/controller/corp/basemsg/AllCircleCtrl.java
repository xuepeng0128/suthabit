package com.yxp.stuhabit.controller.corp.basemsg;

import com.yxp.stuhabit.service.business.CircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/corp/basemsg/circle", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class AllCircleCtrl {
   @Autowired
   private CircleService svr;
    @GetMapping(value="/circleList")
    public Map<String,Object> circleList(String circleName, String schoolId, String schoolName, String trainSchoolId, String trainSchoolName, String teacherPaperId,
                                         String teacharName, String studentName, String studentPaperId, @DateTimeFormat(pattern="yyyy-MM-dd") Date buildDateBegin ,
                                         @DateTimeFormat(pattern="yyyy-MM-dd") Date buildDateEnd, String pageSize, String pageNo, String getTotal) {
          return svr.circleList( circleName, schoolId,schoolName, trainSchoolId,trainSchoolName,teacherPaperId,
                  teacharName, studentName,studentPaperId, buildDateBegin , buildDateEnd,
                  pageSize,pageNo,getTotal);
    }




}
