package com.array.leetcode;

class MyNode {
	MyNode next;
    int value;
    int count;
    MyNode(int value){
        this.value = value;
        this.count = 0;
        this.next = null;
    }
    
    void setCount(){
        this.count++;
    }
    
    int getCount(){
        return this.count;
    }
}

public class Intersection {
    int getHash(int key, int Size) {
		int hash = 5381;
		hash = (((hash << 5) + hash) + key) % Size;
		if (hash < 0)
			hash *= -1;
		return hash % Size;
	}

	void insert(int value, MyNode[] table, int n) {
		int hash = getHash(value, n);
		if (table[hash] == null) {
			table[hash] = new MyNode(value);
			table[hash].setCount();
			return;
		}

		MyNode tmp = table[hash];
		while (tmp != null) {
			if (tmp.value == value) {
				tmp.setCount();
				return;
			}
			tmp = tmp.next;
		}
		tmp = table[hash];
		table[hash] = new MyNode(value);
		table[hash].setCount();
		table[hash].next = tmp;
	}

	int search(int value, MyNode[] table, int n) {
		int hash = getHash(value, n);
		if (table[hash] == null) {
			return 0;
		}

		MyNode tmp = table[hash];
		while (tmp != null) {
			if (tmp.value == value) {
				return tmp.getCount();
			}
			tmp = tmp.next;
		}

		return 0;
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		MyNode table1[] = new MyNode[n1];
		MyNode table2[] = new MyNode[n2];

		for (int i = 0; i < n1; i++) {
			insert(nums1[i], table1, n1);
		}

		for (int i = 0; i < n2; i++) {
			insert(nums2[i], table2, n2);
		}

		int n = 0;
		int check = 0;
		if (n1 < n2) {
			n = n1;
			check = 1;
		} else {
			n = n2;
			check = 2;
		}

		int[] tmp = new int[n1 + n2];
		int count = 0;
		int v, v1, v2;
		if (check == 1) {
			MyNode table[] = new MyNode[n1];
			for (int i = 0; i < n1; i++) {
				if(search(nums1[i], table, n1) == 0) {
					v1 = search(nums1[i], table1, n1);
					v2 = search(nums1[i], table2, n2);
					if(v1<v2)
						v = v1;
					else v = v2;
					while(v-- > 0)
						tmp[count++] = nums1[i];
					
					insert(nums1[i], table, n1);
				}				
			}
		} else {
			MyNode table[] = new MyNode[n2];
			for (int i = 0; i < n2; i++) {
				if(search(nums2[i], table, n2) == 0) {
					v1 = search(nums2[i], table1, n1);
					v2 = search(nums2[i], table2, n2);
					if(v1<v2)
						v = v1;
					else v = v2;
					while(v-- > 0)
						tmp[count++] = nums2[i];
					
					insert(nums2[i], table, n2);
				}				
			}
		}

		if (count == n1 + n2)
			return tmp;
		int[] ret = new int[count];
		for (int i = 0; i < count; i++)
			ret[i] = tmp[i];
		return ret;
	}
}
