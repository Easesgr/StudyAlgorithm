package com.anyi.algorithm;

import java.util.Arrays;

/**
 * 归并排序
 */

public class Item1_MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3};

        if (arr == null || arr.length < 2){
            System.out.println(Arrays.toString(arr));
            return;
        }
        process(arr ,0,4);
        System.out.println(Arrays.toString(arr));
    }
    // 递归算法
    public static void process(int[] arr,int l,int r){
        if (l == r){
            return;
        }
        // 中点
        int mid = l + ( (r - l) >> 1 );

        // 递归合并左右分支
        process(arr,l,mid);

        process(arr,mid + 1,r);

        // 合并分支
        merge(arr,l,r,mid);
    }

    public static void merge(int[] arr , int l , int r , int mid){
        // 记录左右起始点
        int p1 = l;
        int p2 = mid +1;
        // 记录位置
        int i = 0;

        // 准备一个辅助数组
        int[] help = new int[r -l +1];

        // 两组数组没有遍历完
        while (p1 <= mid && p2 <= r  ){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 其中一组遍历完
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l+j] = help[j];
        }
    }

}