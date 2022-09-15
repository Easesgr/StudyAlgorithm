package com.anyi.middle_improvement.chapter3;

/**
 * 有n台洗衣机，每个洗衣机的衣服件数是不一定的，让他们变成都是平均的，每次只能拿一件，那么最少需要多少次变平均
 */
public class Code1_PackingMachine {
    /**
     * 思路：我们求出每一台机器左右的真实台数，让左边和右边应有的台数 - 目前有的台数
     *      如果的两边都小于0，那么要从中间往两边拿 这个时候需要两边数值的绝对值相加
     *      如果两边都大于零，两边从中间拿，只需要拿两边大的那一个
     *      如果一边大于0，一边小于0，那么也只需要遍历两边绝对值较大的那一个
     */
    public static int packingMachine(int[] arr){
        int n = arr.length;
        int sum = 0;
        for(int i = 0 ; i < n; i++){
            sum += arr[i];
        }
        if (sum % n != 0){ // 如果不能整除，怎么移动也平均不了
            return -1;
        }
        int avg = sum / n;
        int leftNum = 0; // 统计左边的值，就可以算出右边的值  0,1,2,3,4
        int maxTimes = 0;
        for(int i = 0 ; i < n ; i++){
            int needLeft = leftNum - i * avg,needRight = sum - leftNum - arr[i]  - (n - i - 1) * avg;
            // 如果两边都小于 0，就需要两者相加
            if(needLeft < 0 && needRight < 0){
                maxTimes = Math.max(maxTimes,Math.abs(needLeft) + Math.abs(needRight));
            }else{
                maxTimes = Math.max(maxTimes,Math.max(Math.abs(needLeft),Math.abs(needRight)));
            }
            leftNum+=arr[i];
        }
        return maxTimes;
    }
}
