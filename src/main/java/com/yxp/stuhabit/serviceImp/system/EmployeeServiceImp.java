package com.yxp.stuhabit.serviceImp.system;

import com.yxp.stuhabit.entity.Employee;
import com.yxp.stuhabit.repo.system.EmployeeRepo;
import com.yxp.stuhabit.service.system.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private EmployeeRepo repo;
    @Override
    public List<Employee> employeeList(String paperId,String employeeName, String tel, String dutyName,String pageSize,String pageNo ) {

        Criteria criteria = new Criteria( );
        if (paperId!=null && !paperId.equals(""))
        {
            criteria=criteria.and("paperId").regex(".*" +paperId +"*.");
        }
        if (employeeName!=null && !employeeName.equals(""))
        {
            criteria=criteria.and("employeeName").regex(".*" +employeeName +"*.");
        }
        if (dutyName!=null && !dutyName.equals(""))
        {
            criteria=criteria.and("duty").regex(".*" +dutyName +"*.");
        }
        Query query= new Query();
        query.addCriteria(criteria).skip( (Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize)).limit(Integer.parseInt(pageSize));
        List<Employee> list = mongoTemplate.find(query,Employee.class);
        return list;
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        return repo.insert(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public void deleteEmployee(String paperId) {
          repo.deleteById(paperId);
    }
}
