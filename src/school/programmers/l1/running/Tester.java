package school.programmers.l1.running;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


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
////이게 고수꺼
//class Solution {
//    public String[] solution(String[] players, String[] callings) {
//        int n = players.length;
//        HashMap<String, Integer> indexMap = new HashMap<>();
//
//        for (int i = 0; i < n; i++) {
//            indexMap.put(players[i], i);
//        }
//
//        for (String calling : callings) {
//            int idx = indexMap.get(calling);
//            if (idx > 0) {
//                String temp = players[idx - 1];
//                players[idx - 1] = players[idx];
//                players[idx] = temp;
//
//                indexMap.put(players[idx - 1], idx - 1);
//                indexMap.put(players[idx], idx);
//            }
//        }
//
//        return players;
//    }
//}


//고수꺼 따라해보기
class Solution {
	public String[] solution(String[] players, String[] callings) {
		
//		Map<String,Integer> numInfo = IntStream.range(0, players.length).boxed()
//				.collect(Collectors.toMap(i->players[i], Function.identity()));

		Map<String,Integer> numInfo = new HashMap<String, Integer>();
		for (int i = 0; i < players.length; i++) {
			numInfo.put(players[i], i);
		}
		
		
		
		for(String str : callings) {
			int num = numInfo.get(str);
			String tempStr = players[num-1];
			players[num-1] = players[num];
			players[num] = tempStr;
			
			numInfo.put(players[num-1], num-1);
			numInfo.put(players[num], num);
			
		}
		return players;
	}
}



//
////이러면 되긴 하는데 느림
//class Solution {
//    public String[] solution(String[] players, String[] callings) {
//        
//    	int[] rank = IntStream.range(0, players.length).toArray();
////    	int[] rank = new int[players.length];
////    	for(int i = 0 ; i < players.length ; i++) rank[i] = i;
//        
//        
//        Map<String, Integer> numInfo = IntStream.range(0, players.length).boxed()
//        		.collect(Collectors.toMap(i->players[i], Function.identity()));
////        Map<String, Integer> numInfo = new HashMap<>();
////		for(int i = 0 ; i < players.length ; i++)
////			numInfo.put(players[i], i);
//
//		for(String str : callings)
//			fnc(rank, numInfo.get(str));
//		
//        
//		String[] answer = new String[players.length];
//		for(int i = 0 ; i < rank.length ; i++) {
//			answer[i] = players[rank[i]];
//		}
//		
//        return answer;
//    }
//    
//    public void fnc(int[] rank, int calling) {
//		for(int i = 0 ; i < rank.length ; i++) {
//			if(rank[i] == calling) {
//				int tempInt = rank[i];
//				rank[i] = rank[i-1];
//				rank[i-1] = tempInt;
//				break;
//			}
//		}
//	}
//}




//
//
////이러면 시간초과
//class Solution {
//	public String[] solution(String[] players, String[] callings) {
//		
//		for(String str : callings) {
//			fnc(players, str);
//		}
//		return players;
//	}
//	
//	public void fnc(String[] players, String calling) {
//		for(int i = 0 ; i < players.length ; i++) {
//			if(players[i].equalsIgnoreCase(calling)) {
//				String tempStr = players[i];
//				players[i] = players[i-1];
//				players[i-1] = tempStr;
//				break;
//			}
//		}
//	}
//}
//
