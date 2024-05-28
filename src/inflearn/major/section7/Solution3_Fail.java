package inflearn.major.section7;

import java.util.*;

import java.util.stream.Collectors;

class Solution3_Fail {
	public int solution(int s, int e){
		int answer = 0;
		

		Queue<Integer> queue = new LinkedList<>();
		
		int[] calf = new int[]{e, 0};
		
		Set<Integer> even = new HashSet<>();
		Set<Integer> odd = new HashSet<>();
		
		queue.offer(s);
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			int calfPos = calf[0];
			int calfNextMove = calf[1]+1;
			
			for (int i=0; i<size; i++) {
				int cur = queue.poll();
				
				if (calfPos > 200000) return -1;
				if (cur == calfPos) return answer;

				queue.offer(cur*2);
				queue.offer(cur+1);
				if (cur-1 > 0) {
					queue.offer(cur-1);
				}
				
				if (answer % 2 == 0) {
					if (even.contains(calfPos+calfNextMove)) return answer;
					even.add(cur*2);
					even.add(cur+1);
					if (cur-1 > 0) {
						even.add(cur-1);
					}
				} else {
					if (odd.contains(calfPos+calfNextMove)) return answer;
					odd.add(cur*2);
					odd.add(cur+1);
					if (cur-1 > 0) {
						odd.add(cur-1);
					}
				}
				
				
			}
			answer++;
			calf = new int[] {calfPos+calfNextMove, calfNextMove};
		}
		
		return -1;
	}
	

	public static void main(String[] args){
		Solution3_Fail T = new Solution3_Fail();
		System.out.println(T.solution(1, 11));	
		System.out.println(T.solution(10, 3));	
		System.out.println(T.solution(1, 34567));
		System.out.println(T.solution(5, 6));	
		System.out.println(T.solution(2, 54321));	
	}
	
}