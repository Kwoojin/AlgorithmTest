package inflearn.major.section2;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution3_Fail {
	public int solution(String s){
		int answer = 0;
		
		Map<Character, Integer> map = new HashMap<>();
		Set<Integer> unique = new HashSet<>();
		
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			int value = entry.getValue();
			
			if (!unique.contains(value)) {
				unique.add(value);
				continue;
			}
			
			
			while (value > 0) {
				value--;
				answer++;
				if (!unique.contains(value) && value > 0) {
					unique.add(value);
					break;
				}
			}
			
			
		}
		
		
		
		return answer;
	}

	public static void main(String[] args){
		Solution3_Fail T = new Solution3_Fail();
		System.out.println(T.solution("aaabbbcc"));	
		System.out.println(T.solution("aaabbc"));	
		System.out.println(T.solution("aebbbbc"));	
		System.out.println(T.solution("aaabbbcccde"));	
		System.out.println(T.solution("aaabbbcccdddeeeeeff"));	
	}
}