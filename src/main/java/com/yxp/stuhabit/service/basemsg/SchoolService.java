package com.yxp.stuhabit.service.basemsg;

import com.yxp.stuhabit.entity.School;

import java.util.List;
import java.util.Map;

public interface SchoolService {
    public Map<String,Object> schoolList(String schoolId, String schoolName, String districtId, String address,
                                         String employeeName, String pageSize, String pageNo, String getTotal);
    public School insertSchool(School school);
    public School updateSchool(School school);
    public School deleteSchool(String schoolId);
}
