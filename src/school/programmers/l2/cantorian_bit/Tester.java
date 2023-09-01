package school.programmers.l2.cantorian_bit;




// https://school.programmers.co.kr/learn/courses/30/lessons/148652
public class Tester {
	public static void main(String[] args) {

		// 1 -> 11011
		// 0 -> 00000AAA
		// 한칸 -> 5칸
		// n번째 비트열 -> 전체: 5^n / 1: 4^n
		
		// 결과 : 8
		// 11011, 11011, 00000, 11011, 11011
		// 11011, 11011, 00000, 11011, 11011 / 11011, 11011, 00000, 11011, 11011 / 00000, 00000, 0    0000, 00000, 00000 / 11011, 11011, 00000, 1    1011, 11011 / 11011, 11011, 00000, 11011, 11011
		// 12345, 67890, 12345, 67890, 12345 / 67890, 12345, 67890, 12345, 67890 / 12345, 67890, 1    2345, 67890, 12345 / 67890, 12345, 67890, 1    2345, 67890 / 12345, 67890, 12345, 67890, 12345
		// 0          1             2              3             4             5              6                 7              8             9                 0              1             2
		long n = 2;
		long l = 62;
		long r = 91;
		
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
    	System.out.println("-----------< " + a + " >-----------");
    	
    	int[] bit = {1,1,0,1,1};
    	long answer = 0;
    	int preIndex = -1;
    	int nowIndex = 1;
        int preN = -1;
        int newN = -1;
        long cntN = 1;  // 이건 1~4까지 가능
        int eZero = -1;
    	
        // 갯수기준으로 a 까지의 5의 거듭제곱(갯수)중 가장 큰 값 ( 갯수가 5미만이 될 때까지만 )
        while( nowIndex < a-3 ) {
        	// 이번 가장 앞그룹의 수준 확인
        	for(int i = 1 ; Math.pow(5, i) <= a-nowIndex ; i++) newN = i;
        	
        	// 이전/현재 위치 갱신
        	preIndex = nowIndex;
        	nowIndex += Math.pow(5, newN);
        	
        	// 이전 수준이랑 같으면 cntN++ 아니면 0
        	if(preN == newN) cntN++;
        	else cntN=1;

        	// 0영역 시작하는데 이전보다 수준이 낮아지면 종료!!!
        	if(cntN == 2 && preN != newN) break;
        	System.out.println("preN: " + preN + " / newN: " + newN);
        	
        	
        	
        	
        	// 이전 수준이랑 이번수준이 1번 같았으면 앞으로 0이 계속나옴 (이전 위치부터A+5^이전수준 까지)
        	if(cntN == 2) {
        		// 0이나오는 마지막 위치 저장
        		eZero = (int) (preIndex + Math.pow(5, preN))-1;
        		System.out.println("-->eZero: " + eZero);
        		
        		// 0영역이 a를 벗어나면 종료 || 0영역 안에서 수준이 낮아지면 종료
        		if(eZero >= a) break;
        	}
        	
        	// 이전에 같더라도 0영역 아니면 1갯수 추가
        	if(cntN!=3) answer +=  Math.pow(4, newN);
        	
        	System.out.println("temp_answer: " + answer + "(eZero: " + eZero + ")");
        	
        	// 이번수준 정보 저장
        	preN = newN;
        	System.out.println("a-nowIndex: " + (a-nowIndex) + " / preIndex: " + preIndex + " / nowIndex: " + nowIndex + " / cntN: " + cntN);
        	System.out.println();
        }
        
        System.out.println("나머지: " + (a-nowIndex));
        if(cntN!=1) {
        	for(int i = 0 ; i <= a-nowIndex ; i++) {
        		answer += bit[i];
        	}
        	System.out.println();
        }
        System.out.println("answer: " + answer);
    	return answer;
    }
}