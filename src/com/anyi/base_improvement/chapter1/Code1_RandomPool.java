package com.anyi.base_improvement.chapter1;

import java.util.*;

/**
 * 编写一个类，可以插入，删除和返回随机一个数
 */
public class Code1_RandomPool {
    public static void main(String[] args) {
        constructArr(new int[]{1,2,3,4,5});
        List<String> res = new ArrayList<>();
        res.add("0:start:2");

        Stack<String > stack = new Stack<>();
        System.out.println(Integer.parseInt(res.get(0).split(":")[2]));
    }
    public static int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        for(int i = 0 ; i< a.length;i++){
            int iMul = 1,left = i - 1,right =i + 1;
            while(left > 0){
                iMul*=a[left];
                left--;
            }
            while(right < a.length){
                iMul*=a[right];
                right ++;
            }
            res[i] = iMul;
        }
        return res;
    }
    public static int uniqueLetterString(String s) {
        Map<Character, List<Integer>> index = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new ArrayList<Integer>());
                index.get(c).add(-1);
            }
            index.get(c).add(i);
        }
        int res = 0;
        for (Map.Entry<Character, List<Integer>> entry : index.entrySet()) {
            List<Integer> arr = entry.getValue();
            arr.add(s.length());
            for (int i = 1; i < arr.size() - 1; i++) {
                res += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i));
            }
        }
        return res;
    }

    public static class Pool<K>{
        private HashMap<K,Integer> keyIndexMap; // 键和值的hashmap
        private HashMap<Integer,K> indexKeyMap; // 值和键的hashmap
        private int size;
        public Pool(){
            this.keyIndexMap = new HashMap<>();
            this.indexKeyMap = new HashMap<>();
            this.size = 0;
        }
        // 插入方法
        public void insert(K key){
            if(!keyIndexMap.containsKey(key)){
                keyIndexMap.put(key,this.size); // 放入index对应key的表
                indexKeyMap.put(this.size ++ ,key); // 放入key对应index的表
            }
        }

        // 删除 key
        public void delete(K key){
            if(keyIndexMap.containsKey(key)){
                // 将最后一个值 拿出来，放到删除的index处
                Integer deleteIndex = keyIndexMap.get(key);
                K lastValue = this.indexKeyMap.get(this.size);
                indexKeyMap.put(deleteIndex,lastValue);
                keyIndexMap.put(lastValue,deleteIndex);
                this.keyIndexMap.remove(key);
                this.indexKeyMap.remove(deleteIndex);
                this.size--;
            }
        }
        // 随机返回一个key
        public K randomKey(){
            Integer index = (int)(Math.random() * this.size);
            if(this.size > 0){
                return indexKeyMap.get(index);
            }
            return null;
        }
    }
}
