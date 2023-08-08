package algorithm_ex;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BfsSoldier {
	private int N, M;
	private char[][] field;
	private boolean[][] visited;
	private final int[] dx = { -1, 1, 0, 0 };
	private final int[] dy = { 0, 0, -1, 1 };

	public BfsSoldier(int N, int M, char[][] field) {
		this.N = N;
		this.M = M;
		this.field = field;
		this.visited = new boolean[M][N];
	}

	private int bfs(int x, int y, char currentColor) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		visited[x][y] = true;

		int size = 0;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			size++;

			for (int i = 0; i < 4; i++) {
				int newX = current[0] + dx[i];
				int newY = current[1] + dy[i];

				if (newX >= 0 && newX < M && newY >= 0 && newY < N && !visited[newX][newY]
						&& field[newX][newY] == currentColor) {
					queue.offer(new int[] { newX, newY });
					visited[newX][newY] = true;
				}
			}
		}

		return size;
	}

	public int[] calculatePower() {
		int whitePower = 0;
		int bluePower = 0;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					int size = bfs(i, j, field[i][j]);
					if (field[i][j] == 'W') {
						whitePower += size * size;
					} else {
						bluePower += size * size;
					}
				}
			}
		}

		return new int[] { whitePower, bluePower };
	}

	public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			int N = scanner.nextInt();
			int M = scanner.nextInt();
			char[][] field = new char[M][N];

			for (int i = 0; i < M; i++) {
			    String line = scanner.next();
			    for (int j = 0; j < N; j++) {
			        field[i][j] = line.charAt(j);
			    }
			}
			
			BfsSoldier battleFieldBFS = new BfsSoldier(N, M, field);
			int[] result = battleFieldBFS.calculatePower();
			System.out.println(result[0] + " " + result[1]);
			
	        // 메모리 사용량 측정
	        Runtime runtime = Runtime.getRuntime();
	        long memory = runtime.totalMemory() - runtime.freeMemory();
	        System.out.println("Used memory in bytes: " + memory);
		}
	}
}
