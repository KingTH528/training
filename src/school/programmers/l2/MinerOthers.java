package school.programmers.l2;

import java.util.*;

// 어떤 고수가 만든거
public class MinerOthers {

	//================//
	//====== 원본 ======//
	//================//
//	public int solution(int[] picks, String[] minerals) {
//		
//		return IntStream.range(0, Math.min(minerals.length, Arrays.stream(picks).sum() * 5))
//				
//				
//				.filter(i -> i % 5 == 0)
//				
//				
//				.mapToObj(i -> Arrays.stream(Arrays.copyOfRange(minerals, i, Math.min(i + 5, minerals.length)))
//						.mapToInt(s -> s.charAt(0) == 'd' ? 25 : s.charAt(0) == 'i' ? 5 : 1).toArray())
//				
//				
//				.sorted((a, b) -> {
//					int diff = Arrays.stream(b).sum() - Arrays.stream(a).sum();
//					if (diff == 0) {
//						return a.length - b.length; // 길이 기준 정렬
//					}
//					return diff;
//				})
//				
//				
//				.mapToInt(arr -> {
//					int n = picks[0]-- > 0 ? 25 : picks[1]-- > 0 ? 5 : 1;
//					return Arrays.stream(arr).map(i -> Math.max(i / n, 1)).sum();
//				})
//				
//				
//				.sum();
//	}
	
	//================//
	//====== 일반 자바 ======//
	//================//
	public int solution(int[] picks, String[] minerals) {
		
		
		//-------- 범위 0 ~ 광물배열 길이 또는 0 ~ 곡갱이 갯수*5중 작은값으로 설정하고 i%5==0일 때마다 아래 코드 실행 --------//
//		IntStream.range(0, Math.min(minerals.length, Arrays.stream(picks).sum() * 5))
//		.filter(i -> i % 5 == 0)
        int endRange = Math.min(minerals.length, sum(picks) * 5);
        List<int[]> subArrays = new ArrayList<>();
        for (int i = 0; i < endRange; i += 5) {
        	
        	//-------- 5칸씩(끝날때는 남은 미네랄 길이) 끊어서 5칸(또는 그 이하)짜리 배열생성 후 피로도 정보 입력 --------//
//			.mapToObj(i -> Arrays.stream(Arrays.copyOfRange(minerals, i, Math.min(i + 5, minerals.length)))
            int[] subArray = new int[Math.min(5, minerals.length - i)];
            for (int j = 0; j < subArray.length; j++) {
//				.mapToInt(s -> s.charAt(0) == 'd' ? 25 : s.charAt(0) == 'i' ? 5 : 1).toArray())
                char firstChar = minerals[i + j].charAt(0);
                subArray[j] = firstChar == 'd' ? 25 : firstChar == 'i' ? 5 : 1;
            }
            subArrays.add(subArray);
        }

        
        
        
      //-------- 리스트내 배열을 입력정보 합 기준으로 정렬하는데 만약 같으면 광물 수 기준으로 정렬 --------//
//		.sorted((a, b) -> {
//		int diff = Arrays.stream(b).sum() - Arrays.stream(a).sum();
//		if (diff == 0) {
//			return a.length - b.length; // 길이 기준 정렬
//		}
//		return diff;
//	})
        subArrays.sort(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int diff = sum(b) - sum(a);
                if (diff == 0) {
                    return b.length - a.length;
                }
                return diff;
            }
        });

        
        
        
      //-------- 정렬 후 높은 값 부터 순서대로 다이아->철->돌 사용시 피로도 합 계산 --------//
      //-------- 위에서 피로도 계산을 5^2,5^1,5^0 로 정리했기 때문에 다이아곡갱이->나누기 25, 철->나누기 5, 돌->나누기 1 (최소값 1로 제한) 해서 피로도 계산이 가능 --------//
//		.mapToInt(arr -> {
//		int n = picks[0]-- > 0 ? 25 : picks[1]-- > 0 ? 5 : 1;
//		return Arrays.stream(arr).map(i -> Math.max(i / n, 1)).sum();
//	})
//	.sum();
        int sumResult = 0;
        for (int[] arr : subArrays) {
            int n;
            if (picks[0]-- > 0) {
                n = 25;
            } else if (picks[1]-- > 0) {
                n = 5;
            } else {
                n = 1;
            }
            for (int value : arr) {
                sumResult += Math.max(value / n, 1);
            }
        }

        return sumResult;
        
    }

    private int sum(int[] arr) {
        int total = 0;
        for (int value : arr) {
            total += value;
        }
        return total;
    }
}
