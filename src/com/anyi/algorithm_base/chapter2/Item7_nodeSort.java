package com.anyi.algorithm_base.chapter2;

public class Item7_nodeSort {
    public static Node sortList(Node head) {
        if(head ==null || head.next == null){
            return head;
        }
        Node cur = head;
        int len = getLen(cur);
        cur = head;
        Node res = null;
        int curlen = len;
        Node pre = new Node();
        while(cur != null  && curlen >= -1){
            if(cur.next == null){
                cur = res;
                len--;
                curlen = len;
                pre = new Node();
            }
            if(cur.val > cur.next.val){ // 前一个大于后一个就交换
                Node temp = cur.next;
                if(len == curlen){
                    res = temp;
                }
                pre.next = temp; // 前节点接连上需要交换的节点
                cur.next = cur.next.next;
                temp.next = cur;
                pre = temp;
                curlen --;
            }else{
                if(len == curlen){
                    res = cur;
                }
                pre.next = cur;
                pre = cur;
                cur = cur.next;
                curlen --;
            }

        }
        return res;
    }
    public static int getLen(Node head){
        int len = 0;
        while(head !=null){
            len ++;
            head = head.next;
        }
        return len;
    }

    /**
     * 采用归并排序
     * @param head
     * @return
     */
    public static ListNode sortListBack(ListNode head) {
        return backSort(head,null);
    }
    public static ListNode backSort(ListNode head, ListNode tail){
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        // 设置快慢指针，找到终点
        ListNode slow = head;
        ListNode quick = head;
        while(quick != tail){
            slow = slow.next;
            quick =quick.next;
            if(quick != tail){ // 保证到达最后一个
                quick = quick.next;
            }
        }
        ListNode mid = slow;
        // 分别对前面 和 后面的分别排序
        ListNode front =  backSort(head,mid);
        ListNode back =  backSort(mid,tail);
        return merge(front,back);
    }
    public static ListNode merge(ListNode head1, ListNode head2){
        ListNode cur = new ListNode(0);
        ListNode head = cur,front=head1,back=head2;

        while(front !=null && back !=null){
            if(front.val <= back.val){
                head.next = front;
                front = front.next;
            }else{
                head.next = back;
                back = back.next;
            }
            head = head.next;
        }
        if(front !=null){
            head.next = front;
        }
        if(back !=null){
            head.next =back;
        }
        return cur.next;
    }
}
