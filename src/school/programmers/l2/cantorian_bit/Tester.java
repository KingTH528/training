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
		int n = 3;
		long l = 51;
		long r = 75;
		
		long answer = new Solution().solution(n, l ,r);
		System.out.println("\n========== 답 ==========\n" + answer);
		
	}
}



//// 이게 내껀데
//class Solution {
//    public long solution(int n, long l, long r) {
//        return (calculator(r)-calculator(l-1));
//    }
//    
//    public int calculator(long a) {
//    	int[] bit = {1,1,0,1,1};
//    	int answer = 0;
//    	long nowIndex = 1;
//        int preN = -1;
//        int newN = -1;
//        long cntN = 1;
//        int eZero = -1;
//    	
//        while( nowIndex < a-3 ) {
//        	for(int i = 1 ; Math.pow(5, i) <= a-nowIndex ; i++) newN = i;
//        	
//        	if(cntN == 2 && preN != newN) break;
//
//        	nowIndex += Math.pow(5, newN);
//        	
//        	if(preN == newN) cntN++;
//        	else cntN=1;
//
//        	if(cntN == 2) {
//        		eZero = (int) (nowIndex + Math.pow(5, preN))-1;
//        		if(eZero >= a) {
//        			answer +=  Math.pow(4, newN);
//        			break;
//        		}
//        	}
//        	
//        	if(cntN!=3) answer +=  Math.pow(4, newN);
//        	preN = newN;
//        }
//    	for(int i = 0 ; i <= a-nowIndex ; i++) {
//    		 if(cntN==2) break;
//    		answer += bit[i];
//    	}
//    	return answer;
//    }
//}


//// 이게 내꺼랑 같은방식이면서 더 좋은 소스(남에꺼)
//class Solution {
//    int[] iArray = {1,1,0,1};
//    private int bits(long index){
//        int answer = 0,  base = 1;
//        
//        if(index < 5){
//            for(int i = 0; i < index; i++) if(iArray[i]==1) answer++;
//            return answer;
//        }
//        while(Math.pow(5,base+1)<index) base++;
//        int noO = (int)Math.pow(4,base);
//        int noI = (int)Math.pow(5,base);
//        int section = (int)(index / noI);
//        int remainder = (int)(index % noI);
//        answer = section * noO;
//        if(section >= 3) answer -= noO;
//        if(section == 2) return answer;
//        else return answer + bits(remainder);
//    }
//    public long solution(int n, long l, long r) {
//        return bits(r)-bits(l-1);
//    }
//}


// 엄청 느리긴 한데 문제를 엄청 단순하게 바꿈, n이 정확히 정의되야함(남에꺼)
class Solution {
    public int solution(int n, long l, long r) {
        long answer = r-l+1;
        for(long i=l-1;i<=r-1;i++){
            for(int j=0;j<n;j++){
                if((i/(int)Math.pow(5,j))%5==2){
                    answer--;
                    break;
                }
            }
        }

        return (int) answer;
    }
}


