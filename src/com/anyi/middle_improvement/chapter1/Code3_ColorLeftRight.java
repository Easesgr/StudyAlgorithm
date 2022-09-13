package com.anyi.middle_improvement.chapter1;

/**
 * 给你一个字符串，必须保证，每个字符都是一个盒子的颜色，R表示红色，G表示绿色
 * 如果我们要保证绿色比每一个红色到起始点的距离的都小，我们对盒子进行染色，最小需要染多少个
 */
public class Code3_ColorLeftRight {
    public static void main(String[] args) {
        int rggrggrgrr = colorLeftRight("RGGRGGRGRR");
        System.out.println(rggrggrgrr);
    }
    public static int colorLeftRight(String boxes){
        int[] leftHelp = new int[boxes.length()];
        int[] rightHelp = new int[boxes.length()];
        leftHelp[0] = boxes.charAt(0) == 'R'? 1:0;
        for(int i = 1 ; i < boxes.length() ; i++){
            leftHelp[i]  = boxes.charAt(i) == 'R'? leftHelp[i-1] + 1:leftHelp[i-1];
        }
        rightHelp[boxes.length()-1] = boxes.charAt(boxes.length()-1) == 'G' ? 1:0;
        for (int i = boxes.length() -2 ;i >=0; i--){
            rightHelp[i] = boxes.charAt(i) == 'G' ? rightHelp[i+1] + 1:rightHelp[i+1];
        }
        int minNum = Integer.MAX_VALUE;
        for(int i = 0 ; i <boxes.length();i++){
            minNum = Math.min(minNum,leftHelp[i] + rightHelp[i]);
        }
        return minNum;
    }
}
