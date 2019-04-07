package com.yxp.stuhabit.controller.dic;

import com.yxp.stuhabit.entity.StudySubject;
import com.yxp.stuhabit.service.dic.StudySubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dic/studysubject", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class StudySubjectCtrl {
    @Autowired
    private StudySubjectService svr;

    @GetMapping(value="/studySubjectList")
    public List<StudySubject> studySubjectList(){

        return svr.studySubjectList();
    }

    @PostMapping(value="/insertStudySubject")
    public StudySubject insertStudySubject(@RequestBody StudySubject StudySubject){
        StudySubject d = svr.insertStudySubject(StudySubject);
        return d;
    }

    @PostMapping(value="/updateStudySubject")
    public StudySubject updateStudySubject(@RequestBody StudySubject StudySubject){
        StudySubject d = svr.updateStudySubject(StudySubject);
        return d;
    }

    @GetMapping(value="/deleteStudySubject")
    public String deleteStudySubject(String StudySubjectId){
        try{
            svr.deleteStudySubject(StudySubjectId);
            return "ok";
        }catch (Exception ex){
            return "fail" + ex.toString();
        }
    }


}
