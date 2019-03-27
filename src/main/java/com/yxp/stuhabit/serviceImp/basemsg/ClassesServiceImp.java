package com.yxp.stuhabit.serviceImp.basemsg;

import com.yxp.stuhabit.entity.Classes;
import com.yxp.stuhabit.repo.basemsg.ClassesRepo;
import com.yxp.stuhabit.service.basemsg.ClassesService;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImp implements ClassesService {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    private ClassesRepo repo;
    @Override
    public List<Classes> classesList(String grade, String classes, String schoolId,String schoolName, String paperId, String studentName, String pageSize, String pageNo) {
        Criteria criteria = new Criteria( );
        if (grade!=null && !grade.equals(""))
        {
            criteria=criteria.and("grade").is(Integer.parseInt(grade));
        }
        if (classes!=null && !classes.equals(""))
        {
            criteria=criteria.and("classes").is(Integer.parseInt(classes));
        }
        if (schoolId!=null && !schoolId.equals(""))
        {
            criteria=criteria.and("school.schoolId").regex(".*" +schoolId +"*.");
        }
        if (schoolName!=null && !schoolName.equals(""))
        {
            criteria=criteria.and("school.schoolName").regex(".*" +schoolName +"*.");
        }
//        if (paperId!=null && !paperId.equals(""))
//        {
//            criteria=criteria.and("students").elemMatch( Criteria.where("paperId").regex(".*" +paperId +"*."));
//        }
//        if (studentName!=null && !studentName.equals(""))
//        {
//            criteria=criteria.and("students").elemMatch( Criteria.where("studentName").regex(".*" +studentName +"*."));
//        }
        Query query= new Query();
        query.addCriteria(criteria).skip( (Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize)).limit(Integer.parseInt(pageSize));
        List<Classes> list = mongoTemplate.find(query,Classes.class);
        return list;
    }

    @Override
    public Classes insertClasses(Classes classes) {
        return repo.insert(classes);
    }

    @Override
    public Classes updateClasses(Classes classes) {
//         classes.get_id().toHexString();
//        ObjectId.
     //   new ObjectId("adfd");
        return repo.save(classes);
    }

    @Override
    public void deleteClasses(String id) {
        repo.deleteById(new ObjectId(id));
    }
}
