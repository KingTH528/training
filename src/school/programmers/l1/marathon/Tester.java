package school.programmers.l1.marathon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//처음에 


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

//
////남에꺼 보고 찾는부분만 바이너리로 변경
//class Solution {
//    public String solution(String[] participant, String[] completion) {
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//        int s = 0;
//        int e = completion.length-1;
//        
//        
//        // 다르면 앞쪽(e 변화) 같으면 뒤쪽(s 변화),  *두 칸 나눴을 때 
//        while(s <= e) {
//        	int tempI = ((s+e)/2);
//        	if(participant[tempI].equalsIgnoreCase(completion[tempI])) {
//        		s = tempI+1;
//        	}else {
//        		e = tempI-1;
//        	}
//        }
//        
//        if(e==0) {
//        	return participant[completion.length-1];
//        }
//        
//        return participant[s];
//    }
//}



//이게 원본
class Solution {
    public String solution(String[] participant, String[] completion) {
    	Map<String, Integer> participantMap = new HashMap<String, Integer>();
    	for(String str : participant) {
    		if(!participantMap.containsKey(str)) {
    			participantMap.put(str, 1);
    		}else {
    			int num = participantMap.get(str) +1;
    			participantMap.replace(str, num);
    		}
    	}
//    	Map<String, Integer> participantMap = IntStream.range(0, participant.length).boxed()
//    		    .collect(Collectors.toMap(i -> participant[i], i -> 1, (existing, replacement) -> existing + 1));
    	
    	for(String str : completion) {
    		int num = participantMap.get(str) -1;
    		if(num==0) {
    			participantMap.remove(str);
    		}else {
    			participantMap.replace(str, num);
    		}
    	}
        return participantMap.keySet().toString().substring(1, participantMap.keySet().toString().length()-1);
    }
}


//처음에 문자열로 바꾼다음 통과한 이름 문자열에서 제거하려고 했느데 ( testtest, test ) 이런경우 불가능해서 안됨!!
//class Solution {
//	public String solution(String[] participant, String[] completion) {
//		
//		StringBuilder sb = new StringBuilder();
//		for(int i = 0 ; i < participant.length ; i++) {
//			sb.append(participant[i]);
//			sb.append("@");
//		}
//		String answer = sb.toString();
//		
//		for(String str : completion) {
//			answer = answer.replace(str+"@", "@");
//			answer = answer.replace("@"+str, "@");
//		}
//		
//		System.out.println(answer);
//		answer = answer.replaceAll("@", "");
//		return answer;
//	}
//}




