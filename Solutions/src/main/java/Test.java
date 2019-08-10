package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {
		System.out.println(findPairs(new int[] {1,3,1,5,4},0));
		System.out.println(findPairs(new int[] {3,1,1,4,5},2));
		System.out.println(findPairs(new int[] {1,2,3,4,5},-1));
		System.out.println(findPairs(new int[] {1,1,1,1,1},0));
	}

	public static int findPairs(int[] nums, int k) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int total =0;
		Map<Integer,Integer> map = new HashMap<>();
		Arrays.sort(nums);
		for(int c = 0;c<nums.length;c++) {
				int initialValue = nums[c];
				int missingVal = initialValue + k;
				int result = Arrays.binarySearch(nums, missingVal);
				if(result > -1 && c != result) {
					int actualValue = nums[result];
					if(Math.abs((initialValue - actualValue) )!= k) {
						continue;
					}
					if(map.containsKey(initialValue) && map.get(initialValue) == actualValue) {
						continue;
					}
					map.put(initialValue, actualValue);
					total+=1;
				}
			
			
		}
		return total;
	}

	public static int[] sortArrayByParityII(int[] A) {
		Stack<Integer> even = new Stack<Integer>();
		Stack<Integer> odd = new Stack<Integer>();
		for (int x = 0; x < A.length; x++) {
			int v = A[x];
			if ((v % 2) == 0) {
				even.add(v);
				continue;
			}
			odd.add(v);
		}

		for (int x = 0; x < A.length; x++) {
			if ((x % 2) == 0) {
				A[x] = even.pop();
				continue;
			}
			A[x] = odd.pop();
		}

		return A;

	}

	public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
		Set<Integer> set = new TreeSet<>();
		for (int c : nums1) {
			set.add(c);
		}
		for (int c : nums2) {
			set.add(c);
		}
		int[] b = set.stream().mapToInt(x -> x).toArray();
		for (int x = 0; x < b.length; x++) {
			nums1[x] = b[x];
		}

		return nums1;
	}

	public static int[] moveZeroes(int[] nums) {
		int l = nums.length;
		int[] b = new int[l];
		if (l != 0) {
			int key = 0;
			for (int x = 0; x < l; x++) {
				if (nums[x] != 0) {
					b[key] = nums[x];
					key += 1;
				}
			}

			for (int x = 0; x < l; x++) {
				nums[x] = b[x];
			}
		}
		return b;
	}

	public static int[] sortArrayByParity2(int[] A) {
		int[] b = new int[A.length];

		int key = 0;
		for (int x = 0; x < A.length; x++) {
			int c = A[x];
			if ((c % 2) == 0) {
				b[key] = c;
				key += 1;
			}

		}

		for (int x = 0; x < A.length; x++) {
			int c = A[x];
			if ((c % 2) != 0) {
				b[key] = c;
				key += 1;
			}
		}

		return b;
	}

	public static int[] sortArrayByParity(int[] A) {
		Map<Boolean, List<Integer>> map = new HashMap<Boolean, List<Integer>>();
		map.put(true, new ArrayList<>());
		map.put(false, new ArrayList<>());

		for (int c : A) {
			List<Integer> res = null;
			if ((c % 2) == 0) {
				res = map.get(true);
				res.add(c);
				continue;
			}

			res = map.get(false);
			res.add(c);
		}

		List<Integer> s = new ArrayList<>(map.get(true));
		s.addAll(map.get(false));

		return s.stream().mapToInt(x -> x).toArray();
	}

	public static void rotate2(int[] nums, int k) {
		int l = nums.length;
		int[] a = new int[l];
		for (int i = 0; i < l; i++) {
			int i2 = (i + k);
			int i3 = i2 % l;
			a[i3] = nums[i];
		}
		for (int i = 0; i < l; i++) {
			nums[i] = a[i];
		}
	}

	public static void rotate(int[] nums, int k) {
		int l = nums.length;

		for (int x = 0; x < k; x++) {
			int lastValue = nums[l - 1];
			for (int y = l - 2; y >= 0; y--) {
				int temp = nums[y];
				nums[y + 1] = temp;
			}
			nums[0] = lastValue;
		}
	}

	static int alternate(String s) {
		Set<String> two = new java.util.HashSet<>();

		List<String> resValidated = new ArrayList<>();
		int l = s.length();
		Set<Character> set = new java.util.HashSet<>();
		for (int x = 0; x < l; x++) {
			char f = s.charAt(x);
			set.add(f);
		}
		set.stream().forEach(f -> {
			set.stream().forEach(f2 -> {
				if (f != f2) {
					two.add(getTwo(f, f2, s));
				}
			});
		});
		for (String res : two) {
			boolean test = false;
			for (int x = 0; x < res.length() - 1; x++) {
				if (res.charAt(x) == res.charAt(x + 1)) {
					break;
				}
				test = true;
			}
			if (test) {
				resValidated.add(res);
			}
		}

		if (resValidated.size() == 0) {
			return 0;
		}
		OptionalInt maxOpt = resValidated.stream().map(x -> x).mapToInt(String::length).max();
		return maxOpt.getAsInt();
	}

	static String getTwo(char a, char b, String s) {
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < s.length(); x++) {
			char f = s.charAt(x);
			if (f == a || f == b) {
				sb = sb.append(f);
			}
		}

		return sb.toString();
	}

	public static boolean groupSum(int start, int[] nums, int target) {
		// Base case: if there are no numbers left, then there is a
		// solution only if target is 0.
		if (start >= nums.length)
			return (target == 0);

		// Key idea: nums[start] is chosen or it is not.
		// Deal with nums[start], letting recursion
		// deal with all the rest of the array.

		// Recursive call trying the case that nums[start] is chosen --
		// subtract it from target in the call.
		if (groupSum(start + 1, nums, target - nums[start]))
			return true;

		// Recursive call trying the case that nums[start] is not chosen.
		if (groupSum(start + 1, nums, target))
			return true;

		// If neither of the above worked, it's not possible.
		return false;
	}
}
