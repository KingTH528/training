package school.programmers.l1.sola;

import java.util.Arrays;
import java.util.HashMap;
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
		
//		int[] answer = new Solution().solution(grid);
//		System.out.println("\n========== 답 ==========\n");
//		for(int i : answer) {
//			System.out.print(i + ", ");
//		}
		
	}
}


// 노드기준으로 실행
class Solution {
	//예시
	//String[]test = {"RL","RR","LR"};
	//이면 ( test[Y].charAt(X) )
	//|RL| --> 
	//|RR| --> 
	//|LR| --> 
	
	
	//----------- 빛이 들어오는 방향 및 위치 파악 필요 -----------//
	// range 기준으로 바깥쪽에 있는 노드들 파악 한 후 진행 혹은 4방향 별로 그때그때 돌아가면서 확인
	// (n*m) 범위에서 기준없이 전부 확인할 경우 확인해야되는 수는 (8*n*m)
	// 기준을 정해줄 필요가 있는데 이러면 또 데이터 저장해놔야햠 ( char[][]grid랑 int[][]check )
	// 각 첫번째 경로의 이동정보만 기록해놔도 그거로 비교하면서 가면 될듯...
	// char[][]grid 말고 바로 int[][]로 바꾸는 것도 좋을듯 (이렇게 하면 배열을 n*m*c 등 여러 차원 배열로 합칠 수 있음)
	// check배열로 칸마다 어느방향에서 들어온게 있는지 나간게 있는지 둘다있는지 아무것도 없는지(4*4)를 다 파악할 수 있으면 좋을듯
	// int[][] 
	// 이거그냥 int[][][] check = new int[ grid[0].lenth() ][ grid.lenth ][ 5(캐릭터기준으로 만든 route변환 방향 & 나가는 방향기록)]
	// 앞에 두 칸은 노드 인덱스 정보
	// 마지막 칸 정리 방법
	// int[][][0] -> route 변환 정보
	// int[][][1] -> 나가는 방향 정보(상)0,1 로 표현(1이면 이전에 지나온 길)
	// int[][][2] -> 나가는 방향 정보(하)0,1 로 표현(1이면 이전에 지나온 길)
	// int[][][3] -> 나가는 방향 정보(좌)0,1 로 표현(1이면 이전에 지나온 길)
	// int[][][4] -> 나가는 방향 정보(후)0,1 로 표현(1이면 이전에 지나온 길)
	
	
	//----------- 사이클 확인 방법 -----------//
	// 하나의 사이클 완성, 중복된 사이클 파악
	// 매번 처음 빛이 들어온 순간엔 처음 시작 위치 및 방향을 저장 && 다시 만나는 순간 사이클 종료!!!
	// 처음 위치 및 방향 => int 2개와 이전/지금 나가는 방향 같은지 확인 (현재위치와 다음 방향이 같은거)
	//
	// 이번에 나가는 방향이 이전에 나간적 있으면 중복이니 끝!!!
	// int[][][][]의 마지막 
	
	
	//----------- 이동방법 -----------//
	// 상우하좌 순서(시계방향)
	// 인덱스(route)로 현재 방향 설정하고 
	// 's'면 route = route; / 'r'이면 route++; / 'l'이면 route--; 
	// route > 3 이면 route-4 또는 0
	// route < 0 이면 route = route+4 또는 3
	// s -> locate[0] = locate[  locate[0] +  dx[route+0] ]; 
	//    , locate[1] = locate[  locate[1] +  dy[route+0] ];
	
	// r -> locate[0] = locate[  locate[0] +  dx[route++] ]; 
	//    , locate[1] = locate[  locate[1] +  dy[route++] ];
	
	// l -> locate[0] = locate[  locate[0] +  dx[route--] ]; 
	//    , locate[1] = locate[  locate[1] +  dy[route--] ];
	
	
	int[] dx = {0,1,0,-1};
	int[] dy = {1,0,-1,0};
	int rangeX = 0;
	int rangeY = 0;
	
	
	
