package MoNiTest;

public class ZiXuLie {//最大连续子序列问题
    public static void main(String[] args) {
//        int[] a = new int[]{-2,11,15,-4,13,-5,-2,-9,-10};
        int[] a = new int[]{-1,-11,-14,20};
//        int num = 0,max = 0;
//        for(int i =0;i<a.length;i++){
//            for(int j =i;j<a.length;j++){
//                num += a[j];
//                if(num>max){
//                    max = num;
//                }
//            }
//            num = 0;
//        }
//        System.out.println(max);
//        int result =  MaxSubSum(a,0,a.length-1);
        long result = YouHua(a);
        System.out.println(result);
    }
    public static int MaxSubSum(int A[], int Left, int Right){//分治法
        int MaxLeftSum,MaxRightSum;
        int MaxLeftBorderSum,MaxRightBorderSum;
        int LeftBorderSum,RightBorderSum;
        int mid,i;

        if(Left == Right) // 处理只有一个元素的子序列
        {
            if(A[Left] > 0){
//                System.out.println(A[Left]);
                return A[Left];
            }
            else // 对于小于等于0的元素，
                return 0;
        }

        mid= (Left + Right)/2;
        // 情况1
        MaxLeftSum = MaxSubSum(A,Left,mid);
//        System.out.println(MaxLeftSum);
        // 情况2
        MaxRightSum = MaxSubSum(A,mid+1,Right);

        // 情况3
        MaxLeftBorderSum = 0;
        LeftBorderSum = 0;
        for(i = mid;i >= Left;i--)// 求解最大序列的左边部分
        {
            LeftBorderSum += A[i];
            if(LeftBorderSum > MaxLeftBorderSum)
                MaxLeftBorderSum = LeftBorderSum;
        }

        MaxRightBorderSum = 0;
        RightBorderSum = 0;
        for(i = mid+1;i <= Right;i++)// 求解最大序列的右边部分
        {
            RightBorderSum += A[i];
            if(RightBorderSum > MaxRightBorderSum)
                MaxRightBorderSum = RightBorderSum;
        }

        return Max(MaxLeftSum, MaxRightSum, MaxLeftBorderSum + MaxRightBorderSum); // 返回三种情况中最大的结果
    }
    public static int Max(int a,int b,int c){
        if(a>=b&&a>=c){
            return a;
        }else if(b>=c&&b>=a){
            return b;
        }else{
            return c;
        }
    }
    public static long YouHua(int[] A){
        long max = Long.MIN_VALUE,num=0,min=0;//max代表前n个数的最大和，min代表前n个数最小和
        for(int i=0;i<A.length;i++){
            num += A[i];
            if(num>max){
                max = num;
                if(max-min>max){
                    max = max - min;
                }
            }
            if(num<min){
                min = num;
            }
        }
        return max;
    }
    //第三种方法：动态规划：递推式：dp[n] = max(0, dp[n-1]) + num[n] (dp[n]表示已第n个数结尾的最大连续子序列和）
}
