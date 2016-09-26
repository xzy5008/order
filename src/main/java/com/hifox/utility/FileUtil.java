package com.hifox.utility;

import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * Created by lihao on 2016/8/16.
 */
public class FileUtil {

    /**
     * Java文件操作 获取文件扩展名
     * @param filename
     * @return
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length() - 1))) {
                return "."+filename.substring(dot + 1);
            }
        }
        return "";
    }

    /**
     * Java文件操作 获取不带扩展名的文件名
     * @param filename
     * @return
     */
    public static String getFileNameNoEx(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }

    /**
     *
     * @param response
     * @param filename 路径 相对路径或绝对路径
     * @param responseFileName 返回的文件名称
     * @throws IOException
     */
    public static void fileDownload(HttpServletResponse response, String filename, String responseFileName) throws IOException {
        if (StringUtils.isEmpty(filename)){
            OutputStream outputStream = response.getOutputStream();
            outputStream.close();
            return;
        }
        File file = new File(filename);
        if (!file.exists()){
            String errorMessage = "Sorry. The image you are looking for does not exist";
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }
        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType==null){
            mimeType = "application/octet-stream";
        }
        if (responseFileName == null)
            responseFileName = filename;
        response.setContentType(mimeType);
        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''"+responseFileName);
        response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''"+java.net.URLEncoder.encode(responseFileName, "UTF-8"));
        response.setContentLength((int)file.length());

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }

}
