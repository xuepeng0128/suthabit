package com.yxp.stuhabit.serviceImp.basemsg;

import com.yxp.stuhabit.entity.School;
import com.yxp.stuhabit.repo.basemsg.SchoolRepo;
import com.yxp.stuhabit.service.basemsg.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImp implements SchoolService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private SchoolRepo repo;
    @Override
    public List<School> schoolList(String schoolId, String schoolName, String cityId, String districtId, String address, String paperId, String pageSize, String pageNo) {
        Criteria criteria = new Criteria( );
        if (schoolId!=null && !schoolId.equals(""))
        {
            criteria=criteria.and("schoolId").regex(".*" +paperId +"*.");
        }
        if (schoolName!=null && !schoolName.equals(""))
        {
            criteria=criteria.and("schoolName").regex(".*" +schoolName +"*.");
        }
        if (cityId!=null && !cityId.equals(""))
        {
            criteria=criteria.and("city.cityId").regex(".*" +cityId +"*.");
        }
        Query query= new Query();
        query.addCriteria(criteria).skip( (Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize)).limit(Integer.parseInt(pageSize));
        List<School> list = mongoTemplate.find(query,School.class);
        return list;
    }

    @Override
    public School insertSchool(School school) {
        return null;
    }

    @Override
    public School updateSchool(School school) {
        return null;
    }

    @Override
    public School deleteSchool(String schoolId) {
        return null;
    }
}
