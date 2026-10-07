package sophiegermain2;

import java.util.Scanner;

public class sophiegermain2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a range (e.g. 1 100):");
		int small = scan.nextInt();
		int big = scan.nextInt();

		int sum = 0;

		for (int i = small; i <= big; i++) {
			if (isSophiePrime(i)) {
				sum += i;
			}
		}
		System.out.println("Sum of Sophie Germain primes: " + sum);
		scan.close();

	}

	public static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSophiePrime(int num) {
		return isPrime(num) && isPrime(2 * num + 1);
	}

}
