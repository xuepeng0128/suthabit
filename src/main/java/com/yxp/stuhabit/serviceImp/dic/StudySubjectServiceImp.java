package com.yxp.stuhabit.serviceImp.dic;

import com.yxp.stuhabit.entity.StudySubject;
import com.yxp.stuhabit.repo.dic.SubjectRepo;
import com.yxp.stuhabit.service.dic.StudySubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudySubjectServiceImp implements StudySubjectService {
    @Autowired
    private SubjectRepo repo;
    @Override
    public List<StudySubject> studySubjectList() {
        return repo.findAll();
    }

    @Override
    public StudySubject findStudySubjectById(String studySubjectId) {
        return repo.findById(studySubjectId).orElse(null);
    }

    @Override
    public StudySubject insertStudySubject(StudySubject studySubject) {
        return repo.insert(studySubject);
    }

    @Override
    public StudySubject updateStudySubject(StudySubject studySubject) {
        return repo.save(studySubject);
    }

    @Override
    public void deleteStudySubject(String studySubjectId) {
         repo.deleteById(studySubjectId);
    }
}
