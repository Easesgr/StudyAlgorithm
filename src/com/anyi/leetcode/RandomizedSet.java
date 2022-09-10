package com.anyi.leetcode;

import java.util.HashMap;

class RandomizedSet {

    HashMap<Integer,Integer> indexKeyMap; // 索引和键值表 用于生成随机数
    HashMap<Integer,Integer> keyIndexMap; // 键值和索引表 用于添加
    int size;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        indexKeyMap = new HashMap<Integer,Integer>();;
        keyIndexMap = new HashMap<Integer,Integer>();
        size = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!keyIndexMap.containsKey(val)){
            indexKeyMap.put(size,val);
            keyIndexMap.put(val,size);
            size++;
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        // 首先这个key必须在里面
        if(keyIndexMap.containsKey(val)){
            // 删除key后，将最后一个数拿到删除key的index里面，更新keyIndex表
            int lastKey = indexKeyMap.get(size-1);
            int deleteIndex = keyIndexMap.get(val);
            indexKeyMap.remove(deleteIndex);
            indexKeyMap.put(deleteIndex,lastKey);
            keyIndexMap.put(lastKey,deleteIndex);
            indexKeyMap.remove(size -1);
            keyIndexMap.remove(val);
            size--;
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        // 获取随机值，首先不能为空
        Integer index = (int)(Math.random() * size);
        return indexKeyMap.get(index);
    }
}
