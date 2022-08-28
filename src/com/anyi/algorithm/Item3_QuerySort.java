package com.anyi.algorithm;

import java.util.Arrays;

/**
 * 快排 采用荷兰国旗问题来优化代码
 * 最简单的快排是每次选最右边一个数来进行快排，出现极端情况就会使复杂度变成O(n**2)
 * 采用荷兰国旗问题来使选择的数一直在中间
 */
public class Item3_QuerySort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,4,5,3,2,32,22,99}; // 4*1 + 3*2 + 2*2 + 4
        querySort(arr ,0,arr.length-1);
        System.out.printf(Arrays.toString(arr));
    }
    public static void querySort(int[] arr ,int l ,int r){
        if (arr == null || arr.length < 2) {
            return;
        }
        if (l < r){
            // 随机选一个数，和最后一个数做交换
            swap(arr,(l + (int)((r - l + 1)*Math.random())),r);
            // 对最后一个数进行part分离
            int[] part = part(arr,l,r);
            // 左边部分递归进快排
            querySort(arr,l,part[0] - 1);
            // 右边部分递归进快排
            querySort(arr,part[1] + 1,r);
        }
    }

    // 将数组分成 左边 < arr[r]  中间 == arr[r] 右边 > arr[r]
    // 返回左右两边的边界值
    public static int[] part(int[] arr ,int l, int r){
        // 荷兰国旗问题算法
        int less = l - 1; // < 右边界
        int more = r; // > 左边界
        // 大于的左边界没有和右边界重合时就持续进行
        while (l < more){
            if (arr[l] < arr[r]){ // 如果小于最后一个值，less右移，并且和l做交换后 l也右移
                swap(arr,++less, l++);
            }else if (arr[l] > arr[r]){ // 如果大于最后一个值，就想让more左移，然后l原来不懂，因为l是新换来的数据
                swap(arr,--more,l);
            }else { // 如果等于，就让l直接右移
                l++;
            }
        }
        swap(arr,more,r);
        return new int[]{less + 1,more};
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
