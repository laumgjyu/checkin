package com.out.util;

import java.io.File;
import java.io.IOException;

/**
 * Created by lmy on 2017/6/12.
 */
public class FileUtil {

    StringBuffer status = new StringBuffer();
    public  StringBuffer listFiles(String path) {

        System.out.println(path);

        File file = new File(path);
        System.out.println(file.exists());
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files == null || files.length == 0) {
//                status.append("没有可用于下载的文件！");
                return status;
            } else {
                for (File file2 : files) {
                    /*
                    '\'在java中是一个转义字符，所以需要用两个代表一个。例如System.out.println( "\\" ) ;只打印出一个"\"。但是'\'也是正则表达式中的转义字符（replaceAll、split 的参数就是正则表达式），需要用两个代表一个。
                     */
                    String[] pathes = file2.getParent().split("\\\\");
                    String userPath = pathes[pathes.length - 1];
                    if (file2.isDirectory()) {
                        listFiles(file2.getPath());
                    } else {
                        status.append(userPath + "----" + file2.getName() + "----");
                    }

                }
                return status;
            }
        } else {
            status.append("路径错误！请通知管理员！");
        }
        return status;
    }

    public  String getPath(String p) {
        ClassLoader classLoader = Thread.currentThread()
                .getContextClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        java.net.URL url = classLoader.getResource("");
//        System.out.println(url);

        String ROOT_CLASS_PATH = url.getPath() + "/";
//        System.out.println(ROOT_CLASS_PATH);

        File rootFile = new File(ROOT_CLASS_PATH);
        String WEB_INFO_DIRECTORY_PATH = rootFile.getParent() + "/";
//        System.out.println(WEB_INFO_DIRECTORY_PATH);

        File webInfoDir = new File(WEB_INFO_DIRECTORY_PATH);
        String SERVLET_CONTEXT_PATH = webInfoDir.getParent() + "/";
//        System.out.println(SERVLET_CONTEXT_PATH);
        //这里 SERVLET_CONTEXT_PATH 就是WebRoot的路径

        String path = SERVLET_CONTEXT_PATH + p;
        path = path.replaceAll("%20", " ");
//        System.out.println(path);
        //文件搞到手

        return path;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("web/upload/312/");
        System.out.println(file.exists());
//        System.out.println(file.getAbsoluteFile());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getCanonicalFile());
//        System.out.println(file.getCanonicalPath());
//        System.out.println(file.getPath());




    }
}
