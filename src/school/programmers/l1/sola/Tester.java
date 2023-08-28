package school.programmers.l1.sola;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//처음에 


// https://school.programmers.co.kr/learn/courses/30/lessons/86052
public class Tester {
	public static void main(String[] args) {
		
		// 결과 : 16
		String[] grid = {"SL","LR"};
		
//		// 결과 : 1,1,1,1	
//		String[] grid = {"S"};
		
//		// 결과 : 4,4
//		String[] grid = {"R","R"};
		
		int[] answer = new Solution().solution(grid);
		System.out.println("\n========== 답 ==========\n");
		for(int i : answer) {
			System.out.print(i + ", ");
		}
	}
}

	//================== 문제 ==================//
	// 1. 빛의 시작 위치 = 그리드의 가장자리
	// 2. 빛은 가장자리에서 반대쪽으로 순환
	// 3. 하나의 사이클이 완성됬는지는 처음의 위치&방향을 만났을 때
	// 4. 중복된 사이클인지는 처음위치랑은 다른데 이미 누가 지나온 위치&방향일때
	// 5. 인덱스 범위 -> ( 0, 0 ) ~ ( grid[0].length()-1, grid.length-1 )
	// 
	// 1. 각 위치별 정보 -> x, y, 꺽는방향, 들어온 방향
	// 1-1. 또는 들어온방향은 따로 배열로 생성
	// 2. 각 빛(프로세스) 별 정보 -> 처음 위치, 처음 방향
	
	
class Solution {
    public int[] solution(String[] grid) {
    	List<Integer> cycleList = new ArrayList<Integer>();
    	
    	// 방향 정리  ->  s만나면 direction += 0;  /  r만나면 direction += 1; (4 -> 0)  /  l만나면 direction += -1; (-1 -> 3) 
    	int direction = -1;
    	int[] dX = {0,1,0,-1};
    	int[] dY = {1,0,-1,0};
    	int cycleLength = 0;
    	
    	// 현재 위치 저장
    	int[] xy = {0,0};
    	
    	// 노드별 정보 정리
    	int[][] nodeInfo = new int[grid[0].length()][grid.length];
    	boolean[][][] check = new boolean[grid[0].length()][grid.length][4];  // true면 이미 지나감
    	
    	for(int i = 0 ; i < grid[0].length() ; i++) {
    		for(int j = 0 ; j < grid.length ; j++) {
    			if(grid[i].charAt(j)=='S')      nodeInfo[i][j] = 0;
    			else if(grid[i].charAt(j)=='R') nodeInfo[i][j] = 1;
    			else if(grid[i].charAt(j)=='L') nodeInfo[i][j] = -1;
    		}
    	}
    	
    	
    	
    	
    	// 1. 처음 들어오는 빛 정보 저장(x, y, 방향)
    	// 사이클 길이 0부터 시작(들어올때 +1) 임시로 cycleLength 표현
    	xy[0] = 0;
    	xy[1] = 0;
    	direction = 2;
    	int[] startInfo = {xy[0], xy[1], direction};  // 나중에 사이클 판단할때 사용
    	
    	
    	//2. 이전에 쓴적없는 거면 이번에 꺾는 방향 적용
    	if(!check[xy[0]] [xy[1]] [direction]) {
    		// 이번 칸의 nodeInfo값dmf 방향에 적용
    		direction += nodeInfo[xy[0]][xy[1]];
    		if(direction < 0) direction = 3;
    		else if(direction > 3) direction = 0;
    	}else {
    		
    	} 
    	
    	//3. 해당 방향으로 이동
    	xy[0] += dX[direction];
    	xy[1] += dX[direction];
    	if(xy[0] < 0) xy[0] = nodeInfo[0].length;
    	else if(xy[1] < 0) xy[1] = nodeInfo.length;
    	else if(xy[0] > nodeInfo[0].length) xy[0] = 0;
    	else if(xy[1] > nodeInfo.length) xy[1] = 0;
    	
    	//4. 이동 직후 cycleLength++;
    	cycleLength++; //j로 대체 가능
    	
    	
    	
    	//===================================================================//
    	
    	// 이전에 쓴적없는 거면 이번에 꺾는 방향 적용
    	if(!check[xy[0]] [xy[1]] [direction]) {
    		// 이번 칸의 nodeInfo값dmf 방향에 적용
    		direction += nodeInfo[xy[0]][xy[1]];
    		if(direction < 0) direction = 3;
    		else if(direction > 3) direction = 0;
    		
    	// 이전에 쓴 적이 있으면 무조건 중복 또는 싸이클 완성!!
    	}else {
    		// startInfo랑 같으면 사이클 하나 생김 (int(사이클 길이) 추가해야됨)
    		if( startInfo[0] == xy[0] &&
    			startInfo[1] == xy[1] &&
    			startInfo[2] == direction) {
    			cycleList.add(cycleLength);
    		}
    	}
    	

    	// 해당 방향으로 이동
    	xy[0] += dX[direction];
    	xy[1] += dX[direction];
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
        int[] answer = new int[cycleList.size()];
        for(int i=0 ; i < answer.length ; i++) {
        	answer[i] = cycleList.get(i);
        }
        
        
        return answer;
    }
}



