package com.anyi.leetcode;

public class Code_322 {
    int minNum = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        process(coins,0,0,amount);
        return minNum;
    }
    public void process(int[] coins,int index,int count,int account){
        if(account < 0 || index >= coins.length){
            return;
        }
        if(account == 0){
            minNum = Math.min(minNum,count);
        }
        // 遍历每一枚硬币
        for(int i = 0; account - i * coins[index] >= 0; i++){
            process(coins,index + 1,count + i,account - coins[index] *i);
        }
    }
}
