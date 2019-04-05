package com.yxp.stuhabit.serviceImp.dic;

import com.yxp.stuhabit.entity.StudySubject;
import com.yxp.stuhabit.repo.dic.SubjectRepo;
import com.yxp.stuhabit.service.dic.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImp implements SubjectService {
    @Autowired
    private SubjectRepo repo;
    @Override
    public List<StudySubject> subjectList() {
        return repo.findAll();
    }
}
