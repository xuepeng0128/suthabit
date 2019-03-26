package com.yxp.stuhabit.service.basemsg;

import com.yxp.stuhabit.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> studentList(String paperId,String studentName,String ageBegin ,String ageEnd,String pageSize,String pageNo);
    public List<Student> saveAll(List<Student> students);
}
