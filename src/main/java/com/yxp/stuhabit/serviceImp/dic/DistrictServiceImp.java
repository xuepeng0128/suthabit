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
    public List<District> districtList() {
        ;return repo.findAll();
    }

    @Override
    public District singleDistrict(String districtId) {
        return repo.findById(districtId).orElse(null);
    }
}
