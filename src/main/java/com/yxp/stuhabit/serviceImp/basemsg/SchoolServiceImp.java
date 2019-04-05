package com.yxp.stuhabit.serviceImp.basemsg;

import com.yxp.stuhabit.entity.School;
import com.yxp.stuhabit.repo.basemsg.SchoolRepo;
import com.yxp.stuhabit.service.basemsg.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SchoolServiceImp implements SchoolService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private SchoolRepo repo;
    @Override
    public Map<String,Object> schoolList(String schoolId, String schoolName, String districtId, String address,
                                         String employeeName, String pageSize, String pageNo, String getTotal) {
        Map<String,Object> map=new HashMap<String,Object>();
        Criteria criteria = new Criteria( );
        if (schoolId!=null && !schoolId.equals(""))
        {
            criteria=criteria.and("schoolId").regex(".*" +schoolId +"*.");
        }
        if (schoolName!=null && !schoolName.equals(""))
        {
            criteria=criteria.and("schoolName").regex(".*" +schoolName +"*.");
        }
        if (districtId!=null && !districtId.equals(""))
        {
            criteria=criteria.and("district.districtId").is(districtId);
        }
        if (address!=null && !address.equals(""))
        {
            criteria=criteria.and("address").regex(".*" +address +"*.");
        }
        if (employeeName!=null && !employeeName.equals(""))
        {
            criteria=criteria.and("saleMan").regex(".*" +employeeName +"*.");
        }
        Query query= new Query();
        query.addCriteria(criteria);
        if(getTotal!= null && getTotal.equals("1"))
        {
           map.put("total" , mongoTemplate.count(query,School.class));
        }

        if (pageNo != null){
            query.addCriteria(criteria).skip( (Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize)).limit(Integer.parseInt(pageSize));
        }
        List<School> list = mongoTemplate.find(query,School.class);
        map.put("list",list);
        return map;
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
