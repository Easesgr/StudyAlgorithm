package com.anyi.middle_improvement.chapter5;

/**
 * 求一个二维矩阵的子矩阵最大累加和
 */
public class Code7_SubMatrixMaxSum {
    /**
     * 思路 ：采用压缩矩阵成数组，求数组的最大累加和
     */
    public static int subMatrixMaxSum(int[][] matrix){
        // 分别是一行，两行，三行，四行 .. n行
        int maxSum = 0;
        for(int i = 0 ; i < matrix.length; i++){
            // 创建一个辅助数组
            int[] help = new int[matrix[0].length];
            for(int j = 0; j <= i ;j ++){
                for(int cur = 0; cur < help.length; cur++){
                    help[cur] += matrix[j][cur];
                }
            }
            maxSum = Math.max(maxSum,subArrayMaxSum(help));
        }
        return maxSum;
    }
    public static int subArrayMaxSum(int[] arr){
        /*
            如果我们假设 i -> j 是最大且最长的区域
            那么从i -> j 位置相加都不可能小于0，如果小于0，那我们就可以截去前面小于0的部分，不符合
            从 ... -> i -1 位置任意位置相加到i-1都不可能>=0,不然我们就会加上这一段
         */
        int maxSum = 0;
        int tempSum = 0;
        for(int i = 0 ; i < arr.length; i++){
            tempSum += arr[i];
            maxSum = Math.max(maxSum,tempSum);
            if(tempSum < 0){
                tempSum = 0;
            }
        }
        return maxSum;
    }
}
