package com.anyi.algorithm_base;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int testTime = 500000;
        int size = 10;//保证数组长度较短，可以几乎穷尽所有情况
        int value = 1000;
        boolean succeed = true;
        //进行多次测试
        for(int i = 0; i < testTime; i++){
            int[] arr1 = generateRandomArray(size,value);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr2);
            //试验证冒泡排序
            Item4_HeapSort.heapSort(arr1);
            //用绝对正确的方法排序
            rightMethod(arr2);

            if(!isEqual(arr1,arr2)){
                succeed = false;
                //如果不相等就跳出判断循环，打印数组，ssucceed为false
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Error!");
    }

    private static void printArray(int[] arr3) {
        System.out.println(Arrays.toString(arr3));
    }

    // 绝对正确的方法
    public static void rightMethod(int[] arr){
        Arrays.sort(arr);
    }

    // 复制数组的方法
    public static int[] copyArray(int[] arr){
        if(arr==null){
            return null;
        }
        int[] res = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            res[i] = arr[i];
        }
        return res;
    }

    // 判断数组是否相等
    public static boolean isEqual(int [] arr,int [] arr1){
        //for zero
        if (arr.length == 0 || arr1.length == 0){
            return true;
        }

        // for null
        if (arr == null && arr1 == null){
            return true;
        }
        // for null other not null but other is null
        if (arr == null && arr1 != null || arr != null && arr1 == null){
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr1[i]){
                return false;
            }
        }
        return true;
    }
        // 生成随机数组
    public static int[] generateRandomArray(int size, int value){
        //产生[0,size]大小的随机整数数组((size+1)*Math.random(1)控制数组大小不会超过size)
        int[] arr = new int[(int) ((int)(size+1)*Math.random())];
        for(int i=0; i < arr.length; i++){
            //给随机数组中元素赋值，范围在(-value,value]之间
            arr[i] = ((int)(value*Math.random()));
        }
        return arr;
    }

}
