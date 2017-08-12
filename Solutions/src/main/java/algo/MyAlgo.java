package main.java.algo;

import java.text.DecimalFormat;
import java.util.Arrays;

public class MyAlgo {

	public static void main(String[] args) {
		LinkedList<Integer> n1 = new LinkedList<Integer>();
		System.out.println("End insert");
		n1.insertEnd(29);
		n1.printList();
		System.out.println("head insert");
		n1.inserHead(30);
		n1.printList();
		System.out.println("End insert");
		n1.insertEnd(52);
		n1.printList();
		System.out.println("head insert");
		n1.inserHead(1);
		n1.printList();
	}

	public static double[] plusMinus(int n, int[] a) {
		DecimalFormat numberFormat = new DecimalFormat("#.000000");
		double[] b = new double[3];
		int p = 0;
		int n1 = 0;
		int ze = 0;
		for (int x = 0; x < a.length; x++) {
			if (a[x] == 0) {
				ze += 1;
			}
			if (a[x] < 0) {
				n1 += 1;
			}
			if (a[x] > 0) {
				p += 1;
			}
		}
		b[0] = Double.valueOf(numberFormat.format((double) p / n));
		b[1] = Double.valueOf(numberFormat.format((double) n1 / n));
		b[2] = Double.valueOf(numberFormat.format((double) ze / n));
		return b;
	}

	public static int[] compareTripTest(int a0, int a1, int a2, int b0, int b1, int b2) {
		int[] res = new int[2];
		res[0] = (a0 > b0) ? 1 : 0;
		res[0] = res[0] + ((a1 > b1) ? 1 : 0);
		res[0] = res[0] + ((a2 > b2) ? 1 : 0);

		res[1] = (a0 < b0) ? 1 : 0;
		res[1] = res[1] + ((a1 < b1) ? 1 : 0);
		res[1] = res[1] + ((a2 < b2) ? 1 : 0);
		return res;
	}

	public static int count8(int n) {
		if ((n / 10) == 8 && (n % 10) == 8) {
			return 3;
		}
		if (n < 10) {
			if (n == 8) {
				return 1;
			}
			return 0;
		}

		int n2 = n / 10;
		int n3 = n;
		boolean t = ((n3 % 10 == 8) && (n2 % 10) == 8);
		int n4 = t ? 88 : n % 10;
		int n5 = t ? n2 / 10 : n / 10;
		return count8(n5) + (count8(n4));
	}

	public static int sumDigits(int n) {
		if (n < 10) {
			return n;
		}
		return sumDigits(n / 10) + sumDigits(n % 10);
	}

	public static int bS(int[] A, int X) {
		Arrays.sort(A);
		int s = 0;
		int e = A.length - 1;
		while (s <= e) {
			int mid = (s + e) / 2;
			int val = A[mid];
			if (val == X) {
				return mid;
			} else {
				if (val > X) {
					e = mid - 1;
				}
				if (val < X) {
					s = mid + 1;
				}
			}
		}
		return -1;
	}

	public static void fun2(int n) {
		if (n == 0)
			return;

		fun2(n / 2);
		System.out.printf("%d", n % 2);
	}

	public static int fun1(int n) {
		if (n == 1)
			return 0;
		else
			return 1 + fun1(n / 2);
	}

	public static int fun1(int x, int y) {
		if (x == 0)
			return y;
		else
			return fun1(x - 1, x + y);
	}

	public static int fib(int n) {
		if (n < 2) {
			return n;
		} else {
			return fib(n - 2) + fib(n - 1);
		}

	}

	public static int fact(int n) {
		int res = 0;
		if (n == 0) {
			return 1;
		} else {
			res = n * fact(n - 1);
			System.out.println(res);
		}
		return res;
	}
}
