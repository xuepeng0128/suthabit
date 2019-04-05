package com.yxp.stuhabit.controller.school.basemsg;


import com.alibaba.fastjson.JSON;
import com.yxp.stuhabit.common.ExcelReader;
import com.yxp.stuhabit.common.XlsRead;
import com.yxp.stuhabit.entity.Student;
import com.yxp.stuhabit.entity.excelTemp.StudentExcel;
import com.yxp.stuhabit.entity.excelTemp.TeacherExcel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/school/basemsg/student", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class StudentCtrl extends XlsRead {

    @PostMapping(value = "/importStudent")
    @ResponseBody
    public Map<String, Object> importStudent(@RequestParam MultipartFile file, //  @RequestParam String schoolId,  //@RequestParam String month,
                                             HttpServletResponse response, HttpServletRequest request) throws IOException {
        boolean insertflag=false;
        String retstr = "";
        Map<String, Object> re = new HashMap<String, Object>();
        List<StudentExcel> list =null;
        Map<String, Object> resMap = this.GetUploadfile(file, request, response);
        if(resMap.get("status").equals("ok")) {
            String originFileName = file.getOriginalFilename().split("\\.")[1].toUpperCase();
            /////////////////读文件插数据库/////////////////////////////////////
            ExcelReader eread = new ExcelReader();

            if (originFileName.equals("XLS")) {
                try {
                    list = eread.toDealXlsFile(
                            StudentExcel.class,
                            new StudentExcel().getExcelTableFeilds(),
                            "学生表",
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
                insertflag = dealXlsFile(this.path, this.guidname, this.tablename,"");
            } else if (originFileName.equals("XLSX")) {
                insertflag = dealXlsxFile(this.path, this.guidname, this.tablename,"");
            } else {
                resMap.put("status", "上传文件失败！");
                retstr = JSON.toJSONString(resMap);
            }
            if (insertflag)
            {
                resMap.put("list",list);
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




    @Override
    public boolean dealXlsFile(String path, String guidname, String tablename, String otherMsgJson) {
        return false;
    }

    @Override
    public boolean dealXlsxFile(String path, String guidname, String tablename, String otherMsgJson) {
        return false;
    }
}
