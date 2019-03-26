package com.yxp.stuhabit.service.system;

import com.yxp.stuhabit.entity.Employee;
import org.springframework.format.annotation.DateTimeFormat;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

public interface EmployeeService {
    public List<Employee> employeeList(String paperId,String employeeName, String tel, String dutyName, String pageSize,String pageNo);
    public Employee insertEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void     deleteEmployee(String paperId);

}
