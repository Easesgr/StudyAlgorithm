package com.anyi.base_improvement.chapter5;


/**
 * 给定一个数组，每次都只能拿最左边或者最右边的值，我先拿，或者对方先拿，谁拿到的和更大，谁就获胜
 * 求我获胜的分数
 */
public class Code3_CartsInLine {
    public static void main(String[] args) {
        int[] arr =new int[]{1,3,100,2,19};
        int i = process(arr);
        System.out.println(i);

    }
    public static int cartsInLine(int[] arr){
        return Math.max(f(arr,0,arr.length - 1),s(arr,0,arr.length -1));
    }
    // 先手函数
    public static int f(int[] arr,int left,int right){
        if(left ==right){
            return arr[left];
        }
        return Math.max(arr[left] + s(arr,left + 1,right),arr[right] + s(arr,left,right-1));
    }
    // 后手函数
    public static int s(int[] arr,int left,int right){
        if(left == right){
            return 0;
        }
        return Math.min(f(arr,left +1,right),f(arr,left,right -1));
    }

    // 改成动态规划
    public static int process(int[] arr){
        int n = arr.length;
        // 两个递归,两张表
        int[][] f = new int[n][n]; // 先手表
        int[][] s = new int[n][n]; // 后手表
        // 根据base case 初始化两个表
        for(int i = 0 ; i< n ; i++){
            f[i][i] = arr[i];
            s[i][i] = 0;
        }
        for(int j = 1 ; j < n ; j++){
            int col = j;
            int row = 0;
            while(col < n){
                s[row][col] = Math.min(f[row][col -1],f[row +1][col]);
               col++;
               row++;
            }
            col = j;
            row = 0;
            while(col < n){
                f[row][col] = Math.max(arr[row]+s[row+1][col],arr[col]+ s[row][col-1]);
                col++;
                row++;
            }
        }
        return Math.max(f[0][n-1],s[0][n-1]);
    }

}
