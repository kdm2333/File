package com.file.bylabel;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.*;

/**
 * @PackageName:com.sitech.libj_mios.file
 * @ClassName:UploadTest
 * @Description:
 * @author: libj_mios
 * @date: 2019/1/10 10:35
 */
public class Bylabel {
/*
 * @Author libj_mios
 * @Description 通过标签名，输出标签下的参数
 * @Date 10:38 2019/1/10
 * @Param String
 * @return Map
 **/
    public Map<String,String> byLabel(String label){
        int i = label.length();
        Map<String,String> map = new HashMap<String,String>();
        try {
            File file = new File("C:/Users/57180/Desktop/ftpfile.properties");
            InputStream in = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            List<String> lines = IOUtils.readLines(br);
            Iterator ite = lines.iterator();
            while (ite.hasNext()){
                String line_1 = ite.next().toString();
                int m = line_1.indexOf("[");
                int n = line_1.indexOf("]",m);
                if (0<=m&&m<n){
                    String label_1 = line_1.substring(m+1,n);
                    if (label.equals(label_1)){
                        break;
                    }
                }
            }
            while (ite.hasNext()){
                String line_2 = ite.next().toString();
                int h = line_2.indexOf("[");
                if (0>h){
                    String[] strings = line_2.split("=");
                    if (strings[0].equals("")) {
                        continue;
                    }else {
                        map.put(strings[0], strings[1]);
                        //System.out.println(strings[0] + ":" + strings[1]);
                    }
                }else {
                    break;
                }
            }
            in.close();
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return map;
    }

    public static  void  main(String[] args){
        Bylabel test = new Bylabel();
        Map<String,String> map = test.byLabel("SMPS_GROOVY_PATH ");//BATCH_FUNC_FTP
        Set set = map.entrySet();
        Iterator item = set.iterator();
        while (item.hasNext()){
            System.out.println(item.next());
        }
    }
}
