package com.anyi.leetcode;

import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    // 采用键值表和值键表，来映射，
    int size;
    HashMap<Integer,Integer> keyIndexMap;
    HashMap<Integer,Integer> indexKeyMap;
    public RandomizedSet() {
        size = 0;
        keyIndexMap = new HashMap<>(); // 创建两个集合来对应
        indexKeyMap = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(!keyIndexMap.containsKey(val)){ // 判断元素是否存在
            size++;
            indexKeyMap.put(size,val);
            keyIndexMap.put(val,size);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(keyIndexMap.containsKey(val)){ // 存不存在
            // 删除第key位置的元素，将最后一个元素放到删除的位置，让size--
            int deleteIndex = keyIndexMap.get(val); // 需要删除的index
            indexKeyMap.put(deleteIndex,indexKeyMap.get(size)); // 将最后一个数放到要删除的索引位置
            keyIndexMap.put(indexKeyMap.get(size),deleteIndex); // 更新最后一个键的index
            keyIndexMap.remove(val); // 删除val对应的键
            indexKeyMap.remove(size); // 删除最后一个值的索引值
            size --;
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int random =(int)(Math.random() * size) + 1;
        return indexKeyMap.get(random);
    }
}