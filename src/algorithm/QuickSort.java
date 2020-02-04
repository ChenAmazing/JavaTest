package algorithm;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {12,1,7,8,45,0,10,11};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr,int left,int right){
        if(left>right){
            return;
        }
        int key = arr[right];
        int tp = left;
        int tmp = right;
        int temp = 0;
        while(left<right){
            while(arr[left]<=key&&left<right){
                left++;
            }
            while(arr[right]>=key&&left<right){
                right--;
            }
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        arr[tmp] = arr[right];
        arr[right] = key;
        quickSort(arr,tp,right-1);
        quickSort(arr,right+1,tmp);
    }
}
