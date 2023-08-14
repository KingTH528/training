package algorithm_ex;

import java.util.Scanner;


//자기꺼 상하좌우 확인하면서 진행
//새로운 정보 부터 우선 탐색

public class DfsSoldier {
	
	//W, B 조심할려고 이넘 사용
	enum SoldierColor {
	    WHITE('W'), BLUE('B');
		char codeA;
		SoldierColor(char codeA) {
			this.codeA = codeA;
	    }
	    public static SoldierColor fromChar(char c) {
	        for (SoldierColor color : values()) {
	        	if (color.codeA == c) return color;
	        }
	        throw new IllegalArgumentException("No matching enum found for character: " + c);
	    }
	    
	}
	private int N, M;
	private SoldierColor[][] field;
	private boolean[][] visited;
	
	public DfsSoldier(int N, int M, SoldierColor[][] field) {
		this.N = N;
		this.M = M;
		this.field = field;
		this.visited = new boolean[M][N];
	}
	
	// 힘 계산
	public int[] calculatePower() {
		int whitePower = 0;
		int bluePower = 0;
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				
				// 이번게 방문 안한거면
				if (!visited[i][j]) {
					
					// size변수 하나 만들어서 상하좌후 재귀적으로 보고 사이즈 더하는 함수 호출(안에서 방문한건지 한번더 확인하니까 신경끄고)
					int size = dfs(i, j, field[i][j]);
					
					
					if (field[i][j] == SoldierColor.WHITE) {
						whitePower += size * size;
					} else {
						bluePower += size * size;
					}
				}
			}
		}
		return new int[] { whitePower, bluePower };
	}
	
	private int dfs(int x, int y, SoldierColor currentColor) {
		
		// x,y가 각각 0~M-1,N-1일때 / 이미 확인한거 / W,B 아닌거 이 세종류 제외
		if (x < 0 || x >= M || y < 0 || y >= N || visited[x][y] || field[x][y] != currentColor) {
			return 0;
		}
		
		visited[x][y] = true;
		int size = 1;
		
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };
		
		// 상하좌우 확인, 대각선 무시
		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			// 재귀적으로 상하좌우 확인하면서 size더하기(0일때랑 M,N일때는 안쪽에서 return 0)
			size += dfs(newX, newY, currentColor);
		}
		
		return size;
	}
	
	public static void main(String[] args) {

		// 입력값 초기화 하고
		try (Scanner scanner = new Scanner(System.in)) {
			int N = scanner.nextInt();
			int M = scanner.nextInt();
			SoldierColor[][] field = new SoldierColor[M][N];
			
			for (int i = 0; i < M; i++) {
				String line = scanner.next();
				for (int j = 0; j < N; j++) {
					field[i][j] = SoldierColor.fromChar(line.charAt(j));
				}
			}
			long startTime = System.currentTimeMillis();
			DfsSoldier battleField = new DfsSoldier(N, M, field);
			
			// 결과 계산
			int[] result = battleField.calculatePower();
			
			System.out.println(result[0] + " " + result[1]);
			
			long endTime = System.currentTimeMillis();
			long timeElapsed = endTime - startTime;
			System.out.println("Execution time in milliseconds: " + timeElapsed);
		}
		
		// 메모리 사용량 측정
		Runtime runtime = Runtime.getRuntime();
		long memory = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Used memory in bytes: " + memory);
	}

}
