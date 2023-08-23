package school.programmers.l1.marathon;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42576
public class Tester {
	public static void main(String[] args) {
		
		
//		// 결과 : "leo"
//		String[] participant = {"leo", "kiki", "eden"};
//		String[] completion = {"eden", "kiki"};
		
//		// 결과 : "vinko"
//		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
//		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		
		// 결과 : "mislav"
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		
		
		
		String answer = new Solution().solution(participant, completion);
		System.out.println("\n========== 답 ==========\n" + answer);
		
	}
}


class Solution {
    public String solution(String[] participant, String[] completion) {
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0 ; i < participant.length ; i++) {
    		sb.append(participant[i]);
    		sb.append("@");
    	}
    	String answer = sb.toString();
    	
    	for(String str : completion) {
    		answer = answer.replace(str+"@", "@");
    		answer = answer.replace("@"+str, "@");
    	}
    	
    	System.out.println(answer);
    	answer = answer.replaceAll("@", "");
        return answer;
    }
}




