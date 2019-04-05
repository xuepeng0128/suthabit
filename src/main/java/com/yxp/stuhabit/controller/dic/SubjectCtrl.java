package com.yxp.stuhabit.controller.dic;

import com.yxp.stuhabit.entity.StudySubject;
import com.yxp.stuhabit.service.dic.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dic/subject", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class SubjectCtrl {
    @Autowired
    private SubjectService svr;

    @GetMapping(value="/subjectList")
    public List<StudySubject> subjectList(){
        return svr.subjectList();
    }


}
