package com.yxp.stuhabit.service.basemsg;

import com.yxp.stuhabit.entity.Classes;

import java.util.List;

public interface ClassesService {

    public List<Classes> classesList(String grade,String classes ,String schoolId,String paperId,String studentName,String pageSize,String pageNo);



}
