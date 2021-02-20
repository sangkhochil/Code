package com.linkedlist;

public class MergeSortLinkList {

	public static void main(String[] args) {
//		/new MergeSortLinkList().mergeTwoLists(l1, l2);
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        else if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;

        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        ListNode head = new ListNode(10);
        ListNode tmp = head;

        while(tmp1 != null && tmp2 != null){
            if(tmp1.val < tmp2.val) {
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }
        //printf("check1");
        while(tmp1 != null){
            tmp.next = tmp1;
            tmp = tmp.next;
            tmp1 = tmp1.next;
        }
       while(tmp2 != null){
            tmp.next = tmp2;
            tmp = tmp.next;
            tmp2 = tmp2.next;
        }
        return head.next;
    }
}
