package com.yxp.stuhabit.service.system;

import com.yxp.stuhabit.entity.Employee;
import org.springframework.format.annotation.DateTimeFormat;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public Map<String,Object> employeeList(String paperId, String employeeName, String tel, String dutyName, String pageSize, String pageNo, String getTotal);
    public Employee singleEmployee(String paperId);
    public Employee insertEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void     deleteEmployee(String paperId);

}
