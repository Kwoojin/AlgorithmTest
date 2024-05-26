package inflearn.major.section2;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution2 {
	
	public int[] solution(String s){
		int[] answer = new int[5];
		
		Map<Integer, Integer> t = new HashMap<>();
		
		for (char c : s.toCharArray()) {
			int ascii = (int) c - 97;
			t.put(ascii, t.getOrDefault(ascii, 0)+1);
		}
		
		int max = t.values()
		 .stream()
		 .max(Integer::compareTo)
		 .get()
		;
		
		for (int i=0; i<answer.length; i++) {
			int repeat = t.getOrDefault(i, 0);
			answer[i] = max - repeat;  
		}
		
		
		return answer;
	}

	public static void main(String[] args){
		Solution2 T = new Solution2();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}
	
	
}