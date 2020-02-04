package algorithm;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {12,1,7,8,45,0,10,11};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        divide(arr,left,right,temp);
    }
    public static void divide(int[] arr,int left,int right,int[] temp){
        if(left<right) {
            int mid = (left + right) / 2;
            divide(arr, 0, mid, temp);
            divide(arr, mid + 1, right, temp);
            merge(arr,left,mid,right,temp);
        }
    }
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid+1;
        int t = 0;
        while (i<=mid&&j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){
            temp[t++] = arr[i++];
        }
        while (j<=right){
            temp[t++] = arr[j++];
        }
        t = 0;
        while(left<=right){
            arr[left++] = temp[t++];
        }
    }
}