	int[][][] nodeInfo;
    public int[] solution(String[] grid) {
        
    	// 현재 위치설정
    	// 진행 중 0,0이면서 첫번째 움직인 위치와 같을 경우
    	int route = 2;
    	int[] locate = {0,0};
    	
    	// 그리드 범위 0~range 까지
    	// 이 범위 넘기면 route변경 하듯이 변경
    	rangeX = grid[0].length()-1;
    	rangeY = grid.length-1;
    	
    	// 노드별 정보 초기화
    	nodeInfo = new int[grid[0].length()][grid.length][5];
    	for(int i = 0 ; i <= rangeY ; i++){
    		for(int j = 0 ; j <= rangeX ; j++) {
    			if(grid[i].charAt(j)=='S')      nodeInfo[j][i][0] = 0;
    			else if(grid[i].charAt(j)=='R') nodeInfo[j][i][0] = 1;
    			else if(grid[i].charAt(j)=='L') nodeInfo[j][i][0] = -1;
    			
    			//들어온 경로로 하자(1~4) route+1이랑 비교
//    			nodeInfo[j][i][1] = 0;
//    			nodeInfo[j][i][2] = 0;
//    			nodeInfo[j][i][3] = 0;
//    			nodeInfo[j][i][4] = 0;
    		}
    	}
    	
    	
    	//dx dy 써서 바깥쪽으로 돌리고 싶지만 일단 하나 해보고 정리
    	//아래로 오는 빛
    	route = 2;
    	locate[0] = 0;
    	locate[1] = 0;
    	
    	for(int i = 0 ; i <= rangeX ; i++) {
    		int[] thisInfo = {locate[0], locate[1], route};
    		if(nodeInfo[0][i][route+1] != 1){
    			route = router(route, nodeInfo[0][i][0]);
    			nodeInfo[0][i][route+1] = 1;
    			locate[0] = locate[  locate[0] +  dx[route] ]; 
    			locate[1] = locate[  locate[1] +  dy[route] ];
    		}else {
    			break;
    		}
    	}
    	
    	
//    	//위로 오는 빛
//    	route = 0;
//    	for(int i = 0 ; i <= rangeX ; i++) {
//    		
//    	}
//
//    	//왼쪽으로 오는 빛
//    	route = 3;
//    	for(int i = 0 ; i <= rangeY ; i++) {
//    		
//    	}
//    	
//    	//오른쪽으로 오는 빛
//    	route = 1;
//    	for(int i = 0 ; i <= rangeY ; i++) {
//    		
//    	}
    	
    	
    	
    	
    	int[] answer = {};
        return answer;
    }
    
    
    public int search(int[] locate, int route, int[] startInfo) {
    	for(int i = 0 ; i <= rangeX ; i++) {
    		
    		// 이번 노드의 이번 들어오는 방향 설정하고
    		int[] thisInfo = {locate[0], locate[1], route};
    		nodeInfo[thisInfo[0]]
    				[locate[1]  ]
    				[(route+1)  ] = 1;
    		
    		
    		// 이번에 바뀔 방향 설정 하고
    		route = router(route, nodeInfo[0][i][0]);
    		
    		// 이번 노드의 이번 들어오는 방향이 이전에 쓴게 아니면 다음 노드로 넘어가고
    		if(nodeInfo[thisInfo[0]][i][route] != 1){
    			
    			locate[0] = locate[  locate[0] +  dx[route] ]; 
    			locate[1] = locate[  locate[1] +  dy[route] ];
    			nodeInfo[0][i][route+1] = 1;
    			
    			search(locate, );
    			
    		// 이번 노드의 다음 방향이 이미 쓴거면 브레이크!!! 또는 리턴 0
    		}else {
    			return 0 ;
    		}
    	}
    	
    	
    	return 0;
	}
    
    
    // 처음 돌릴 함수
    // startInfo = {x, y, 꺽는방향} --> 노드정보
    public int search(int[] startInfo, int route) {
    	for(int i = 0 ; i <= rangeX ; i++) {
    		
    		// 이번 노드의 이번 들어오는 방향 확인
    		int[] thisInfo = {i, startInfo[1], route};
    		nodeInfo[thisInfo[0]]
    				[startInfo[1]  ]
    				[(route+1)  ] = 1;
    		
    		if() {
    			
    		}
    		
    		// 이번에 바뀔 방향 설정 하고
    		route = router(route, nodeInfo[thisInfo[0]][thisInfo[1]][0]);
    		
    		// 이번에 다음 노드 확인하고
    		
    		
    		
    		// 이번 노드의 이번 들어오는 방향이 이전에 쓴게 아니면 다음 노드로 넘어가고
    		if(nodeInfo[thisInfo[0]][i][route] != 1){
    			
    			locate[0] = locate[  locate[0] +  dx[route] ]; 
    			locate[1] = locate[  locate[1] +  dy[route] ];
    			nodeInfo[0][i][route+1] = 1;
    			
    			search(locate, );
    			
    			// 이번 노드의 다음 방향이 이미 쓴거면 브레이크!!! 또는 리턴 0
    		}else {
    			return 0 ;
    		}
    	}
    	
    	
    	return 0;
    }
    
    
    
    
    public int router(int i, int change) {
    	int re = i + change; 
    	if(re < 0) return 3;
    	if(re > 3) return 0;
    	return re;
    }
    
