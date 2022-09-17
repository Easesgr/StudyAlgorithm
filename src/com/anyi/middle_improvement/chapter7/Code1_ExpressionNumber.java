package com.anyi.middle_improvement.chapter7;

/*
    给你一个字符串，只包含 0、1、|、&、^ 五种符号，请问在其之间加括号，返回预期结果 desired的方法数
 */
public class Code1_ExpressionNumber {
    public static void main(String[] args) {
        int i = expressionNumber("1&1|0^1|1&0&1", false);
        System.out.println(i);
    }
    public static int expressionNumber(String s,boolean desire){
        int n = s.length();
        if(n %2 ==0){ // 如果是偶数，根本没办法比较
            return 0;
        }
        if(!isValid(s)){
            // 验证失败
            return 0;
        }
        char[] str = s.toCharArray();
        return process(str,desire,0,s.length() - 1);
    }
    public static int process(char[] str, boolean desire,int L,int R){
        if(L == R){ // 当L等于R的时候，只剩一个
            if(str[L] == '1'){
                return desire ? 1:0; // 如果是1，希望是true，就返回1，希望false就返回0种
            }else{
                return desire ? 0:1; // 如果是0，希望是true,就返回0，希望是true就返回1种
            }
        }
        // 如果是普遍情况
        int res = 0;
        if(desire){ // 如果期待的是true
            // 尝试L -> R 的所有位置
            for (int i = L + 1 ; i < R; i+=2){ // 取出每一个符号
                switch (str[i]){
                    case '&':
                        res += process(str,true,L,i -1) * process(str,true,i + 1,R);
                        break;
                    case '|':
                        res += process(str,true,L,i -1) * process(str,true,i + 1,R);
                        res += process(str,false,L,i-1) * process(str,true,i + 1,R);
                        res += process(str,true,L,i-1) * process(str,false,i + 1,R);
                        break;
                    case '^':
                        res += process(str,true,L,i -1) * process(str,true,i +1,R);
                        res += process(str,false,L,i -1) * process(str,false,i +1,R);
                        break;
                }
            }
        }else { // 期待是 false
            for (int i = L +1; i < R; i++){
                switch (str[i]){
                    case '&':
                        res += process(str,false,L,i -1) * process(str,true,i + 1,R);
                        res += process(str,true,L,i -1) * process(str,false,i + 1,R);
                        res += process(str,false,L,i -1) * process(str,false,i + 1,R);
                        break;
                    case '|':
                        res += process(str,false,L,i -1) * process(str,false,i + 1,R);
                        break;
                    case '^':
                        res += process(str,true,L,i -1) * process(str,false,i +1,R);
                        res += process(str,false,L,i -1) * process(str,true,i +1,R);
                        break;
                }
            }
        }
        return res;
    }

    public static boolean isValid(String str){
        // 判断是否合法
        char[] chars = str.toCharArray();
        int index =0;
        while(index < chars.length){
            if(index % 2 == 0){
                if( !(chars[index] == '0' ||chars[index] == '1')){
                    return false;
                }

            }
            if(index % 2 == 1){
                if( !(chars[index] == '^' || chars[index] == '&' || chars[index] == '|')){
                    return false;
                }
            }
            index ++;
        }
        return true;
    }
}
