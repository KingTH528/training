package algorithm_ex;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BfsSoldier {

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

    private static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int N, M;
    private SoldierColor[][] field;
    private boolean[][] visited;

    public BfsSoldier(int N, int M, SoldierColor[][] field) {
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
                    int size = bfs(i, j);
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

    private int bfs(int x, int y) {
        int size = 0;

        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { 1, -1, 0, 0 };

        SoldierColor currentColor = field[x][y];
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            if (current.x < 0 || current.x >= M || current.y < 0 || current.y >= N || visited[current.x][current.y] || field[current.x][current.y] != currentColor) {
                continue;
            }

            visited[current.x][current.y] = true;
            size++;

            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];
                queue.add(new Position(newX, newY));
            }
        }

        return size;
    }

    public static void main(String[] args) {
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
            BfsSoldier battleField = new BfsSoldier(N, M, field);
            int[] result = battleField.calculatePower();
            System.out.println(result[0] + " " + result[1]);

            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            System.out.println("Execution time in milliseconds: " + timeElapsed);
        }

        Runtime runtime = Runtime.getRuntime();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory in bytes: " + memory);
    }
}
