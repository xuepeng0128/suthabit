package com.yxp.stuhabit.controller.corp.basemsg;


import com.yxp.stuhabit.entity.Teacher;
import com.yxp.stuhabit.service.basemsg.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/corp/basemsg/teacher", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class AllTeacherCtrl {
    @Autowired
    private TeacherService svr;

    @GetMapping(value="/teacherList")
    public Map<String ,Object> teacherList(String paperId,String teacherName,String schoolName,String duty,String pageSize,String pageNo,String getTotal){
          return svr.teacherList(paperId,teacherName,schoolName,duty,pageSize,pageNo,getTotal);
    }

    @GetMapping(value="/singleTeacher")
    public Teacher singleTeacher(String paperId){
        return svr.singleTeacher(paperId);
    }




}
