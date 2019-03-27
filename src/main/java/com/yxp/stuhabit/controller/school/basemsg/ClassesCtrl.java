package com.yxp.stuhabit.controller.school.basemsg;

import com.yxp.stuhabit.entity.Classes;
import com.yxp.stuhabit.service.basemsg.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/school/basemsg/classes", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class ClassesCtrl {

    @Autowired
    private ClassesService svr;

    @GetMapping(value="/classesList")
    public List<Classes> classesList (String grade, String classes , String schoolId, String schoolName, String paperId, String studentName, String pageSize, String pageNo)
    {
        return svr.classesList(grade,classes ,schoolId, schoolName,paperId, studentName, pageSize, pageNo);
    }

    @PostMapping(value = "/insertClasses")
    public Classes insertClasses(@RequestBody Classes classes){
        return svr.insertClasses(classes);
    }
    @PostMapping(value = "/updateClasses")
    public Classes updateClasses(@RequestBody Classes classes){
        return svr.updateClasses(classes);
    }

    @GetMapping(value="/deleteClasses")
    public String deleteClasses(String _id){
        try {
            svr.deleteClasses(_id);
            return "ok";
        }catch (Exception ex){
            return "fail" + ex.toString();
        }
    }



}
