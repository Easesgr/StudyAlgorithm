package com.anyi.middle_improvement.chapter2;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashSet;
import java.util.List;

/**
 * 给你两个数组，从一个数组往另个数组中拿值，必须保证拿的值另个数组中没有，并且拿完之后
 * 两个数组的平均值都必须升高
 */
public class Code2_MagicOp {
    public static int magicOp(int[] arr1,int[] arr2){
        double sum1 = getSum(arr1);
        double sum2 = getSum(arr2);
        if(avg(sum1,arr1.length) == avg(sum2,arr2.length)){
            return 0;
        }
        // 只能从大的集合中，将大于小平均数集合的并且小于大集合平均数的大集合的数拿到小集合中
        int[] moreArr = null;
        int[] lessArr = null;
        double lessSum = 0.0;
        double moreSum = 0.0;
        // 先确定哪个集合的平均值小
        if (avg(sum1,arr1.length) > avg(sum2,arr2.length)){
            moreArr = arr1;
            moreSum = sum1;
            lessArr = arr2;
            lessSum = sum2;
        }else{
            moreArr = arr2;
            moreSum = sum2;
            lessArr = arr1;
            lessSum = sum1;
        }
        // 建立一个存储小集合值，防止大集合拿过来的值，小集合中已经存在
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < lessArr.length ;i++){
            set.add(lessArr[i]);
        }
        int lessSize = lessArr.length;
        int moreSize = moreArr.length;
        int res =0;
        // 遍历大集合，找到大集合中第一个大于的小集合平均值的num
        for(int i= 0 ;i < moreArr.length ; i++){
            if(moreArr[i] > avg(lessSum,lessSize) && moreArr[i]
                    < avg(moreSum,moreSize) && !set.contains(moreArr[i])){
                // 满足条件，将值加入
                res ++;
                set.add(moreArr[i]);
                lessSize ++;
                moreSize --;
                lessSum += moreArr[i];
                moreSum -= moreArr[i];
            }
        }
        return res;
    }
    public static double avg(double sum,int len){
        return (double) (sum / len);
    }
    public static double getSum(int[] arr){
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
