package com.anyi.base_improvement.chapter2;

/**
 * KMP算法 可以解决一类，多种东西重复比较，可以进行优化的问题
 * 思路：首先，针对当前数组生成一个前缀和数组，也就是以当前位置往前，前缀相等的个数,赋给当前位置
 */
public class Code1_KMP {
    public static void main(String[] args) {
        String str = "aabaaabaaac";
        String sonStr = "aabaaac";
        int indexOf = getIndexOf(str, sonStr);
        System.out.println(indexOf);
    }
    public static int getIndexOf(String s,String sonStr){
        if(s.length() < sonStr.length()){
            return -1;
        }
        int[] next = getPreNum(sonStr);
        // 遍历每一个数
        int i1= 0;
        int i2 =0;
        while(i1 < s.length() && i2 < sonStr.length()){
            if(s.charAt(i1) == sonStr.charAt(i2)){ // 相等同时往前走
                i1++;
                i2++;
            }else if(next[i2] == -1){
                // 如果i2的前一个已经是-1了，也就是最前面一个了,还是不能和当前字符串匹配，那么只能父串的下一个和子串第一个比
                i1 ++;
            }else{// 如果不相等，并且前缀还不是-1，也就是还有到到达子串的第一个，就让子串往前移动，和当前值比；
                i2 = next[i2];
            }
        }
        // 最后退栈，如果是i2引起的退栈，说明匹配到了所有的子串
        return  i2 == sonStr.length()?i1 - i2 : -1;
    }
    // 生成需要查询字符串对应的的前缀树列表
    public static int[] getPreNum(String str){ // 生成前缀数组
        // 前缀数组长度和需要查询的字符串的长度一致
        int[] pArr = new int[str.length()];
        // 初始化第一个值和第二个值
        pArr[0] = -1;
        pArr[1] = 0 ;
        int cn = 0;
        int i = 2;
        while(i < str.length()){
            if(str.charAt(i -1) == str.charAt(cn)){
                pArr[i++] = ++cn;
            }else if(cn > 0){
                cn = pArr[cn];
            }else{
                pArr[i++] = 0;
            }
        }
        return pArr;
    }
}
