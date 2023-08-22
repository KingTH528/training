package school.programmers.l1.trio;

public class Tester {
	public static void main(String[] args) {
//		int[] intArr = {0,0,0}; //1
//		int[] intArr = {-2, 3, 0, 2, -5}; //2
		int[] intArr = {-3, -2, -1, 0, 1, 2, 3};  //5
//		int[] intArr = {-1, 1, -1, 1};  //0
		
		System.out.println("==============================\n답 : " + new Solution().solution(intArr));
		
	}
}

class Solution {
	
	public int solution(int[] number) {
		return fnc(number, 3, 0, 0, 0);
	}
	
	public int fnc(int[] number, int n, int total, int sum, int start) {
		int cnt = 0;
		for(int i = start ; i < number.length+1-n ; i++) {
			int thisSum = sum+number[i];
			if(n <= 1) {
				if(thisSum == total) {
					cnt++;
				}
			}else {
				cnt += fnc(number, n-1, total, thisSum, i+1);
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



