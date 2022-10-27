package com.anyi.middle_improvement.chapter7;

/**
 * 给你一个字符串，删除其中的字符串，每种字符串只保留一个，并且返回最小字典序
 */
public class Code4_RemoveDuplicateLettersLess {
    public static void main(String[] args) {
        String abcdbefag = remove( "cdadabcc");
        System.out.println(abcdbefag);
    }
    public static String remove(String str){
        if(str.equals("") || str.length() == 1){
            return str;
        }
        int[] map = new int[27];
        // 统计当前字符串出现的频次
        for (int i = 0; i < str.length(); i++) {
            map[str.charAt(i) - 'a']++;
        }
        int minIndex = 0;
        for(int i = 0; i <str.length() ; i++){
            if(--map[str.charAt(i) - 'a'] == 0){
                minIndex = str.charAt(minIndex) > str.charAt(i)?i:minIndex;
                break;
            }else{
                /**
                 * 如果当前minIndex一直都是最小就一直都是这个值，一直走到有重复的直到时候，让minIndex作为最小字典序
                 */
                minIndex = str.charAt(minIndex) > str.charAt(i)?i:minIndex;
            }
        }
        return String.valueOf(str.charAt(minIndex)) +remove(
                str.substring(minIndex + 1).replace(String.valueOf(str.charAt(minIndex)),"")
        );

    }
}
