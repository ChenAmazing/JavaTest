package Test;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class IOReadWrite {
    public static void main(String[] args) {

    }

    //获取文件io流后，数据的读取和输出都是对该流的操作。
    // fis.read(buf)读取fis的流写入buf,fos.write(outdata)将数据写入fos
    public static void readFile(File file){
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            byte[] bytes = new byte[1024];
            int len = 0;
            while((len = bis.read(bytes))!=-1){
                System.out.println();
            }
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void wirteFile(File file){
        try{
            FileOutputStream fos = new FileOutputStream(file);
            String str = "this is new file";
            byte[] bytes = str.getBytes();
            fos.write(bytes);
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
