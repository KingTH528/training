package school.programmers.l2.kakao_picture;




// https://school.programmers.co.kr/learn/courses/30/lessons/1835
public class Tester {
	public static void main(String[] args) {

		// 결과 : 3648
		// n = 2
		// String[] data = ["N~F=0", "R~T>2"]
		
		// 결과 : 0
		// n = 2
		// String[] data = ["M~C<2", "C~M>1"]
		long n = 2;
		String[] data  = {"N~F=0", "R~T>2"};
		
		long answer = new Solution().solution(n, data);
		System.out.println("\n========== 답 ==========\n" + answer);
		
	}
}

class Solution {
    public int solution(long n, String[] data) {
        int answer = 0;
        return answer;
    }
}