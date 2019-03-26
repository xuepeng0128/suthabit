package com.yxp.stuhabit.serviceImp.system;

import com.alibaba.fastjson.JSON;
import com.yxp.stuhabit.common.Md5Tool;
import com.yxp.stuhabit.entity.Menu;
import com.yxp.stuhabit.entity.User;
import com.yxp.stuhabit.repo.system.MenuRepo;
import com.yxp.stuhabit.repo.system.UserRepo;
import com.yxp.stuhabit.service.system.InitSysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

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
        //2.插入supperadmin用户
        userRepo.save(new User("supadmin",Md5Tool.string2MD5("a"),null,null,true,false,null));
        //3.插入菜单项
        List<Menu> menulist=  JSON.parseArray(menuJsonstr(),Menu.class);
        menuRepo.saveAll(menulist);


       // ExecutableMongoScript script = new ExecutableMongoScript(makeBillIdStr);
      //  scriptOps.register(new NamedMongoScript("makeBillId", script)); //指定脚本名称
       // scriptOps.execute(script, "directly execute script");

    }

    private String menuJsonstr(){
        String jsonstr="[" +
                       "   { 'menuId' :'101', 'menuName' :'日常业务', 'url' : '/','powers':'', 'subMenu':[" +
                       "                   { 'menuId' :'10101', 'menuName' :'产品分类', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                       "                   { 'menuId' :'00102', 'menuName' :'产品档案', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                       "                   { 'menuId' :'00103', 'menuName' :'供货商分类', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                       "                   { 'menuId' :'00104', 'menuName' :'供货商管理', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                       "                   { 'menuId' :'00105', 'menuName' :'采购订单', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                       "                   { 'menuId' :'00106', 'menuName' :'采购入库单', 'url' : '/','powers':'', 'subMenu':[ ] }" +
                       "               ] " +
                       "   },    " +
                        "   { 'menuId' :'102', 'menuName' :'统计分析', 'url' : '/','powers':'', 'subMenu':[" +
                        "               ] " +
                        "   }  ,   " +
                        "   { 'menuId' :'108', 'menuName' :'字典管理', 'url' : '/','powers':'', 'subMenu':[" +
                        "                   { 'menuId' :'00301', 'menuName' :'客户档案', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00302', 'menuName' :'总部销售出库单', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00303', 'menuName' :'销售报表', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00304', 'menuName' :'门店设置', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "               ] " +
                        "   }     " +
                        "   { 'menuId' :'109', 'menuName' :'系统管理', 'url' : '/','powers':'', 'subMenu':[" +
                        "                   { 'menuId' :'00401', 'menuName' :'库存明细账', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00402', 'menuName' :'销售明细账', 'url' : '/','powers':'', 'subMenu':[ ] }," +

                        "                   { 'menuId' :'00404', 'menuName' :'单品进销存明细', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "               ] " +
                        "   }     " +
                        "   { 'menuId' :'201', 'menuName' :'基础数据', 'url' : '/','powers':'', 'subMenu':[" +
                        "                   { 'menuId' :'00501', 'menuName' :'库存明细', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00502', 'menuName' :'销售明细', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00503', 'menuName' :'进销存汇总', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00504', 'menuName' :'单品进销存明细', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "               ] " +
                        "   { 'menuId' :'202', 'menuName' :'日常业务', 'url' : '/','powers':'', 'subMenu':[" +
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
