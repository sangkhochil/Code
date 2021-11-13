package com.array.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ArrayDiagonal {
	int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 } };

	public void diagonal1() {
		List<List<Integer>> diagonal = new ArrayList<List<Integer>>();
		for (int i = 0; i < (arr.length + arr[0].length - 1); i++)
			diagonal.add(new ArrayList<Integer>());

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				diagonal.get(i + j).add(arr[i][j]);
			}
		}

		// print
		for (int i = 0; i < diagonal.size(); i++) {
			for (int j = diagonal.get(i).size() - 1; j >= 0; j--)
				System.out.print(diagonal.get(i).get(j) + " ");
			System.out.println();
		}
	}

	public void diagonal2() {
		Map<Integer, List<Integer>> diagonal = new TreeMap<Integer, List<Integer>>();
//		for (int i = 0; i < (arr.length + arr[0].length - 1); i++)
//			diagonal.add(new ArrayList<Integer>());

		for (int i = 0; i < arr.length; i++) {
			for (int j = arr[0].length - 1; j >= 0; j--) {
				if (diagonal.get(j - i) == null)
					diagonal.put(j - i, new ArrayList<Integer>());
				diagonal.get(j - i).add(arr[i][j]);
			}
		}

		// print
		Iterator<Entry<Integer, List<Integer>>> ir = diagonal.entrySet().iterator();
		while (ir.hasNext()) {
			Entry<Integer, List<Integer>> entry = ir.next();
			System.out.print(entry.getKey() + " => ");
			for (int i = 0; i < entry.getValue().size(); i++)
				System.out.print(entry.getValue().get(i) + " ");
			System.out.println();
		}
	}
}
