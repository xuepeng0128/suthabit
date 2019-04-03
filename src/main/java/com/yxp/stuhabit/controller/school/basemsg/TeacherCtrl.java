package com.yxp.stuhabit.controller.school.basemsg;

import com.alibaba.fastjson.JSON;
import com.yxp.stuhabit.common.ExcelReader;
import com.yxp.stuhabit.common.XlsRead;
import com.yxp.stuhabit.entity.School;
import com.yxp.stuhabit.entity.Teacher;
import com.yxp.stuhabit.entity.TeacherDuty;
import com.yxp.stuhabit.entity.TeacherOnserve;
import com.yxp.stuhabit.entity.excelTemp.TeacherExcel;
import com.yxp.stuhabit.service.basemsg.TeacherService;
import com.yxp.stuhabit.service.dic.TeacherDutyService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/school/basemsg/teacher", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class TeacherCtrl extends XlsRead {
    @Autowired
    private TeacherService svr;
    @Autowired
    private TeacherDutyService dsvr;

    @PostMapping(value="/insertTeacher")
    public Teacher insertTeacher(@RequestBody Teacher teacher){
          return  svr.insertTeacher(teacher);
    }

    @PostMapping(value="/updateTeacher")
    public Teacher updateTeacher(@RequestBody Teacher teacher) {
        return svr.updateTeacher(teacher);
    }

    @PostMapping(value="/saveAllTeacher")
    public String saveAllTeacher(@RequestBody List<Teacher> teachers){
        List<Teacher> list= svr.saveAllTeacher(teachers);
        if (list.isEmpty())
        {
             return "fail";
        }else {
            return "ok";
        }
    }

    @GetMapping(value="/deleteTeacher")
    public String deleteTeacher(String paperId){
         try {
             svr.deleteTeacher(paperId);
             return "ok";
         } catch(Exception ex){
             return "fail" + ex.toString();
         }

    }


    @PostMapping(value = "/importTeacher")
    @ResponseBody
    public Map<String, Object> importTeacher(@RequestParam MultipartFile file,   @RequestParam String schoolJson,  //@RequestParam String month,
                                              HttpServletResponse response, HttpServletRequest request) throws IOException {
        boolean insertflag=false;
        String retstr = "";
        Map<String, Object> re = new HashMap<String, Object>();
        List<TeacherExcel> list =null;
            Map<String, Object> resMap = this.GetUploadfile(file, request, response);
        if(resMap.get("status").equals("ok")) {
            String originFileName = file.getOriginalFilename().split("\\.")[1].toUpperCase();
            /////////////////读文件插数据库/////////////////////////////////////
            ExcelReader eread = new ExcelReader();

            if (originFileName.equals("XLS")) {
                try {
                           list = eread.toDealXlsFile(
                            TeacherExcel.class,
                            new TeacherExcel().getExcelTableFeilds(),
                            "教职工表",
                            this.path, this.guidname
                    );
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
                ////////////////////////////////////////////////////
                insertflag = dealXlsFile(this.path, this.guidname, this.tablename,schoolJson);
            } else if (originFileName.equals("XLSX")) {
                insertflag = dealXlsxFile(this.path, this.guidname, this.tablename,schoolJson);
            } else {
                resMap.put("status", "上传文件失败！");
                retstr = JSON.toJSONString(resMap);
            }
            if (insertflag)
            {
                resMap.put("status","ok");
                retstr=JSON.toJSONString(resMap);
            }
            //////////////////////////////////////////////////////////
            PrintWriter writer = null;
            try {
                writer = response.getWriter();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            writer.print(retstr);
        }
        return re;


    }





    POIFSFileSystem fs=null;
    HSSFWorkbook wb=null;
    HSSFSheet sheet;
    HSSFRow row;
    @Override
    public boolean dealXlsFile(String path, String guidname, String tablename,String otherMsgJson) {
        School school= JSON.parseObject(otherMsgJson,School.class);
        File file = new File(path, guidname);
        //casilin:插入数据，先从excel中读取数据
        InputStream is=null;
        int n=0;
        Map<String, Object> paras = new HashMap<String, Object>();
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ExcelReader excelReader = new ExcelReader();

        String[] colName = excelReader.readExcelTitle(is,null);

        try {
            is.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //下面读取字段内容
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            fs = new POIFSFileSystem(is);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);

        //得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        List<Teacher> teacherList = new ArrayList<>();
        List<TeacherDuty> teacherDuties= dsvr.teacherDutyList();
        //正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            TeacherDuty duty=   teacherDuties.stream().filter(d -> d.teacherDutyName ==
                    excelReader.getStringCellValue(row.getCell(2)).trim()).findFirst().orElse(null);
            row = sheet.getRow(i);
            teacherList.add(
                new Teacher(
                        excelReader.getStringCellValue(row.getCell(0)).trim(),
                        excelReader.getStringCellValue(row.getCell(1)).trim(),
                        excelReader.getStringCellValue(row.getCell(2)).trim(),
                        duty,
                        new TeacherOnserve(school,null,null,duty)
                )
            );



        }
        ///////////////执行插入//////////////////////////////////
        if(svr.saveAllTeacher(teacherList).isEmpty())
            return false;
        else
            return true;
    }


    @Override
    public boolean dealXlsxFile(String path, String guidname, String tablename,String otherMsgJson) {
        return true;
    }
}
