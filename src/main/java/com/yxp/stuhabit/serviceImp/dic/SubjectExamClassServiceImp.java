package com.yxp.stuhabit.serviceImp.dic;

import com.yxp.stuhabit.entity.SubjectExamClass;
import com.yxp.stuhabit.repo.dic.SubjectExamClassRepo;
import com.yxp.stuhabit.service.dic.SubjectExamClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectExamClassServiceImp implements SubjectExamClassService {
    @Autowired
    private SubjectExamClassRepo repo;
    @Override
    public List<SubjectExamClass> subjectExamClassList() {
        return repo.findAll();
    }

    @Override
    public SubjectExamClass insertSubjectExamClass(SubjectExamClass subjectExamClass) {
        return repo.insert(subjectExamClass);
    }

    @Override
    public SubjectExamClass updateSubjectExamClass(SubjectExamClass subjectExamClass) {
        return repo.save(subjectExamClass);
    }

    @Override
    public void deleteSubjectExamClass(String subjectExamClassId) {
         repo.deleteById(subjectExamClassId);
    }
}
