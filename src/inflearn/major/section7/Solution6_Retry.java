package inflearn.major.section7;

import java.util.*;

import java.util.stream.Collectors;

class Solution6_Retry {

	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {1, -1, 0, 0};
	
	private int answer = 0;
	
	
	public int sword(List<int[]> straw, int[][] board) {
		int lenx = board.length;
		int leny = board[0].length; 
		
		int[][] checked = new int[lenx][leny];
		
		Queue<int[]> queue = new LinkedList<>();
		
		for (int[] s : straw) {
			queue.offer(s);
		}
		
		int l = 0;
		while(!queue.isEmpty()) {
			l++;
			int size = queue.size();
			for (int i=0; i<size; i++) {
				int[] cur = queue.poll();
				
				for (int j=0; j<4; j++) {
					int nx = cur[0] + dx[j];
					int ny = cur[1] + dy[j];
					
					if (nx >= 0 && nx < lenx 
							&& ny >= 0 && ny < leny
							&& board[nx][ny] == 3
					) {
						return l;
					}
					
					if (nx >= 0 && nx < lenx 
							&& ny >= 0 && ny < leny
									&& board[nx][ny] != 1
									&& checked[nx][ny] == 0
					) {
						checked[nx][ny] = 1;
						queue.offer(new int[] {nx, ny});
					}
				}
			}
		}
		
		return -1;
	}
	
	public List<int[]> strawberry(int[] princess, int[][] board) {
		int lenx = board.length;
		int leny = board[0].length; 
		
		int[][] checked = new int[lenx][leny];
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(princess);
		
		List<int[]> straw = new ArrayList<>();
		
		int l = 0;
		while(!queue.isEmpty() && straw.isEmpty()) {
			l++;
			int size = queue.size();
			for (int i=0; i<size; i++) {
				int[] cur = queue.poll();
				
				for (int j=0; j<4; j++) {
					int nx = cur[0] + dx[j];
					int ny = cur[1] + dy[j];
					

					if (nx >= 0 && nx < lenx 
							&& ny >= 0 && ny < leny
							&& board[nx][ny] == 4) {
						straw.add(new int[] {nx, ny});
					}
					
					if (nx >= 0 && nx < lenx 
							&& ny >= 0 && ny < leny
							&& board[nx][ny] != 1
							&& checked[nx][ny] == 0
					) {
						checked[nx][ny] = 1;
						queue.offer(new int[] {nx, ny});
					}
				}
			}
		}
		
		answer += l;
		
		
		return straw;
	}
	
	
	public int[] princess(int[][] board) {
		int lenx = board.length;
		int leny = board[0].length; 
		
		for (int i=0; i<lenx; i++) {
			for (int j=0; j<leny; j++) {
				if (board[i][j] == 2) {
					return new int[] {i, j};
				}
			}
		}
		
		return new int[] {-1, -1};
	}
	
	public int solution(int[][] board){
		this.answer = 0;
		
		
		int[] princess = princess(board);
		List<int[]> straw = strawberry(princess, board);
		int s = sword(straw, board);

		
		return answer+s;
	}

	public static void main(String[] args){
		Solution6_Retry T = new Solution6_Retry();
		System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
			{0, 0, 0, 1, 0, 1, 0, 0}, 
			{0, 2, 1, 1, 3, 0, 4, 0},
			{0, 0, 0, 4, 1, 1, 1, 0}}));
		System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4}, 
			{0, 1, 1, 0, 0, 0, 1, 0}, 
			{0, 1, 4, 0, 1, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0}, 
			{1, 0, 1, 0, 0, 1, 1, 0}, 
			{4, 0, 0, 0, 1, 0, 0, 0}, 
			{4, 1, 0, 0, 1, 0, 0, 0}, 
			{4, 0, 0, 0, 0, 0, 1, 2}}));
		System.out.println(T.solution(new int[][]{{4, 1, 0, 1, 0}, 
			{0, 1, 0, 1, 0}, 
			{0, 0, 2, 3, 4}, 
			{0, 1, 0, 1, 0}}));
	}
	
}