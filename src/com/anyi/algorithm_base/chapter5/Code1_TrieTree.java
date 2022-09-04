package com.anyi.algorithm_base.chapter5;

import java.util.Arrays;

/**
 * 前缀树
 */
public class Code1_TrieTree {
    public static class TrieNode{ // 前缀树节点的数据
        public int pass;
        public int end;
        public TrieNode[] nexts; // 也可以自己用 hashMap<Character,TrieNode> 来初始化
        public TrieNode(){
            pass = 1;
            end = 1;
            nexts = new TrieNode[26]; // 26字母分别对应的26个位置
        }
    }
    // 生成前缀树
    public static class Trie{
        private static TrieNode root; // 初始化一个TrieNode
        public Trie(){
            root = new TrieNode();
        }
        // 生成前缀树
        public static void insert(String s){
            // 首先转换数组
            char[] words = s.toCharArray();
            // 遍历words
            TrieNode node = root; // 保留头节点位置
            node.pass ++;
            int cur = 0;
            for (int i = 0; i < words.length; i++) {
                cur = words[i] - 'a';
                if (node.nexts[cur] == null){ // 如果当前节点下一个没有该节点，就穿件一个节点
                    node.nexts[cur] = new TrieNode();
                }
                node = node.nexts[cur]; // 深度优先
                node.pass ++;
            }
            node.end ++;
        }
        public static int search(String s){ // 一个字符串是否在前缀树里面有几个
            if(s ==null){
                return 0;
            }
            TrieNode node = root; // 保存头节点位置
            // 转成字符串
            char[] words = s.toCharArray();
            for (int i = 0; i < words.length; i++) {
                int cur = words[i] - 'a';
                if(node.nexts[cur] == null){ // 一旦一个比对是 null
                    return 0;
                }
                node = node.nexts[cur]; // 跳到下一个比对
            }
            return node.end;
        }
        // 查询以当前字符串为前缀的节点个数
        public static int prefixNums(String s){
            if (s == null){
                return  0;
            }
            TrieNode node = root;
            char[] words = s.toCharArray();
            for (int i = 0; i < words.length; i++) {
                int cur = words[i] - 'a';
                if(node.nexts[cur] == null){ // 一旦一个比对是 null
                    return 0;
                }
                node = node.nexts[cur];
            }
            return node.pass; // 返回经过该节点的个数，就是有共同前缀的个数
        }
        // 从前缀树中删除某一字符串
        public static void delete(String s){
            if(s == null){
                return;
            }
            if(search(s) != 0){ // 判断删除的字符串是否在前缀树中
                TrieNode node = root;
                char[] words = s.toCharArray();
                int cur = 0;
                for (int i = 0; i < words.length; i++) {
                    cur  = words[i] - 'a';
                    if (--node.nexts[cur].pass == 0){ // 如果到了最后一个，就将他的end--
                        node.nexts[cur] = null;
                        return;
                    }
                    node = node.nexts[cur];
                }
                node.end --; // 还有多个数，以当前节点结尾的数少了一个
            }
        }
    }
}
