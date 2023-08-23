package school.programmers.l1.mail;

// https://school.programmers.co.kr/learn/courses/30/lessons/161990
public class Tester {
	public static void main(String[] args) {
		
//		// 결과 0, 1, 3, 4
//		String[] wallpaper = {".#...", "..#..", "...#."};
		
//		// 결과 1, 3, 5, 8
//		String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
		
//		// 결과 0, 0, 7, 9
//		String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
		
		// 결과 1, 0, 2, 1
		String[] wallpaper = {"..", "#."};
		
		
		int[] answer = new Solution().solution(wallpaper);
		System.out.println("\n========== 답 ==========\n");
//		for(int i : answer) {
//			System.out.print(answer[i] + ", ");
//		}
		
	}
}



class Solution {
    public int[] solution(String[] wallpaper) {
    	int rangeX = wallpaper[0].length();
    	int rangeY = wallpaper.length;
    	int minX = Integer.MAX_VALUE;
    	int minY = Integer.MAX_VALUE;
    	int maxX = Integer.MIN_VALUE;
    	int maxY = Integer.MIN_VALUE;
    	
    	for(int iY = 0 ; iY < rangeY ; iY++) {
    		for(int iX = 0 ; iX < rangeX ; iX++) {
    			if(wallpaper[iY].charAt(iX)=='#') {
    				if(minX>iX) minX = iX;
    				if(minY>iY) minY = iY;
    				if(maxX<iX) maxX = iX;
    				if(maxY<iY) maxY = iY;
    			}
    		}
    	}
    	
        return new int[]{minY, minX, maxY+1, maxX+1};
    }
}

