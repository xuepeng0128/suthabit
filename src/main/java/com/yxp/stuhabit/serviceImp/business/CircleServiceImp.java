package com.yxp.stuhabit.serviceImp.business;

import com.yxp.stuhabit.entity.Circle;
import com.yxp.stuhabit.repo.business.CircleRepo;
import com.yxp.stuhabit.service.business.CircleService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CircleServiceImp implements CircleService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private CircleRepo repo;
    @Override
    public Map<String,Object> allcircleList(String schoolstyle,String circleName, String schoolName,
                                            Date buildDateBegin , Date buildDateEnd,String queryPaperId,
                                            String pageSize, String pageNo , String getTotal) {
        Map<String,Object> map= new HashMap<String,Object>();
        Criteria criteria = new Criteria( );
        if (schoolstyle.equals("1"))
        {
            criteria=criteria.and("school").exists(true);
            if (!queryPaperId.isEmpty())
            {
                criteria=criteria.and("school.saleMan.paperId").is(queryPaperId);
            }
        }
        if(schoolstyle.equals("2"))
        {
            criteria=criteria.and("trainSchool").exists(true);
            if (!queryPaperId.isEmpty())
            {
                criteria=criteria.and("trainSchool.saleMan.paperId").is(queryPaperId);
            }
        }
        if (circleName!=null && !circleName.equals(""))
        {
            criteria=criteria.and("circleName").regex(".*" +circleName +"*.");
        }
        if (schoolName!=null && !schoolName.equals(""))
        {
            criteria=criteria.andOperator(new Criteria().orOperator(
                     Criteria.where("school.schoolName").regex(".*" +schoolName +"*."),
                     Criteria.where("trainSchool.trainSchoolName").regex(".*" +schoolName +"*.")
            ));
        }


        if (buildDateBegin!=null )
        {
            criteria=criteria.and("buildDate").gte(buildDateBegin);
        }
        if (buildDateEnd!=null )
        {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(buildDateEnd);
            calendar.add(calendar.DATE,1);
            criteria=criteria.and("buildDate").lt(calendar.getTime());
        }


//        Aggregation agg = Aggregation.newAggregation(
//                Aggregation.match(criteria),
//                Aggregation.lookup("putcard","circleId","circle.circleId","putcards"),
//                Aggregation.unwind("putcards"),
//                Aggregation.group("circleId","circleName","school.schoolName","buildMan.teacherName")
//                Aggregation.project("price").andExpression("{$count : '$price'} ").as("avgPrice"),
//                Aggregation.sort(Sort.Direction.DESC,"avgPrice"),
//                Aggregation.limit(1)
//        );
//



        Query query= new Query();
        query.addCriteria(criteria);
        if (getTotal!= null && getTotal.equals("1"))
        {
            long total= mongoTemplate.count(query,Circle.class);
            map.put("total",total);
        }
        query.skip( (Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize)).limit(Integer.parseInt(pageSize));
        List<Circle> list = mongoTemplate.find(query,Circle.class);
        map.put("list",list);
        return map;
    }



    @Override
    public Map<String,Object> schoolCircleList(String circleName, String schoolId,String teacherPaperId,
                                               String teacharName, String studentName,Date buildDateBegin , Date buildDateEnd,
                                               String pageSize, String pageNo , String getTotal) {
        Map<String,Object> map= new HashMap<String,Object>();
        Criteria criteria = new Criteria( );
        if (circleName!=null && !circleName.equals(""))
        {
            criteria=criteria.and("circleName").regex(".*" +circleName +"*.");
        }
        if (schoolId!=null && !schoolId.equals(""))
        {
            criteria=criteria.and("school.schoolId").regex(".*" +schoolId +"*.");
        }
        if (teacherPaperId != null && !teacherPaperId.equals("") )
        {
            criteria=criteria.andOperator(
                    criteria.orOperator(  Criteria.where("buildMan.paperId").is(teacherPaperId),
                                            Criteria.where("teachers.paperId").is(teacherPaperId)
                    )
            )
            ;
        }
        if (teacharName!=null && !teacharName.equals(""))
        {
            criteria=criteria.and("buildMan.teacharName").regex(".*" +teacharName +"*.");
        }

        if (studentName!=null && !studentName.equals(""))
        {
            criteria=criteria.and("student.studentName").regex(".*" +studentName +"*.");
        }

        if (buildDateBegin!=null )
        {
            criteria=criteria.and("buildDate").gte(buildDateBegin);
        }
        if (buildDateEnd!=null )
        {

            Calendar calendar = new GregorianCalendar();
            calendar.setTime(buildDateEnd);
            calendar.add(calendar.DATE,1);
            criteria=criteria.and("buildDate").lt(calendar.getTime());
        }


        Query query= new Query();
        query.addCriteria(criteria);
        if (getTotal!= null && getTotal.equals("1"))
        {
            long total= mongoTemplate.count(query,Circle.class);
            map.put("total",total);
        }
        query.skip( (Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize)).limit(Integer.parseInt(pageSize));
        List<Circle> list = mongoTemplate.find(query,Circle.class);
        map.put("list",list);
        return map;
    }

    @Override
    public Map<String, Object> trainSchoolCircleList(String circleName, String trainSchoolId, String trainSchoolName, String teacherPaperId, String teacharName, String studentName, String studentPaperId, Date buildDateBegin, Date buildDateEnd, String pageSize, String pageNo, String getTotal) {
        return null;
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