    public int  indexX(int i) {
    	if(i > rangeX) return 0;
    	if(i < 0) return rangeX;
		return i;
	}
    
    public int  indexY(int i) {
    	if(i > rangeY) return 0;
    	if(i < 0) return rangeY;
    	return i;
    }
    
    
}




//// 에로우 기준으로 실행
//class Solution {
//	//예시
//	//String[]test = {"RL","RR","LR"};
//	//이면 ( test[Y].charAt(X) )
//	//|RL| --> 
//	//|RR| --> 
//	//|LR| --> 
//	
//	//----------- 화살표 배열 생성() -----------//
//	//Boolean[][][] arrow = new Boolean[  test[Y].lenth()*2  ][  test.lenth*2  ][4]  -> [0~3]이 상우하좌 또는 그냥 상하좌우
//	
//	
//	//----------- 빛이 들어오는 방향 및 위치 파악 필요 -----------//
//	//arrow의 가장 바깥쪽 기준으로 파악
//	
//	
//	//----------- 사이클 확인 방법 -----------//
//	// 하나의 사이클 완성, 중복된 사이클 파악
//	// 하나의 사이클 완성유무는 arrow배열의 true를 확인 한 순간 결정
//	// 이미 확인한 사이클과 같은지도 
//	// 만약 
//	
//	
//	//----------- 이동방법 -----------//
//	// 상우하좌 순서(시계방향)
//	// 인덱스(route)로 현재 방향 설정하고 
//	// 's'면 route = route; / 'r'이면 route++; / 'l'이면 route--;
//	// route > 3 이면 route-4 또는 0
//	// route < 0 이면 route = route+4 또는 3
//	int[] dx = {0,1,0,-1};
//	int[] dy = {1,0,-1,0};
//	
//    public int[] solution(String[] grid) {
//        
//    	// 현재 위치설정
//    	// 진행 중 0,0이면서 첫번째 움직인 위치와 같을 경우
//    	int[] locate = {0,0};
//    	
//    	// 그리드 범위 0~range 까지
//    	// 이 범위 넘기면 route변경 하듯이 변경
//    	int rangeX = grid[0].length()-1;
//    	int rangeY = grid.length-1;
//    	
//    	
//    	
//    	
//    	int[] answer = {};
//        return answer;
//    }
//}





