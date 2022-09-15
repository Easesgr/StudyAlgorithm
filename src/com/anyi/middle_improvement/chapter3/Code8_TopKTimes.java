package com.anyi.middle_improvement.chapter3;

import java.util.HashMap;

/**
 * 实现一个可以统计一个字符串次数，并且添加后可以随时返回出现次数最多的k个
 */
public class Code8_TopKTimes {
    public static class Node { // 节点
        public String str;
        public int times;
        public Node(String str, int times) {
            this.str = str;
            this.times = times;
        }
    }
    public static class TopKRecord{
        private HashMap<String ,Node> strNodeMap;
        private Node[] heep;
        private int heepSize;
        private HashMap<Node,Integer> nodeIndexMap;
        public TopKRecord(){
            heep = new Node[heepSize];
            heepSize= 0;
            strNodeMap = new HashMap<>();
            nodeIndexMap = new HashMap<>();
        }
        public void add(String str){
            Node curNode = null;
            int preIndex = -1;// 当前节点的指针
            if(!strNodeMap.containsKey(str)){ // 当前节点不在集合中
                curNode = new Node(str,1); // 创建集合，加到两张查询表中
                strNodeMap.put(str,curNode);
                nodeIndexMap.put(curNode,heepSize++);// 当前值
            }else{
                // 如果字符串存在
                curNode = strNodeMap.get(str);
                curNode.times ++;
                preIndex = nodeIndexMap.get(curNode);// 找到字段对应的坐标
            }
            if(preIndex == -1){ // 不在堆上
                if(heepSize == heep.length){ // 如果队满了
                    if(heep[0].times < curNode.times){ //看看当前节点的频率能不能干过最顶上的
                        nodeIndexMap.put(heep[0],-1); // 将最顶上节点拿下来
                        nodeIndexMap.put(curNode,0); //将当前节点放上去
                        heep[0] = curNode;
                        heapIfy(heep,0,heepSize); // 从当前节点往下做heapify 将最下节点调上来
                    }
                }else{
                    nodeIndexMap.put(curNode,heepSize); // 如果堆还没满，直接加到最后，然后网上做heapInsert，将当前小的值往上走
                    heep[heepSize] = curNode;
                    heapInsert(heep,heepSize++);
                }
            }else{
                heapIfy(heep,preIndex,heepSize);// 如果在堆上，直接让当前节点往下走
            }
        }
        public  void heapInsert(Node[] arr, int index){
            while (arr[index].times > arr[(index -1) / 2].times){
                swap(arr,index,(index -1) / 2);
                index = (index -1) / 2;
            }
        }
        // 向下比较替换
        public  void heapIfy(Node[] arr,int index, int heapSize){
            int left =index * 2 +1;
            while ( left < heapSize){
                // 兄弟节点之间比较
                int largest = left + 1 < heapSize && arr[left].times < arr[left +1].times ? left +1 : left;
                // 父节点和子节点直接比较
                largest = arr[index].times < arr[largest].times ? largest : index;
                if (largest == index){ // 到达根节点退出
                    break;
                }
                swap(arr,index,largest);
                index = largest;
                left = index * 2 +1;
            }
        }
        // 交换
        public void swap(Node[] arr,int i, int j){
            nodeIndexMap.put(arr[i],j);
            nodeIndexMap.put(arr[j],i);
            Node temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}
