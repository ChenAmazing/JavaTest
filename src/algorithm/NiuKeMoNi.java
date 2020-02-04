package algorithm;

public class NiuKeMoNi {
//    static int[][] map = new int[101][101];
public static void main(String[] args) {
    result(4,6,6);
}
    public static void result(int n,int m,int k){
        int x = 0,y = 0,flagNum=0;
        if(n>0&&m>0){
            while(x<n&&y<m){
                x++;
                y++;
                flagNum++;
                if(flagNum>k){
                    System.out.println(-1);
                    return;
                }
            }
        }else if(n<0&&m<0){
            while(x>n&&y>m){
                x--;
                y--;
                flagNum++;
                if(flagNum>k){
                    System.out.println(-1);
                    return;
                }
            }
        }else if(n>0&&m<0){
            while(x<n&&y>m){
                x++;
                y--;
                flagNum++;
                if(flagNum>k){
                    System.out.println(-1);
                    return;
                }
            }
        }else if(n<0&&m>0){
            while(x>n&&y<m){
                x--;
                y++;
                flagNum++;
                if(flagNum>k){
                    System.out.println(-1);
                    return;
                }
            }
        }
            if(x==n&&y==m){
                System.out.println(k);
            }
            if(y!=m){
                cal(m,y,k,flagNum);
            }else if(x!=n){
                cal(n,x,k,flagNum);
            }

    }
    public static void cal(int m,int y,int k,int flagNum){
        int dis = Math.abs(m-y);
        int num = k-flagNum;
        if(dis>num){
            System.out.println(-1);
        }else{
            flagNum = flagNum + dis-1;
            num = k-flagNum;
            if(num%2==0){
                flagNum = flagNum+num/2;
            }else{
                flagNum = flagNum+num/2-1;
            }
            System.out.println(flagNum);
        }
    }
}
