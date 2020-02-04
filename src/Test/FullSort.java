package Test;

import java.util.Arrays;

public class FullSort {
    //全排列
    public static void main(String[] args) {
        core(new int[]{1,2,3});
    }
    private static void core(int[] array) {
        int length = array.length;
        fullArray(array, 0, length - 1);
    }

    private static void fullArray(int[] array, int cursor, int end) {
        if (cursor == end) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = cursor; i <= end; i++) {
                //i是从cursor开始 i=cursor; swap(array, cursor, i)相当于固定当前位置，在进行下一位的排列。
                swap(array, cursor, i);
//                System.out.println(cursor+"======"+i);
                fullArray(array, cursor + 1, end);
                swap(array, cursor, i);
            }
        }
    }
    public static void swap(int[] array,int cursor,int i){
        int temp = array[i];
        array[i] = array[cursor];
        array[cursor] = temp;
    }

}
