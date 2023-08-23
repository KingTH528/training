package school.programmers.l1.wallpaper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


// https://school.programmers.co.kr/learn/courses/30/lessons/92334
public class Tester {
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo",
							"apeach frodo",
							"frodo neo",
							"muzi neo",
							"apeach muzi"};
		int k = 2;
		
		
		
		int[] answer = new Solution().solution(id_list, report, k);
		System.out.println("\n========== 답 ==========\n");
		for(int i : answer) {
			System.out.print(i + ", ");
		}
		
		
	}
}



class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
    	
//    	Map<String, Integer> member = IntStream.range(0, id_list.length).boxed()
//    			.collect(Collectors.toMap(i->id_list[i], Function.identity()));
//    	
    	Map<String, Integer> member = new HashMap<String, Integer>();
    	for(int i = 0 ; i < id_list.length ; i++) {
    		member.put(id_list[i], i);
    	}
    	
    	Map<String, HashSet<String>> id_map = new HashMap<String, HashSet<String>>();
    	for(String str : id_list) {
    		id_map.put(str, null);
    	}
    	
    	for(String str : report) {
    		String[] strArr = str.split(" ");
    		HashSet<String> tempSet = new HashSet<String>();
    		if(id_map.get(strArr[1]) != null) {
    			tempSet = id_map.get(strArr[1]);
    		}
    		tempSet.add(strArr[0]);
    		id_map.put(strArr[1], tempSet);
    	}
    	
    	int[] answer = new int[id_list.length];
    	for(int i = 0 ; i < answer.length ; i++) answer[i] = 0;
    	
    	for(int i = 0 ; i < answer.length ; i++) {
    		if(id_map.get(id_list[i]) != null && id_map.get(id_list[i]).size() >= k) {
				for(String str : id_map.get(id_list[i])) {
					answer[member.get(str)] ++;
				}
    		}
    	}
    	
        return answer;
    }
}