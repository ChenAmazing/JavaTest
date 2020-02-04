package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;

//文件读取，测试的txt文件以','作为分隔符,ascii码为44
//测试了char占多少个字节以及中文字符占了多少个字节
public class fileRead {
    public static void main(String[] args) {
        File file = new File("G:\\fileread.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            int read = 0;
            char c = ' ';
            StringBuffer sb = new StringBuffer();
            while((read = fis.read())!= -1){
                if(read != 44){
                  c = (char)read;
                  sb.append(c);
                }else{
                    System.out.println(sb);
//                    sb.delete(0,sb.length());
//                    System.out.println(sb.length());
                }
            }
            System.out.println(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void chineseChar(){
        String s = "哈";
        try {
            System.out.println(s.getBytes().length);
            System.out.println(s.getBytes("GBK").length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
