package com.linkedlist;

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }


public class DeleteNode {

	public static void main(String[] args) {
		//new DeleteNode().deleteNode();
	}
	
	public void deleteNode(ListNode node) {
		ListNode tmp = node;
		while(tmp.next != null) {
			tmp.val = tmp.next.val;
			if(tmp.next.next == null)
				tmp.next = null;
			tmp = tmp.next;
		}
	}
}

