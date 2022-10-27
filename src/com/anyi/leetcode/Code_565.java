package com.anyi.leetcode;

class Code_565 {
    public static void main(String[] args) {
        arrayNesting(new int[]{5,4,0,3,1,6,2});
    }
    public static int arrayNesting(int[] nums) {
        // 图的遍历，这里0-n之间的数，并且这些数都在数组中，所以一定会成环，找出最大的环
        int n = nums.length,max = Integer.MIN_VALUE;
        for(int i = 0; i < n ; i++){
            int cut = 0;
            int j = i;
            while(j < n){
                int num = nums[j];
                nums[j] = n;
                j = num;
                cut ++;
            }
            max = Math.max(max,cut);
        }
        return max;
    }
}