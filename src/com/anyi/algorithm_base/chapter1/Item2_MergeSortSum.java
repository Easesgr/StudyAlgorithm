package com.anyi.algorithm_base.chapter1;

/**
 * 最下和问题 采用归并排序来实现
 * 简单来说就是 左边数比右边大就记作和
 */
public class Item2_MergeSortSum {
    // 递归算法
    public static int process(int[] arr,int l,int r){
        if (l == r){
            return 0;
        }
        // 中点
        int mid = l + ( (r - l) >> 1 );
        // 左右两边的和 加上最后合并的和
        return process(arr,l,mid) + process(arr,mid + 1,r) + merge(arr,l,r,mid);
    }

    public static int merge(int[] arr , int l , int r , int mid){
        // 记录左右起始点
        int p1 = l;

        int p2 = mid +1;
        // 记录位置
        int i = 0;

        int sum = 0;

        // 准备一个辅助数组
        int[] help = new int[r -l +1];

        // 两组数组没有遍历完
        while (p1 <= mid && p2 <= r  ){
            help[i++] = arr[p1] < arr[p2] ? sum += arr[p1++] * (r - p2  + 1): arr[p2++];
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
        return sum;
    }
}
