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
		
		
		
//		IntStream.range(0, Math.min(minerals.length, Arrays.stream(picks).sum() * 5))
//		.filter(i -> i % 5 == 0)
        int endRange = Math.min(minerals.length, sum(picks) * 5);
        List<int[]> subArrays = new ArrayList<>();
        for (int i = 0; i < endRange; i += 5) {
        	
        	
//			.mapToObj(i -> Arrays.stream(Arrays.copyOfRange(minerals, i, Math.min(i + 5, minerals.length)))
            int[] subArray = new int[Math.min(5, minerals.length - i)];
            for (int j = 0; j < subArray.length; j++) {
//				.mapToInt(s -> s.charAt(0) == 'd' ? 25 : s.charAt(0) == 'i' ? 5 : 1).toArray())
                char firstChar = minerals[i + j].charAt(0);
                subArray[j] = firstChar == 'd' ? 25 : firstChar == 'i' ? 5 : 1;
            }
            subArrays.add(subArray);
        }

        
        
        
        
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
