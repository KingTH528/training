package baekjoon.test;

import java.io.*;

class Main{
	static void main(String[]a)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(br.ready()) {
			bw.write(br.readLine());
		}
		bw.flush();
		
	}
}