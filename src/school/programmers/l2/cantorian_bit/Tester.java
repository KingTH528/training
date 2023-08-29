package school.programmers.l2.cantorian_bit;




// https://school.programmers.co.kr/learn/courses/30/lessons/148652
public class Tester {
	public static void main(String[] args) {

		// 1 -> 11011
		// 0 -> 00000
		// 한칸 -> 5칸
		
		
		
		// 결과 : 8
		// 110  11, 11011, 00000, 11  011, 11011
		// 123  45, 67890, 12345, 67  890, 12345
		// n번째 비트열의 l번째 칸~r번째 칸사이 1갯수
		int n = 1;
		long l = 4;
		long r = 17;
		
		int answer = new Solution().solution(n, l ,r);
		System.out.println("\n==========  ==========\n" + answer);
		
		// n=1부터만 생각해도 됨
		// 1인 칸부터 n번째 비트열 -> 1: 4^n개, 2: 5^n-4^n개
		
		// 04~17은 n-1에서 1(4번째)~4(2번째)
		// 11~17은 n-1에서 3(1번째)~4(2번째)
		// l~r은   n-1에서 l/5+1()
		
		// 무조건 4-4-0-4-4 - 4-4-0-4-4 순환구조
		// l,r이 있는 칸이 4-4-0-4-4 중 어디쯤인지 확인하고
		// 첫번재 4의 4번째 칸, 3번재 4의 2번째 칸인걸 확인
		
		
		
	}
}


class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        
        return answer;
    }
}