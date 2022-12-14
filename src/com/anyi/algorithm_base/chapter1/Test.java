package com.anyi.algorithm_base.chapter1;

import java.util.*;

public class Test {
    public static void main(String[] args) {
    /*    int[] arrs = new int[]{3,2,4,1};

        int testTime = 500000;
        int size = 10;//保证数组长度较短，可以几乎穷尽所有情况
        int value = 1000;
        boolean succeed = true;
        //进行多次测试
        for(int i = 0; i < testTime; i++){
            int[] arr1 = generateRandomArray(size,value);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr2);
            //试验证冒泡排序
            List<Integer> integers = Item6_CakeSort.pancakeSort(arrs);
            printArray(arrs);
            //用绝对正确的方法排序
            rightMethod(arr2);

            if(!isEqual(arr1,arr2)){
                succeed = false;
                //如果不相等就跳出判断循环，打印数组，ssucceed为false
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Error!");*/
        /*
        List<List<String>> lists = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("leetcode");
        strings.add("google");
        strings.add("facebook");
        lists.add(strings);
        strings.clear();
        ArrayList<String> strings2 = new ArrayList<>();
        strings.add("google");
        strings.add("microsoft");
        lists.add(strings2);
        ArrayList<String> strings3 = new ArrayList<>();
        strings.add("google");
        strings.add("facebook");
        lists.add(strings3);
        peopleIndexes(lists);
        */
        String text = "abc";
        String[] split = text.split("");
        System.out.println(Arrays.toString(split));
        StringBuffer tex = new StringBuffer();

    }

    private static void printArray(int[] arr3) {
        System.out.println(Arrays.toString(arr3));
    }

    // 绝对正确的方法
    public static void rightMethod(int[] arr){
        Arrays.sort(arr);
    }

    // 复制数组的方法
    public static int[] copyArray(int[] arr){
        if(arr==null){
            return null;
        }
        int[] res = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            res[i] = arr[i];
        }
        return res;
    }

    // 判断数组是否相等
    public static boolean isEqual(int [] arr,int [] arr1){
        //for zero
        if (arr.length == 0 || arr1.length == 0){
            return true;
        }

        // for null
        if (arr == null && arr1 == null){
            return true;
        }
        // for null other not null but other is null
        if (arr == null && arr1 != null || arr != null && arr1 == null){
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr1[i]){
                return false;
            }
        }
        return true;
    }
        // 生成随机数组
    public static int[] generateRandomArray(int size, int value){
        //产生[0,size]大小的随机整数数组((size+1)*Math.random(1)控制数组大小不会超过size)
        int[] arr = new int[(int) ((int)(size+1)*Math.random())];
        for(int i=0; i < arr.length; i++){
            //给随机数组中元素赋值，范围在(-value,value]之间
            arr[i] = ((int)(value*Math.random()));
        }
        return arr;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // 左右指针实现
        Arrays.sort(nums); // 排序
        // 准备一个列表来接收
        List<List<Integer>> res = new ArrayList<>();

        // 左指针从头开始右指针从尾开始
        for(int first= 0;first < nums.length;++first){
            if(first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            int third = nums.length - 1;
            for(int second = first +1; second < nums.length;++second){
                if(second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }

                if(second < third && nums[first] + nums[second] + nums[third] >0){
                    --third;
                }
                if(second == third){
                    break;
                }
                if(nums[first] + nums[second] + nums[third] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }
        return res;
    }
    public static List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer>  res = new ArrayList<>();
        // 首先找出最大的一个
        for(int i = 0 ; i < favoriteCompanies.size(); i++){
            boolean isSon = false;
            for(int j = 0; j < favoriteCompanies.size(); j++){
                if(i == j){
                    continue;
                }
                // 判断每一个是不是别人的子集
                isSon = oneIsSon(favoriteCompanies.get(i),favoriteCompanies.get(j));
            }
            if(!isSon){
                res.add(i);
            }
        }
        return res;
    }
    public static boolean oneIsSon(List<String> one,List<String> two){
        if(one.size() > two.size()){ // 如果one子集长度小于two那一定不是他的子集
            return false;
        }
        return new HashSet<>(two).containsAll(one);
    }
}
