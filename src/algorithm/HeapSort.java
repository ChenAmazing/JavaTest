package algorithm;


import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] num = new int[]{0, 12, 55, 41, 6, 100, 8};
        int[] arr = Arrays.copyOf(num, num.length);//新建一个数组空间
        int length = arr.length;
        makeMaxHeap(arr, length);//第一次构建大顶堆
        //对第一次构建完的堆，把顶部的元素和数组最后一个元素交换，然后继续调整堆
        for (int i = length - 1; i >= 0; i--) {
            swap(arr, i, 0);
            length--;
            heapify(arr, 0, length);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void heapify(int[] arr, int i, int length) {//调整堆
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int large = i;
        if (leftChild < length && arr[leftChild] > arr[large]) {
            large = leftChild;
        }
        if (rightChild < length && arr[rightChild] > arr[large]) {
            large = rightChild;
        }
        if (large != i) {
            swap(arr, i, large);
            heapify(arr, large, length);//第一次构建堆时不执行，用作后续交换根节点元素时向下调整堆
        }
    }

    public static void makeMaxHeap(int[] arr, int length) {
        int finalparent = (length - 1 - 1) / 2;
        for (int j = finalparent; j >= 0; j--) {
            heapify(arr, j, length);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
