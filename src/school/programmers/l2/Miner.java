package school.programmers.l2;

import java.util.Arrays;
import java.util.Comparator;



//곡갱이별로 5번씩 사용하게 되니까 한단계라도 높은 광물이 하나라도 껴있으면 그거에 따라서 피로도 차이가 넘사벽으로 벌어짐
//이라고 생각했지만 마지막에 하나만 (다이아나 철)들어오면 그것보다 한단계 낮은 광물 5개랑 같은 값을 가질 수 있음

public class Miner {

	public int solution(int[] picks, String[] minerals) {
		int answer = 0;

		
		// 미네랄 -> 곡갱이별 피로도로 정리
		int[][] mineralsInt;
		
		// 피로도 정리배열 row 결정
		// 미네랄 갯수/5 기준으로 row 생성
		int row = minerals.length/5+1;
		if(minerals.length%5==0)row -= 1;
		
		// 보유한 곡갱이 갯수 기준으로 row 수 제한
		if(row > picks[0]+picks[1]+picks[2]) {
			row = picks[0]+picks[1]+picks[2];
		}
		
		
		
		// 실제 사용할 곡갱이별 수량 제한(곡갱이 수가 미네랄 수보다 많이 처리할 수 있을 때 / 다이아 -> 철 -> 돌 순서)
		if(row < picks[0]) picks[0] = row;
		if(row < picks[0] + picks[1]) picks[1] = row - picks[0];
		if(row < picks[0] + picks[1] + picks[2]) picks[2] = row - picks[0] - picks[1];
		
		
		
		
		
		// 필요한 만큼만 곡갱이별 피로도 배열 생성
		mineralsInt = new int[row][3];
		int mineralsD = 0;
		int mineralsI = 0;
		int mineralsS = 0;
		int thisRow = 0;
		for(int i = 0 ; i < minerals.length ; i ++){
			
			if(minerals[i].equalsIgnoreCase("diamond")) mineralsD++;
			else if(minerals[i].equalsIgnoreCase("iron")) mineralsI++;
			else if(minerals[i].equalsIgnoreCase("stone")) mineralsS++;
			else {};
			
			//5의 배수전 || 마지막데이터에서 줄바꿈 및 피로도 정리
			if((i != 0 && i%5 == 4) || i == minerals.length-1) {
				
				//곡갱이별 피로도 정리
				mineralsInt[thisRow][0] = mineralsD + mineralsI + mineralsS;
				mineralsInt[thisRow][1] = 5*mineralsD + mineralsI + mineralsS;
				mineralsInt[thisRow][2] = 25*mineralsD + 5*mineralsI + mineralsS;
				
				mineralsD = 0;
				mineralsI = 0;
				mineralsS = 0;
				
				thisRow++; 
			}
			if(thisRow == row) break;
			
		}
		
		
		// 곡갱이 별 피로도 기준으로 배열 정렬 (최소값 구하고 제외하는 방식으로 해도 되는데 머리아플 듯...)
		Arrays.sort(mineralsInt, new Comparator<int[]>() {
		    @Override
		    public int compare(int[] a, int[] b) {
		        if (b[2] != a[2]) {
		            return a[2] - b[2];  	 // mineralsInt[row][2]기준으로 정렬하는데
		        } else {
		        	if(b[1] != a[1]) {
		        		return a[1] - b[1];  // 같으면 mineralsInt[row][1] 기준으로 정렬
		        	}else {
		        		return  a[0] - b[0]; // 그것도 같으면 mineralsInt[row][0] 기준으로 정렬
		        	}
		        }
		    }
		});
		
		// 정렬된 순서대로 돌곡 -> 철곡 -> 다곡 넣고 계산
		for(int i = 0 ; i < picks[2] ; i++) answer += mineralsInt[i][2];
		for(int i = 0 ; i < picks[1] ; i++) answer += mineralsInt[i+picks[2]][1];
		for(int i = 0 ; i < picks[0] ; i++) answer += mineralsInt[i+picks[2]+picks[1]][0];
		
		
        return answer;
	}
}
