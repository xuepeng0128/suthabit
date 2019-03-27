package com.yxp.stuhabit.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/transFile", method = {RequestMethod.GET,RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class UploadFileCtrl {

    @Autowired private GridFsTemplate gft;

    @RequestMapping(value = "/uploadFileToLocal")
    public String uploadFileToLocal(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        uploadFileToRepo(file,request,response);
        String filename=file.getOriginalFilename();
        String path = "";
        String[] str =  filename.split("\\.");
        String fileFormat = str[str.length - 1];
        if("png".equalsIgnoreCase(fileFormat) || "jpg".equalsIgnoreCase(fileFormat) || "gif".equalsIgnoreCase(fileFormat)){
            //path = request.getContextPath()+"/src/main/resources/static/photos/";
            path=request.getSession().getServletContext().getRealPath("/photos/");
        }
        if("MP4".equalsIgnoreCase(fileFormat) || "M4V".equalsIgnoreCase(fileFormat) || "3GP".equalsIgnoreCase(fileFormat) || "3G2".equalsIgnoreCase(fileFormat) || "WMV".equalsIgnoreCase(fileFormat) || "ASF".equalsIgnoreCase(fileFormat) ||
                "AVI".equalsIgnoreCase(fileFormat) || "FLV".equalsIgnoreCase(fileFormat) || "MKV".equalsIgnoreCase(fileFormat) || "WEBM".equalsIgnoreCase(fileFormat)){
            path=request.getSession().getServletContext().getRealPath("/vedios/");
        }
        if("mp3".equalsIgnoreCase(fileFormat)){
            path=request.getSession().getServletContext().getRealPath("/audios/");
        }
        File file1 = new File(path);
        if(!file1.exists()){
            file1.mkdir();
        }
        try {
            BufferedOutputStream os=new BufferedOutputStream(new FileOutputStream(new File(path+filename)));
            os.write(file.getBytes());
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }

    @RequestMapping(value = "/uploadFileToRepo")
    public void uploadFileToRepo(MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        String filename=file.getOriginalFilename();
        try {
            ObjectId oi=gft.store(file.getInputStream(),filename);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

}
