package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PracticeSolutions {
	static Map<Integer, Integer> map = new HashMap<>();

	static {
		map.put(1, 0);
		map.put(2, 0);
		map.put(3, 0);
		map.put(4, 0);
		map.put(5, 0);
	}

	public static void main(String[] args)   {
		
		for(int x:myFilter(Arrays.asList(1,3,5,3),x->(x%3)==0)) {
			System.out.println(x);
		}
	}
	
	 
	
	public static int getMaxRecur(List<Integer> nums) {
		int l = nums.size();
		if (l == 1) {
			return nums.get(0);
		}
		int a = nums.get(0);
		nums.remove(0);
		return Math.max(a, getMaxRecur(nums));
	}
	
	 private static List<Integer> myFilter(List<Integer> nums,Predicate<Integer> myCustomFilter){
		
		return nums.stream()
				.filter(myCustomFilter)
				.collect(Collectors.toList());
	}
	 
	 
	
	static int solve(int[] s, int d, int m) {
		
		int res = 0;
		int c = 0;
		int b= 0;
		int last = 0;
		for(int x = 0; x < s.length; x++) {
			
			if(c==m){
				c = 1;
				b = b - last;
				b+=s[x];
			}else {
					c+=1;
					b+=s[x];
					if(b==d) {
						res+=1;
						c = 1;
						b=s[x];
					}
					last = s[x];
			}
		}
		return res;
	}
	
	static int[] flip(int a[]) {
		int l = a.length;
		int n = l/2;
		for(int x= 0,y=l-1; x < n; x++,y--) {
			int a1 = -a[x];
			int b = -a[y];
			a[x] = b;
			a[y] = a1;
		}
		
		return a;
	}
	
	 static int[] countingSort1(int[] arr) {
	       int max = Integer.MIN_VALUE;
			for(int x=0;x<arr.length;x++) {
				max = Math.max(max, arr[x]);
			}
			int []k = new int[max+1];
			
			for(int x=0;x<arr.length;x++) {
				int a = arr[x];
				int actual = a;
				int val = k[actual] + 1;
				k[actual] = val;
			}
	        return k;
	    }
	
	static int[] countingSort2(int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int x=0;x<arr.length;x++) {
			max = Math.max(max, arr[x]);
		}
		int []k = new int[max+1];
		
		for(int x=0;x<arr.length;x++) {
			int a = arr[x];
			int actual = a;
			int val = k[actual] + 1;
			k[actual] = val;
		}
		
		for(int x = 0 ; x <k.length-1;x++) {
			int v = k[x] + k[x+1];
			k[x+1] = v;
		}
		int res[] = new int[arr.length];
		
		
		for(int x=0;x<res.length;x++) {
			int key = arr[x];
			int index = k[key] -1;
			k[key] = index;
			res[index] = arr[x];
		}
		
		return res;
    }
	
	static String twoStrings(String s1, String s2) {
		Set<Integer> n =  s1.chars().mapToObj(c->c).collect(Collectors.toSet());
		for(int x = 0; x < s2.length();x++) {
			int p = s2.charAt(x);
			if(n.contains(p)) {
				return "YES";
			}
		}
		return "NO";
	}
	
	public static int checkTest(int a) {
		if(a > 1) {
			throw new RuntimeException("test list");
		}
		return a+1;
	}
	
	static int stringConstruction(String s) {
		int count = 0;
		Set<Integer> n =  s.chars().mapToObj(c->c).collect(Collectors.toSet());
		
      return  n.size();
    }
	
	static int anagaram(String s){
		  int l = s.length();
	        if((l%2) != 0) 
	        	return -1;
	        int c = 0;
	        int d = l /2;
	        Map<Character,Integer> m1 = new HashMap<>();
	        Map<Character,Integer> m2 = new HashMap<>();
	        for(int x = 0,y=d; x < d && y < l;x++,y++){
	        	char a1 = s.charAt(x);
	        	char a2 = s.charAt(y);
	        	helpAnagram(m1, a1);
	        	helpAnagram(m2, a2);
	        }
	        
	        for(int x = 0 ; x < d; x++) {
	        	char key = s.charAt(x);
	        	if(m1.containsKey(key) && m2.containsKey(key)){
	        		int val1 = m1.get(key);
	        		int val2 = m2.get(key);
	        		if(val1 == val2) {
	        			continue;
	        		}else{
	        			c+= Math.abs(val1-val2);
	        		}
	        	}
	        }
	        
	        return c;
	    }
	    
	    static void helpAnagram( Map<Character,Integer> map,char key){
			if(map.containsKey(key)){
				map.replace(key, map.get(key), map.get(key)+1);
	    	}else {
	    		map.put(key, 1);
	    	}
		}

	static int beautifulBinaryString(String b) {
		int c = 0;
		int start = 0;
		
		while(true) {
			int index = b.indexOf("010",start);
			if(index != -1 && b.substring(index, index+3).equals("010")) {
				c+=1;
			}
			if(index == -1) {
				break;
			}
			start+= index+3;
		}
		return c;
	}
	

	static int theLoveLetterMystery(String s) {
		int l = s.length();
		int c = 0;
		for (int x = 0, y = l - 1; x < l && y >= 0; x++, y--) {
			int p1 = s.charAt(x);
			int p2 = s.charAt(y);
			c += Math.abs(p1 - p2);
		}
		return c / 2;
	}

	static int fairRations(int[] B) {
		int count = 0;
		int t = Arrays.stream(B).reduce(0, (z, y) -> z + y) % 2;
		if (t != 0) {
			return -1;
		}
		for (int i = 0; i < B.length; i++) {
			int a = B[i];
			if (a % 2 != 0) {
				B[i] = a + 1;
				int b = B[i + 1];
				B[i + 1] = b + 1;
				count += 2;
			}

		}

		return count;
	}

	static int beautifulTriplets(int d, int[] arr) {
		Arrays.sort(arr);
		int count = 0;
		int l = arr.length;

		for (int x = l - 1; x >= 0; x--) {
			int last = arr[x];
			int second = last - d;
			int r1 = binarySearch(arr, second);
			if (r1 == -1) {
				continue;
			}
			int first = second - d;
			int r2 = binarySearch(arr, first);
			if (r2 == -1) {
				continue;
			}
			count += 1;
		}

		return count;
	}

	static int binarySearch(int[] a, int k) {
		int l = 0;

		int r = a.length - 1;

		int m = 0;

		while (l <= r) {

			m = l + (r - l) / 2;

			if (a[m] == k) {
				return m;
			}
			if (a[m] > k) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return -1;
	}

	static long repeatedString2(String s, long n) {

		long count = 0;

		if (s.contains("a")) {
			long initA = s.chars().filter(a -> a == 'a').count();
			long d = n / s.length();
			long rem = n % s.length();
			count = initA * d;

			if (rem != 0) {
				int r2 = (int) rem;
				count += s.substring(0, r2).chars().filter(a -> a == 'a').count();
			}

		}

		return count;
	}

	static int binarySearchRepeatedString2(char[] a, char k) {
		int l = 0;

		int r = a.length - 1;

		int m = 0;

		while (l <= r) {

			m = l + (r - l) / 2;

			if (a[m] == k) {
				return m;
			}
			if (a[m] > k) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return -1;
	}

	static String solve2(int[] a) {
		int l = a.length;

		if (l == 1)
			return "YES";
		int x = 0;
		int y = l - 1;
		int sl = a[x];
		int sr = a[y];
		int t = l - 2;
		while (t >= 0) {

			x++;
			if (x < t) {
				sl += a[x];
				continue;
			}
			if (y > t) {
				y--;
				if (y > t) {
					sr += a[y];
					continue;
				}

			}

			if (sl == sr) {
				return "YES";
			}

			t -= 1;
			x = 0;
			y = l - 1;
			sl = a[x];
			sr = a[y];

		}

		return "NO";
	}

	static int examRush(int[] tm, int t) {
		int c = 0;
		int p = 0;

		Arrays.sort(tm);
		for (int x = 0; x < tm.length; x++) {
			int a = tm[x];
			c += a;
			if (t >= c) {
				p = x;
			}

		}

		return p;

	}

	static int[] missingNumbers(int[] arr, int[] brr) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int x = 0; x < arr.length; x++) {
			int key = arr[x];
			if (map.containsKey(key)) {
				int oldValue = map.get(key);
				int newValue = oldValue + 1;
				map.replace(key, oldValue, newValue);
			} else {
				map.put(key, 1);
			}

		}

		Map<Integer, Integer> map2 = new HashMap<>();
		for (int x = 0; x < brr.length; x++) {
			int key = brr[x];
			if (map2.containsKey(key)) {
				int oldValue = map2.get(key);
				int newValue = oldValue + 1;
				map2.replace(key, oldValue, newValue);
			} else {
				map2.put(key, 1);
			}

		}
		List<Integer> list = new ArrayList<>();

		for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
			int k = entry.getKey();
			int v = entry.getValue();

			if (map.get(k) != v) {
				list.add(k);
			}
		}

		return list.stream().sorted().mapToInt(i -> i).toArray();

	}

	static int[] closestNumbers(int[] arr) {
		Arrays.sort(arr);
		List<Integer> list = new LinkedList<>();

		int min = Integer.MAX_VALUE;

		for (int x = 0; x < arr.length - 1; x++) {
			int p = arr[x];
			int p2 = arr[x + 1];

			int d = Math.abs(p - p2);
			min = Math.min(min, d);
		}

		for (int x = 0; x < arr.length - 1; x++) {
			int p = arr[x];
			int p2 = arr[x + 1];

			int d = Math.abs(p - p2);

			if (min == d) {
				list.add(p);
				list.add(p2);
			}
		}

		return list.stream().sorted().mapToInt(i -> i).toArray();

	}

	public static void insertionSort(int[] A) {
		for (int i = 1; i < A.length; i++) {
			int value = A[i];
			int j = i;
			while (j >= 1 && A[j - 1] > value) {
				A[j] = A[j - 1];
				j--;
			}
			A[j] = value;
		}

		printArray(A);
	}

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
	}

	static int[] getTheGroups(int n, String[] queryType, int[] students1, int[] students2) {
		Set<Integer> set = new HashSet<>();
		int c = 0;
		for (String str : queryType) {
			if ("Friend".equals(str)) {
				for (int a : students1) {
					if (set.contains(a)) {
						int po = a + 1;
						if (po < n) {
							set.add(po);
						}
					} else {
						set.add(a);
					}
				}

			}
			if ("Total".equals(str)) {

				for (int b : students2) {
					if (set.contains(b)) {
						continue;
					} else {
						c += 1;
					}
				}
				c += set.size();
				break;
			}
		}

		return new int[] { c };
	}

	static int differentTeams(String skills) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('p', 0);
		map.put('c', 0);
		map.put('m', 0);
		map.put('b', 0);
		map.put('z', 0);
		int count = 0;
		skills.chars().forEach(skill -> {
			char key = (char) skill;
			if (map.containsKey(key)) {
				int oldValue = map.get(key);
				int newValue = oldValue + 1;
				map.replace(key, oldValue, newValue);
			}
		});
		int[] b = new int[5];
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			char key = entry.getKey();
			int value = entry.getValue();
			if (value == 0) {
				return 0;
			} else {
				b[count] = value;
				count += 1;
			}
		}
		Arrays.sort(b);
		int p = b[0];
		for (int x = 1; x < b.length; x++) {
			int p2 = b[x];
			if (p == p2 || (p < p2)) {
				continue;
			} else {
				return 0;
			}
		}
		return p;
	}

	static int consecutive(long num) {
		long l = 0;
		long r = 0;
		long s = 0;
		long c = 0;
		while (r <= (num + 1) / 2) {
			r++;
			s += r;
			while (s > num) {
				l++;
				s -= l;
			}
			if (s == num)
				c++;
		}
		return (int) c;
	}

	static int countConsecutive(int N) {
		// constraint on values of L gives us the
		// time Complexity as O(N^0.5)
		int count = 0;
		for (int L = 1; L * (L + 1) < 2 * N; L++) {
			float a = (float) ((1.0 * N - (L * (L + 1)) / 2) / (L + 1));
			if (a - (int) a == 0.0)
				count++;
		}
		return count;
	}

	static int makingAnagrams(String s1, String s2) {
		List<Character> a = s1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		List<Character> b = s2.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		Collections.sort(a);
		Collections.sort(b);
		int l1 = a.size();
		int l2 = b.size();
		int sum = l1 + l2;
		if (l1 == l2 && s1.equalsIgnoreCase(s2)) {
			return 0;
		}

		return helpMk(a, b);

	}

	public static int helpMk(List<Character> a, List<Character> b) {
		int sum = 0;
		int c2 = 0;
		for (int x = 0; x < a.size(); x++) {
			char p = a.get(x);
			for (int y = 0; y < b.size(); y++) {
				char p2 = b.get(y);
				if (p == p2) {
					a.remove(x);
					b.remove(y);
					x -= 1;
					break;
				}
			}
		}
		sum = a.size() + b.size();
		return sum;
	}

	static String pangrams(String s) {
		s = s.toLowerCase();
		boolean[] res = new boolean[26];
		for (int x = 0; x < s.length(); x++) {
			char a = s.charAt(x);

			if (a >= 97 && a <= 122) {
				int t = 25 - (122 - a);
				res[t] = true;

			}

		}

		for (boolean test : res) {

			if (test == false) {
				return "not pangram";
			}
		}

		return "pangram";

	}

	static String hackerrankInString(String s) {
		String base = "hackerrank";
		s = s.toLowerCase();
		StringBuilder sb = new StringBuilder();
		int c = 0;
		for (int x = 0; x < base.length(); x++) {
			char a = base.charAt(x);
			for (int y = 0; y < s.length(); y++) {
				char b = s.charAt(y);
				if (a == b) {
					if (sb.length() == 0) {
						sb.append(a);
						c = y;
						break;
					}
					if (c < y) {
						sb.append(a);
						c = y;
						break;

					}

				}

			}
		}

		return sb.toString().equals(base) ? "YES" : "NO";
	}

	static void adder(int N) {

		System.out.println(adderHelper(N));
	}

	static int adderHelper(int N) {
		if (N == 0) {
			return 0;
		}
		return N + adderHelper(N - 1);
	}

	static String comM(String message) {
		StringBuilder sb = new StringBuilder();
		int c = 1;
		for (int x = 0; x < message.length(); x++) {
			char a = message.charAt(x);
			char b = (x + 1) < message.length() ? message.charAt(x + 1) : 0;

			if (a == b) {
				c += 1;
			} else {
				sb.append(a);
				if (c != 1) {
					sb.append(c);
					c = 1;
				}
			}

		}

		return sb.toString();
	}

	static int minimumDistances(int[] a) {
		Map<Integer, Integer> map = new HashMap<>();
		int min = Integer.MAX_VALUE;
		boolean noValueExist = true;

		for (int i = 0; i < a.length; i++) {
			int b = a[i];
			if (map.containsKey(b)) {
				int val = map.get(b);
				if (val != i) {
					int dif = Math.abs(val - i);
					min = Math.min(min, dif);
					noValueExist = false;
				} else {
					continue;
				}
			} else {
				map.put(b, i);
			}
		}

		return noValueExist == true ? -1 : min;
	}

	static int designerPdfViewer(int[] h, String word) {
		int max = 0;
		int r = 0;
		for (int x = 0; x < word.length(); x++) {
			char charA = word.charAt(x);
			int intNumber = charA;

			if (96 < intNumber && 122 >= intNumber) {
				int letterN = intNumber - 96;
				int c = h[letterN - 1];
				max = Math.max(max, c);
			}
		}

		r = max * word.length();

		return r;
	}

	static int jumpingOnClouds(int[] c) {
		int l = c.length;
		int t = 0;
		for (int x = 0; x <= l - 2; x++) {
			int f = c[x + 1];
			int f2 = (x + 2) > l - 1 ? 0 : c[x + 2];
			if (f != 1) {
				if (f2 != 1) {
					t += 1;
					x += 1;
				} else {
					t += 1;
				}
				continue;
			}
			if (f2 != 1) {
				t += 1;
				x += 1;
				continue;
			}
		}

		return t;
	}

	static long repeatedString(String s, long n) {
		if (s.length() > 1) {
			int c = 0;
			int c1 = 0;
			for (int i = 0; i < s.length(); i++) {

				if (c < n) {
					char a = s.charAt(i);
					if (a == 'a') {
						c1 += 1;
					}
					c += 1;
					if ((i + 1) == s.length()) {
						i = -1;
					}
				} else {
					return c1;
				}
			}

		}

		return n;
	}

	static int squares(int a, int b) {
		int z = 0;
		for (int x = a; x <= b; x++) {
			double c = Math.sqrt(x);
			int d = (int) c;
			boolean e = c > d;

			if (e == false) {
				z += 1;
				a += 2;
			}

		}
		return z;
	}

	static int viralAdvertising(int n) {
		int a = 5 / 2;
		int z = a;

		for (int x = 2; x <= n; x++) {
			a = (a * 3) / 2;
			System.out.println(x + " = " + a);
			z += a;
		}
		return z;
	}

	public static boolean strCopies(String str, String sub, int n) {
		return n == helper(str, sub) ? true : false;
	}

	public static int helper(String str, String sub) {
		int l = sub.length();
		if (str != null && str.length() >= l) {
			if (str.substring(0, l).equals(sub)) {
				return 1 + helper(str.substring(1), sub);
			} else {
				return 0 + helper(str.substring(1), sub);
			}
		} else {
			return 0;
		}
	}

	static int beautifulDays(int i, int j, int k) {
		int c = 0;
		for (int x = i; x <= j; x++) {
			int a = x;
			int r = Integer.valueOf(new StringBuilder(String.valueOf(a)).reverse().toString());
			if ((Math.abs(a - r) % k) == 0) {
				c += 1;
			}
		}
		return c;
	}

	static int pairs(int k, int[] arr) {
		int c = 0;
		for (int x = 0; x < arr.length; x++) {
			int a = arr[x];
			for (int y = x + 1; y < arr.length; y++) {
				int b = arr[y];
				int d = Math.abs(a - b);
				if (d == k) {
					c += 1;
				}
			}
		}
		return c;

	}

	public static char longConsecutiveChar(String str) {
		/*
		 * Map<Character,Integer> m = new LinkedHashMap<>(); for(int x = 0 ; x
		 * <str.length();x++) { char a = str.charAt(x); if(m.containsKey(a)){
		 * m.replace(a, m.get(a), m.get(a)+1); }else{ m.put(a, 1); } } int max = 0; char
		 * c = 0; for(Map.Entry<Character, Integer> e : m.entrySet() ) { if(max <
		 * e.getValue()) { max = e.getValue(); c = e.getKey(); } }
		 */
		Map<Character, Integer> m = new LinkedHashMap<>();
		for (int x = 0; x < str.length() - 1; x++) {
			char a = str.charAt(x);
			char b = str.charAt(x + 1);
			if (a == b) {
				if (m.containsKey(a)) {
					m.replace(a, m.get(a), m.get(a) + 1);
				} else {
					m.put(a, 1);
				}
			} else if ((x - 1) >= 0 && a == str.charAt(x - 1)) {
				m.replace(a, m.get(a), m.get(a) + 1);
			}
		}
		int max = 0;
		char c = 0;
		for (Map.Entry<Character, Integer> e : m.entrySet()) {
			if (max < e.getValue()) {
				max = e.getValue();
				c = e.getKey();
			}
		}
		return c;
	}

	public static char firstOccur(String str) {
		Map<Character, Integer> m = new LinkedHashMap<>();
		for (int x = 0; x < str.length(); x++) {
			char a = str.charAt(x);
			if (m.containsKey(a)) {
				m.replace(a, m.get(a), m.get(a) + 1);
			} else {
				m.put(a, 1);
			}
		}
		for (Map.Entry<Character, Integer> e : m.entrySet()) {
			if (e.getValue() > 1) {
				return e.getKey();
			}
		}
		return 0;
	}

	/*
	 * static int[] missingNumbers(int[] arr, int[] brr) { int res[] = null; int s =
	 * brr.length - arr.length; res = new int[s]; int count = 0; Map<Integer,
	 * Integer> a = new HashMap<>(); Map<Integer, Integer> b = new HashMap<>(); for
	 * (int x = 0; x < brr.length; x++) { int xb = brr[x]; if (arr.length - 1 >= x)
	 * { int xa = arr[x]; pro(xa, a); }
	 * 
	 * pro(xb, b); } for (Map.Entry<Integer, Integer> e : a.entrySet()) { int y =
	 * e.getValue(); int x = e.getKey();
	 * 
	 * if (b.containsKey(x) && b.get(x) > y) { res[count] = x; count++; } }
	 * Arrays.sort(res); return res; }
	 */

	static void pro(int xb, Map<Integer, Integer> a) {
		if (a.containsKey(xb)) {
			int old = a.get(xb);
			int newV = 1 + old;
			a.replace(xb, old, newV);
		} else {
			a.put(xb, 1);
		}
	}

	static int[] icecreamParlor(int m, int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> res = new ArrayList<>();
		for (int x = 0; x < arr.length; x++) {
			map.put(arr[x], x + 1);
		}
		for (int x = 0; x < arr.length; x++) {
			int j = m - arr[x];
			if (map.containsKey(j) && (x + 1) != map.get(j)) {
				res.add(x + 1);
				res.add(map.get(j));
				break;
			}
		}
		return res.stream().sorted().mapToInt(Integer::valueOf).toArray();
	}

	public static int fact(int n) {
		if (n == 0)
			return 1;
		return n * fact(n - 1);
	}

	public static int findMagicIndex(int[] a) {
		return bSearch(a, 0, a.length - 1);
	}

	private static int bSearch(int[] a, int left, int right) {
		int mid = left + (right - left) / 2;
		int val = a[mid];
		if (val == mid) {
			return mid;
		}
		if (val > mid) {
			return bSearch(a, left, mid - 1);
		}
		return bSearch(a, mid + 1, right);
	}

	public static int strCount(String str, String sub) {
		if (str.length() < sub.length()) {
			return 0;
		}
		if (str.substring(0, sub.length()).equals(sub)) {
			return 1 + strCount(str.substring(sub.length()), sub);
		}
		return 0 + strCount(str.substring(1), sub);
	}

	public static boolean nestParen(String str) {
		int l = str.length();

		if (l == 0) {
			return true;
		}
		char a = str.charAt(0);
		char z = str.charAt(l - 1);
		if (a == '(' && z == ')') {
			return nestParen(str.substring(1, l - 1));
		}

		return false;
	}

	public static String parenBit(String str) {
		int indexStart = str.indexOf("(");
		int lastStart = str.indexOf(")");
		return str.substring(indexStart, lastStart + 1);
	}

	public static int countHi2(String str) {
		int l = str.length();
		if (l < 2) {
			return 0;
		}
		char i = str.charAt(l - 1);
		char h = str.charAt(l - 2);
		int t = l - 3;
		boolean isX = !(t != -1 && str.charAt(t) == 'x');
		if (h == 'h' && i == 'i' && isX) {
			return 1 + countHi2(str.substring(0, l - 1));
		}

		return 0 + countHi2(str.substring(0, l - 1));
	}

	public static String stringClean(String str) {
		if (str.length() <= 1)
			return str;
		char a1 = str.charAt(0);
		char a2 = str.charAt(1);
		if (a1 == a2) {
			return stringClean(str.substring(1));
		}
		return a1 + stringClean(str.substring(1));
	}

	public static int count11(String str) {
		if (str.length() <= 1)
			return 0;
		String s = str.substring(0, 2);
		if (s.equals("11")) {
			return count11(str.substring(2)) + 1;
		}
		return count11(str.substring(1)) + 0;
	}

	public static int countAbc(String str) {
		if (str.length() <= 2)
			return 0;
		String s = str.substring(0, 3);
		if (s.equals("abc") || s.equals("aba")) {
			return 1 + countAbc(str.substring(1));
		}
		return 0 + countAbc(str.substring(1));
	}

	public static String endX(String str) {
		int l = str.length();
		if (l <= 1)
			return str;
		char a1 = str.charAt(0);
		if (a1 == 'x') {
			return endX(str.substring(1)) + a1;
		}

		return a1 + endX(str.substring(1));
	}

	public static String pairStar(String str) {
		int l = str.length();
		if (l <= 1)
			return str;
		char a1 = str.charAt(0);
		char a2 = str.charAt(1);
		if (a1 == a2) {
			return a1 + "*" + pairStar(str.substring(1));
		}
		return a1 + pairStar(str.substring(1));
	}

	public static String allStar(String str) {
		int l = str.length();
		if (l == 1)
			return str;
		return str.charAt(0) + "*" + allStar(str.substring(1));
	}

	public static boolean array220(int[] nums, int index) {
		if (nums.length == index) {
			return false;
		}
		int c = nums[index];
		if ((c % 10) == 0 && index != 0) {
			return true;
		}

		return array220(nums, index + 1);
	}

	public static int array11(int[] nums, int index) {
		if (nums.length == index) {
			return 0;
		}
		int c = nums[index];
		if (c == 11) {
			return 1 + array11(nums, index + 1);
		}
		return array11(nums, index + 1);
	}

	public static boolean array6(int[] nums, int index) {
		if (nums.length == index) {
			return false;
		}
		int c = nums[index];
		if (c == 6) {
			return true;
		}

		return array6(nums, index + 1);
	}

	public static String noX(String str) {
		int l = str.length();
		if (l == 0) {
			return str;
		}

		if (str.charAt(0) == 'x') {
			return noX(str.substring(1));
		}
		return str.charAt(0) + noX(str.substring(1));
	}

	public static String changePi(String str) {
		int l = str.length();
		if (l < 2) {
			return str;
		}
		char p = str.charAt(0);
		char i = str.charAt(1);
		if (p == 'p' && i == 'i') {
			return "3.14" + changePi(str.substring(2));
		}
		return String.valueOf(p) + changePi(str.substring(1));
	}

	public static String changeXY(String str) {
		int l = str.length();
		if (l == 0) {
			return str;
		}
		char x = str.charAt(0);
		if (x == 'x') {
			return String.valueOf('y') + changeXY(str.substring(1));
		}
		return String.valueOf(x) + changeXY(str.substring(1));
	}

	public static int countHi(String str) {
		if (str.length() < 2) {
			return 0;
		}
		int l = str.length();
		char h = str.charAt(l - 2);
		char i = str.charAt(l - 1);
		if (h == 'h' && i == 'i') {
			return 1 + countHi(str.substring(0, l - 1));
		}
		return 0 + countHi(str.substring(0, l - 1));
	}

	public static int countX(String str) {
		if (str.isEmpty()) {
			return 0;
		}
		int l = str.length() - 1;
		char x = str.charAt(l);
		if (x == 'x') {
			return 1 + countX(str.substring(0, l));
		}
		return 0 + countX(str.substring(0, l));

	}

	static int[] breakingRecords(int[] score) {
		int res[] = new int[2];
		Map<Character, Integer> map = new HashMap<>();
		map.put('l', score[0]);
		map.put('h', score[0]);

		Arrays.stream(score).forEach(x -> {

			if (map.get('h') < x) {
				res[0] = res[0] + 1;
				int old = map.get('h');
				map.replace('h', old, x);
			} else if (map.get('l') > x) {
				res[1] = res[1] + 1;
				int old = map.get('l');
				map.replace('l', old, x);
			}
		});
		return res;
	}

	static int equalizeArray(int[] arr) {
		int res = 0;

		Map<Integer, Integer> mapEqual = new HashMap<>();
		for (int x : arr) {
			if (mapEqual.containsKey(x)) {
				int old = mapEqual.get(x);
				int curr = mapEqual.get(x) + 1;
				mapEqual.replace(x, old, curr);
			} else {
				mapEqual.put(x, 1);
			}
		}
		int key = Collections.max(mapEqual.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue())
				.getKey();
		for (int y : arr) {
			if (key != y) {
				res += 1;
			}
		}
		return res;
	}

	static int getMoneySpent(int[] keyboards, int[] drives, int s) {
		int k = keyboards.length;
		int d = drives.length;
		int res = 0;
		Arrays.sort(keyboards);
		Arrays.sort(drives);
		if (k > d) {
			res = getMoney2(keyboards, drives, s);
		} else {
			res = getMoney2(drives, keyboards, s);
		}
		return res;
	}

	static int getMoney2(int[] high, int[] low, int s) {
		int max = 0;
		for (int x = 0; x < high.length; x++) {
			for (int y = 0; y < low.length; y++) {
				int total = high[x] + low[y];
				if (total > s) {
					continue;
				}
				max = Math.max(total, max);

			}
		}

		if (max > s || max <= 0)
			max = -1;
		return max;
	}

	static String[] catAndMouse(int x, int y, int z) {
		String[] res = new String[1];
		int y1 = 0;
		int x1 = 0;

		x1 = Math.abs(z - x);
		y1 = Math.abs(z - y);

		if (x1 == y1) {
			res[0] = "Mouse C";
		} else if (x1 > y1) {
			res[0] = "Cat B";
		} else {
			res[0] = "Cat A";
		}
		return res;
	}

	static int marsExploration(String s) {
		int res = 0;
		for (int x = 0; x < s.length() - 2; x += 3) {
			char c1 = s.charAt(x);
			char c2 = s.charAt(x + 1);
			char c3 = s.charAt(x + 2);
			if (c1 != 'S') {
				res += 1;
			}
			if (c2 != 'O') {
				res += 1;
			}
			if (c3 != 'S') {
				res += 1;
			}
		}

		return res;
	}

	static int countPairs(int a[], int k) {
		int res = 0;
		Arrays.sort(a);

		Set<Integer> set = new HashSet<>();
		for (int x : a) {
			set.add(x);
		}

		for (int x = 0; x < a.length; x++) {
			int f = a[x] - k;
			if (set.contains(f)) {
				res += 1;
			}
		}
		return res;
	}

	static int sockMerchant(int n, int[] ar) {

		Arrays.sort(ar);
		LinkedList<Integer> l = new LinkedList<>();
		for (int x : ar) {
			l.add(x);
		}
		for (int x = 0; x < l.size() - 1; x += 2) {
			if (l.get(x) != l.get(x + 1)) {
				l.remove(x);
				x -= 2;
			}
		}

		return l.size() / 2;
	}

	static int hurdleRace(int k, int[] height) {
		int res = 0;
		int max = 0;
		max = Arrays.stream(height).max().getAsInt();
		if (max < k) {
			return 0;
		}
		res = max - k;
		return res;
	}

	static int diagonalDifference(int[][] a) {
		int res = 0;
		int sa = 0;
		int sb = 0;
		int x = 0;
		int z = a.length - 1;
		while (x < a.length && z >= 0) {
			sa += a[x][x];
			sb += a[x][z];
			x += 1;
			z -= 1;
		}
		res = sa - sb;
		return Math.abs(res);
	}

	static int migratoryBirds(int n, int[] ar) {
		int maxValue = 0;
		int keyMax = 0;
		for (int key : ar) {
			int v = map.get(key);
			map.replace(key, v, v + 1);
			int newValue = map.get(key);
			if (newValue > maxValue) {
				maxValue = newValue;
				keyMax = key;
			}
		}
		ar[0] = keyMax;
		ar[1] = maxValue;
		map.forEach((x, y) -> {
			if (ar[1] == y && x < ar[0]) {
				ar[0] = x;
			}
		});

		return ar[0];

	}

	static int[] solve(int[] a) {
		for (int x = 0; x < a.length; x++) {
			int o = a[x];
			if (o < 38) {
				continue;
			} else {
				int b = ((o / 5) * 5);
				int i = ((o % 5) != 0) ? b + 5 : o + 5;
				int d = i - o;
				if (d < 3) {
					a[x] = i;
				}
			}
		}
		return a;
	}

	static int alternatingCharacters(String s) {
		int count = 0;
		for (int x = 0; x < s.length() - 1; x++) {
			if (s.charAt(x) == s.charAt(x + 1)) {
				count += 1;
			}
		}
		return count;
	}

	static int gemstones(String[] arr) {
		int count = 0;
		for (char x = 'a'; x <= 'z'; x++) {
			boolean t = true;
			for (int y = 0; y < arr.length; y++) {
				if (arr[y].contains(Character.toString(x)) == false) {
					t = false;
					break;
				}
			}
			if (t) {
				count += 1;
			}
		}
		return count;
	}

	static String funnyString(String s) {
		StringBuilder r = new StringBuilder(s).reverse();
		int l = s.length();
		for (int x = 0; x < l - 1; x++) {
			int v1 = s.charAt(x + 1) - s.charAt(x);
			int v2 = r.charAt(x + 1) - r.charAt(x);
			if (Math.abs(v1) != Math.abs(v2)) {
				return "Not Funny";
			}
		}

		return "Funny";
	}

	public static void low2(Stack<Integer> s1, Stack<Integer> s2, Stack<Integer> s3) {
		int a_s1 = s1.stream().mapToInt(Integer::intValue).sum();
		int a_s2 = s2.stream().mapToInt(Integer::intValue).sum();
		int a_s3 = s3.stream().mapToInt(Integer::intValue).sum();
		if (a_s1 > a_s2) {
			if (a_s2 > a_s3) {
				low(s3, s1, s2);
			} else {
				low(s2, s1, s3);
			}
		} else if (a_s1 < a_s2) {
			if (a_s1 > a_s3) {
				low(s3, s1, s2);
			} else {
				low(s1, s3, s2);
			}
		}
	}

	public static void low(Stack<Integer> low, Stack<Integer> a1, Stack<Integer> a2) {
		int lw = low.stream().mapToInt(Integer::intValue).sum();
		int s1_i = a1.stream().mapToInt(Integer::intValue).sum();
		while (true && s1_i > lw) {
			a1.pop();
			int s1 = a1.stream().mapToInt(Integer::intValue).sum();
			if (lw > s1) {
				break;
			}
		}
		int s2_i = a2.stream().mapToInt(Integer::intValue).sum();
		while (true && s2_i > lw) {
			a2.pop();
			int s2 = a2.stream().mapToInt(Integer::intValue).sum();
			if (lw > s2) {
				break;
			}
		}
		int s1 = a1.stream().mapToInt(Integer::intValue).sum();
		int s2 = a2.stream().mapToInt(Integer::intValue).sum();
		while (!low.isEmpty()) {
			low.pop();
			lw = low.stream().mapToInt(Integer::intValue).sum();
			if (lw == s1 && lw == s2) {
				break;
			} else if (lw < s1) {
			}
		}
		System.out.println(lw);
	}

	public static int dominator(int A[]) {
		int result = 0;
		Map<Integer, Integer> con = new HashMap<>();
		int hKey = 0;
		int eKey = 0;
		if (A == null)
			return -1;
		for (int i = 0; i < A.length; i++) {
			int b = A[i];
			if (con.get(b) != null) {
				int oldValue = con.get(b);
				int count = oldValue + 1;
				con.replace(b, oldValue, count);
				if (count > con.get(hKey)) {
					hKey = b;
					eKey = i;
				}
			} else {
				con.put(b, 1);
				hKey = b;
				eKey = i;
			}
		}
		int half = A.length / 2;
		result = half < con.get(hKey) ? eKey : -1;

		return result;
	}

	public static boolean isBalanced(String expression) {
		Stack<Character> stack = new Stack<Character>();
		/*
		 * int l = expression.length(); if (l == 0) return true; for (int x = 0; x <
		 * expression.length(); x++) { char c = expression.charAt(x); if (con.get(c) !=
		 * null) { stack.push(c); } else { char close = con.get(stack.peek()); if (close
		 * == c) { stack.pop(); continue; } else { return false; } }
		 * 
		 * }
		 */
		return stack.isEmpty();
	}

	static int[] leftRotation(int[] a, int d) {
		LinkedList<Integer> list = new LinkedList<>();
		if (a != null) {
			for (int x : a) {
				list.add(x);
			}
			if (list != null) {
				for (int x = 0; x < d; x++) {
					int t = list.get(0);
					list.remove(0);
					list.add(t);
				}
			}
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	public static int[] arrayLeftRotation(int[] a, int n, int k) {
		int b[] = new int[a.length];
		for (int x = 0; x < k; x++) {
			int t = a[0];
			b[a.length - 1] = t;
			for (int y = 1; y < a.length; y++) {
				b[y - 1] = a[y];
			}
			System.arraycopy(b, 0, a, 0, a.length);
		}
		return a;
	}

	public static int[][] BitMarch(int n) {
		int c = 8;
		int r = (c - n) + 1;
		int t = r;
		int[][] a = new int[r][c];
		for (int x = 0; x < r; x++) {
			c = c - 1;
			t = t - 1;
			for (int y = c; y >= t; y--) {
				a[x][y] = 1;
			}
		}
		return a;
	}

	public static String compressionString(String str1) {
		int l = str1.length() - 1;
		int c = 1;
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < l; x++) {
			char a1 = str1.charAt(x);
			char a2 = str1.charAt(x + 1);
			if (a1 == a2) {
				c += 1;
				if ((x + 1) == (l)) {
					sb.append(a1).append(c);
				}
				continue;
			}
			if (sb.toString().length() > str1.length()) {
				return str1;
			} else {
				sb.append(a1).append(c);
				c = 1;
				continue;
			}
		}
		if (sb.toString().length() > str1.length() || sb.toString().length() == str1.length()) {
			return str1;
		}

		return sb.toString();
	}

	public static String subtractSum(int n) {
		// return fruit name like "apple"
		int s = 0;
		if (n >= 10 && n <= 10000) {
			while (true) {
				int m = n % 10;
				n = n - m;
				n = n / 10;
				if (n < 10) {
					s += n + m;
					break;
				}

				s += m;

			}
			System.out.println(s);
		}
		return null;
	}

	public static boolean isUnique(String str) {
		char[] cstr = str.toCharArray();
		boolean[] c = new boolean[128];
		for (int x = 0; x < cstr.length; x++) {
			int temp = cstr[x];
			if (c[temp] == false) {
				c[temp] = true;
				continue;
			} else {
				return false;
			}
		}

		return true;
	}

	public static int sumT(int[] a) {
		int res = 0;
		Arrays.sort(a);
		Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
		for (int x = 0; x < a.length - 1; x++) {
			if (a[x] == a[x + 1]) {
				if (set.contains(a[x])) {
					set.remove(a[x]);
				}
			}
		}
		for (int c : set) {
			res += c;
		}
		return res;
	}

	public static int fish3(int[] A, int[] B) {
		Stack<Integer> s = new Stack<Integer>();

		for (int i = 0; i < A.length; i++) {
			int size = A[i];
			int dir = B[i];
			if (s.empty()) {
				s.push(i);
			} else {
				while (!s.empty() && dir - B[s.peek()] == -1 && A[s.peek()] < size) {
					s.pop();
				}
				if (!s.empty()) {
					if (dir - B[s.peek()] != -1)
						s.push(i);
				} else {
					s.push(i);
				}
			}
		}
		return s.size();
	}

	public static int fish(int[] A, int[] B) {
		int l = A.length;
		int c = 1;
		List<Integer> fish = new LinkedList<Integer>();
		Stack<Integer> direc = new Stack<Integer>();
		for (int x = 0; x < l; x++) {
			fish.add(A[x]);
			direc.push(B[x]);
		}
		while (true) {
			int p = (c < direc.size()) ? direc.get(c) : direc.get(c - 1);
			int q = ((c + 1) < direc.size()) ? direc.get(c + 1) : direc.get(c);
			if (p != q) {
				int p1 = fish.get(c);
				int q1 = fish.get(c + 1);
				if (p1 > q1) {
					fish.remove(c + 1);
					direc.pop();
					c = c - 1;
				} else {
					if (p == 1) {
						fish.remove(c);
						direc.remove(c);
						c = c - 1;
					} else {
						fish.remove(c);
						direc.remove(c);
						c = c - 1;
					}

				}
			} else {
				break;
			}

			c += 1;
		}

		return fish.size();
	}

	public static int family(int N) {
		String s = String.valueOf(N);
		int res = 0;
		char[] b = s.toCharArray();
		Arrays.sort(b);
		StringBuilder sb = new StringBuilder(Arrays.toString(b).replaceAll("\\[|\\]|,|\\s", "")).reverse();
		res = Integer.valueOf(sb.toString());
		if (res > 100_000_000) {
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

	// 100
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
		if (l == 0)
			return 1;
		if ((l % 2) == 1)
			for (int x = 0; x < l; x++) {
				char k = S.charAt(x);
				if (ref.containsKey(k)) {
					ref2.add(k);
				} else if (x != 0) {
					int index = ref2.size() - 1;
					char last = 0;
					char comV = 0;
					if (index >= 0) {
						last = ref2.get(index);
						comV = ref.get(last);
						if (comV == k) {
							ref2.remove(index);
						} else {
							return 0;
						}
					} else {
						return 0;
					}
				} else {
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
	 * List< Integer > list = Arrays.stream(A).boxed().collect(Collectors.toList());
	 * when i used the above code (Stream) there was a problem in performance when
	 * converting an array to list.
	 * 
	 * the old way to convert is much better in performance using for loop (below
	 * code)
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

	public static int[] cyclicRotation(int[] a, int d) {
		int[] c = null;
		if (a == null || a.length <= 1) {
			return a;
		}
		for (int x = 0; x < d; x++) {
			for (int y = 0; y < a.length; y++) {
				if (y == 0) {
					c = new int[a.length];
					int f = a[y];
					c[y] = a[a.length - 1];
					y = y + 1;
					c[y] = f;
				} else {
					c[y] = a[y - 1];
				}
			}
			a = c;
			c = null;
		}

		return a;
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
