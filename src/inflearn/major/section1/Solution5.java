package inflearn.major.section1;

class Solution5 {
	public static int solution(int[] nums){

		// answer : 정답
		// len : 현재 수열 길이
		// d : 현재 수열의 방향 ( 0: 증가, 1: 감소)
		// prevNum : 이전 숫자
		 
		int answer = 0, len = 0, d = 0, prevNum = Integer.MIN_VALUE;
		
		for (int num : nums) {

			if (d == 0) {
				// 1. 현재 수열이 증가하고 있는 상황

				// 2. 수열이 증가하고 있는 상황에서의 시뮬레이션
				if (prevNum > num) {
					// 이전 숫자보다 작을 경우, 수열의 방향을 감소로 변경
					d = -1;	
				} else if (prevNum == num) {
					// 이전 숫자와 값이 같을 경우, 바이토닉 수열이 아니므로 길이 초기화
					len = 0;
				}

				// 길이 증가
				len++;
			} else {
				// 1. 현재 수열이 감소하고 있는 상황

				// 2. 수열이 감소하고 있는 상황에서의 시뮬레이션
				if (prevNum > num) {
					// 2-1. 이전 숫자보다 작을 경우, 길이 증가
					len++;	
				} else {
					// 2-2. 이전 숫자보다 크거나, 같을 경우 수열이 끝났다고 판단

					// 2-2-1. 현재까지의 길이를 계산하여 더 길면 정답으로 변경
					if (answer < len) {
						answer = len;
					}

					// 2-2-2. 초기화
					len = 1; // 현재 숫자부터 다시 시작하므로 값은 1
					d = 0;

					// 2-2-3. 현재 숫자 이전의 값을 비교했을 때, 증가하고 있었다면 길이 하나 증가
					if (prevNum < num) {
						len++;
					}
				}
			}
			
			prevNum = num;
		}

		// 현재 진행중이던 수열이 감소하고 있고 길이가 정답보다 크다면, 정답으로 변경
		if (answer < len && d == -1) {
			answer = len;
		}
				
		return answer;	
	}

	public static void main(String[] args){
		Solution5 T = new Solution5();
		System.out.println(Solution5.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
		System.out.println(Solution5.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
		System.out.println(Solution5.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
		System.out.println(Solution5.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
	}
}
