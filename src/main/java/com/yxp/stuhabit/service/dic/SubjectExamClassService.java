package com.yxp.stuhabit.service.dic;

import com.yxp.stuhabit.entity.SubjectExamClass;

import java.util.List;

public interface SubjectExamClassService {
    public List<SubjectExamClass> subjectExamClassList();
    public SubjectExamClass findSubjectExamClassById(String subjectExamClassId);
    public SubjectExamClass insertSubjectExamClass(SubjectExamClass subjectExamClass);
    public SubjectExamClass updateSubjectExamClass(SubjectExamClass subjectExamClass);
    public void deleteSubjectExamClass(String subjectExamClassId);
}
