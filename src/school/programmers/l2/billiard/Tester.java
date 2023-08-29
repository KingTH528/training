package school.programmers.l2.billiard;

// https://school.programmers.co.kr/learn/courses/30/lessons/169198
public class Tester {
	public static void main(String[] args) {
		
		// 결과 : 52, 37, 116
		int m = 10;
		int n = 10;
		int startX = 1;
		int startY = 5;
		int[][] balls = {{2, 5},{8, 5},{5, 2},{5, 8},{3, 8},{2,7},{7,3}};
		
		int[] answer = new Solution().solution(m, n, startX, startY, balls);
		System.out.println("\n========== 답 ==========\n");
		for(int i : answer) {
			System.out.print(i + ", ");
		}
	}
}

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int [balls.length];
        
        for(int i = 0 ; i < balls.length ; i++) {
        	// 왼쪽 기준
        	int ansL = (balls[i][0]+startX)*(balls[i][0]+startX) + (balls[i][1]-startY)*(balls[i][1]-startY);
        	// 위쪽 기준
        	int ansU = (2*n-balls[i][1]-startY)*(2*n-balls[i][1]-startY) + (balls[i][0]-startX)*(balls[i][0]-startX);
        	// 오른쪽 기준
        	int ansR = (2*m-balls[i][0]-startX)*(2*m-balls[i][0]-startX) + (balls[i][1]-startY)*(balls[i][1]-startY);
        	// 아래쪽 기준
        	int ansD = (balls[i][1]+startY)*(balls[i][1]+startY) + (balls[i][0]-startX)*(balls[i][0]-startX);
        	
        	// 경로 가릴 때
        	if(startX == balls[i][0]) {
        		     if(startY < balls[i][1]) ansU = Integer.MAX_VALUE;
        		else if(startY > balls[i][1]) ansD = Integer.MAX_VALUE;
        	}else if(startY == balls[i][1]) {
        		     if(startX < balls[i][0]) ansR = Integer.MAX_VALUE;
        		else if(startX > balls[i][0]) ansL = Integer.MAX_VALUE;
        	}
        	
        	int ansAB = Math.min(ansL, ansU);
        	int ansCD = Math.min(ansR, ansD);
        	answer[i] = Math.min(ansAB, ansCD);
        }
        
        return answer;
    }
}


