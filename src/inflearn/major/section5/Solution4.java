package inflearn.major.section5;

import java.util.*;

import inflearn.major.section5.Solution3_Fail.Range;

import static java.util.stream.Collectors.toList;

class Solution4 {


	public int solution(int[] plantTime, int[] growTime){
		int answer = 0;
		
		ArrayList<Flower> flowers = new ArrayList<>();
		
		for (int i=0; i<plantTime.length; i++) {
			flowers.add(new Flower(plantTime[i], growTime[i]));
		}
		Collections.sort(flowers);
		
		int lt=0; int rt=0;
		
		for(Flower flower: flowers) {
			rt = Math.max(lt+flower.getPlant() + flower.getGrow(), rt);
			lt += flower.getPlant();
		}
		
		return rt;
	}

	public static void main(String[] args){
		Solution4 T = new Solution4();
		System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
		System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
		System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
		System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
		System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
	}
	
	
	public static class Flower implements Comparable<Flower> {
		
		private final int plant;
		
		private final int grow;
		
		public Flower(int plant, int grow) {
			this.plant = plant;
			this.grow = grow;
		}
		
		
		@Override
		public int compareTo(Flower other) {
			if (this.grow == other.grow) {
				return this.plant - other.plant;
			}
			return other.grow - this.grow;
		}
		
		public int getPlant() {
			return this.plant;
		}
		
		public int getGrow() {
			return this.grow;
		}
		
	}
	
}