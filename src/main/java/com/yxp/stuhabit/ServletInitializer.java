package com.yxp.stuhabit;

import com.yxp.stuhabit.service.system.InitSysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class ServletInitializer extends SpringBootServletInitializer {
    @Autowired
    private InitSysService svr;
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StuhabitApplication.class);
    }
    @RequestMapping("/")
    public String test()
    {
         svr.initSys();
        return "index.html";
    }
}
