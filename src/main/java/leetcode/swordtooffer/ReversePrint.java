package leetcode.swordtooffer;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
//
//
// 示例 1：
//
// 输入：head = [1,3,2]
//输出：[2,3,1]
//
//
//
// 限制：
//
// 0 <= 链表长度 <= 10000
// Related Topics 栈 递归 链表 双指针
// 👍 164 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class ReversePrint {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static int[] reversePrint(ListNode head) {
        if (head == null)
            return new int[]{};
        ListNode pre = null,cur = head;
        int len = 0;
        while (cur != null) {
            len ++;
            ListNode t =  cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        int[] ints = new int[len];
        cur = pre;
        int i = 0;
        while (cur !=null){
            ints[i] = cur.val;
            cur = cur.next;
            i++;
        }
        return ints;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        int[] ints = reversePrint(listNode1);
        System.out.println(ints);
    }
}
