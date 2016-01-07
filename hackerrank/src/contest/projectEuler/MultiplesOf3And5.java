package contest.projectEuler;

import java.util.Scanner;

public class MultiplesOf3And5 {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int t = in.nextInt();
        for (int i = 0; i < t; i++) {
        	long n = (long)in.nextInt()-1;
        	long sum=0;
        	long three=n/3;
        	long five=n/5;
        	long fifteen=n/15;
            sum=sumof(3, 3,three)+sumof(5, 5, five)-sumof(15, 15, fifteen);
            System.out.println(sum);
        }
        in.close();
    }
    public static long sumof(long a,long d,long n){
    	long sum=(((2*a)+((n-1)*d))*n)/2;
        return sum;
    }
}
