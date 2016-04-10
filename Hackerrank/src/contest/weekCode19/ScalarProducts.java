package contest.weekCode19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ScalarProducts {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();
		int m = in.nextInt();
		int n = in.nextInt();
		long len = ((long) n * 2) + 2;
		long[][] vec = new long[n][2];
		long first = 0;
		long second = (long) c;
		int j = 0;
		List<Integer> ids = new ArrayList<Integer>();
		Map<String, String> values = new HashMap<String, String>();
		for (int i = 2; i < len; i++) {
			long third = (first + second) % m;
			if (i % 2 == 0)
				vec[j][0] = third;
			else {
				vec[j][1] = third;
				String str = vec[j][0] + "," + vec[j][1];
				if (values.containsKey(str)) {
					values.put(str, values.get(str) + "," + j);
				} else {
					values.put(str, "" + j);
				}
				j++;
			}
			first = second;
			second = third;
		}
		for (Map.Entry<String, String> entry : values.entrySet()) {
			String[] parts = entry.getValue().split(",");
			if (parts.length > 1) {
				ids.add(Integer.parseInt(parts[0]));
				ids.add(Integer.parseInt(parts[1]));
			} else
				ids.add(Integer.parseInt(parts[0]));
		}
		Set<Long> set = new TreeSet<Long>();
		for (int i = 0; i < ids.size() - 1; i++) {
			for (j = i + 1; j < ids.size(); j++) {
				long sum = vec[ids.get(i)][0] * vec[ids.get(j)][0] + vec[ids.get(i)][1] * vec[ids.get(j)][1];
				set.add(sum % m);
			}
		}
		System.out.println(set.size());
		in.close();
	}
}
