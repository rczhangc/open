package org.open.boot.util.file;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @author barnak
 */
public class FileUtil {

    /**
     * 从网络下载图片到本地
     *
     * @param urlString 需要下载图片的路径
     * @param filename  下载后图片的命名
     * @param savePath  下载到那个文件夹下
     */
    public static void downloadNetworkPicture(String urlString, String filename, String savePath) {
        try {
            URL url = new URL(urlString);
            URLConnection con = url.openConnection();
            con.setConnectTimeout(5000);
            InputStream inputStream = con.getInputStream();
            File file = new File(savePath);
            if(!file.exists()){
                // 路径文件夹不存在进行创建
                boolean mkdirs = file.mkdirs();
                if (!mkdirs) {
                    throw new FileNotFoundException("文件夹创建失败");
                }
            }
            OutputStream outputStream = new FileOutputStream(file.getPath()+"\\"+filename+".jpg");
            int length;
            byte[] bs = new byte[1024];
            while ((length = inputStream.read(bs)) != -1) {
                outputStream.write(bs, 0, length);
            }
            outputStream.close();
            inputStream.close();
        } catch (Exception e) {
            System.out.println(filename);
        }
    }

    /**
     * 从网络下载图片到本地
     *
     * @param fileMap key网络地址 value目标文件名称
     * @param savePath 存储路径
     */
    public static void downloadNetworkPicture(Map<String, String> fileMap , String savePath) {
        for (Map.Entry<String, String> entry : fileMap.entrySet()) {
            downloadNetworkPicture(entry.getKey(), entry.getValue(), savePath);
        }
    }
}
