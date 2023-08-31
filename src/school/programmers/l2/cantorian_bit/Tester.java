package school.programmers.l2.cantorian_bit;




// https://school.programmers.co.kr/learn/courses/30/lessons/148652
public class Tester {
	public static void main(String[] args) {

		// 1 -> 11011
		// 0 -> 00000AAA
		// 한칸 -> 5칸
		// n번째 비트열 -> 전체: 5^n / 1: 4^n
		
		// 결과 : 8
		// 110  11, 11011, 00000, 11  011, 11011
		// 123  45, 67890, 12345, 67  890, 12345
		long n = 2;
		long l = 4;
		long r = 17;
		
		long answer = new Solution().solution(n, l ,r);
		System.out.println("\n==========  ==========\n" + answer);
		
	}
}


class Solution {
    public long solution(long n, long l, long r) {
        return (calculator(r)-calculator(l-1));
    }
    
    // 첫번째칸 ~ a번째칸 까지의 1의 갯수( 갯수 = e-s+1 )
    public long calculator(long a) {
    	System.out.println("-----------");
    	// int[][] nArray = new long [21][2];
    	// 같은 수준 두번이면 이후 5^n칸은 전부 0!!!!
    	// 만약 이후 5^n칸이 a를 넘거나 a면 완전 스탑!!!
    	// 안넘으면 다음 1부터 시작!!!
    	//
    	// 만약 세번이면 1갯수 안세고 다음칸
    	
    	int[] bit = {1,1,0,1,1};
    	long answer = 0;
    	long nowIndex = 1;
        long preN = 1;
        long newN = -1;
        long cntN = 0;
    	
        // 갯수기준으로 a 까지의 5의 거듭제곱(갯수)중 가장 큰 값 ( 갯수가 5미만이 될 때까지만 )
        while( nowIndex < a-5 ) {
        	
        	long lengt = (int) (a - nowIndex +1);
        	
        	for(int i = 1 ; Math.pow(5, i) < a-nowIndex ; i++) newN = i;
        	System.out.println("preN: " + preN + " / newN: " + newN);
        	if(preN == newN) cntN++;
        	else cntN = 0;
        	
        	nowIndex += Math.pow(5, newN);  // 현재 위치 갱신
        	
        	// 만약 조상이 0이아니면 (= 이번이 세번째 같은 newN이 아니면)
        	// 
        	System.out.println("cntN : " + cntN);
        	if(cntN!=3) {
        		answer +=  Math.pow(4, newN);        // 1갯수 추가
        	}
        	preN = newN;                         // 현재 수준 -> 이전 수준으로 변경
        	
        	
        	
        }
        
        for(int i = 0 ; i <= a-nowIndex ; i++) {
        	answer += bit[i];
        }
        System.out.println(answer);
    	return answer;
    }
}