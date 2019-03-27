package com.yxp.stuhabit.controller;

import com.mongodb.*;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping(value = "/fileApi", method = {RequestMethod.GET,RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class DownLoadFileCtrl {

    @PostMapping(value = "/downloadFile")
    public void downloadFile(String filename,String path,HttpServletRequest request, MongoDbFactory mongoDbFactory){
        //获取数据库连接
        DB db=mongoDbFactory.getLegacyDb();
        //GridFS 是一种将文件写入mongodb的规范，他会将大型文件分割成几个小型文件存入到mongodb数据库中
        GridFS gridFS=new GridFS(db);
        //创建一个查询
        DBObject dbo=new BasicDBObject();
        ((BasicDBObject) dbo).put("filename",filename);
        //通过gridFS查询对应条件的文件，
        GridFSDBFile gffile=gridFS.findOne(dbo);
        if(!new File(path).exists()){
            new File(path).mkdir();
        }
        try {
//            gffile.writeTo(response.getOutputStream());
            path=path+filename;
            gffile.writeTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping(value = "/findFile")
    public GridFSDBFile findFile(String filename, MongoDbFactory mongoDbFactory){
        //获取数据库连接
        DB db=mongoDbFactory.getLegacyDb();
        //GridFS 是一种将文件写入mongodb的规范，他会将大型文件分割成几个小型文件存入到mongodb数据库中
        GridFS gridFS=new GridFS(db);
        //创建一个查询
        DBObject dbo=new BasicDBObject();
        ((BasicDBObject) dbo).put("filename",filename);
        //通过gridFS查询对应条件的文件，
        GridFSDBFile gffile=gridFS.findOne(dbo);
        return gffile;
    }


}
