package inflearn.major.section3;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution3_Retry {
	public int[] solution(int[] arrival, int[] state){
		int[] answer = new int[arrival.length];
		
		Map<Integer, List<Integer>> arrivalMap = new HashMap<>();
		for (int i=0; i<arrival.length; i++) {
			arrivalMap.putIfAbsent(arrival[i], new ArrayList<>());
			arrivalMap.get(arrival[i]).add(i);
		}
		
		int time = 0;
		Integer previousState = null;
		List<Integer> waiting = new ArrayList<>();
		int p = 0;
		
		while(p<arrival.length) {
			if (arrivalMap.containsKey(time)) {
				waiting.addAll(arrivalMap.get(time));
			}
			
			if (!waiting.isEmpty()) {
//				Collections.sort(waiting);
				
				if (previousState == null) {
					int person = waiting.get(0);
					answer[person] = time;
					previousState = state[person];
					waiting.remove(0);
					p++;
				} else {
					boolean flag = false;
					for (int i=0; i<waiting.size(); i++) {
						int per = waiting.get(i);
						if (previousState == state[per]) {	
							answer[per] = time;
							p++;
							flag = true;
							waiting.remove(i);
							break;
						}
					}
					
					if (!flag) {
						int person = waiting.get(0);
						answer[person] = time;
						previousState = state[person];
						waiting.remove(0);
						p++;
					}
				}
			}
			
			time++;
		}
		
		
		return answer;
	}
		
	public static void main(String[] args){
		Solution3_Retry T = new Solution3_Retry();
		System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
		System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
		System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
	}
	
	
}