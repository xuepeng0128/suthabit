package com.yxp.stuhabit.service.basemsg;

import com.yxp.stuhabit.entity.Teacher;

import java.util.Map;

public interface TeacherService {
     public Map<String,Object> teacherList(String paperId,String teacherName,String schoolName,String duty,String pageSize,String pageNo,String getTotal);
     public Teacher singleTeacher(String paperId);
     public Teacher insertTeacher(Teacher teacher);
     public Teacher updateTeacher(Teacher teacher);
     public void deleteTeacher(String paperId);

}
