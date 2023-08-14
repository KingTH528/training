package school.programmers.l2;

public class Miner {

	public static void main(String[] args) {
		
		
		
		
		
		

	}

	
	
	public int solution(int[] picks, String[] minerals) {
		int answer = 0;


		// 미네랄 -> 곡갱이별 피로도로 정리
		int row = minerals.length/5+1;
		if(minerals.length%5==0){
			row -= 1;
		}
		
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
			if(i!=0 && i%5==0) {
				
				//곡갱이별 피로도 정리
				//다이아 곡갱이 썼을 때
				mineralsInt[thisRow][0] = mineralsD + mineralsI + mineralsS;
				//철 곡갱이 썼을 때
				mineralsInt[thisRow][1] = 5*mineralsD + mineralsI + mineralsS;
				//돌 곡갱이 썼을 때
				mineralsInt[thisRow][2] = 25*mineralsD + 5*mineralsI + mineralsS;
				
				//피로도 초기화
				mineralsD = 0;
				mineralsI = 0;
				mineralsS = 0;
				
				//줄바꿈
				thisRow++; 
			}
			
			
			//이걸 곡갱이별 피로도 말고 곡갱이별 피로도의 차이를 구하고 그 차이가 큰것 부터 다이아 -> 철 -> 돌 순서로 넣으면?
			// 다<->철, 철<->돌 피로도 차이 구하고 차이가 큰 걸 
			
			
		}
		
		
		
		
		
		return answer;
	}
}
