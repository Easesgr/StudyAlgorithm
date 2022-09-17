package com.anyi.middle_improvement.chapter5;

/**
 * 路灯问题，给你一个字符串，“..X..XX..X”, .表示可以放路灯的路，X表示墙，一盏路灯可以照亮自己放的位置和前后各一个位置
 * 请问最少需要放多少盏路灯可以照亮所有路
 */
public class Code5_Light {
    public static int light(String s){
        char[] strs = s.toCharArray();
        int i= 0;
        int light = 0;
        while(i < strs.length){
            if(strs[i] == 'X'){
                i++;
                continue;
            }else{
                light++;
                if(i + 1 == strs.length){
                    break; // 到达最后一个，放一盏灯直接走
                }else{
                    if(strs[i + 1] == 'X'){ // 如果是 X 那么当前灯放一个，直接跳到 i + 2
                        i =+2;
                    }else{ // 如果是 ‘.’ 放一盏灯在i+1，就可以直接到 i + 3 进行判断了
                        i+=3;
                    }
                }
            }
        }
        return light;
    }
}
