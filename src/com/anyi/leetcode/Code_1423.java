package com.anyi.leetcode;

public class Code_1423 {
    public static void main(String[] args) {
        maxScore(new int[]{1,2,3,4,5,6,1},3);
    }
    public static int maxScore(int[] cardPoints, int k) {
        // 无论怎么取，最后剩下的都是 n-k张连续的，我们求出连续的n-k个最小值就能知道最大值了
        int sum = 0;
        int n = cardPoints.length;
        int allSum = 0;
        int left = 0;
        int right = n - k;

        for(int i = 0; i < n; i++){
            if(i == right){
                sum = allSum;
            }
            allSum += cardPoints[i];
        }
        int minSum = sum;
        while(right < n){
            sum += (cardPoints[right++] - cardPoints[left++]);
            minSum = Math.min(minSum,sum);
        }
        return allSum - minSum;
    }
}
