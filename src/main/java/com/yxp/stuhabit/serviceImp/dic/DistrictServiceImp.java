package com.yxp.stuhabit.serviceImp.dic;

import com.yxp.stuhabit.entity.District;
import com.yxp.stuhabit.repo.dic.DistrictRepo;
import com.yxp.stuhabit.service.dic.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImp implements DistrictService {
    @Autowired
    private DistrictRepo repo;
    @Override
    public List<District> studentList() {
        ;return repo.findAll();
    }
}
