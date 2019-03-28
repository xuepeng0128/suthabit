package com.yxp.stuhabit.serviceImp.system;

import com.alibaba.fastjson.JSON;
import com.yxp.stuhabit.common.Md5Tool;
import com.yxp.stuhabit.entity.*;
import com.yxp.stuhabit.repo.system.MenuRepo;
import com.yxp.stuhabit.repo.system.UserRepo;
import com.yxp.stuhabit.service.system.InitSysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InitSysServiceImpl implements InitSysService {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    UserRepo userRepo;
    @Autowired
    MenuRepo menuRepo;
    @Override
    public void initSys() {
        //1.判断是否存在admin用户
        if (userRepo.existsById("supadmin"))
            return;
        //3.插入菜单项
        List<Menu> menulist=  JSON.parseArray(menuJsonstr(),Menu.class);
        menuRepo.saveAll(menulist);
        //2.插入supperadmin用户
        userRepo.save(new User("supadmin",Md5Tool.string2MD5("a"),null,null,true,false,null,
                menulist.stream().filter(m ->m.getKind()==1 ).collect(Collectors.toList())));



       // ExecutableMongoScript script = new ExecutableMongoScript(makeBillIdStr);
      //  scriptOps.register(new NamedMongoScript("makeBillId", script)); //指定脚本名称
       // scriptOps.execute(script, "directly execute script");

    }

    private String menuJsonstr(){
        String jsonstr="[" +
                       "   { 'menuId' :'101', 'menuName' :'数据资源', 'url' : '/','powers':'', 'kind':1,'subMenu':[" +
                       "                   { 'menuId' :'10101', 'menuName' :'学校资源', 'url' : '/','powers':'','kind':1, 'subMenu':[ ] }," +
                       "                   { 'menuId' :'00102', 'menuName' :'学生资源', 'url' : '/','powers':'','kind':1, 'subMenu':[ ] }," +
                       "                   { 'menuId' :'00103', 'menuName' :'教师资源', 'url' : '/','powers':'','kind':1, 'subMenu':[ ] }," +
                       "                   { 'menuId' :'00104', 'menuName' :'微习惯资源', 'url' : '/','powers':'','kind':1, 'subMenu':[ ] }," +
                       "                   { 'menuId' :'00105', 'menuName' :'培训机构资源', 'url' : '/','powers':'','kind':1, 'subMenu':[ ] }" +
                       "               ] " +
                       "   },    " +
                        "   { 'menuId' :'102', 'menuName' :'统计分析', 'url' : '/','powers':'','kind':1, 'subMenu':[" +
                        "               ] " +
                        "   }  ,   " +
                        "   { 'menuId' :'108', 'menuName' :'字典管理', 'url' : '/','powers':'', 'kind':1,'subMenu':[" +
                        "               ] " +
                        "   }  ,   " +
                        "   { 'menuId' :'109', 'menuName' :'系统管理', 'url' : '/','powers':'','kind':1, 'subMenu':[" +
                        "                   { 'menuId' :'10901', 'menuName' :'微习惯通用模板', 'url' : '/','powers':'','kind':1, 'subMenu':[ ] }," +
                        "                   { 'menuId' :'10902', 'menuName' :'员工管理', 'url' : '/','powers':'','kind':1, 'subMenu':[ ] }," +
                        "                   { 'menuId' :'10903', 'menuName' :'系统用户', 'url' : '/','powers':'','kind':1, 'subMenu':[ ] }," +
                        "                   { 'menuId' :'10904', 'menuName' :'第三方机构管理员', 'url' : '/','powers':'','kind':1, 'subMenu':[ ] }," +
                        "               ] " +
                        "   } ,    " +
                        "   { 'menuId' :'201', 'menuName' :'基础数据', 'url' : '/','powers':'','kind':2, 'subMenu':[" +
                        "                   { 'menuId' :'00501', 'menuName' :'库存明细', 'url' : '/','powers':'','kind':2, 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00502', 'menuName' :'销售明细', 'url' : '/','powers':'', 'kind':2,'subMenu':[ ] }," +
                        "                   { 'menuId' :'00503', 'menuName' :'进销存汇总', 'url' : '/','powers':'','kind':2, 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00504', 'menuName' :'单品进销存明细', 'url' : '/','powers':'','kind':2, 'subMenu':[ ] }," +
                        "               ] " +
                        "   { 'menuId' :'202', 'menuName' :'微习惯养成', 'url' : '/','powers':'','kind':2, 'subMenu':[" +
                        "                   { 'menuId' :'00601', 'menuName' :'计量单位', 'url' : '/frame/dictionary/unit','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00602', 'menuName' :'品牌', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00603', 'menuName' :'付款约定', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00604', 'menuName' :'付款方式', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "               ] " +
                        "   } ,    " +
                        "   { 'menuId' :'203', 'menuName' :'统计分析', 'url' : '/','powers':'', 'subMenu':[" +
                        "                   { 'menuId' :'00601', 'menuName' :'计量单位', 'url' : '/frame/dictionary/unit','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00602', 'menuName' :'品牌', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00603', 'menuName' :'付款约定', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00604', 'menuName' :'付款方式', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "               ] " +
                        "   },     " +
                        "   { 'menuId' :'209', 'menuName' :'系统管理', 'url' : '/','powers':'', 'subMenu':[" +
                        "                   { 'menuId' :'00601', 'menuName' :'计量单位', 'url' : '/frame/dictionary/unit','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00602', 'menuName' :'品牌', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00603', 'menuName' :'付款约定', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00604', 'menuName' :'付款方式', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "               ] " +
                        "   }     " +
                       "]";
        return jsonstr;
    }


}
