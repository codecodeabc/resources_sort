package leetcode.twopointer;


/**
 * 142. Linked List Cycle II (Medium)
 * 题目描述
 * 给定一个链表，如果有环路，找出环路的开始点。
 * 3.5 滑动窗口 – 11/143 –
 * 输入输出样例
 * 输入是一个链表，输出是链表的一个节点。如果没有环路，返回一个空指针。
 * 图 3.1: 题目 142 - 输入样例
 * 在这个样例中，值为 2 的节点即为环路的开始点。
 * 如果没有特殊说明，LeetCode 采用如下的数据结构表示链表。
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class LinkListCycle2 {
    public static ListNode detectCycle(ListNode head) {
        /**
         *
         * 设快指针为a,慢指针b,起点到入口距离 l,b进入圈后走了 k，第一轮走了 t次
         *
         * 所以 a 走了 2t, b 走了 t, 且 a 追上 b 需要多走一圈，则一圈为 t，
         * 且 b 走了 l + k == t 则 b 再走 l 就到了入口
         *
         * 所以 a 从头走起知道 a == b ,此时为入口了
         */
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null){
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
            }
            if(slow!=null){
                slow = slow.next;
            }
            if(slow == fast){
                break;
            }
        }
        if(fast == null){
            return null;
        } else{
            fast = head;
            while(fast != slow){
                if(fast!=null && slow!=null){
                    fast = fast.next;
                    slow = slow.next;
                }
            }
        }
        return fast;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode2;
        ListNode listNode = detectCycle(listNode1);
        System.out.println(listNode.val);
    }
}
