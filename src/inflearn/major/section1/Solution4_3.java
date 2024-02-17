package inflearn.major.section1;

import java.util.*;
class Solution4_3 {
	  public int[] solution(int c, int r, int k) {
	    int[] answer = new int[2];
	    if (k > c * r) return new int[] {0,0};
	    
	    int[][] seat = new int[c][r];
	    int[] dx = { -1, 0, 1, 0 };
	    int[] dy = { 0, 1, 0, -1 };
	    
	    int x = 0, y = 0, count = 1, d = 1, array=0;
	    
	    while (count < k) {
	      array++;
	      int nx = x + dx[d];
	      int ny = y + dy[d];
	      if (nx < 0 || nx >= c || ny < 0 || ny >= r || seat[nx][ny] > 0) {
	        d = (d + 1) % 4;
	        continue;
	      }
	      seat[x][y] = count;
	      count++;
	      x = nx;
	      y = ny;
	    }
	    answer[0] = x + 1;
	    answer[1] = y + 1;
	    System.out.println(array);
	    return answer;
	  }
	  
		public static void main(String[] args){
			Solution4_3 T = new Solution4_3();
			System.out.println(Arrays.toString(T.solution(6, 5, 12)));	
			System.out.println(Arrays.toString(T.solution(6, 5, 20)));
			System.out.println(Arrays.toString(T.solution(6, 5, 30)));
			System.out.println(Arrays.toString(T.solution(6, 5, 31)));
		}
	}