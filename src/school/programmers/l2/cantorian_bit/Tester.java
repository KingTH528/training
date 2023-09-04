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
		System.out.println("\n========== 답 ==========\n" + answer);
		
	}
}



// 내께 제일빠름
class Solution {
    public long solution(long n, long l, long r) {
        return (calculator(r)-calculator(l-1));
    }
    
    public long calculator(long a) {
    	int[] bit = {1,1,0,1,1};
    	long answer = 0;
    	long nowIndex = 1;
        int preN = -1;
        int newN = -1;
        long cntN = 1;
        int eZero = -1;
    	
        while( nowIndex < a-3 ) {
        	for(int i = 1 ; Math.pow(5, i) <= a-nowIndex ; i++) newN = i;
        	
        	if(cntN == 2 && preN != newN) break;

        	nowIndex += Math.pow(5, newN);
        	
        	if(preN == newN) cntN++;
        	else cntN=1;

        	if(cntN == 2) {
        		eZero = (int) (nowIndex + Math.pow(5, preN))-1;
        		if(eZero >= a) {
        			answer +=  Math.pow(4, newN);
        			break;
        		}
        	}
        	
        	if(cntN!=3) answer +=  Math.pow(4, newN);
        	preN = newN;
        }
        
        if(cntN!=2) {
        	for(int i = 0 ; i <= a-nowIndex ; i++) {
        		answer += bit[i];
        	}
        }
    	return answer;
    }
}