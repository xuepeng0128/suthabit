package com.yxp.stuhabit.serviceImp.basemsg;

import com.yxp.stuhabit.entity.Teacher;
import com.yxp.stuhabit.repo.basemsg.TeacherRepo;
import com.yxp.stuhabit.service.basemsg.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private TeacherRepo repo;
    @Override
    public Map<String, Object> teacherList(String paperId, String teacherName, String schoolName, String duty, String pageSize, String pageNo, String getTotal) {
        Map<String,Object> map=new HashMap<String,Object>();
        Criteria criteria = new Criteria( );
        if (paperId!=null && !paperId.equals(""))
        {
            criteria=criteria.and("paperId").regex(".*" +paperId +"*.");
        }
        if (teacherName!=null && !teacherName.equals(""))
        {
            criteria=criteria.and("teacherName").regex(".*" +teacherName +"*.");
        }
        if (schoolName!=null && !schoolName.equals(""))
        {
            criteria=criteria.and("onserve.school.schoolName").regex(".*" +schoolName +"*.");
        }
        if (duty!=null && !duty.equals(""))
        {
            criteria=criteria.and("duty").regex(".*" +duty +"*.");
        }

        Query query= new Query();
        query.addCriteria(criteria);
        if(getTotal.equals("1"))
        {
            map.put("total" , mongoTemplate.count(query,Teacher.class));
        }

        if (pageNo != null){
            query.addCriteria(criteria).skip( (Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize)).limit(Integer.parseInt(pageSize));
        }
        List<Teacher> list = mongoTemplate.find(query,Teacher.class);
        map.put("list",list);
        return map;
    }

    @Override
    public Teacher singleTeacher(String paperId) {
        return repo.findById(paperId).orElse(null);
    }

    @Override
    public Teacher insertTeacher(Teacher teacher) {
        return repo.insert(teacher);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return repo.save(teacher);
    }

    @Override
    public void deleteTeacher(String paperId) {
          repo.deleteById(paperId);
    }
}
