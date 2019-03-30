package com.yxp.stuhabit.serviceImp.basemsg;

import com.yxp.stuhabit.entity.School;
import com.yxp.stuhabit.entity.Student;
import com.yxp.stuhabit.repo.basemsg.StudentRepo;
import com.yxp.stuhabit.service.basemsg.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepo repo;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<Student> studentList(String paperId, String studentName,String sex, String ageBegin, String ageEnd, String pageSize, String pageNo,String getTotal) {
        Criteria criteria = new Criteria( );
        if (paperId!=null && !paperId.equals(""))
        {
            criteria=criteria.and("paperId").regex(".*" +paperId +"*.");
        }
        if (studentName!=null && !studentName.equals(""))
        {
            criteria=criteria.and("studentName").regex(".*" +studentName +"*.");
        }
        if (sex != null && !sex.equals("") && !sex.equals("0") )
        {
            criteria=criteria.and("sex").is(sex);
        }
//        if (ageBegin!=null && !ageBegin.equals(""))
//        {
//            criteria=criteria.and("birthday")
//        }
        Query query= new Query();
        query.addCriteria(criteria).skip( (Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize)).limit(Integer.parseInt(pageSize));
        List<Student> list = mongoTemplate.find(query,Student.class);
        return list;
    }

    @Override
    public List<Student> saveAll(List<Student> students) {
      return  repo.saveAll(students);
    }
}
