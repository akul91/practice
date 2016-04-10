/*
 * 
 * Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 */
package practice;

import java.util.Scanner;

public class CompareVersionNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String v1 = in.next();
		String v2 = in.next();
		System.out.print(compareVersion(v1, v2));
		in.close();
	}

	public static int compareVersion(String version1, String version2) {
		String[] split1 = version1.split("\\.");
		String[] split2 = version2.split("\\.");
		int n = Math.min(split1.length, split2.length);
		int val = 0;
		for (int i = 0; i < n; i++) {
			if (Integer.parseInt(split1[i]) > Integer.parseInt(split2[i])) {
				val = 1;
				break;
			} else if (Integer.parseInt(split1[i]) < Integer.parseInt(split2[i])) {
				val = -1;
				break;
			}
		}
		if (val == 0) {
			int diff = Math.abs(split1.length - split2.length);
			if (n + diff == split1.length) {
				for (int i = n; i < n + diff; i++) {
					if (Integer.parseInt(split1[i]) == 0)
						val = 0;
					else
						val = 1;
				}
			} else if (n + diff == split2.length) {
				for (int i = n; i < n + diff; i++) {
					if (Integer.parseInt(split2[i]) == 0)
						val = 0;
					else
						val = -1;
				}
			}
		}
		return val;
	}
}
