package leetcode.linkedlist;

public class ReverseLinkedList {

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
		
		new ReverseLinkedList().reverseList(head);
	}
	public ListNode reverseList(ListNode head) {
		if(head == null) return null;
		if(head.next == null) return head;
		
		ListNode node = new ListNode(head.val);
		ListNode tmp = head.next;
		while(tmp != null) {
			ListNode t = new ListNode(tmp.val);
			t.next = node;
			node = t;
			tmp = tmp.next;
		}
		return node;
    }
}
