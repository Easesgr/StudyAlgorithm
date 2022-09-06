package com.anyi.base_improvement.chapter3;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 滑动窗口， 窗口里面持续保持最大值在队头，如果遇到不是最大值的，让前面的值全部出队，仍然保存当前最大值
 */
public class Code1_SlidingWindowsMaxArray {
    public static void main(String[] args) {
        int[] maxWindows = getMaxWindows(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(maxWindows));
    }
    public static int[] getMaxWindows(int[] arr, int w){
        // 创建一个双端队列
        LinkedList<Integer>  doubleQueue = new LinkedList<>();
        int[] res = new int[arr.length - w + 1]; // 窗口大小导致最后 w-1 个是没有最大值的
        int index = 0;
        for (int i = 0 ; i < arr.length; i++){
            while(!doubleQueue.isEmpty() && arr[doubleQueue.peekLast()] <= arr[i]){
                doubleQueue.pollLast();// 从后端退出
            }
            doubleQueue.addLast(i);
            // 最大的节点已经是过期的节点，就将它删除
            if (doubleQueue.peekFirst() == i -w){
                doubleQueue.pollFirst();
            }
            if( i >= w -1 ){
                res[index ++] = arr[doubleQueue.peekFirst()]; // 保存最大值
            }
        }
        return res;
    }
}
