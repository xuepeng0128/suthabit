package com.yxp.stuhabit.service.basemsg;

import com.yxp.stuhabit.entity.School;

import java.util.List;

public interface SchoolService {
    public List<School> schoolList(String schoolId,String schoolName,String cityId,String districtId,String address,String paperId,String pageSize,String pageNo);
    public School insertSchool(School school);
    public School updateSchool(School school);
    public School deleteSchool(String schoolId);
}
