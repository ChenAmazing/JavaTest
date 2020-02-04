package MoNiTest;

import java.util.ArrayList;
import java.util.Arrays;

public class methodOne {
    public static void main(String[] args) {
        int x= nthUglyNumber(9);
    }
    public static int nthUglyNumber(int n) {//构造数
        // write your code here
        int a = 0,b=0,c=0;
        if(n==1){
            return 1;
        }
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(1);
        while(ar.size()<n){
            int x = ar.get(a)*2;
            int y = ar.get(b)*3;
            int z = ar.get(c)*5;
            int tmp = min(x,y,z);
            if(tmp!=ar.get(ar.size()-1)){//防止出现重复元素
                ar.add(tmp);
            }
            if(tmp==x){
                a++;
            }else if(tmp==y){
                b++;
            }else if(tmp==z){
                c++;
            }
        }
        System.out.println(Arrays.toString(ar.toArray()));
        return ar.get(ar.size()-1);
    }
    public static int min(int x,int y,int z){
        int tmp = x<y?x:y;
        return tmp<z?tmp:z;
    }

}
