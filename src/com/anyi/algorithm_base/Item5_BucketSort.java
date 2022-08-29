package com.anyi.algorithm_base;

/**
 * 桶排序优化
 */
public class Item5_BucketSort {

    // 主函数
    public static void bucketSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        final  int counts = 10;
        // 获取要进出几次桶
        int digit = getDigit(arr);
        // 遍历进出桶
        for (int i = 1; i <= digit; i++) {
            // 创建一个help数组与原数组一样大 ，帮助出桶
            int[] help = new int[arr.length];

            // 创建计数器
            int[] count = new int[counts];
            // 从左往右遍历数组计数
            for (int j = 0; j < arr.length; j++) {
                int remainder = getDigitNumber(arr[j],i);
                count[remainder] ++;
            }
            for (int j = 1; j < count.length; j++) {
                count[j] = count[j] + count[j -1];
            }

            // 在从右往左遍历数组，让数组完成入桶和出桶
            for (int k = arr.length -1; k >= 0 ; k--) {
                int remainder = getDigitNumber(arr[k],i);
                help[count[remainder] - 1] = arr[k];
                count[remainder] --;
            }
            // 将help数组拷贝回原数组
            for (int j = 0; j < help.length; j++) {
                arr[j] = help[j];
            }
        }


    }

    // 获取数组中最大数字的位数
    public static int getDigit(int[] arr){
        int max = Integer.MIN_VALUE;
        int digit = 0;
        for (int i = 0; i < arr.length; i++) {
          max = Math.max(max,arr[i]);
        }
        while (max != 0 ){
            max /= 10;
            digit++;
        }
        return digit;
    }


    // 获取一个数的第几位
    public static int getDigitNumber(int num, int digit){
        int number = 0;
        while (digit > 0){
            number = num % 10;
            num /= 10;
            digit --;
        }
        return number;
    }



}
