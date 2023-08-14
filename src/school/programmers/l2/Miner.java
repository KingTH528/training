package school.programmers.l2;

import java.util.Arrays;

public class Miner {

	public static void main(String[] args) {
//		int[] picks = {1, 3, 2};
//		String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
		int[] picks = {0, 1, 1};
		String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
		
		System.out.println("\n답 : " + solution(picks, minerals));

	}

	public static int solution(int[] picks, String[] minerals) {
		int answer = 0;

		// 미네랄 -> 곡갱이별 피로도로 정리
		int row = minerals.length/5+1;
		if(minerals.length%5==0){
			row -= 1;
		}
		System.out.println("row : " + row);
		int[][] mineralsInt = new int[row][3];
		int mineralsD = 0;
		int mineralsI = 0;
		int mineralsS = 0;
		int thisRow = 0;
		for(int i = 0 ; i < minerals.length ; i ++){
			
			if(minerals[i].equalsIgnoreCase("diamond")) mineralsD++;
			else if(minerals[i].equalsIgnoreCase("iron")) mineralsI++;
			else if(minerals[i].equalsIgnoreCase("stone")) mineralsS++;
			else {};
			
			//5의 배수면 줄바꿈 및 피로도 정리
			if((i!=0 && i%5==4) || i == minerals.length-1) {
				System.out.println();
				System.out.println("==줄바꿈==(" + thisRow + ")->" + (thisRow+1));
				System.out.println("다이아 수 : " + mineralsD);
				System.out.println("철 수 : " + mineralsI);
				System.out.println("돌 수 : " + mineralsS);
				
				//곡갱이별 피로도 정리
				//다이아 곡갱이 썼을 때
				mineralsInt[thisRow][0] = mineralsD + mineralsI + mineralsS;
				//철 곡갱이 썼을 때
				mineralsInt[thisRow][1] = 5*mineralsD + mineralsI + mineralsS;
				//돌 곡갱이 썼을 때
				mineralsInt[thisRow][2] = 25*mineralsD + 5*mineralsI + mineralsS;
				
				mineralsD = 0;
				mineralsI = 0;
				mineralsS = 0;
				
				thisRow++; 
			}
		}

		
		System.out.println("\n피로도 정리");
		for(int[] i : mineralsInt) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		
		
		int tempAnswer = 0;
		int tempIndex = -1;
		
		
		for(int i = 0 ; i < picks[0] ; i++) {
			for(int j = 0 ; j<row ; j++) {
				int thisD = (mineralsInt[j][1] -  mineralsInt[j][0]);
				if(tempAnswer < thisD) {
					tempAnswer = thisD;
					tempIndex = j;
				}else {
					
				}
			}
			answer += mineralsInt[tempIndex][0];
			mineralsInt[tempIndex][0] = 0;
			mineralsInt[tempIndex][1] = 0;
			mineralsInt[tempIndex][2] = 0;
			tempAnswer = 0;
		}
		
		for(int i = 0 ; i < picks[1] ; i++) {
			for(int j = 0 ; j<row ; j++) {
				int thisD = (mineralsInt[j][2] -  mineralsInt[j][1]);
				if(tempAnswer < thisD) {
					tempAnswer = thisD;
					tempIndex = j;
				}
			}
			answer += mineralsInt[tempIndex][1];
			mineralsInt[tempIndex][0] = 0;
			mineralsInt[tempIndex][1] = 0;
			mineralsInt[tempIndex][2] = 0;
			tempAnswer = 0;
		}
		
		for(int i = 0 ; i < picks[2] ; i++) {
			for(int j = 0 ; j<row ; j++) {
				if(mineralsInt[j][2] != 0) tempIndex = j;
			}
			//여기
			answer += mineralsInt[tempIndex][2];
			mineralsInt[tempIndex][0] = 0;
			mineralsInt[tempIndex][1] = 0;
			mineralsInt[tempIndex][2] = 0;
		}

		return answer;
	}
}
