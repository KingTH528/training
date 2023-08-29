package school.programmers.l1.sola;

import java.util.*;


// https://school.programmers.co.kr/learn/courses/30/lessons/86052
public class Tester {
	public static void main(String[] args) {
		
//		// 결과 : 16
//		String[] grid = {"SL","LR"};
		
		// 결과 : 1,1,1,1	
		String[] grid = {"S"};
		
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
	
	
//class Solution {
//	int[][] nodeInfo;
//	boolean[][][] check;
//	int[] dX = {0,1,0,-1};
//	int[] dY = {1,0,-1,0};
//	
//    public int[] solution(String[] grid) {
//    	List<Integer> cycleList = new ArrayList<Integer>();
//    	
//    	// 방향 정리  ->  s만나면 direction += 0;  /  r만나면 direction += 1; (4 -> 0)  /  l만나면 direction += -1; (-1 -> 3) 
//    	
//    	// 현재 위치 저장
//    	int[] xy = {0,0};
//    	
//    	// 노드별 정보 정리
//    	nodeInfo = new int[grid[0].length()][grid.length];            // [x][y]
//    	check = new boolean[grid[0].length()][grid.length][4];  // true면 이미 지나감
//    	
//    	for(int i = 0 ; i < grid[0].length() ; i++) {
//    		for(int j = 0 ; j < grid.length ; j++) {
//    			if(grid[j].charAt(i)=='S')      nodeInfo[i][j] = 0;
//    			else if(grid[j].charAt(i)=='R') nodeInfo[i][j] = 1;
//    			else if(grid[j].charAt(i)=='L') nodeInfo[i][j] = -1;
//    		}
//    	}
//
//    	
//    	for(int i = 0 ; i < nodeInfo.length ; i ++) {
//    		for(int j = 0 ; j < nodeInfo[0].length ; j ++) {
//    			for(int k = 0 ; k < 4 ; k++) {
//    				int startDir = k;
//    				int[] startXY = {i,j};
//    				
//    				int nowLength = cycle(startXY, startDir, startXY, startDir, true)-1;
//    				if(nowLength>0) {
//    					cycleList.add(nowLength);
//    				}
//    			}
//    		}
//    	}
//    	
//        int[] answer = new int[cycleList.size()];
//        for(int i=0 ; i < answer.length ; i++) {
//        	answer[i] = cycleList.get(i);
//        }
//        Arrays.sort(answer);
//        
//        return answer;
//    }
//    
//    
//    public int cycle(int[]startLoc, int startDir, int[]loc, int dir, boolean b) {
//    	int length = 1;
//    	// 이전에 지나간 적이 있고
//    	if(check[loc[0]] [loc[1]] [dir]) {
//    		// start정보랑 같으면 길이 리턴
//    		if(startLoc[0]==loc[0] && 
//			   startLoc[1]==loc[1] && 
//			   startDir==dir &&
//			   !b) {
//    			return length;
//    		// start정보랑 다르면 0
//    		}else {
//    			return 0;
//    		}
//    	// 지나간 적이 없으면 다음 방향&위치 구하고
//    	}else {
//    		check[loc[0]] [loc[1]] [dir] = true;
//    		int newDir = turnner(dir, nodeInfo[loc[0]][loc[1]]);
//    		int[] newLoc = new int[2];
//    		
//    		newLoc[0] = loc[0]+dX[newDir];
//    		if(newLoc[0]<0) {
//    			newLoc[0]=nodeInfo.length-1;
//    		}else if(newLoc[0]>nodeInfo.length-1){
//    			newLoc[0]=0;
//    		}
//    		
//    		newLoc[1] = loc[1]+dY[newDir];
//    		if(newLoc[1]<0) {
//    			newLoc[1]=nodeInfo[0].length-1;
//    		}else if(newLoc[1]>nodeInfo[0].length-1){
//    			newLoc[1]=0;
//    		}
//    		// length를 아래부터 위로 올라가면서 더함(근데 0부터 올라올땐 끝까지 0이 나올 수 있게 해줘야함)
//    		length *= cycle(startLoc, startDir, newLoc, newDir, false);
//    		length++;
//    	}
//    	
//    	return length;
//    }
//    
//    
//    public int turnner(int d, int route) {
//    		d += route;
//    		if(d<0) d+=4;
//    		else if(d>3) d-=4;
//    	return d;
//    }
//    
//}

//class Solution {
//    int[][] nodeInfo;
//    boolean[][][] check;
//    int[] dX = {0, 1, 0, -1};
//    int[] dY = {1, 0, -1, 0};
//
//    public int[] solution(String[] grid) {
//        List<Integer> cycleList = new ArrayList<>();
//
//        int rows = grid.length;
//        int cols = grid[0].length();
//        nodeInfo = new int[rows][cols];
//        check = new boolean[rows][cols][4];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                char ch = grid[i].charAt(j);
//                nodeInfo[i][j] = ch == 'S' ? 0 : ch == 'R' ? 1 : -1;
//            }
//        }
//
//        for (int x = 0; x < rows; x++) {
//            for (int y = 0; y < cols; y++) {
//                for (int dir = 0; dir < 4; dir++) {
//                    if (!check[x][y][dir]) {
//                        Stack<int[]> stack = new Stack<>();
//                        int length = 0;
//
//                        stack.push(new int[]{x, y, dir});
//                        while (!stack.isEmpty()) {
//                            int[] top = stack.pop();
//                            int curX = top[0], curY = top[1], curDir = top[2];
//
//                            if (check[curX][curY][curDir]) {
//                                continue;
//                            }
//
//                            check[curX][curY][curDir] = true;
//                            length++;
//
//                            int newDir = (curDir + nodeInfo[curX][curY] + 4) % 4;
//                            int newX = (curX + dX[newDir] + rows) % rows;
//                            int newY = (curY + dY[newDir] + cols) % cols;
//
//                            stack.push(new int[]{newX, newY, newDir});
//                        }
//
//                        if (length > 0) {
//                            cycleList.add(length);
//                        }
//                    }
//                }
//            }
//        }
//
//        int[] answer = new int[cycleList.size()];
//        for (int i = 0; i < answer.length; i++) {
//            answer[i] = cycleList.get(i);
//        }
//        Arrays.sort(answer);
//
//        return answer;
//    }
//}


class Solution {
    public int[] solution(String[] grid) {
        List<Integer> cycleList = new ArrayList<>();
        int rows = grid.length, cols = grid[0].length();
        boolean[][][] check = new boolean[rows][cols][4];
        int[] dX = {0, 1, 0, -1}, dY = {1, 0, -1, 0};

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                for (int dir = 0; dir < 4; dir++) {
                    if (!check[x][y][dir]) {
                        Stack<int[]> stack = new Stack<>();
                        int length = 0;

                        stack.push(new int[]{x, y, dir});
                        while (!stack.isEmpty()) {
                            int[] top = stack.pop();
                            int curX = top[0], curY = top[1], curDir = top[2];

                            if (check[curX][curY][curDir]) continue;

                            check[curX][curY][curDir] = true;
                            length++;

                            char ch = grid[curX].charAt(curY);
                            int newDir = (curDir + (ch == 'S' ? 0 : ch == 'R' ? 1 : -1) + 4) % 4;
                            int newX = (curX + dX[newDir] + rows) % rows;
                            int newY = (curY + dY[newDir] + cols) % cols;

                            stack.push(new int[]{newX, newY, newDir});
                        }

                        if (length > 0) cycleList.add(length);
                    }
                }
            }
        }

        int[] answer = cycleList.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);
        return answer;
    }
}
