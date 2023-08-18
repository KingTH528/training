package school.programmers.l1.babbling;

import java.util.Arrays;

public class Babbling {

	public static void main(String[] args) {
		String[] babbling = {"aya", "ye", "woo", "ma"};
//		String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
		//                   aya+ye  (그냥 불가) ye+ye  ye+ma+woo   aya+aya+a(중복&a라 불가)
		System.out.println("답은 " + solution(babbling));
		
	}
	
	
    public static int solution(String[] babbling) {
        int answer = 0;	
        
        //스트링으로 만들어서 정리 후 다시 배열로...
        String babblingStr = Arrays.toString(babbling);
        babblingStr = babblingStr.substring(1, babblingStr.length()-1);
        babblingStr = babblingStr.replaceAll("ayaaya|yeye|woowoo|mama", "2");
        babblingStr = babblingStr.replaceAll("aya|ye|woo|ma", "1");
        babblingStr = babblingStr.replaceAll("1", "");
        String[] result = babblingStr.split(", ");

        //갯수 세기
        answer = babbling.length-result.length;
        for(String tempStr : result) {
        	if(tempStr.isEmpty()) answer++;
        }
        return answer;
    }
    
    
    public static int solution0(String[] babbling) {
        int answer = 0;
        String[] strArr = {"aya", "ye", "woo", "ma"};
        for(int i = 0 ; i <babbling.length ; i++) {
        	String prevStr = "";
        	boolean bool = false;
        	for(int j = 0 ; j < strArr.length ; j++) {
        		if(prevStr.equalsIgnoreCase(strArr[j]))continue;
        		
        		if(babbling[i].startsWith(strArr[j])) {
        			babbling[i] = babbling[i].replaceFirst(strArr[j], "");
        			prevStr = strArr[j];
        			bool = true;
        		}
        		
        		if(babbling[i].length()==0) {
        			answer++;
        			break;
        		}
        		if(j==strArr.length-1) {
        			if(!bool){
        				break;
        			}else {
        				j=-1;
        				bool = false;
        			}
        		}
        	}
        }
        return answer;
    }
}
