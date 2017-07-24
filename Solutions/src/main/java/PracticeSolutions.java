package main.java;

import java.util.Arrays;

public class PracticeSolutions {

	public static void main(String[] args) {
		
	}
	
	public static int oddOccurrencesInArray(int A[]){
		Arrays.sort(A);
		if(A.length == 1) return A[0];
		for (int x = 1; x < A.length; x++) {
			if( (x-1 )== 0 && A[x - 1] != A[x]){
				return A[x - 1]; 
			}
			if(A[x - 1] == A[x] || ((x+1) < A.length && A[x] == A[x+1])){
				continue;
			}else{
				return  A[x];
			}
		}
		return 0;
	}
	
	public static int[] cyclicRotation(int[] A, int K){
		int []c = null;
		if(A == null || A.length <= 1){
			return A;
		}
		 for(int x = 0 ; x < K; x++){
			 for(int y = 0 ; y < A.length; y++){
				 if(y == 0){
					 c = new int[A.length];
					int f = A[y];
					c[y] = A[A.length-1];
					y = y + 1;
					c[y] = f;
				 }else{
					 c[y] = A[y-1];
				 }
			 }A = c;
			 c = null;
		 }
		 
		return A;
	}
	
	public static int binaryGap(int N){
		String binary = Integer.toBinaryString(N);
		int index = 0;
		int index2 = 0;
		int start = 0;
		int start2 = 0;
		int h = 0, l =0;
		if(!binary.contains("0")){return 0;}
		while(true){
			index = binary.indexOf("1", start);
			if (index != -1) {
				start2 = index + 1;
				index2 = binary.indexOf("1", start2);
				if (index2 != -1) {
					l = binary.substring(index+1,index2).length();
					if (h < l) {
						h = l;
					}
				}
			}
			if(index == -1){
				break;
			}
			start+=1;
		}
		return h;
	}
}
