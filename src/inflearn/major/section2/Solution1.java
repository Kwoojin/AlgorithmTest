package inflearn.major.section2;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution1 {
	public int solution2(String s){
		Map<Character, Integer> repeatCharMap = new HashMap<>();
		
		for (char c : s.toCharArray()) {
			repeatCharMap.put(c, repeatCharMap.getOrDefault(c, 0)+1);
		}
		
		Optional<Integer> min = repeatCharMap
			.entrySet()
			.stream()
			.filter(entry -> entry.getValue() == 1)
			.map(entry -> entry.getKey())
			.map(key -> s.indexOf(key)+1)
			.min(Integer::compareTo);
		
		if (min.isEmpty()) {
			return -1;
		}

		return min.get();
	}
	
	public int solution(String s){
		int answer = 0;
		
		Map<Character, Integer> repeatCharMap = new HashMap<>();
		
		for (char c : s.toCharArray()) {
			repeatCharMap.put(c, repeatCharMap.getOrDefault(c, 0)+1);
		}
		
		for (int i=0; i<s.length(); i++) {
			if (repeatCharMap.get(s.charAt(i)) == 1) {
				return i+1;
			}
		}
		
		return -1;
	}

	public static void main(String[] args){
		Solution1 T = new Solution1();
		System.out.println(T.solution("statitsics"));
		System.out.println(T.solution("aabb"));
		System.out.println(T.solution("stringshowtime"));
		System.out.println(T.solution("abcdeabcdfg"));
	}
	
	
}