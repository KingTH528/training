package school.programmers.l1.parkroutes;


public class Tester {
	public static void main(String[] args) {
		
		
		
		String[] park = {"OSO","OOO","OXO","OOO"};
		String[] routes = {"E 2","S 3","W 1"};
		
		System.out.println("\n\n답\n" + 
		new Solution().solution(
				park, routes
				
		));
		
	}
}

class Solution {
	
    public int[] solution(String[] park, String[] routes) {
        int x=-1, y=-1;
        int maxX=park[0].length()-1, maxY=park.length-1;
        
        //시작지점 확인
        boolean S = false;
        for(int i = 0 ; i<park.length ; i++) {
        	if(S) break;
        	if(park[i].contains("S")) {
        		char[] chA = park[i].toCharArray();
        		for(int j = 0 ; j < chA.length ; j++) {
        			if(chA[j]=='S') {
        				x=j;
        				y=i;
        				S = true;
        				break;
        			}
        		}
        	}
        }
        System.out.println("시작점 : " + x + ", " + y);

        //명령별 방향 크기 확인
        for(String str : routes) {
        	char route = 'y';
        	int dis = Character.getNumericValue(str.charAt(2));
        	int pM = 1;
        	int tempX = x;
        	int tempY = y;
        	if(str.charAt(0)=='W' || str.charAt(0)=='N') pM = -1;
        	if(str.charAt(0)=='E' || str.charAt(0)=='W') {
        		tempX += pM;
        		route='x';
        	}else {
        		tempY+= pM;
        	}
        	System.out.println("명령 : " + route + "방향으로 " + dis*pM);
        	
        	
        	boolean f = true;
        	// i는 그냥 명령한 이동 수
    		for(int i = 0 ; i < dis ; i ++) {
    			if(0 <= tempX && tempX < maxX     && 0 <= tempY && tempY < maxY        && park[tempY].charAt(tempX)!='X') {
    				if(route=='x') {
    					System.out.println("sss" + i);
    					tempX += pM;
    				}
    				else tempY += pM;
    			}
    			else {
    				System.out.println("ddd" + i);
    				tempX = x;
    				tempY = y;
    				f = false;
    				break;
    			}
    		}
    		if(f) {
    			System.out.println("성공");
    			if(route=='x') x = tempX - pM;
    			else y = tempY - pM;
    		}else {
    			
    			System.out.println("실패");
    		}
    		System.out.println("x:" + x + " y:" + y);
        }
        System.out.println("\n결과\nx:" + x + " y:" + y);
        int[] answer = {y,x};
        return answer;
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

