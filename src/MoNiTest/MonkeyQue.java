package MoNiTest;

public class MonkeyQue {//猴子分香蕉
    public static int flag = 0;
    public static void main(String[] args) {
//        String a = new String("AB");
//        String b = new String("AB");
//        System.out.println(a.equals(b));
//        System.out.println(a==b);
//        System.out.println(a.hashCode()+" : "+b.hashCode());
        for(int i=1;i<10000000;i++){
            divide(i,7,4);
            if(flag==6){
                System.out.println(i);
                break;
            }
            flag = 0;
        }
    }
    public static void divide (int num,int n,int m){
        if(num>n&&flag<n+1){
            int next = num - num%n -num/n;
            if(num%n==m){
                flag++;
                divide(next,n,m);
            }
        }
    }

}
