package inflearn.major.section4;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution6_answer_after_fail {
    public int solution(int[] tasks, long k) {
    	int answer = 0;
    	

        int[] sortedTasks = new int[tasks.length + 1];
        sortedTasks[0] = 0;
        System.arraycopy(tasks, 0, sortedTasks, 1, tasks.length);
        Arrays.sort(sortedTasks);

        int restTask = tasks.length;
        for (int i=1; i<sortedTasks.length; i++) {
        	int removeTask = (sortedTasks[i]-sortedTasks[i-1]) * restTask;
        	if (removeTask < k) {
        		k = k-removeTask;
        		restTask--;
        	} else {
        		int once = (sortedTasks[i]-sortedTasks[i-1]);
        		if (once < k ) {
        			int num =  (int)k/once;
        			k = k - once*num;
        		}
        	}
        }

    	return answer;
    }

	public static void main(String[] args){
		Solution6_answer_after_fail T = new Solution6_answer_after_fail();
		System.out.println(T.solution(new int[]{1, 2, 3}, 5));
		System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
		System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
	}
	
	
}