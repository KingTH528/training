package school.programmers.l2.kakao_picture;




// https://school.programmers.co.kr/learn/courses/30/lessons/1835
public class Tester {
	public static void main(String[] args) {

		// 사람은 8명 {A, C, F, J, M, N, R, T}
		// 조건은 3종류 =, <, >
		// 조건 뒤 숫자는 +1을 해줘야 간격이 됨(인덱스 간격이 1~7 사이)
		// =1 이면 인덱스 차이가 2
		// <1 이면 인넥스 차이가 1이상
		
		// 결과 : 3648
		// n = 2
		// String[] data = ["N~F=0", "R~T>2"]
		
		// 결과 : 0
		// n = 2
		// String[] data = ["M~C<2", "C~M>1"]
		long n = 2;
		String[] data  = {"N~F=0", "R~T>2"};
//		long answer = new Solution().solution(n, data);
//		System.out.println("\n========== 답 ==========\n" + answer);
		
	}
//}

//class Solution {
//    public int solution(long n, String[] data) {
//    	int maxNoA = 40320;
//        int answer = 0;
//        
//        // {A, C, F, J, M, N, R, T}
//        int[] policy = 
//        
//        
//        
//        
//        
////        
////        
////        
////        // --------- 조건이 1개일 경우(n=1) --------- //
////        
////        // '='일 경우 -> 두개의 경우의수*나머지 경우의 수
////        if(data[0].charAt(3)=='=') {
////        	Integer thisNum = new Integer(String.valueOf(data[0].charAt(4)));
////        	int tempAnswer = 0;
////        	int i = thisNum;
////        	int tempA = 2*(7-i);
////        	tempAnswer = tempA * factorial(6);
////        	answer += tempAnswer;
////        }
////        
////        // '<'일 경우 -> 해당 범위를 고려한 경우의 수*나머지 경우의 수
////        if(data[0].charAt(3)=='<') {
////        	Integer thisNum = new Integer(String.valueOf(data[0].charAt(4)));
////        	int tempAnswer = 0;
////        	for(int i = 0 ; i < thisNum ; i++) {
////            	int tempA = 2*(7-i);
////            	tempAnswer = tempA * factorial(6);
////        	}
////        	answer += tempAnswer;
////        }
////        
////        // '>'일 경우 -> 해당 범위를 고려한 경우의 수*나머지 경우의 수
////        if(data[0].charAt(3)=='>') {
////        	Integer thisNum = new Integer(String.valueOf(data[0].charAt(4)));
////        	int tempAnswer = 0;
////        	for(int i = 6 ; i < thisNum ; i--) {
////        		int tempA = 2*(7-i);
////        		tempAnswer = tempA * factorial(6);
////        	}
////        	answer += tempAnswer;
////        }
//        
//        
//        return answer;
//    }
    
    public int factorial(int n) {
    	int answer = 1;
    	for(int i = n ; i>1 ; i--) {
    		answer *= i;
    	}
    	return answer;
    }
}