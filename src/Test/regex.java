package Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {
    private static String s = "Alicellll This is a story about Alice and Bob. Alice wants to send a private message to Bob. Alice.";
    public static void main(String[] args) {
        reg();
    }
    public static void reg(){
        String r = "\\b"+"Alice"+"\\b";// \b代表单词边界
        String rThree = "\\W"+"Alice"+"\\W";//匹配" Alice "
        String rTwo = "[1][3578]\\d{9}";//匹配首位只能为1，第二位为3，5，7，8其中一个，后面9个数字

//        Pattern pat = Pattern.compile(r);
//        Matcher mat = pat.matcher(s);
//        if(mat.find()){
//            System.out.println(mat.group());
//        }
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                if(s.substring(i,j).matches(r)){
                    System.out.println("yes");
                }
            }
        }
    }
}
