package baekjoon.l1.byte_input;

public class Main1 {
	static Reader in = new Reader();
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int T = in.nextInt();
		for(int i = 0; i < T; i++) {
			sb.append(in.nextInt()+in.nextInt()).append("\n");
		}
		System.out.println(sb);
	}
	
	static class Reader {
		final int SIZE = 1 << 13;
		byte[] buffer = new byte[SIZE];
		int index, size;

		
		
		// nextLong()함수랑 리턴 타입만 다름
		int nextInt() throws Exception {
			int n = 0;
			byte c;
			
			// 공백이나 제어문자 건너뜀
			while ((c = read()) <= 32);
			
			// 마이너스 붙었으면 한번 더 읽어서 다음칸부터 확인
			boolean neg = c == '-' ? true : false;
			if (neg) c = read();
			
			//     |~~  이전숫자*10  ~~| + 이번문자 아스키
			do n = (n << 3) + (n << 1) + (c & 15);
			while (isNumber(c = read()));
			
			// 마이너스 붙었으면 마지막에 부호변경
			if (neg) return -n;
			return n;
		}

		long nextLong() throws Exception {
			long n = 0;
			byte c;
			while ((c = read()) <= 32)
				;
			boolean neg = c == '-' ? true : false;
			if (neg)
				c = read();
			do
				n = (n << 3) + (n << 1) + (c & 15);
			while (isNumber(c = read()));
			if (neg)
				return -n;
			return n;
		}
		
		boolean isNumber(byte c) {
			return 47 < c && c < 58;
		}
		
		
		// 처음 들어왔을 때는 0,0이라 바이트배열(버퍼)에 전부 넣어 놓음
		// 만약 들어온 값이 SIZE보다 크면 다 읽었을 때 size랑 index가 다시 같아지면서 SIZE만큼 또 읽어옴
		// 그다음에 또 다 읽어서 size랑 index가 같아졌을 때 size가 -1이면 buffer[1]이 리턴되는데 이건 따로 처리가 없는건가?
		byte read() throws Exception {
			if (index == size) {
				size = System.in.read(buffer, index = 0, SIZE);
				if (size < 0)
					buffer[0] = -1;
			}
			return buffer[index++];
		}
	}
}