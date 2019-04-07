package com.yxp.stuhabit.controller.dic;

import com.yxp.stuhabit.entity.SubjectExamClass;
import com.yxp.stuhabit.service.dic.StudySubjectService;
import com.yxp.stuhabit.service.dic.SubjectExamClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dic/subjectexamclass", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class SubjectExamClassCtrl {
    @Autowired
    private SubjectExamClassService svr;
    @Autowired
    private StudySubjectService subjectService;

    @GetMapping(value="/subjectExamClassList")
    public List<SubjectExamClass> subjectExamClassList(){
        return svr.subjectExamClassList();
    }

    @GetMapping(value="/findById")
    public SubjectExamClass findById(String subjectExamClassId){
        return svr.findSubjectExamClassById(subjectExamClassId);
    }

    @PostMapping(value="/insertSubjectExamClass")
    public SubjectExamClass insertSubjectExamClass(@RequestBody SubjectExamClass subjectExamClass){
        //补充学科
        subjectExamClass.setStudySubject(subjectService.findStudySubjectById(subjectExamClass.getStudySubject().getStudySubjectId()));
        SubjectExamClass d = svr.insertSubjectExamClass(subjectExamClass);
        return d;
    }

    @PostMapping(value="/updateSubjectExamClass")
    public SubjectExamClass updateSubjectExamClass(@RequestBody SubjectExamClass subjectExamClass){
        subjectExamClass.setStudySubject(subjectService.findStudySubjectById(subjectExamClass.getStudySubject().getStudySubjectId()));
        SubjectExamClass d = svr.updateSubjectExamClass(subjectExamClass);
        return d;
    }

    @GetMapping(value="/deleteSubjectExamClass")
    public String deleteSubjectExamClass(String subjectExamClassId){
        try{
            svr.deleteSubjectExamClass(subjectExamClassId);
            return "ok";
        }catch (Exception ex){
            return "fail" + ex.toString();
        }
    }
    
    

}
