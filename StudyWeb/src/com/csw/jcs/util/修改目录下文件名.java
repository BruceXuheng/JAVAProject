package com.csw.jcs.util;

import java.io.File;
import java.util.ArrayList;

public class 修改目录下文件名 {

    public static void main(String[] args) {
        ArrayList<String> fileNameList = new ArrayList<>();
        getAllFileName("G:\\java慕课就业\\2 web\\步骤一 网页搭建入门\\04 前端油画商城案例\\",fileNameList);
    }


    /**
     * 获取某个文件夹下的所有文件
     *
     * @param fileNameList 存放文件名称的list
     * @param path 文件夹的路径
     * @return
     */
    public static void getAllFileName(String path,ArrayList<String> fileNameList) {
        //ArrayList<String> files = new ArrayList<String>();
        boolean flag = false;
        File file = new File(path);
        File[] tempList = file.listFiles();

        assert tempList != null;
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                //fileNameList.add(tempList[i].toString());
                fileNameList.add(tempList[i].getName());
              System.out.println("文     件：" + tempList[i].getName());
              if(tempList[i].toString().contains("【微信a_xue1995 售各类资源")){
                  String str = tempList[i].toString().replace("【微信a_xue1995 售各类资源】","");
                  tempList[i].renameTo(new File(str));
              }

//                System.out.println();
            }
            if (tempList[i].isDirectory()) {
//              System.out.println("文件夹：" + tempList[i]);
                getAllFileName(tempList[i].getAbsolutePath(),fileNameList);
            }
        }
        return;
    }




}
