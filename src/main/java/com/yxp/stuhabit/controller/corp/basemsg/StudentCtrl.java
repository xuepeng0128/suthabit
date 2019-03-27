package com.yxp.stuhabit.controller.corp.basemsg;

import com.yxp.stuhabit.entity.Student;
import com.yxp.stuhabit.service.basemsg.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/corp/basemsg/student", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class StudentCtrl {
   @Autowired
    private StudentService svr;

    @GetMapping(value="/studentList")
    public List<Student> studentList(String paperId, String studentName, String ageBegin , String ageEnd, String pageSize, String pageNo){
        return svr.studentList(paperId, studentName, ageBegin ,  ageEnd,  pageSize,  pageNo);
    }



}
