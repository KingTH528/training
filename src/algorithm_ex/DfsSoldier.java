package algorithm_ex;

import java.util.Scanner;

public class DfsSoldier {
	enum SoldierColor {
        WHITE('W'),
        BLUE('B');

        char code;

        SoldierColor(char code) {
            this.code = code;
        }

        static SoldierColor getColor(char code) {
            for (SoldierColor color : values()) {
                if (color.code == code) return color;
            }
            return null;
        }
    }

    private int N, M;
    private char[][] field;
    private boolean[][] visited;

    public DfsSoldier(int N, int M, char[][] field) {
        this.N = N;
        this.M = M;
        this.field = field;
        this.visited = new boolean[M][N];
    }

    public int[] calculatePower() {
        int whitePower = 0;
        int bluePower = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                	int size = dfs(i, j, field[i][j]);
                    if (field[i][j] == SoldierColor.WHITE.code) {
                        whitePower += size * size;
                    } else {
                        bluePower += size * size;
                    }
                }
            }
        }
        return new int[]{whitePower, bluePower};
    }

    private int dfs(int x, int y, char currentColor) {
        if (x < 0 || x >= M || y < 0 || y >= N || visited[x][y] || field[x][y] != currentColor) {
            return 0;
        }

        visited[x][y] = true;
        int size = 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            size += dfs(newX, newY, currentColor);
        }

        return size;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        char[][] field = new char[M][N];

        for (int i = 0; i < M; i++) {
            String line = scanner.next();
            for (int j = 0; j < N; j++) {
                field[i][j] = line.charAt(j);
            }
        }
        long startTime = System.currentTimeMillis();

        DfsSoldier battleField = new DfsSoldier(N, M, field);
        int[] result = battleField.calculatePower();
        System.out.println(result[0] + " " + result[1]);

        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds: " + timeElapsed);

        // 메모리 사용량 측정
        Runtime runtime = Runtime.getRuntime();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory in bytes: " + memory);
    }

}
