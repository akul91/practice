package algo.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class JimAndTheOrders {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Map<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
		for (int j = 1; j <= n; j++) {
			int temp = in.nextInt() + in.nextInt();
			if (map.containsKey(temp)) {
				ArrayList<Integer> list = map.get(temp);
				list.add(j);
				map.put(temp, list);
			} else
				map.put(temp, new ArrayList<Integer>(Arrays.asList(j)));
		}
		for (Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			for (Integer value : entry.getValue())
				System.out.print(value + " ");
		}
		in.close();
	}

}
