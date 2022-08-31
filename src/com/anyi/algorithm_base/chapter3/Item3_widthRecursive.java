package com.anyi.algorithm_base.chapter3;


import com.anyi.algorithm_base.chapter2.Node;

import java.util.*;

/**
 * 宽度遍历
 */
public class Item3_widthRecursive {

    public static void widthRecursive(TreeNode head){
        // 采用队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            TreeNode poll = queue.remove();
            System.out.println(poll.value + "");
            if (poll.left != null){
                queue.add(poll.left);
            }
            if (poll.right !=null){
                queue.add(poll.right);
            }
        }
    }
}
