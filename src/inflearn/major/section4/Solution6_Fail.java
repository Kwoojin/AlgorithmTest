package inflearn.major.section4;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution6_Fail {
    public int solution(int[] tasks, long k) {
    	int answer = 0;

    	int pos = 0;
    	for (int t=0; t<k; t++) {
    		tasks[pos]--;
    		pos = nextPos(tasks, pos);
    		if (pos == -1) {
    			return -1;
    		}
    	}
	
		return pos+1;
    }

	public static void main(String[] args){
		Solution6_Fail T = new Solution6_Fail();
		System.out.println(T.solution(new int[]{1, 2, 3}, 5));
		System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
		System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
	}
	
	public int nextPos(int[] tasks, int pos) {
		int next = (pos+1) % tasks.length;
		while(tasks[next] == 0) {
			if (next == pos) {
				return -1;
			}
			next = (next+1) % tasks.length;
		}
		
		return next;
	}
	
	
}