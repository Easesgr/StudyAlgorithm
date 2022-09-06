package com.anyi.base_improvement.chapter1;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 并查集结构
 */
public class Code3_UnionFind {
    // 元素将自己包装起来
    public static class Element<V>{
        public V value;
        public Element(V value){
            this.value = value;
        }
    }
    public static class UnionFindSet<V>{
        // 三个集合
        public HashMap<V,Element<V>>  elementMap; // 自己表示一个集合
        public HashMap<Element<V> ,Element<V>> fatherMap; // 当前元素的父元素
        public HashMap<Element<V>,Integer> sizeMap; // 表示当前集合作为代表节点，该条链表的长度
        public UnionFindSet(List<V> list){ // 必须将所有元素初始化
            for (V v : list) {
                Element<V> vElement = new Element<>(v);
                elementMap.put(v,vElement); // 当前值对应的节点
                fatherMap.put(vElement,vElement); // 刚开始的时候，自己是自己的父节点
                sizeMap.put(vElement,1); // 初始化的时候，所有节点都是自己的代表节点
            }
        }
        // 找到自己的头
        public Element<V> findHead(Element<V> element){
            // 准备一个栈，找头的同时让所有元素进栈，然后让所有的元素的上一节点都该更代表节点
            Stack<Element<V>> stack = new Stack<>();
            while(element != fatherMap.get(element)){ // 只要不等于头节点
                stack.push(element);
                element = fatherMap.get(element);
            }
            while(!stack.isEmpty()){
                fatherMap.put(stack.pop(),element);
            }
            return element;
        }
        // 查询两个字符是不是一个组
        public Boolean isSame(V v1 ,V v2){
            if(elementMap.containsKey(v1)&&elementMap.containsKey(v2)){
                return findHead(new Element<>(v1)) == findHead(new Element<>(v2));
            }
            return false;
        }
        // 合并两个集合
        public void union(V v1,V v2){
            if(elementMap.containsKey(v1)&&elementMap.containsKey(v2)){
                Element<V> V1 = findHead(new Element<>(v1));
                Element<V> V2 = findHead(new Element<>(v2));
                if(V1 != V2){
                    if(sizeMap.get(V1) > sizeMap.get(V2)){
                        fatherMap.put(V2,V1);
                        sizeMap.put(V1,sizeMap.get(V2) + sizeMap.get(V1));
                    }else {
                        fatherMap.put(V1,V2);
                        sizeMap.put(V2,sizeMap.get(V2) + sizeMap.get(V1));
                    }
                }
            }
        }
    }
}
