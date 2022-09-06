package com.anyi.base_improvement.chapter2;

/*
    经典Manacher算法
 */
public class Code2_Manacher {
    public static void main(String[] args) {
        String maxBackString = getMaxBackString( "bbab");
        System.out.println(maxBackString);
    }
    public static String getMaxBackString(String s){
        // 处理一下子串
        char[] str = dealWithS(s);
        int[] pArr = new int[str.length];
        // 进入循环
        int R = 0;
        int C = 0;
        for(int i =0 ; i< str.length; i++){
            // 当前节点不在往右扩到最大的里面，那么当前半径就是1
            /* 如果在里面的的两种情况:
             一个是完全在里面，那么当前点的半径就和前面对称的点一致也就是 C - (i - C) 左边界到对称点的距离
             对称点的半径超出R，那么就是R-i最大
            */
            // 如果是超出去的也当做是全在里面，最后往外扩，只需要取小的
            pArr[i] = R > i ? Math.min(pArr[2 * C - i],R -i):1;

            while(i +pArr[i] < str.length && i -pArr[i] > -1){
                if(str[i + pArr[i]] == str[i - pArr[i]]){
                    pArr[i] ++;
                }else{
                    break; // 如果不相等，一步就退出了
                }
            }
            // 改变当前半径C和当前左边界R
            if(i + pArr[i] > R){
                R = i + pArr[i];
                C = i;
            }
        }
        int maxIndex = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;
        for (int i = 0 ; i < pArr.length; i++){
            if(pArr[i] > maxC){
                maxC = pArr[i];
                maxIndex = i;
            }
        }
        maxC--; // 半径包含了两次自己这个元素，所有要 --；
        String maxString = getString(str,maxIndex -maxC,maxIndex +maxC);
        return maxString;
    }
    public static String getString(char[] str ,int left ,int right){
        StringBuffer res = new StringBuffer();
        for(int i = left; i< right ; i++){

            if(str[i] == '#'){
                continue;
            }
            res.append(str[i]);
        }
        return res.toString();
    }
    public static char[] dealWithS(String  s){ // 12121 -> #1#2#1#2#1#
        // 前后都加上#
        char[] res = new char[s.length() * 2 +1];
        int index = 0;
        int i = 0;
        while (index < res.length){
            res[index] = (index++ & 1) == 0 ? '#' : s.charAt(i++);
        }
        return res;
    }
}
