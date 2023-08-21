package school.programmers.l1.parkroutes;


public class Tester {
	public static void main(String[] args) {
		
		
		
//		String[] park = {"OOS", "OOO", "OOO"};
//		String[] routes = {"S 2", "E 2", "W 1"};
//		
//		String[] park = {"SOO", "OOO", "OOO"};
//		String[] routes = {"E 2", "S 2", "W 1"};
		
		String[] park = {"OSO", "OOO", "OXO", "OOO"};
		String[] routes = {"E 2", "S 3", "W 1"};
		
		
		new Solution().solution(park, routes);
////		System.out.println("\n\n답\n" + 
//			for(int i : new Solution().solution(park, routes))System.out.println(i);
//			
//		
////		);
		
	}
}



class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] xy = findS(park);
        int maxX = park.length - 1;
        int maxY = park[0].length() - 1;
        for (String route : routes) {
            char direction = route.charAt(0);
            int distance = Character.getNumericValue(route.charAt(2));
            int dx = 0, dy = 0;

            if(direction=='E')dy = 1;
            else if(direction=='W')dy = -1;
            else if(direction=='N')dx = -1;
            else if(direction=='S')dx = 1;

            int[] tempXY = {xy[0], xy[1]};
            for (int i = 0; i < distance; i++) {
            	int[] newXY = {xy[0] + dx, xy[1] + dy};
            	if (    0 <= newXY[0] && newXY[0] <= maxX 
            		     && 0 <= newXY[1] && newXY[1] <= maxY 
            		     && park[newXY[0]].charAt(newXY[1]) != 'X') {
            		xy = newXY.clone();
                } else {
                	xy = tempXY.clone();
                    break;
                }
            }
        }
        return xy;
    }

    // 시작지점 찾기
    private int[] findS(String[] park) {
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}





//
//
//class Solution {
//    public int[] solution(String[] park, String[] routes) {
//        int x=-1, y=-1;
//        int maxX=park[0].length()-1, maxY=park.length-1;
//        System.out.println("최대 : " + maxX + ", 최소 : " + maxY);
//        boolean S = false;
//        for(int i = 0 ; i<park.length ; i++) {
//        	if(S) break;
//        	if(park[i].contains("S")) {
//        		char[] chA = park[i].toCharArray();
//        		for(int j = 0 ; j < chA.length ; j++) {
//        			if(chA[j]=='S') {
//        				x=j;
//        				y=i;
//        				S = true;
//        				break;
//        			}
//        		}
//        	}
//        }
//        System.out.println("시작점 : (" + x + ", " + y + ")");
//
//        
//        for(String str : routes) {
//        	char route = str.charAt(0);
//        	int dis = Character.getNumericValue(str.charAt(2));
//        	int pM = 1;
//        	if(str.charAt(0)=='E' || str.charAt(0)=='W') route='x';
//        	else route='y';
//        	if(str.charAt(0)=='W' || str.charAt(0)=='N') pM = -1;
//        	
//        	
//        	System.out.println(str + " -> " + route + ", " + dis*pM);
//        	int tempX = x;
//        	int tempY = y;
//        	if(route=='x') {
//        		for(int i = 0 ; i < dis ; i ++) {
//        			if(0 <= x+pM && x+pM <= maxX    && park[y].charAt(x+pM)!='X') {
//        				x += pM;
//        				System.out.println("1-1   " + x + ", " + y);
//        			}
//        			else {
//        				System.out.println("1-2   " + x + ", " + y);
//        				x = tempX;
//        				y = tempY;
//        				break;
//        			}
//        		}
//        	}else {
//        		for(int i = 0 ; i < dis ; i ++) {
//        			if(0 <= y+pM && y+pM <= maxY     && park[y+pM].charAt(x)!='X') {
//        				y += pM;
//        				System.out.println("2-1   " + x + ", " + y);        				
//        			}
//        			else {
//        				System.out.println("2-2   " + x + ", " + y);
//        				x = tempX;
//        				y = tempY;
//        				break;
//        			}
//        		}
//        	}
//        }
//        
//        System.out.println("답 : " + x + ", " + y);
//
//        int[] answer = {y,x};
//        return answer;
//    }
//}

