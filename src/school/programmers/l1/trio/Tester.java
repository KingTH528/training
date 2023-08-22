package school.programmers.l1.trio;

public class Tester {
	public static void main(String[] args) {
//		int[] intArr = {0,0,0}; //1
		int[] intArr = {-2, 3, 0, 2, -5}; //2
//		int[] intArr = {-3, -2, -1, 0, 1, 2, 3};  //5
//		int[] intArr = {-1, 1, -1, 1};  //0
		
		System.out.println("==============================\n답 : " + new Solution().solution(intArr));
		
	}
}

class Solution {
	
	int cnt = 0;
	
	public int solution(int[] number) {
		fnc(number, 3, 0, 0, 0);
		
		return cnt;
	}
	
	
	// cnt를 리턴
	public int fnc(int[] number, int n, int total, int sum, int start) {
		
		for(int i = start ; i < number.length+1-n ; i++) {
			int thisSum = sum+number[i];
//			System.out.println("합 : " + thisSum);
			if(n <= 1) {
				System.out.println("마지막 포문" + n + ", " + i + " --> " + number[i]);
				if(thisSum == total) {
					
					cnt++;
				}else {
					
				}
			}else {
				System.out.println(n + ", " + i + " --> " + number[i]);
				fnc(number, n-1, cnt, sum, i+1);
			}
		}
		
		
		
		
		
		
		return cnt;
	}
	
	
}




//class Solution {
//    public int solution(int[] number) {
//        int answer = 0;
//        
//        for(int i = 0 ; i < number.length-2 ; i++) {
//        	for(int j = i+1 ; j < number.length-1 ; j++ ) {
//        		int tempA = number[i]+number[j];
//        		for(int k = j+1 ; k < number.length ; k++) {
//        			if(tempA == -number[k]) {
//        				answer++;
//        			}
//        		}
//        	}
//        }
//        
//        return answer;
//    }
//}



