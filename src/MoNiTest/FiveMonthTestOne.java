package MoNiTest;

import java.util.Scanner;

public class FiveMonthTestOne {
    public static void main(String[] args) {
        int[] n = new int[2];
        int[][] map = new int[4][13];
        for(int i=0;i<4;i++){
            for(int j=0;j<13;j++){
                map[i][j] = j+1;
            }
        }

        Scanner scan = new Scanner(System.in);
        int flag = 0;
        for(int j=0;j<2;j++){
            flag = 0;
            for(int i =0;i<3;i++){
                int a = scan.nextInt();
                map[flag++][a-1] = -1;
                n[j] = n[j] + a;
            }
        }
        int[] r =new int[2];
        double count = 0;
        for(int k=0;k<46;k++){
            for(int i=0;i<2;i++){
                r[i] = result(map,n[i],i);
            }
            if(r[0]>r[1]){
                count++;
            }
        }
        System.out.println(count/46);
    }
    public static int result(int[][] map,int n,int i1){
        for(int i=0;i<4;i++){
            for(int j=0;j<13;j++){
                if(map[i][j]<0){

                }else {
                    n = n+map[i][j];
                    if(i1==0){
                        map[i][j] = -1;
                    }

                    return n;
                }
            }
        }
        return 100;
    }
}
