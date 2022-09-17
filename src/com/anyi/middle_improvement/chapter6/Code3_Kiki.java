package com.anyi.middle_improvement.chapter6;

/**
 * 如果一个主播当前的人气是 cur ，要使人气到恰好aim
 * 以下几种方法， 点赞 人气 + 2 代价 dc
 *             礼物 人气 * 2 代价 gc
 *             私聊 人气 - 2 代价 sc
 */
public class Code3_Kiki {
    // 单纯的递归是无法达成目标的
    public static int kiki(int cur,int aim,int dc,int gc,int sc){
        if(cur > aim){
            return -1;
        }
        // aim * 2 最大不能到达， ((aim - cur) / 2)*dc 一种普遍解
        return process(0,cur,aim,dc,gc,sc,aim *2,((aim - cur) / 2)*dc);
    }
    public static int process(int preMoney,int cur,int aim,int dc,int gc,int sc,int limitAim,int limitCoin){
        if(preMoney > limitCoin){
            return Integer.MAX_VALUE;
        }
        if(preMoney < 0){
            return Integer.MAX_VALUE;
        }
        if(cur > limitAim){
            return Integer.MAX_VALUE;
        }
        if(cur == aim){
            return preMoney;
        }
        int min = Integer.MAX_VALUE; // 取最大值
        int p1 = process(preMoney + dc,cur + 2,aim,dc,gc,sc,limitAim,limitCoin);
        if(p1 != Integer.MAX_VALUE){
            min = p1;
        }
        int p2 = process(preMoney + gc,cur * 2,aim,dc,gc,sc,limitAim,limitCoin);
        if(p2 != Integer.MAX_VALUE){
            min = Math.min(min,p2);
        }
        int p3 = process(preMoney + sc,cur - 2,aim,dc,gc,sc,limitAim,limitCoin);
        if(p3 != Integer.MAX_VALUE){
            min = Math.min(min,p3);
        }
        return min;
    }
}
