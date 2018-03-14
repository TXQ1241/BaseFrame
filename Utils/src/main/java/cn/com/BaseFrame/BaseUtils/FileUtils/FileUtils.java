package cn.com.BaseFrame.BaseUtils.FileUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件工具类
 *
 * @author xyh
 * @create 2018-02-22 15:18
 **/
public class FileUtils implements Serializable {

    /**
     *  @Description: 一键替换
     *  @author xyh
     *  @Date 14:31 2018/3/14
     *  @method replace : 一键替换
     *  params  filePath : 文件路径,mattcher 要被替换的内容,content 替换的内容
     *  @return 
     *  @exception 
     **/
    public void replaceFile(String filePath,String mattcher,String content,String fileType) {
        File file = new File(filePath);
        isDirectory(file,mattcher,content,fileType);
    }

    /**
     *  @Description: 判断是不是文件夹,
     *  @author xyh
     *  @Date 14:48 2018/3/14
     *  @method
     *  params
     *  @return
     *  @exception
     **/
    public void isDirectory(File srcFile,String mattcher,String content,String fileType) {
        if(srcFile.isDirectory()) {
            File[] files = srcFile.listFiles();
            for(File file : files) {
                isDirectory(file,mattcher,content,fileType);
            }
        }else {
            replace(srcFile,mattcher,content,fileType);
        }
    }

    public void replace(File srcFile,String mattcher,String content,String fileType) {
        try {
            String fileName = srcFile.getName();
            if(fileType != null && !"".equals(fileType)) {
                //按照,进行拆分
                String[] types = fileType.split(",");
                for(String type : types) {
                    if(!fileName.endsWith("type")) {
                        return;
                    }
                }
            }

            String path = srcFile.getAbsolutePath();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(srcFile),"utf-8"));

            String line = "";
            boolean flag = false;
            List<String> lineList = new ArrayList<String>();

            while((line = bufferedReader.readLine()) != null) {
                if(line.contains(mattcher)) {
                    line = line.replaceAll(mattcher,  content);
                    //需要定义一个标识符,如果有,那么则回写,如果没有,那么不回写,直接跳过
                    flag = true;
                }
                lineList.add(line);
            }

            bufferedReader.close();


            //如果没有,就不回写
            if(flag) {
                //开启写
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(srcFile),"utf-8"));

                System.out.println(srcFile.getAbsolutePath());
                for(String str : lineList) {
                    bufferedWriter.write(str);
                    bufferedWriter.write("\r"); //添加换行
                }
                bufferedWriter.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
