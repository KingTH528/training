package school.programmers.l1.foodFight;

public class Tester {
	public static void main(String[] args) {
//		int[] intArr = {1, 3, 4, 6};
		int[] intArr = {1, 7, 1, 2};
		
		System.out.println("답\n" + 
		new Solution().solution1(
				intArr
				
		));
	}
}

class Solution {
	
	
// String = String + StringBuilder 과정을 없에니까 속도가 훨씬 빨라짐
	public String solution(int[] food) {
		StringBuilder answer = new StringBuilder();
		for(int i =1 ; i<food.length ; i++) {
			int jj = food[i]/2;
			for(int j = 0 ; j<jj ; j++) {
				answer.append(i);
			}
		}
		String re = answer.toString();
		
		return answer.append("0").append(new StringBuilder(re).reverse()).toString();
	}
    public String solution0(int[] food) {
        StringBuilder answer = new StringBuilder();
        for(int i =1 ; i<food.length ; i++) {
        	int jj = food[i]/2;
        	for(int j = 0 ; j<jj ; j++) {
        		answer.append(i);
        	}
        }
        
        String re = answer + "0";
        re = re + answer.reverse();
        return re;
    }

    
// 포문 안에서 압뒤 다만들어주면 insert함수는 엄청 느림
	public String solution1(int[] food) {
		StringBuilder answer = new StringBuilder("0");
		for(int i =food.length-1 ; i>=0 ; i--) {
			int jj = food[i]/2;
			for(int j = 0 ; j<jj ; j++) {
				answer.append(i);
				answer.insert(0, i);
			}
		}
		
		return answer.toString();
	}
	
// 처음부터 sb두개 만들면? 이것도 시간 좀 걸림
	public String solution2(int[] food) {
        StringBuilder answer = new StringBuilder();
        StringBuilder answer2 = new StringBuilder();
        for(int i =1 ; i<food.length ; i++) {
        	int jj = food[i]/2;
        	for(int j = 0 ; j<jj ; j++) {
        		answer.append(i);
        		answer2.append(i);
        	}
        }
        
        return new String( answer.append("0").append(answer2.reverse()));
	}
	
	
}



