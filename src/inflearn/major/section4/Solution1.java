package inflearn.major.section4;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution1 {
	public int[] solution(int[] nums){
		return Arrays
			.stream(nums)
			.mapToObj(num -> new BinaryNumber(num))
			.sorted()
			.mapToInt(binary -> binary.getNumber())
			.toArray();
	}

	public static void main(String[] args){
		Solution1 T = new Solution1();
		System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
		System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
		System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
	}
	

	
	public static class BinaryNumber implements Comparable<BinaryNumber> {
		
		private final int number;
		
		private final int binary;
		
		private final int binarySum;
		
		public BinaryNumber(int number) {
			this.number = number;
			this.binary = toBinaryNumber(this.number);
			this.binarySum = sumOfDigits(this.binary);
		}
		
		
		@Override
		public int compareTo(BinaryNumber other) {
			if (this.binarySum == other.binarySum) {
				return this.number - other.number;
			}
			return this.binarySum - other.binarySum;
		}
		
		public int toBinaryNumber(int n) {
			if (n == 0) {
				return 0;
			}
			
			StringBuilder binary = new StringBuilder();

	        while (n > 0) {
	            binary.insert(0, n % 2);
	            n = n / 2;
	        }

	        return Integer.parseInt(binary.toString());
		}
		
		public int sumOfDigits(int n) {
			int sum = 0;
	        
	        while (n != 0) {
	            sum += n % 10;
	            n = n / 10;
	        }
	        
	        return sum;
		}
		
		public int getNumber() {
			return this.number;
		}
		
	}
	
	
}