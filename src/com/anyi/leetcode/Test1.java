package com.anyi.leetcode;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(main(2));
    }
    public static String  main(int time) {
        String ori_time = time + ":";
        if (time >= 12 && time < 24){
            time -=12;
        }
        int s_h = 360/60,s_m = 30/60;
        int t = Math.round((30 * time) / (s_h - s_m));
        int o = (int) Math.round((t * 0.5) / (s_h - s_m));
        if(t < 10){
            return ori_time + "0" + (t + o);
        }
        return  ori_time + (t + o);
    }
}
