package contest.weekCode19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindThePermutation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[] arr = new int[n];
			for (int j = 1; j <= n; j++) {
				arr[j - 1] = j;
			}
			List<int[]> permutations = findPermutations(arr, n);
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < permutations.size(); j++) {
				int[] p = permutations.get(j);
				int min = Integer.MAX_VALUE;
				for (int x = 0; x < p.length - 1; x++)
					min = Math.min(min, Math.abs(p[x] - p[x + 1]));
				if (min > max)
					max = min;
				map.put(j, min);
			}
			int count = 0;
			boolean flag = false;
			int val = 0;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue() == max)
					++count;
				if (count == k) {
					val = entry.getKey();
					flag = true;
					break;
				}
			}
			if (flag) {
				int[] p = permutations.get(val);
				for (int x = 0; x < p.length; x++) {
					System.out.print(p[x] + " ");
				}
			} else
				System.out.print("-1");
			System.out.println();
		}
		in.close();
	}

	private static List<int[]> findPermutations(int[] arr, int len) {
		List<int[]> permutations = new ArrayList<int[]>();
		boolean flag = false;
		while (!flag) {
			permutations.add(arr.clone());
			int i;
			for (i = len - 2; i >= 0; --i)
				if (arr[i] < arr[i + 1])
					break;
			if (i == -1)
				flag = true;
			else {
				int ceilIndex = findCeil(arr, arr[i], i + 1, len - 1);
				int temp = arr[i];
				arr[i] = arr[ceilIndex];
				arr[ceilIndex] = temp;
				quickSort(arr, i + 1, len);
			}
		}
		return permutations;
	}

	private static int findCeil(int[] arr, int first, int start, int end) {
		int ceilIndex = start;
		for (int i = start + 1; i <= end; i++)
			if (arr[i] > first && arr[i] < arr[ceilIndex])
				ceilIndex = i;

		return ceilIndex;
	}

	static int partition(int[] ar, int start, int end) {
		int pivot = ar[start];
		int pos = start;
		for (int i = start + 1; i < end; i++) {
			if (ar[i] < pivot) {
				++pos;
				int temp = ar[i];
				for (int j = i; j >= pos; j--) {
					ar[j] = ar[j - 1];
				}
				ar[pos] = temp;
			}
		}
		for (int i = start; i < pos; i++)
			ar[i] = ar[i + 1];
		ar[pos] = pivot;
		return pos;
	}

	static void quickSort(int[] ar, int start, int end) {
		if (start >= end - 1)
			return;
		int pos = partition(ar, start, end);
		quickSort(ar, start, pos);
		quickSort(ar, pos + 1, end);
	}
}
