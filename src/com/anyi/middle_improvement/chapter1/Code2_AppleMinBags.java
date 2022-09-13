package com.anyi.middle_improvement.chapter1;

/**
 * 给你n个苹果，只能使用6/8的袋子来装，要求必须装满，最少需要多少个袋子，如果没有装满就没法装，返回-1
 */
public class Code2_AppleMinBags {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i +"苹果需要" + print(i) + "个袋子" );
        }
    }
    public static int appleMinBags(int n){
        if((n & 1) != 0){
            return -1;
        }
        // 尽量用8个的袋子装，剩下的交给装6的袋子来搞定
        int bag8 = n / 8;
        int bag6 = -1;
        int rest = n - bag8 *8;
        while(bag8 >=0 && rest < 24){
            int restBag6 = minBag6(rest);
            if (restBag6 != -1){
                bag6 = restBag6;
                break;
            }
            rest = n - (--bag8)* 8;
        }
        return bag6 == -1?-1:bag6 + bag8;
    }
    public static int minBag6(int n){
        return n %6==0?(n /6):-1;
    }
    // 打表法
    public static int print(int n){
        if ((n &1) !=0){
            return -1;
        }
        if(n <18){
            return n == 0?0:(n == 6|| n==8 ? 1: (n == 12 || n==16?2:-1));
        }
        return (n -18)/8 +1;
    }
}
