package com.yxp.stuhabit.serviceImp.system;

import com.alibaba.fastjson.JSON;
import com.yxp.stuhabit.common.Md5Tool;
import com.yxp.stuhabit.entity.District;
import com.yxp.stuhabit.entity.Menu;
import com.yxp.stuhabit.entity.User;
import com.yxp.stuhabit.repo.dic.DistrictRepo;
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
    @Autowired
    DistrictRepo districtRepo;
    @Override
    public void initSys() {
        //1.判断是否存在admin用户
        if (userRepo.existsById("supadmin"))
            return;
        //3.插入菜单项
        List<Menu> menulist=  JSON.parseArray(menuJsonstr(),Menu.class);
        menuRepo.saveAll(menulist);
        //2.插入supperadmin用户



        userRepo.save(new User("supadmin","supadmin",Md5Tool.string2MD5("a"),null,null,true,false,false,null,null,
                null));


        //.4.插入区域字典
        List<District> districtList = JSON.parseArray(this.cityJsonstr(),District.class);
        districtRepo.saveAll(districtList);



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
                        "                   { 'menuId' :'10805', 'menuName' :'试卷题型', 'url' : '/frame/corpdic/subjectexamclass','powers':'','kind':1, 'subMenu':[ ] }," +
                        "               ] " +
                        "   }  ,   " +
                        "   { 'menuId' :'109', 'menuName' :'系统管理', 'url' : '/','powers':'','kind':1, 'subMenu':[" +
                        "                   { 'menuId' :'10901', 'menuName' :'员工管理', 'url' : '/frame/corpsystem/employee','powers':'','kind':1, 'subMenu':[ ] }," +
                        "                   { 'menuId' :'10902', 'menuName' :'系统用户', 'url' : '/frame/corpsystem/user','powers':'','kind':1, 'subMenu':[ ] }," +
                        "                   { 'menuId' :'10903', 'menuName' :'用户权限', 'url' : '/frame/corpsystem/userPower','powers':'','kind':1, 'subMenu':[ ] }," +
                        "                   { 'menuId' :'10904', 'menuName' :'学校管理员', 'url' : '/frame/corpsystem/schoolAdmin','powers':'','kind':1, 'subMenu':[ ] }," +
                        "                   { 'menuId' :'10905', 'menuName' :'培训机构管理员', 'url' : '/frame/corpsystem/trainschoolAdmin','powers':'','kind':1, 'subMenu':[ ] }," +
                        "                   { 'menuId' :'10909', 'menuName' :'修改密码', 'url' : '/frame/corpsystem/changePwd','powers':'','kind':1, 'subMenu':[ ] }," +
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

    // 区域
    // private String  districtId;
    //   private String  districtName;
    //   private City city;
    private String cityJsonstr(){
        String jsonstr="[" +
                        "{districtId :'370602000000',districtName :'芝罘区',city :{cityId : '370600000000',cityName : '烟台市'}}," +
                        "{districtId :'370611000000',districtName :'福山区',city :{cityId : '370600000000',cityName : '烟台市'}}," +
                        "{districtId :'370612000000',districtName :'牟平区',city :{cityId : '370600000000',cityName : '烟台市'}}," +
                        "{districtId :'370613000000',districtName :'莱山区',city :{cityId : '370600000000',cityName : '烟台市'}}," +
                        "{districtId :'370634000000',districtName :'长岛县',city :{cityId : '370600000000',cityName : '烟台市'}}," +
                        "{districtId :'370671000000',districtName :'烟台高新技术产业开发区',city :{cityId : '370600000000',cityName : '烟台市'}}," +
                        "{districtId :'370672000000',districtName :'烟台经济技术开发区',city :{cityId : '370600000000',cityName : '烟台市'}}," +
                        "]";
        return jsonstr;
    }

}
