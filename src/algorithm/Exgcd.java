package algorithm;

public class Exgcd {
    static int x,y;
    public static void main(String[] args) {
        int r = exgcd(4,3,24,4,3);
    }
    public static int exgcd(int a,int b,int c,int start,int end){
       if(b==0){
           x = 1;
           y = 0;
           return a;
       }else{
           int result = exgcd(b, a % b,c,start,end);
           int temp = y;
           y = x-(a/b)*y;
           x = temp;
//           System.out.println(x);
//           System.out.println(y);
//           if(x*start+y*end==c){
//               System.out.println("x="+x+";y="+y);
//           }
           return result;
       }
    }
}
