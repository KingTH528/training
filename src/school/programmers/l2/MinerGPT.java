package school.programmers.l2;

import java.util.Arrays;
import java.util.stream.IntStream;

// 어떤 고수가 만든거
public class MinerGPT {

	public int solution(int[] picks, String[] minerals) {
		
		return IntStream.range(0, Math.min(minerals.length, Arrays.stream(picks).sum() * 5))
				
				
				.filter(i -> i % 5 == 0)
				
				
				.mapToObj(i -> Arrays.stream(Arrays.copyOfRange(minerals, i, Math.min(i + 5, minerals.length)))
						.mapToInt(s -> s.charAt(0) == 'd' ? 25 : s.charAt(0) == 'i' ? 5 : 1).toArray())
				
				
				.sorted((a, b) -> {
					int diff = Arrays.stream(b).sum() - Arrays.stream(a).sum();
					if (diff == 0) {
						return a.length - b.length; // 길이 기준 정렬
					}
					return diff;
				})
				
				
				.mapToInt(arr -> {
					int n = picks[0]-- > 0 ? 25 : picks[1]-- > 0 ? 5 : 1;
					return Arrays.stream(arr).map(i -> Math.max(i / n, 1)).sum();
				})
				
				
				.sum();
	}
}
