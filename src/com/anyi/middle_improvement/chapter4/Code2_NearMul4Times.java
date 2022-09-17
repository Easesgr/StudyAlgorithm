package com.anyi.middle_improvement.chapter4;

/**
 * 给你一个数组，判断一下这个数组经过交换后是否可以变成相邻元素相乘都是4的倍数
  */

public class Code2_NearMul4Times {
    public static void main(String[] args) {
        nearMul4Times(new int[]{3,2,8,18,2,4});
    }
    /**
     * 思路 ：我们可以统计奇数的个数a，只是2的倍数的个数b，是4倍数值c
     *      如果b==0，那么只要c >= a-1 就可以满足
     *      如果b!=0,
     *          b==1，这个时候 c >=a + 1; 这个时候 c 至少要有一个
     *          b>1 , 这个时候，只需要 c >=a 即可
     */
    public static boolean nearMul4Times(int[] arr){
        // 统计个数
        int[] times = new int[3]; // 0 -> a ; 1->b;  2 -> c;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 != 0){
                times[0] ++;
            }else if(arr[i] %2 == 0 && arr[i] % 4 != 0){
                times[1]++;
            }else{
                times[2]++;
            }
        }
        // 判断几个值
        if(times[1] == 0 && times[2] < times[0] -1){ // 如果 b 等于0 如果4的倍数值，仍然小于奇数-1个，返回false
            return false;
        }
        if(times[1] ==1 && times[2] < times[0] + 1){
            return false;
        }
        if(times[1] > 1 && times[2] < times[0]){
            return false;
        }
        return true;
    }
}
