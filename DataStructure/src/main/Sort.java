package main;

public class Sort {

	public static void main(String[] args) {
		String s = "00:00:00PM";
		System.out.println(timeConversion(s));
	}

	static String timeConversion(String s) {
		StringBuilder sb = new StringBuilder();
		String[] s1 = s.split(":");
		int l = s.length();
		String type = s.substring(l-2, l);
		int s1l = s1.length;
		s1[s1l - 1] = String.valueOf(s1[s1l - 1].charAt(0)) +String.valueOf(s1[s1l - 1].charAt(1));
		int oH = Integer.valueOf(s1[0]);
		if(type.equals("PM") && oH == 12) {
			 sb
			.append("00")
			.append(":")
			.append(s1[1])
			.append(":")
			.append(s1[2]);
		}else if(type.equals("PM") && oH != 12 && oH != 0) {
			int h = oH+12;
			s1[0] = String.valueOf(h);
			sb
			.append(s1[0])
			.append(":")
			.append(s1[1])
			.append(":")
			.append(s1[2]);
		}else {
			sb
			.append(s1[0])
			.append(":")
			.append(s1[1])
			.append(":")
			.append(s1[2]);
		}
		
		return sb.toString();
	}

	static int runningTime(int[] arr) {
		int res = 0;
		int key = 0;
		int j = 0;
		for (int x = 1; x < arr.length; x++) {
			key = arr[x];
			j = x;
			while (j > 0 && arr[j - 1] > key) {
				arr[j] = arr[j - 1];
				j -= 1;
				res += 1;
			}
			arr[j] = key;

		}

		return res;
	}

	static void insertionSort1(int n, int[] arr) {
		int key = 0;
		int j = 0;
		for (int x = 1; x < n; x++) {
			key = arr[x];
			j = x;
			while (j > 0 && arr[j - 1] > key) {
				arr[j] = arr[j - 1];
				j -= 1;
				for (int y : arr) {
					System.out.print(y + " ");
				}
				System.out.println();
			}
			arr[j] = key;

		}
		for (int y : arr) {
			System.out.print(y + " ");
		}
		System.out.println();

	}

	static void insertionSort2(int n, int[] arr) {
		int key = 0;
		int j = 0;
		for (int x = 1; x < n; x++) {
			key = arr[x];
			j = x;
			while (j > 0 && arr[j - 1] > key) {
				arr[j] = arr[j - 1];
				j -= 1;
			}
			arr[j] = key;
			for (int y : arr) {
				System.out.print(y + " ");
			}
			System.out.println();

		}
	}
}
