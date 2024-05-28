package inflearn.major.section7;

import java.util.*;

import java.util.stream.Collectors;

class Solution2 {
	
	public int bfs(int[] pool, int a, int b, int home) {
		Queue<int[]> queue = new LinkedList<>();
		int[] checked = new int[10000];
		int count = 0;

        Set<Integer> poolSet = Arrays.stream(pool)
            .boxed()
            .collect(Collectors.toSet());
		
		
		queue.offer(new int[] {0, 0});
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i=0; i<size; i++) {
				int[] current = queue.poll();
				
				int next = current[0] + a;
				if (next == home) return count+1; 
				if (checked[next] == 0 && !poolSet.contains(next) && next < home+a) {
					checked[next]=1;
					queue.offer(new int[] {next, 1});
				}
				
				if (current[1] != 0) {
					int before = current[0] - b;
					if (before == home) return count+1; 
					if (0 < before && checked[before] == 0 && !poolSet.contains(before)) {
						checked[before]=1;
						queue.offer(new int[] {before, 0});
					}
				}
				
			}
			
			count++;
		}
		
		
		return -1;
	}
	
	public int solution(int[] pool, int a, int b, int home){
		return bfs(pool, a, b, home);
	}

	public static void main(String[] args){
		Solution2 T = new Solution2();
		System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));	
		System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));	
		System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));	
		System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));	
		System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));	
	}
	
}