package com.yxp.stuhabit.serviceImp.business;

import com.yxp.stuhabit.entity.Circle;
import com.yxp.stuhabit.repo.business.CircleRepo;
import com.yxp.stuhabit.service.business.CircleService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class CircleServiceImp implements CircleService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private CircleRepo repo;
    @Override
    public List<Circle> circleList(String circleName, String schoolId, String schoolName, String trainSchoolId, String trainSchoolName,
                                   String teacherPaperId, String teacharName, String studentName, String studentPaperId,
                                   String buildDateBegin, String buildDateEnd, String pageSize, String pageNo) {
        Criteria criteria = new Criteria( );
        if (circleName!=null && !circleName.equals(""))
        {
            criteria=criteria.and("circleName").regex(".*" +circleName +"*.");
        }
        if (schoolId!=null && !schoolId.equals(""))
        {
            criteria=criteria.and("school.schoolId").regex(".*" +schoolId +"*.");
        }
        if (schoolName!=null && !schoolName.equals(""))
        {
            criteria=criteria.and("school.schoolName").regex(".*" +schoolName +"*.");
        }
        if (trainSchoolId!=null && !trainSchoolId.equals(""))
        {
            criteria=criteria.and("trainSchool.trainSchoolId").regex(".*" +trainSchoolId +"*.");
        }
        if (trainSchoolName!=null && !trainSchoolName.equals(""))
        {
            criteria=criteria.and("trainSchool.trainSchoolName").regex(".*" +trainSchoolName +"*.");
        }
        if (teacherPaperId!=null && !teacherPaperId.equals(""))
        {
            criteria=criteria.and("teacher.paperId").regex(".*" +teacherPaperId +"*.");
        }
        if (teacharName!=null && !teacharName.equals(""))
        {
            criteria=criteria.and("teacher.teacharName").regex(".*" +teacharName +"*.");
        }
        if (studentPaperId!=null && !studentPaperId.equals(""))
        {
            criteria=criteria.and("student.paperId").regex(".*" +studentPaperId +"*.");
        }
        if (studentName!=null && !studentName.equals(""))
        {
            criteria=criteria.and("student.studentName").regex(".*" +studentName +"*.");
        }

        if (buildDateBegin!=null && !buildDateBegin.equals(""))
        {
            criteria=criteria.and("buildDate").gte(new Date(buildDateBegin));
        }
        if (buildDateEnd!=null && !buildDateEnd.equals(""))
        {

            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date(buildDateEnd));
            calendar.add(calendar.DATE,1);
            criteria=criteria.and("buildDate").lt(calendar.getTime());
        }


        Query query= new Query();
        query.addCriteria(criteria).skip( (Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize)).limit(Integer.parseInt(pageSize));
        List<Circle> list = mongoTemplate.find(query,Circle.class);
        return list;
    }

    @Override
    public Circle insertCircle(Circle circle) {
        return repo.insert(circle);
    }

    @Override
    public Circle updateCircle(Circle circle) {
        return repo.save(circle);
    }

    @Override
    public void deleteCircle(String circleId) {
         repo.deleteById(new ObjectId(circleId));
    }
}
