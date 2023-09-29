package baekjoon.test;

import java.io.*;

class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = 0;
		
		for(int i = a ; i <= b ; i++) {
			boolean bool = true;
			if(i>2) {
				sum+=i;
				for(int j = 2 ; j <= i/2+1 ; j++) {
					if(i%j==0) {
						sum-=i;
						bool = false;
						break;
					}
				}
			}else if(i==2) {
				min=i;
				sum+=2;
			}
			if(sum==i && bool) min=i;
		}
		
		if(sum==0) System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}
