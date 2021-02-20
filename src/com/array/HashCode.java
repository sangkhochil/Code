package com.array;

public class HashCode {
	int SIZE;
	int hash(int c) {
		int hash = 5381;
		// int c;
		// while (c = *str++)
		hash = (((hash << 5) + hash) + c) % SIZE;
		if (hash < 0)
			hash *= -1;
		return hash % SIZE;
	}
}


class Node {
    Node next;
    int value;
    int index;
    Node(int value, int index){
        this.value = value;
        this.index = index;
        this.next = null;
    }
}

class Solution {
    int SIZE;
    int getHash(int c) {
		int hash = 5381;
		// int c;
		// while (c = *str++)
		hash = (((hash << 5) + hash) + c) % SIZE;
		if (hash < 0)
			hash *= -1;
		return hash % SIZE;
	}
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        SIZE = nums.length;
        Node []table = new Node[SIZE];
        for(int i=0; i<nums.length; i++) {
            table[i] = null;
        }
        
        for(int i=0; i<nums.length; i++) {
            int hash = getHash(nums[i]);
            if(table[hash] == null){
                table[hash] = new Node(nums[i], i);
            } else {
                Node tmp = table[hash];
                int check = 0;
                while(tmp != null) {
                    if(tmp.value == nums[i]) {
                        check = 1;
                        if((i - tmp.index) <= k)
                            return true;
                        else{
                            tmp.index = i;
                        }                            
                    }
                    tmp = tmp.next;
                }
                
                if(check != 1) {
                    Node tmp1 = table[hash];
                    table[hash] = new Node(nums[i], i);
                    table[hash].next = tmp1;
                }
            }
        }
        return false;
    }
}