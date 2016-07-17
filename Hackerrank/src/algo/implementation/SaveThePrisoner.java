package algo.implementation;

import java.util.Scanner;

public class SaveThePrisoner {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int s = in.nextInt();
			m=m%n;
			int index=0;
			if(s+m>n){
				index=s+m-n;
				index--;
			}
			else{
				index=s+m-1;
			}
			if(index==0)
				index=n;
			System.out.println(index>n?index%n:index);
		}
		in.close();

	}

}
