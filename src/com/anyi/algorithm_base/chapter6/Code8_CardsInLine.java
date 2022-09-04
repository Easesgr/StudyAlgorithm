package com.anyi.algorithm_base.chapter6;

/*
    拿卡片问题，给定一个数组，只能拿最左边或者最右边的卡
    你拿了其中一张之后由你的对手来拿，持续到卡被拿完，统计最后的分数。谁获胜
 */
public class Code8_CardsInLine {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 100, 20, 4};
        int i = cardsInLine(nums);
        System.out.println(i);
    }
    public static int cardsInLine(int[] nums){
        return Math.max(f(nums,0,nums.length -1),b(nums,0,nums.length -1));
    }

    // 可看做玩家1
    public static int f(int[] nums,int left,int right){
        if(left == right){
            return nums[left];
        }
        return Math.max( nums[left] + b(nums,left + 1,right),nums[right] + b(nums,left,right-1));
    }
    // 玩家2
    public static int b(int[] nums,int left,int right){
        if(left == right){
            return 0;
        }
        return Math.min(f(nums,left + 1 ,right),f(nums,left,right-1));
    }
}
