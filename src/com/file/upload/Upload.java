package com.file.upload;

import java.io.*;
import java.nio.charset.Charset;

import org.apache.commons.net.ftp.FTPClient;
/**
 * @PackageName:com.sitech.libj_mios.file
 * @ClassName:Upload
 * @Description:
 * @author: libj_mios
 * @date: 2019/1/10 16:29
 */

public class Upload{

    public void conn(String fileName,String path){

        String ips[] = {"172.21.10.37","21","crm2webapp","crm2webapp"};
        FTPClient ftp = new FTPClient();
        try{
            ftp.connect(ips[0],Integer.parseInt(ips[1]));
            ftp.login(ips[2],ips[3]);
            ftp.setCharset(Charset.forName("UTF-8"));
            ftp.setControlEncoding("UTF-8");
            fileName = new String(fileName.getBytes("GBK"),"iso-8859-1");
            ftp.changeWorkingDirectory("/crm2webapp/YSL/TEMP");
            ftp.storeFile(fileName,new FileInputStream(path));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Upload up = new Upload();
        up.conn("A上传测试001","C:/Users/57180/Desktop/上传测试.txt");

    }
}