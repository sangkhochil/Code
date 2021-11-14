package leetcode.linkedlist;

public class DetectLoop {

	public static void main(String[] args) {		

	}
	
	public boolean hasCycle(ListNode head) {
		if(head == null) return false;
		ListNode tmp1 = head; 
		ListNode tmp2 = head ;
		while(tmp1.next != null){
			if(tmp1 == tmp2) return true;
			tmp1 = tmp1.next;
			tmp2 = tmp2.next.next;
		}
		return false;
	}
}
