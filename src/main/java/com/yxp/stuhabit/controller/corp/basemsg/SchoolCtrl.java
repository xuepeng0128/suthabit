package com.yxp.stuhabit.controller.corp.basemsg;

import com.yxp.stuhabit.service.basemsg.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/basemsg/school", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class SchoolCtrl {
     @Autowired
    private SchoolService svr;


}
