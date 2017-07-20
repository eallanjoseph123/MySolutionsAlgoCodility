package main.java;

public class PracticeSolutions {

	public static void main(String[] args) {
		
	}
	
	public static int binaryGap(int N){
		String binary = Integer.toBinaryString(N);
		int index = 0;
		int index2 = 0;
		int start = 0;
		int start2 = 0;
		int h = 0, l =0;
		if(!binary.contains("0")){
			return 0;
		}
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
