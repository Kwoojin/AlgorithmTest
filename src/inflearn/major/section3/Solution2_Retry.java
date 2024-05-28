package inflearn.major.section3;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution2_Retry {
	public String solution(String s){
		StringBuilder answer = new StringBuilder();
		
		
		
		int k = 0;
		
		Stack<Integer> numStack = new Stack<>();
		Stack<StringBuilder> charStack = new Stack<>();
		
		for (char c: s.toCharArray()) {
			
			if (Character.isDigit(c)) {
				int num = Character.getNumericValue(c);
				k = k*10 + num;
			} else if (c == '(') {
				k = k == 0 ? 1 : k;
				numStack.push(k);
				k = 0;
				charStack.push(new StringBuilder());
			} else if (c == ')') {
				String s2 = charStack.pop().toString();
				StringBuilder tmpBuilder = new StringBuilder();
				int r = numStack.pop();
				
				for (int i=1; i<=r; i++) {
					tmpBuilder.append(s2);
				}
				
				if (charStack.isEmpty()) {
					answer.append(tmpBuilder.toString());
				} else {
					StringBuilder sb = charStack.pop();
					sb.append(tmpBuilder.toString());
					charStack.push(sb);
				}
				
			} else {
				if (charStack.isEmpty()) {
					answer.append(c);
				} else {
					StringBuilder sb = charStack.pop();
					sb.append(c);
					charStack.push(sb);
				}
			}
			
		}
		
		return answer.toString();
	}

	public static void main(String[] args){
		Solution2_Retry T = new Solution2_Retry();
		System.out.println(T.solution("3(a2(b))ef"));
		System.out.println(T.solution("2(ab)k3(bc)"));
		System.out.println(T.solution("2(ab3((cd)))"));
		System.out.println(T.solution("2(2(ab)3(2(ac)))"));
		System.out.println(T.solution("3(ab2(sg))"));
	}
	
	
	
	
}