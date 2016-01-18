package algo.search;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class MissingNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int b[] = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = in.nextInt();
		}
		Map<Integer, Integer> amap = new TreeMap<Integer, Integer>();
		int m = in.nextInt();
		for (int i = 0; i < m; i++) {
			int temp = in.nextInt();
			if (amap.containsKey(temp))
				amap.put(temp, amap.get(temp) + 1);
			else
				amap.put(temp, 1);
		}
		for (int i = 0; i < n; i++) {
			if (amap.containsKey(b[i])) {
				int diff = amap.get(b[i]) - 1;
				if (diff > 0)
					amap.put(b[i], diff);
				else
					amap.remove(b[i]);
			}
		}

		for (Entry<Integer, Integer> entry : amap.entrySet()) {
			System.out.print(entry.getKey() + " ");
		}
		in.close();
	}

}
