package com.leetcode;

/**
 * @author monkjavaer
 * @date 2021/3/5
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String print(ListNode node) {
        StringBuilder sb = new StringBuilder();

        if(node.next != null){
            sb.append(node.val).append(">");
            sb.append(print(node.next));
        }else {
            sb.append(node.val);
        }
        return sb.toString();
    }
}
