package com.anyi.algorithm_base.chapter2;

/**
 * 合并n个链表
 */
public class Item8_MergeNNode {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode();
        for(int i= 0; i < lists.length; i++){
            res = merge(backSort(res,null),backSort(lists[i],null));
        }
        return res;
    }
    public ListNode merge(ListNode head1,ListNode head2){
        ListNode res = new ListNode();
        ListNode temp = res, temp1 = head1, temp2 = head2;
        while(temp1 != null && temp2 !=null){
            if(temp1.val < temp2.val){
                temp.next = temp1;
            }else{
                temp.next = temp2;
            }
            temp = temp.next;
        }
        return res.next;
    }
    public ListNode backSort(ListNode head,ListNode tail){
        if(head != null){
            return null;
        }
        if(head.next == tail){
            head.next = null;
            return head;
        }
        // 准备一个快指针和一个慢指针
        ListNode slow = head;
        ListNode fast = head;
        while(fast !=tail){
            slow = slow.next;
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode left =  backSort(head,mid);
        ListNode right = backSort(mid,tail);
        return merge(left,right);
    }
}
