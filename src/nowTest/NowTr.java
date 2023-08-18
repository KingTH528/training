package nowTest;

import java.util.*;

public class NowTr {

	public static void main(String[] args) {
		String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
		//                   aya+ye  (그냥 불가) ye+ye  ye+ma+woo   aya+aya+a(중복&a라 불가)
		System.out.println("답은 " + solution(babbling));
		
	}
    public static int solution(String[] babbling) {
        int answer = 0;
        
        String babblingStr = Arrays.toString(babbling);
        babblingStr = babblingStr.substring(1, babblingStr.length()-1);
        babblingStr = babblingStr.replaceAll("ayaaya|yeye|woowoo|mama", "-+-");
        babblingStr = babblingStr.replaceAll("aya|ye|woo|ma", "@_@");
        babblingStr = babblingStr.replaceAll("@_@", "");
        
        for(String tempStr : babblingStr.split(", ")) {
        	if(tempStr.equalsIgnoreCase("") || tempStr == null || tempStr.isEmpty()) answer++;
        }
        return answer;
    }
}
