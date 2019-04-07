package com.yxp.stuhabit.serviceImp.system;

import com.yxp.stuhabit.entity.Menu;
import com.yxp.stuhabit.repo.system.MenuRepo;
import com.yxp.stuhabit.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImp implements MenuService {
    @Autowired
    private MenuRepo repo;
    @Override
    public List<Menu> menuList(int kind) {

            return repo.findMenuByKind(kind);

    }
}
