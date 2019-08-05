package main;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;


public class Test {
	public static void main(String[] args) {
		
		
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
    	
        for(int x= 0;x <k;x++) {
        	int lastValue = nums[l-1];
        	for(int y = l-2;y>=0;y--) {
        		int temp = nums[y];
        		nums[y+1]=temp;
        	}
        	nums[0]=lastValue;
        }
    }

	static int alternate(String s) {
		Set<String> two = new java.util.HashSet<>();
		
		List<String> resValidated = new ArrayList<>(); 
		int l = s.length();
		Set<Character> set = new java.util.HashSet<>();
		for(int x=0;x<l;x++) {
			char f = s.charAt(x);
			set.add(f);
		}
		set.stream().forEach(f->{
			set.stream().forEach(f2->{
				if(f != f2) {
					two.add(getTwo(f,f2,s));
				}
			});
		});
		for(String res : two) {
			boolean test = false;
			for(int x=0;x<res.length()-1;x++) {
				if(res.charAt(x) == res.charAt(x+1)) {
					break;
				}
				test = true;
			}
			if(test) {
				resValidated.add(res);
			}
		}
		
		if(resValidated.size() == 0) {
			return 0;
		}
		OptionalInt maxOpt  =resValidated.stream()
                .map(x->x)
                .mapToInt(String::length)
                .max();
		return maxOpt.getAsInt();
	}
	
	
	static String getTwo(char a,char b , String s) {
		StringBuilder sb = new StringBuilder();
		for(int x=0;x<s.length();x++) {
			char f = s.charAt(x);
			if(f == a || f ==b) {
				sb =sb.append(f);
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
