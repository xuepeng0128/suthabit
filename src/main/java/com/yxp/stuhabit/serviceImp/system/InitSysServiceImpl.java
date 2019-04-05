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

    // 菜单
    private String menuJsonstr(){
        String jsonstr="[" +
                       "   { 'menuId' :'101', 'menuName' :'数据资源', 'url' : '/','powers':'', 'kind':1,'subMenu':[" +
                       "                   { 'menuId' :'10101', 'menuName' :'学校资源', 'url' : '/frame/corpbasemsg/school','powers':'','kind':1, 'subMenu':[ ] }," +
                       "                   { 'menuId' :'00102', 'menuName' :'学生资源', 'url' : '/frame/corpbasemsg/student','powers':'','kind':1, 'subMenu':[ ] }," +
                       "                   { 'menuId' :'00103', 'menuName' :'教师资源', 'url' : '/frame/corpbasemsg/teacher','powers':'','kind':1, 'subMenu':[ ] }," +
                       "                   { 'menuId' :'00104', 'menuName' :'微习惯资源', 'url' : '/frame/corpbasemsg/circle','powers':'','kind':1, 'subMenu':[ ] }," +
                       "                   { 'menuId' :'00105', 'menuName' :'培训机构资源', 'url' : '/','powers':'','kind':1, 'subMenu':[ ] }" +
                       "               ] " +
                       "   },    " +
                        "   { 'menuId' :'102', 'menuName' :'统计分析', 'url' : '/','powers':'','kind':1, 'subMenu':[" +
                        "               ] " +
                        "   }  ,   " +
                        "   { 'menuId' :'108', 'menuName' :'字典管理', 'url' : '/','powers':'', 'kind':1,'subMenu':[" +
                        "                   { 'menuId' :'10801', 'menuName' :'微习惯资源池', 'url' : '/frame/corpdic/habittemplate','powers':'','kind':1, 'subMenu':[ ] }," +
                        "                   { 'menuId' :'10802', 'menuName' :'公司职务', 'url' : '/frame/corpdic/corpduty','powers':'','kind':1, 'subMenu':[ ] }," +
                        "                   { 'menuId' :'10803', 'menuName' :'学校职务', 'url' : '/frame/corpdic/teacherduty','powers':'','kind':1, 'subMenu':[ ] }," +
                        "                   { 'menuId' :'10804', 'menuName' :'学校课程', 'url' : '/frame/corpdic/studysubject','powers':'','kind':1, 'subMenu':[ ] }," +
                        "                   { 'menuId' :'10805', 'menuName' :'试卷题型', 'url' : '/frame/corpdic/questiontype','powers':'','kind':1, 'subMenu':[ ] }," +
                        "               ] " +
                        "   }  ,   " +
                        "   { 'menuId' :'109', 'menuName' :'系统管理', 'url' : '/','powers':'','kind':1, 'subMenu':[" +
                        "                   { 'menuId' :'10901', 'menuName' :'员工管理', 'url' : '/frame/corpsystem/employee','powers':'','kind':1, 'subMenu':[ ] }," +
                        "                   { 'menuId' :'10902', 'menuName' :'系统用户', 'url' : '/frame/corpsystem/user','powers':'','kind':1, 'subMenu':[ ] }," +
                        "                   { 'menuId' :'10903', 'menuName' :'用户权限', 'url' : '/frame/corpsystem/userPower','powers':'','kind':1, 'subMenu':[ ] }," +
                        "                   { 'menuId' :'10904', 'menuName' :'第三方机构管理员', 'url' : '/frame/corpsystem/schoolAdmin','powers':'','kind':1, 'subMenu':[ ] }," +
                        "                   { 'menuId' :'10905', 'menuName' :'修改密码', 'url' : '/frame/corpsystem/changePwd','powers':'','kind':1, 'subMenu':[ ] }," +
                        "               ] " +
                        "   } ,    " +
                        "   { 'menuId' :'201', 'menuName' :'基础数据', 'url' : '/','powers':'','kind':2, 'subMenu':[" +
                        "                   { 'menuId' :'00501', 'menuName' :'学校信息', 'url' : '/','powers':'','kind':2, 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00502', 'menuName' :'教师信息', 'url' : '/','powers':'', 'kind':2,'subMenu':[ ] }," +
                        "                   { 'menuId' :'00503', 'menuName' :'班级信息', 'url' : '/','powers':'','kind':2, 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00504', 'menuName' :'学生信息', 'url' : '/','powers':'','kind':2, 'subMenu':[ ] }," +
                        "               ] " +
                        "   { 'menuId' :'202', 'menuName' :'微习惯', 'url' : '/','powers':'','kind':2, 'subMenu':[" +
                        "                   { 'menuId' :'00601', 'menuName' :'习惯圈', 'url' : '/frame/dictionary/unit','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00602', 'menuName' :'学生打卡', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00603', 'menuName' :'打卡考评', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00604', 'menuName' :'考试成绩导入', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "               ] " +
                        "   } ,    " +
                        "   { 'menuId' :'203', 'menuName' :'微达学院', 'url' : '/','powers':'','kind':2, 'subMenu':[" +
                        "                   { 'menuId' :'00601', 'menuName' :'课程发布', 'url' : '/frame/dictionary/unit','powers':'', 'subMenu':[ ] }," +

                        "               ] " +
                        "   } ,    " +
                        "   { 'menuId' :'203', 'menuName' :'统计分析', 'url' : '/','powers':'', 'subMenu':[" +

                        "               ] " +
                        "   },     " +
                        "   { 'menuId' :'209', 'menuName' :'系统管理', 'url' : '/','powers':'', 'subMenu':[" +
                        "                   { 'menuId' :'00601', 'menuName' :'用户管理', 'url' : '/frame/dictionary/unit','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00602', 'menuName' :'用户权限', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00603', 'menuName' :'修改密码', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "               ] " +
                        "   }     " +
                       "]";
        return jsonstr;
    }

    // 市州
    private String cityJsonstr(){
        String jsonstr="[";
        return jsonstr;
    }

}
