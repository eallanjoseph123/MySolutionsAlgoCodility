package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PracticeSolutions {

	public static void main(String[] args) {
		
	}
	
	
	public static int fish(int[] A, int[] B){
		int l = A.length;
		int currentLive = 0;
		List<Integer> fish=new LinkedList<Integer>();
		for(int x = 0; x < l ;x ++){
			fish.add(A[x]);
		}
		currentLive = fish.size();
		for(int x = 0 ;x < l-1;x++){
			if(B[x] != B[x+1]){
				if(A[x] > A[x+1]){
					fish.remove(x+1);
				}if(A[x] < A[x+1]){
					fish.remove(x);
				}
			}
		}
		return currentLive;
	}

	public static int family(int N) {
		String s = String.valueOf(N);
		int res = 0;
		char[] b = s.toCharArray();
		Arrays.sort(b);
		StringBuilder sb = new StringBuilder(Arrays.toString(b).replaceAll("\\[|\\]|,|\\s", "")).reverse();
		res = Integer.valueOf(sb.toString());
		if (res > 100_000_000){
			res = -1;
		}
		return res;
	}
	public static boolean swap1(int[] A) {
		int l = A.length;
		int ctn = 0;
		int[] B = Arrays.copyOf(A, A.length);
		Arrays.sort(B);
		for (int x = 0; x < l; x++) {
			int a = A[x];
			int b = B[x];
			if (b != a)
				ctn++;

		}
		if (ctn > 2)
			return false;

		return true;
	}
	

	//100 
	/**
	 * NESTING problem can be used this algo same score 100
	 */
	public static int brackets(String S) {
		Map<Character, Character> ref = new HashMap<>();
		ref.put('(', ')');
		ref.put('{', '}');
		ref.put('[', ']');
		List<Character> ref2 = new ArrayList<>();
		int l = S.length();
		if (l == 0) return 1;
	    if((l%2) == 1)
		for(int x = 0 ; x < l ;x++){
			char k = S.charAt(x);
			if(ref.containsKey(k)){
				ref2.add(k);
			}else if(x != 0){
				int index = ref2.size()-1;
				char last = 0;
				char comV = 0;
				if(index >=0){
					last = ref2.get(index);
					comV = ref.get(last);
					if(comV == k){
						ref2.remove(index);
					}else{
						return 0;
					}
				}else{
					return 0;
				}
			}else{
				return 0;
			}
		}
		return ref2.size() == 0 ? 1 : 0;
	}

	// 100
	public static int passingCar(int[] A) {
		int res = 0;
		int z = 0;
		for (int x = 0; x < A.length; x++) {
			if (A[x] == 0) {
				z++;
			}
			if (A[x] == 1 && z > 0) {
				res += z;
			}
		}
		if (res > 1_000_000_000 || res < 0)
			res = -1;
		return res;
	}

	// 93 score
	public static int triangle(int[] A) {
		int l = A.length;
		Arrays.sort(A);

		if (l < 3)
			return 0;
		for (int x = 2; x < l; x++) {
			int t = A[x - 2] + A[x - 1];
			if (t > A[x]) {
				return 1;
			}
		}

		return 0;
	}

	// 100 score //O(n)
	public static int maxProductOfThree(int[] A) {
		int res = -1000;
		int l = A.length - 1;
		Arrays.sort(A);
		int f2 = A[0] * A[1] * A[l];
		int f = Math.max(f2, A[0] * A[1] * A[2]);
		int s = A[l] * A[l - 1] * A[l - 2];
		res = Math.max(f, s);
		return res;
	}

	// 77score
	public static int[] maxCounter(int N, int[] A) {
		int[] b = new int[N];
		int l = A.length;
		int last = 0;
		for (int x = 0; x < l; x++) {
			int c = A[x];
			if (c <= N) {
				int t = c - 1;
				b[t] = b[t] + 1;
				last = Math.max(last, b[t]);
			}
			if (c == (N + 1)) {
				for (int y = 0; y < N; y++) {
					b[y] = last;
				}
			}
		}

		return b;
	}

	// 100
	/**
	 * List< Integer > list =
	 * Arrays.stream(A).boxed().collect(Collectors.toList()); when i used the
	 * above code (Stream) there was a problem in performance when converting an
	 * array to list.
	 * 
	 * the old way to convert is much better in performance using for loop
	 * (below code)
	 * 
	 * @param A
	 * @return
	 */
	public static int missingInteger(int[] A) {
		int res = 1;
		Arrays.sort(A);
		int y = 0;
		Set<Integer> set = new HashSet<>();
		for (int x = 0; x < A.length; x++) {
			set.add(A[x]);
		}
		while (true) {
			y += 1;
			if (set.contains(y)) {
				continue;
			} else {
				res = y;
				break;
			}
		}
		return res;
	}

	public static int tapeEquilibrium(int[] A) {
		int l = A.length;
		int res = 100_000;
		int total = IntStream.of(A).sum();
		int sum = 0;
		for (int x = 0; x < l - 1; x++) {
			sum += A[x];
			res = Math.min(res, Math.abs(sum - (total - sum)));
		}
		return res;
	}

	public static int getValue(String key, String code) {
		int l = code.length();
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < l; x++) {
			int in = key.indexOf(code.charAt(x));
			if (in != -1) {
				if (in == key.length() - 1) {
					sb.append(0);
				} else {
					in += 1;
					sb.append(in);
				}
			}
		}
		return Integer.valueOf(sb.toString());
	}

	// 75 score
	public static int countDiv(int A, int B, int K) {
		int res = 0;
		int t = 0;
		t = (B % 2) == 0 ? B : B - 1;
		res = ((t - A) / K);
		return res + 1;

	}

	public static int distinct(int[] A) {
		Arrays.sort(A);
		List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
		Set<Integer> set = new HashSet<>(list);
		return set.size();
	}

	public static String print(int n) {
		StringBuilder res = new StringBuilder("");
		String res2 = "";
		if (n < 0 || (n % 2) == 0) {
			return null;
		} else {
			for (int x = 0; x < n; x++) {
				for (int y = 0; y <= x; y++) {

				}
			}
		}

		return res.toString();

	}

	public static int countPassengers(ArrayList<int[]> stops) {
		int res = 0;
		for (int[] n : stops) {
			res = res + n[0] - n[1];
		}
		return res;
	}

	public static int solution2(int[] A, int X) {
		int N = A.length;
		if (N == 0) {
			return -1;
		}
		int l = 0;
		int r = N - 1;
		while (l < r) {
			int m = (l + r) / 2;
			int c = A[m];
			if (c >= X) {
				r = m - 1;
			}
			l = m;

		}
		if (A[l] == X) {
			return l;
		}
		return -1;
	}

	public static long thirt(long n) {
		long[] A = { 1, 10, 9, 12, 3, 4 };
		int c = 0;
		long d = 0;
		long result = 0;
		long s = 0;
		long m = -1;
		while (true) {
			d = n % 10;
			n = n / 10;
			if (m == 2) {
				break;
			}
			if (n < 10) {
				long z = n % 10;
				c = A.length > c ? c : 0;
				s = s + (d * A[c]) + (z * A[c + 1]);
				result = s;
				c = 0;
				n = s;
				s = 0;
				m++;
			} else {
				c = A.length > c ? c : 0;
				s = s + (d * A[c]);
				c += 1;
			}
		}

		return result;
	}

	// 100
	public static int frogRiver(int X, int[] A) {
		Set<Integer> set = new HashSet<>();
		Integer[] b = null;
		int res = -1;
		int c = 1;
		for (int k = 0; k < A.length; k++) {
			int p = A[k];
			if (p <= X) {
				if (set.add(p)) {
					res = Math.max(res, k);
				}
			}
		}
		b = set.toArray(new Integer[set.size()]);
		Arrays.sort(b);
		for (int y = 0; y < b.length; y++) {
			if (b[y] != c || b.length != X) {
				return -1;
			}
			c += 1;
		}
		return res;
	}

	// frogjump
	public static int frogjump(int X, int Y, int D) {
		int res = Y - X;
		int res2 = res / D;
		int res3 = res2 * D;
		int res4 = res3 + X;
		if (res4 >= Y) {
			return res2;
		} else {
			int res5 = Y - res4;
			if (res5 < D) {
				return res2 + 1;
			}
		}
		return 0;
	}

	public static int permMissingElem(int[] A) {
		int res = 0;
		int l = A.length;
		Arrays.sort(A);
		if (l == 0)
			return 1;
		for (int x = 0; x < l; x++) {
			int f = A[x] + 1;
			if (x == 0 && A[x] != 1) {
				res = 1;
				break;
			}
			if ((x + 1) < l && f == A[x + 1]) {
				continue;
			} else {
				res = f;
				break;
			}
		}
		return res;
	}

	public static int oddOccurrencesInArray(int A[]) {
		Arrays.sort(A);
		if (A.length == 1)
			return A[0];
		for (int x = 1; x < A.length; x++) {
			if ((x - 1) == 0 && A[x - 1] != A[x]) {
				return A[x - 1];
			}
			if (A[x - 1] == A[x] || ((x + 1) < A.length && A[x] == A[x + 1])) {
				continue;
			} else {
				return A[x];
			}
		}
		return 0;
	}

	public static int[] cyclicRotation(int[] A, int K) {
		int[] c = null;
		if (A == null || A.length <= 1) {
			return A;
		}
		for (int x = 0; x < K; x++) {
			for (int y = 0; y < A.length; y++) {
				if (y == 0) {
					c = new int[A.length];
					int f = A[y];
					c[y] = A[A.length - 1];
					y = y + 1;
					c[y] = f;
				} else {
					c[y] = A[y - 1];
				}
			}
			A = c;
			c = null;
		}

		return A;
	}

	public static int binaryGap(int N) {
		String binary = Integer.toBinaryString(N);
		int index = 0;
		int index2 = 0;
		int start = 0;
		int start2 = 0;
		int h = 0;
		if (!binary.contains("0")) {
			return 0;
		}
		while (true) {
			index = binary.indexOf("1", start);
			if (index != -1) {
				start2 = index + 1;
				index2 = binary.indexOf("1", start2);
				if (index2 != -1) {
					h = Math.max(h, binary.substring(index + 1, index2).length());
				}
			}
			if (index == -1) {
				break;
			}
			start += 1;
		}
		return h;
	}
}
