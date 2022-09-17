package com.anyi.middle_improvement.chapter5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将一组字符串，生成前缀树，并且按照目录结构打印
 * a\\b\\c
 * a
 *   b
 *     c
 * 如上转换
 */
public class Code1_GetFolderTree {
    public static class Node{
        public String str;
        public Map<String ,Node> nextNodes;
        public Node(String str){
            this.str = str;
            nextNodes = new HashMap<>();
        }
    }
    public static Node getFolderTree(String[] strs){
        // 一个跟节点
        Node root = new Node("");
        for(String foldPath : strs){
            String[] paths = foldPath.split("\\\\");
            Node cur = root;
            for(String path: paths){
                if(!cur.nextNodes.containsKey(path)){
                    cur.nextNodes.put(path,new Node(path));
                }else{
                    cur = cur.nextNodes.get(path);
                }
            }
        }
        return root;
    }
}
