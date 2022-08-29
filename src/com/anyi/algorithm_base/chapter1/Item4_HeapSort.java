package com.anyi.algorithm_base.chapter1;

/**
 * 堆排序
 * 采用算法 heapInsert 、 heapIfy
 */
public class Item4_HeapSort {

    /**
     * 堆排序
     */
    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        // 算出 heapSize
        int heapSize =arr.length;
        // 进行一次insert 变成大根堆
        for (int i = 0;i < arr.length; i++) {
            heapInsert(arr,i);
        }
        // 交换最后一个数和第一个数
        swap(arr,0,--heapSize);
        // 当所有的排好时heapSize变成 0
        while (heapSize > 0){
            // 进行一次从0往下heapIfy
            heapIfy(arr,0,heapSize);
            // 交换最后一个数和第一个数
            swap(arr,0,--heapSize);
        }
    }
    // 向上比较替换
    public static void heapInsert(int[] arr, int index){
        while (arr[index] > arr[(index -1) / 2]){
            swap(arr,index,(index -1) / 2);
            index = (index -1) / 2;
        }
    }
    // 向下比较替换
    public static void heapIfy(int[] arr,int index, int heapSize){
      int left =index * 2 +1;
       while ( left < heapSize){
           // 兄弟节点之间比较
           int largest = left + 1 < heapSize && arr[left] < arr[left +1] ? left +1 : left;
           // 父节点和子节点直接比较
           largest = arr[index] < arr[largest] ? largest : index;
           if (largest == index){ // 到达根节点退出
               break;
           }
           swap(arr,index,largest);
           index = largest;
           left = index * 2 +1;
       }
    }
    // 交换
    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
