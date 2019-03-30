package com.yxp.stuhabit.controller.corp.basemsg;

import com.yxp.stuhabit.entity.Classes;
import com.yxp.stuhabit.service.basemsg.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/corp/basemsg/classes", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class AllClassesCtrl {
    @Autowired
    private ClassesService svr;

    @GetMapping(value="/classesList")
    public List<Classes> classesList (String grade,String classes ,String schoolId,String schoolName,String paperId,String studentName,String pageSize,String pageNo)
    {
        return svr.classesList(grade,classes ,schoolId, schoolName,paperId, studentName, pageSize, pageNo);
    }

}
