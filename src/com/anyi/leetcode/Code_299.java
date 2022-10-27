package com.anyi.leetcode;

public class Code_299 {
    public static void main(String[] args) {
        getHint( "1807","7810");
    }
    public static String getHint(String secret, String guess) {
        //准备两个数组来保存不同数，然后取两个数中小的那个
        int[] sec = new int[10];
        int[] gue = new int[10];
        int bullNum = 0;
        for(int i = 0 ; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bullNum ++;class NumArray {
                    int[] frontSum;
                    int[] nums;
                    public NumArray(int[] nums) {
                        // 初始化数组
                        this.nums = nums;
                        frontSum = new int[nums.length + 1];
                        for(int i = 0 ; i < nums.length; i++){
                            frontSum[i + 1] = frontSum[i] + nums[i];
                        }
                    }

                    public void update(int index, int val) {
                        int sub = val - nums[index];
                        nums[index] = val;
                        // 更新前缀数组
                        for(int i = index + 1; i < frontSum.length; i++){
                            frontSum[i] += sub;
                        }
                    }

                    public int sumRange(int left, int right) {
                        return frontSum[right + 1] - frontSum[left];
                    }
                }
            }else{
                sec[secret.charAt(i) - '0'] ++;
                gue[guess.charAt(i) - '0'] ++;
            }
        }
        int cow = 0;
        for(int i = 0; i < 10; i++){
            cow += Math.min(sec[i],gue[i]);
        }
        return bullNum + "A" + cow + "B";
    }
}
