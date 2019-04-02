package com.yxp.stuhabit.serviceImp.dic;

import com.yxp.stuhabit.entity.Subject;
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
    public List<Subject> subjectList() {
        return repo.findAll();
    }
}
