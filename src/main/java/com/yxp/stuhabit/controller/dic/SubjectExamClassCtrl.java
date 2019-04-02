package com.yxp.stuhabit.controller.dic;

import com.yxp.stuhabit.entity.SubjectExamClass;
import com.yxp.stuhabit.service.dic.SubjectExamClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dic/subjectexamclass", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class SubjectExamClassCtrl {
    @Autowired
    private SubjectExamClassService svr;

    @GetMapping(value="/subjectExamClassList")
    public List<SubjectExamClass> subjectExamClassList(){
        return svr.subjectExamClassList();
    }



}
