package com.linkedlist;

public class PalindromeLinkedList {

	public static void main(String[] args) {
	}
	
	public boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null) return true;
		
		ListNode node = new ListNode(head.val);
		ListNode tmp = head.next;
		int count = 1;
		while(tmp != null) {
			ListNode t = new ListNode(tmp.val);
			t.next = node;
			node = t;
			tmp = tmp.next;
			count++;
		}
		tmp = head;
		int i = 0;
		while(tmp != null) {			
			if(tmp.val != node.val) return false;
			if(i == count/2) return true;
			tmp = tmp.next;
			node = node.next;
			i++;
		}
		return true;
    }

}
