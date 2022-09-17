package com.anyi.middle_improvement.chapter6;

/*
    给定数字的n，给你一个n长度的数组，里面的数字都是从1-n，请找出没有出现过的数字
 */
public class Code2_PrintNoInArray {
    public static void main(String[] args) {
        printNoInArray(new int[]{6,2,3,1,4,4});
    }
    /* 充第一个位置开始找，找到它应该去的位置，并且将该位置的值改成需要在那的数字，
        然后获得一个新的需要到达准确位置的值，一直这样换下去，如果回到了最初的位置，
        就说明当前位置已经调整好了，下一个值，如果找到值位置上已经有是这个值了，直接退出，
        坐标位置这个数就是不在集合中的
     */
    public static void printNoInArray(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        for(int value:arr){
            modify(value,arr);
        }
        for(int i = 0; i < arr.length ; i++){
            if(arr[i] != i+1){
                System.out.println(i + 1);
            }
        }
    }
    public static void modify(int value, int[] arr){
        while(arr[value - 1] != value){
            int temp = arr[value -1];
            arr[value - 1] = value;
            value =temp;
        }
    }
}
