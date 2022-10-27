package com.anyi.leetcode;

class Code_306 {
    public static void main(String[] args) {
        isAdditiveNumber("199100199");
    }
    public static boolean isAdditiveNumber(String num) {
        // 找到前两个数，然后找第三个数，相等继续往后推进，相当于只需要验证第一对是否成立
        int n = num.length();
        for (int secondStart = 1; secondStart < n - 1; ++secondStart) {
            if (num.charAt(0) == '0' && secondStart != 1) {
                break;
            }
            for (int secondEnd = secondStart; secondEnd < n - 1; ++secondEnd) {
                if (num.charAt(secondStart) == '0' && secondStart != secondEnd) {
                    break;
                }
                if (valid(secondStart, secondEnd, num)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean valid(int secondStart,int secondEnd,String num){
        // 拿到第一个数，算出第三个数然后和第三个数比对，持续往后比对
        int firstStrat = 0,firstEnd = secondStart - 1,n = num.length();
        while(secondEnd <= n -1){
            String third = addString(num,firstStrat,firstEnd,secondStart,secondEnd);
            int thirdStart = secondEnd + 1,thirdEnd =thirdStart + third.length() -1;
            if(thirdEnd > n -1 || !num.substring(thirdStart,thirdEnd + 1 ).equals(third)){
                return false;
            }
            if(thirdEnd == n -1){
                return true;
            }
            firstStrat = secondStart;
            firstEnd =secondEnd;
            secondStart = thirdStart;
            secondEnd = thirdEnd;
        }
        return false;
    }
    public static String addString(String num, int firstStrat,int firstEnd,int secondStart, int secondEnd){
        // 计算两个数字字符串
        StringBuffer res = new StringBuffer();
        int cur = 0;
        while(firstEnd >= firstStrat && secondEnd >= secondStart){
            int bit = (num.charAt(firstEnd) - '0') + (num.charAt(secondEnd) - '0') + cur;
            res.append(bit %10);
            cur = bit /10;
            firstEnd --;
            secondEnd --;
        }
        while(secondEnd >= secondStart || cur != 0){
            int bit = secondEnd < secondStart ?0:(num.charAt(secondEnd) - '0');
            if(cur != 0){
               res.append((bit + cur) %10);
               cur = (bit + cur)/ 10;
            }else{
                res.append(bit);
            }
            secondEnd --;
        }
        res.reverse();
        return res.toString();
    }

}