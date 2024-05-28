package inflearn.major.section5;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Solution5_2 {

	public int[] solution(String[] students){
		int n = students.length;
		int[] answer = new int[n];
		
		Student[] students2 = new Student[n];
		Map<String, Integer> sums = new HashMap<>();
		for (int i=0; i<n; i++) {
			String[] studentInfo = students[i].split(" ");
			students2[i] = new Student(i, studentInfo[0], Integer.parseInt(studentInfo[1]));
			sums.put(studentInfo[0], 0);
		}
		Arrays.sort(students2);
		
		
		int total = 0;
		
		for (int i=0; i<n; i++) {
			Student student = students2[i];
			answer[student.getId()] = total - sums.get(student.getTeam());
			total += student.getAttack();
			sums.put(student.getTeam(), sums.get(student.getTeam())+student.getAttack());
		}
		
		return answer;
	}

	public static void main(String[] args){
		Solution5_2 T = new Solution5_2();
		System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
		System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
		System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
		System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
	}
	
	public static class Student implements Comparable<Student> {
		
		private final int id;
		
		private final String team;
		
		private final int attack;
		
		public Student(int id, String team, int attack) {
			this.id = id;
			this.team = team;
			this.attack = attack;
		}
		
		
		@Override
		public int compareTo(Student other) {
			if (this.attack == other.attack) {
				return this.team.compareTo(other.team);
			}
			return Integer.compare(this.attack, other.attack);
		}
		
		public int getId() {
			return this.id;
		}
		
		public int getAttack() {
			return this.attack;
		}
		
		public String getTeam() {
			return this.team;
		}
		
	}
	
}