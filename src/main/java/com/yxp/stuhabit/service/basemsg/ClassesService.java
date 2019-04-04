package com.yxp.stuhabit.service.basemsg;

import com.yxp.stuhabit.entity.Classes;

import java.util.List;

public interface ClassesService {

    public List<Classes> classesList(String grade,String classes ,String schoolId,String schoolName,String paperId,String studentName,String pageSize,String pageNo);
    public List<Classes> schoolclassesList(String grade,String classes ,String schoolId,String headmasterName );
    public Classes insertClasses(Classes classes);
    public Classes updateClasses(Classes classes);
    public void deleteClasses(String _id);


}
