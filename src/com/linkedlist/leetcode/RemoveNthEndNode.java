package com.linkedlist.leetcode;

public class RemoveNthEndNode {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode t1 = new ListNode(2);
		head.next = t1;
		ListNode t2 = new ListNode(3);
		t1.next = t2;
		ListNode t3 = new ListNode(4);
		t2.next = t3;
		ListNode t4 = new ListNode(5);
		t3.next = t4;
		
		new RemoveNthEndNode().removeNthFromEnd(head, 2);
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null) return null;
		
		ListNode tmp = head;
		
		int count = 0;
		while(tmp != null){
			count++;
			tmp = tmp.next;
		}
		
		if( count == n) return head.next;
		
		tmp = head;
		ListNode tmp1 = head.next;
		int i = 1;
		while(tmp1 != null) {
			if(count - n == i) {
				tmp.next = tmp1.next;
				break;
			}
			tmp = tmp.next;
			tmp1 = tmp1.next;
			i++;
		}
		
		return head;
    }
}
