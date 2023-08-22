package school.programmers.l1.personalinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tester2 {
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
		
		int[] sdvf = new Solution2().solution(today, terms, privacies);

		for(int i : sdvf) {
			System.out.print(i + " ");
		}
	}
}

//고수의 소스
class Solution2 {
    public int[] solution(String today, String[] terms, String[] privacies) {
    	
    	//답 넣을 리스트
        List<Integer> answer = new ArrayList<>();
        
        //term정보 정리
        Map<String, Integer> termMap = new HashMap<>();
        
        //스트링 날짜를 전부 일 단위 int로 변경( 천재!!!! )
        int date = getDate(today);

        for (String s : terms) {
            String[] term = s.split(" ");

            termMap.put(term[0], Integer.parseInt(term[1]) * 28);
        }
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            // 등록정보 + term정보 <= 지금
            if (getDate(privacy[0]) + (termMap.get(privacy[1])) <= date) {
                answer.add(i + 1);
            }
        }
        
        int[] an = new int[answer.size()];
        for(int i = 0 ; i< an.length ; i++) {
        	an[i] = answer.get(i);
        }
        
        return an;
    }

    private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}


