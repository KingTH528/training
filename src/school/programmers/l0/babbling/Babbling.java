package school.programmers.l0.babbling;

public class Babbling {

	public static void main(String[] args) {
//		String[] babbling = {"aya", "yee", "u", "maa", "wyeoo"};
		String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
		System.out.println("답은 " + new Solution().solution(babbling));
		
	}
}

class Solution {
    public int solution(String[] babbling) {
    	String[] we = {"aya", "ye", "woo", "ma"};
    	int answer = 0;
    	
        for(String str : babbling) {
        	for(String str2 : we) {
        		str = str.replace(str2, "@");
        	}
        	str = str.replaceAll("@", "");
        	if(str.isEmpty() || str == null) {
        		answer++;
        	}
        }
        return answer;
    }
}