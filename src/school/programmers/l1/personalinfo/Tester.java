package school.programmers.l1.personalinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tester {
	public static void main(String[] args) {
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", 
							  "2021.07.01 B", 
							  "2022.02.19 C", 
							  "2022.02.20 C"};
		
//		String today = "2020.01.01";
//		String[] terms = {"Z 3", "D 5"};
//		String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
		
		int[] sdvf = new Solution().solution(today, terms, privacies);

		for(int i : sdvf) {
			System.out.print(i + " ");
		}
	}
}

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
    	
    	//데이터 정리 ( 오늘 날짜(인티저 어레이), 기간(키 벨류), 등록일 )
		Integer[] todayArr = dateConvert(today);
		Map<String, Integer> policy = new HashMap<String, Integer>();
		List<Map<String, Object>> regList = new ArrayList<Map<String,Object>>();
		
        for(String str : terms) {
        	String[] tempStr = str.split(" ");
        	policy.put(tempStr[0], Integer.valueOf(tempStr[1]) );
        }
        for(String str : privacies) {
        	Map<String, Object> info = new HashMap<String, Object>();
        	String[] infoStr = str.split(" ");
        	info.put("regDate", dateConvert(infoStr[0]));
        	info.put("policy", infoStr[1]);
        	regList.add(info);
        }
        
        //privacies마다 terms로 만료일 확인 후 오늘 날짜랑 비교
        List<Integer> tempAnswer = new ArrayList<Integer>();
        for(int i = 0 ; i < regList.size() ; i++) {
        	Integer[] tempDate = prev(
        							  (Integer[])(regList.get(i).get("regDate")), 
        							   policy.get(regList.get(i).get("policy"))  );
        	if(compare(todayArr, tempDate)) {
        		tempAnswer.add(i);
        	}
        	
        }
        
        //배열로 정리
        int[] answer = new int[tempAnswer.size()];
        for(int i = 0 ; i< answer.length ; i++) {
        	answer[i] = tempAnswer.get(i)+1;
        }
        return answer;
    }
    
    
    //날짜 integer배열로 변환
    public Integer[] dateConvert(String date) {
    	String[] StringArr = date.split("\\.");
    	Integer[] intArr = new Integer[StringArr.length];
		for(int i = 0 ; i<intArr.length ; i++) {
			intArr[i] = Integer.valueOf(StringArr[i]);
		}
    	return intArr;
	}
    
    public Integer[] prev(Integer[] date, int term) {
    	date[1] += term;
    	date[2] -= 1;    	
		
    	if(date[2] == 0) {
    		date[2] = 28;
    		date[1] -= 1;
    	}
    	
		if(date[1] > 12) {
			date[0] += date[1]/12;
			date[1] = date[1]%12;
		}

		if(date[1]==0) {
			date[0]--;
			date[1]=12;
		}

    	return date;
	}
    
    // 두 날짜 비교(앞이 크면 true / 작거나 같으면 false)
    public boolean compare(Integer[] now, Integer[] reg) {
    	
    	if(now[0]>reg[0]) {
    		return true;
    	}else if(now[0]<reg[0]){
    		return false;
    	}else if(now[1]>reg[1]) {
    		return true;
    	}else if(now[1]<reg[1]) {
    		return false;
    	}else if(now[2]>reg[2]) {
    		return true;
    	}else if(now[2]<reg[2]) {
    		return false;
    	}
    	//완전 같은때
    	return false;
	}
}





