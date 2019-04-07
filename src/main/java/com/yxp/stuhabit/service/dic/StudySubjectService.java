package com.yxp.stuhabit.service.dic;

import com.yxp.stuhabit.entity.StudySubject;

import java.util.List;

public interface StudySubjectService {
    public List<StudySubject> studySubjectList();
    public StudySubject findStudySubjectById(String studySubjectId);
    public StudySubject insertStudySubject(StudySubject studySubject);
    public StudySubject updateStudySubject(StudySubject studySubject);
    public void deleteStudySubject(String studySubjectId);
}
