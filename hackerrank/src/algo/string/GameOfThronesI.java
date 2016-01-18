package algo.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class GameOfThronesI {

	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		String inputString = myScan.nextLine();

		String ans = "YES";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < inputString.length(); i++) {
			if (map.containsKey(inputString.charAt(i)))
				map.put(inputString.charAt(i), map.get(inputString.charAt(i)) + 1);
			else
				map.put(inputString.charAt(i), 1);
		}
		if (inputString.length() % 2 == 0) {
			for (Entry<Character, Integer> entry : map.entrySet()) {
				if (entry.getValue() % 2 != 0) {
					ans = "NO";
					break;
				}
			}
		} else {
			int count = 0;
			for (Entry<Character, Integer> entry : map.entrySet()) {
				if (entry.getValue() % 2 != 0)
					++count;
			}
			if (count != 1)
				ans = "NO";
		}
		System.out.println(map);
		System.out.println(ans);
		myScan.close();

	}

}
