package com.anyi.leetcode;

/**
 * 矩阵搜索
 */
public class Code1 {
    public static void main(String[] args) {
        exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED");
    }
    public static boolean exist(char[][] board, String word) {
        // 传染遍历
        char[] strs = word.toCharArray();
        for(int i = 0 ; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == strs[0]){
                    if(infect(i,j,board,0,strs)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean infect(int i ,int j , char[][] board,int index,char[] strs){
        if(index == strs.length){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length ){
            return false;
        }
        if(board[i][j] != strs[index]){
            return false;
        }

        // 持续的遍历
        char temp = board[i][j];
        board[i][j] = '0';
        boolean down = infect(i +1,j,board,index +1,strs);
        boolean right=  infect(i,j+1,board,index +1,strs);
        boolean up =  infect(i -1,j,board,index +1,strs);
        boolean left = infect(i,j-1,board,index +1,strs);
        boolean res = down?down:(right?right:(up?up:(left?left:false)));
        board[i][j] = temp;
        return res;
    }
}
