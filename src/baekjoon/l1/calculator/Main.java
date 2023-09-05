package baekjoon.l1.calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double A = (double)Integer.valueOf(st.nextToken());
		double B = (double)Integer.valueOf(st.nextToken());
		System.out.println((int)(A+B));
		System.out.println((int)(A-B));
		System.out.println((int)(A*B));
		System.out.println((int)(A/B));
		System.out.println((int)(A%B));
	}
}
