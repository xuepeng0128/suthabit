package com.yxp.stuhabit.repo.system;

import com.yxp.stuhabit.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository<Employee,String> {
}
