package com.yxp.stuhabit.controller.corp.system;

import com.yxp.stuhabit.entity.Menu;
import com.yxp.stuhabit.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/corp/system/menu", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class MenuCtrl {
    @Autowired
    private MenuService svr;

    @GetMapping(value = "/allMenu")
    public List<Menu> menuList(String kind){
        return  svr.menuList(Integer.parseInt(kind));
    }


}
