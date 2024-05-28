package inflearn.major.section3;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution4_Fail {
	public int solution(int[] laser, String[] enter){
		int answer = 0;
		
		Queue<Person> queue = new LinkedList<>();
		List<Person> enters = new ArrayList<>();
		
		for (String s : enter) {
			String times[] = s.split(" ")[0].split(":");
			int time = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
			enters.add(new Person(time, Integer.parseInt(s.split(" ")[1])));
		}
		
		
		Person current = null;
		int i=0;
		int endTime=0;
		for (int t=enters.get(0).getTime(); t<1200; t++) {
			
			if (endTime==t) {
				current = null;
				endTime = 0;
				
				if (!queue.isEmpty()) {
					current = queue.poll();
					endTime = current.getTime() + laser[current.getType()];
				}
			}
			
			while(i<enters.size()) {
				Person per = enters.get(i);
				if (t >= per.getTime()) {
					if (current == null) {
						current = per;
						endTime = per.getTime() + laser[per.getType()];
					} else {
						queue.offer(per);
						answer = Math.max(answer, queue.size());
					}
					
					i++;
				} else {
					break;
				}
			}
		}
		
		return answer;
	}
		
	public static void main(String[] args){
		Solution4_Fail T = new Solution4_Fail();
		System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
		System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
		System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
	}
	
	public static class Person implements Comparable<Person> {
	    int time;
	    int type;

	    public Person(int time, int type) {
	        this.time = time;
	        this.type = type;
	    }

	    @Override
	    public int compareTo(Person other) {
	    	if (this.time == other.time) {
	    		return Integer.compare(other.type, this.type);
	    	}
	        return Integer.compare(this.time, other.time);
	    }
	    
	    public int getType() {
	    	return this.type;
	    }
	    
	    public int getTime() {
	    	return this.time;
	    }
	    
	    
	}
	
	
}