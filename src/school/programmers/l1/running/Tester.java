package school.programmers.l1.running;

import java.util.*;


// https://school.programmers.co.kr/learn/courses/30/lessons/178871
public class Tester {
	public static void main(String[] args) {
		String[] players = {"mumu", "soe", "poe", "kai", "mine"};
		String[] callings = {"kai", "kai", "mine", "mine"};
		
		
		// "mumu", "kai", "mine", "soe", "poe" //
		System.out.println("\n========== 답 ==========\n");
		String[] an = new Solution().solution(players, callings);
		for(String str : an) {
			System.out.print(str + ", ");
		}
	}
}



//
//class Solution {
//	public String[] solution(String[] players, String[] callings) {
//		
//		//선수정보 저장
//		Map<String, Integer> info = new HashMap<>();
//		for(int i = 0 ; i < players.length ; i++) {
//			info.put(players[i], i);
//		}
//		
//		// 등수 배열 초기화
//		int[] rank = new int[players.length];
//		for(int i = 0 ; i < rank.length ; i++) rank[i] = i-1;
//		
//		
//		for(String str : callings) {
//			int tempInt = 
//			rank[]
//		}
//		
//		
//		
//		
//		
//		return null;
//	}
//}





class Solution {
    public String[] solution(String[] players, String[] callings) {
    	
    	// 등수 배열 초기화
        for(String str : callings) {
        	fnc(players, str);
        }
        return players;
    }
    
    public void fnc(String[] players, String calling) {
		for(int i = 0 ; i < players.length ; i++) {
			if(players[i].equalsIgnoreCase(calling)) {
				String tempStr = players[i];
				players[i] = players[i-1];
				players[i-1] = tempStr;
				break;
			}
		}
	}
}


