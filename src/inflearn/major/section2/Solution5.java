package inflearn.major.section2;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution5 {
	public String solution(String[] votes, int k){
		String answer = " ";
		
		Map<String, List<String>> results = new HashMap<>();
		
		for (String vote: votes) {
			String[] voteDetail = vote.split(" ");
			List<String> values = results.getOrDefault(voteDetail[1], new ArrayList<>());
			values.add(voteDetail[0]);
			results.put(voteDetail[1], values);
		}
		
		Map<String, Integer> gifts = new HashMap<>();
		
		for (String result: results.keySet()) {
			List<String> votePs = results.get(result);
			
			if (votePs.size() < k) {
				continue;
			}
			
			for (String vote : votePs) {
				gifts.put(vote, gifts.getOrDefault(vote, 0)+1);
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (String gift: gifts.keySet()) {
			if (gifts.get(gift) > max) {
				max = gifts.get(gift);
				answer = gift;
			} else if (gifts.get(gift) == max) {
				if (gift.compareTo(answer) < 0) {
					answer= gift;
				}
			}
			
		}
		

		return answer;
	}

	public static void main(String[] args){
		Solution5 T = new Solution5();
		System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
		System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
	}
	
	
}