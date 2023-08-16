package school.programmers.l2;

public class MinerStarter {

	public static void main(String[] args) {

//		int[] picks = {1, 3, 2};
//		String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
//		int[] picks = {0, 1, 1};
//		String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
//		int[] picks = {1, 1, 1};
//		String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "stone", "stone", "stone", "stone", "stone"};
//		int[] picks = {1, 1, 1};
//		String[] minerals = {"diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "stone", "stone", "stone", "stone", "stone"};
//		int[] picks = {1, 1, 1};
//		String[] minerals = {"iron", "iron", "iron", "stone", "stone", "diamond", "diamond", "diamond", "diamond", "diamond"};
//		int[] picks = {1, 5, 5};
//		String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron"};
//		int[] picks = {5, 1, 0};
//		String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "diamond", "diamond"};
		int[] picks = {5, 1, 0};
		String[] minerals = {"iron", "iron", "diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron"};

		
		
		System.out.println("답 : " + new MinerOthers().solution(picks, minerals));
		
	}

}
