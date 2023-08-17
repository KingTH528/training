package basic;

import java.util.*;

public class byteTr {
	
	public static void main(String[] args) {
		
		//========================//
		//==== string to byte ====//
		//========================//
//		String testStr = "한글";
		String testStr = "testStr";
		byte[] strToByteArr = testStr.getBytes();
//		System.out.println("!!!String test!!!");
//		System.out.println("<문자열> : " + testStr);
//		
//		
//		System.out.print("<아스키> : ");
//		for(int i : strToByteArr) System.out.print(i + " ");
//		
//		
//		System.out.print("\n<바이너리> : ");
//		for(int i : strToByteArr) System.out.print(Integer.toBinaryString(i) + " ");
//		
//		
//		System.out.print("\n<8비트로> : ");
//		for(byte b : strToByteArr) System.out.print(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0') + " ");
//		
//		
//		System.out.println("\nbyte to binary");
//		for(byte i : strToByteArr) {
//			System.out.print(Integer.toBinaryString(i));
//		}
//		
		
		
		System.out.println(dice(2,2,2));
		
		byte[] testArr = new byte[1024];
		for(int i = 0 ; i<strToByteArr.length ; i++) {
			testArr[i] = strToByteArr[i];
		}
		System.out.println("testArr");
		System.out.println(new String(testArr).trim());
		
		
		
//		
//		
//		System.out.print("\n<아스키 -> 스트링> : ");
//		int[] asciiValues = {116, 101, 115, 116, 83, 116, 114};
//		for(int i : asciiValues) System.out.print((char) i);
//		
//		
//		System.out.print("\n<바이너리 -> 스트링> : ");
////		String[] binaryValues = {"1110100", "1100101", "1110011", "1110100", "1010011", "1110100", "1110010"};
//		String[] binaryValues = {"01110100", "01100101", "01110011", "01110100", "01010011", "01110100", "01110010"};
////		StringBuilder binaryToString = new StringBuilder();
//		for(String binary : binaryValues) {
//			System.out.print((char) Integer.parseInt(binary, 2));
////		    binaryToString.append((char) Integer.parseInt(binary, 2));
//		}
////		System.out.println("<바이너리 -> 스트링>\n" + binaryToString.toString());
//
//
//		
	

		
		
		
		
		
		
//		
//		
//		
//		
//		
//		//========================//
//		//==== int to byte ====//
//		//========================//
//		int intA = 2147483647;
//		int midA = intA*2/2;
//		int midB = intA*2 >>> 1;
//		
//		System.out.println("\n");
//		System.out.println("!!!int test!!!");
//		System.out.println("0"+Integer.toBinaryString(intA) + " --> " + intA);
//		System.out.println(binary32(intA) + " --> " + intA);
//		System.out.println(binary32(midA*2) + " --> " + intA*2);
//		System.out.println(binary32(midA) + " --> " + midA);
//		System.out.println(binary32(midB) + " --> " + midB);
//		
		
//      byte value = 5;
//
//      // 왼쪽 시프트
//      byte leftShift = (byte) (value << 1);
//      System.out.println("5(0101) << 1 = " + leftShift + "(" + Integer.toBinaryString(leftShift & 0xFF) + ")");
//
//      // 부호 있는 오른쪽 시프트
//      byte negativeValue = -5;
//      byte rightShiftSigned = (byte) (negativeValue >> 1);
//      System.out.println("-5(11111011) >> 1 = " + rightShiftSigned + "(" + Integer.toBinaryString(rightShiftSigned & 0xFF) + ")");
//
//      // 부호 없는 오른쪽 시프트
//      int rightShiftUnsigned = (negativeValue & 0xFF) >>> 1;
//      System.out.println("-5(11111011) >>> 1 = " + rightShiftUnsigned + "(" + Integer.toBinaryString(rightShiftUnsigned) + ")");
		
		
	}

	public static int dice(int a, int b, int c) {
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		map.put(a, null);
		map.put(b, null);
		map.put(c, null);
		System.out.println("max : " + map.size());
		int answer = 1;
		for(int i = 1 ; i <=4-map.size() ; i++) {
//			for(int i = 1 ; i <=Collections.max(Arrays.asList(intArr)) ; i++) {
			answer *= (int) (Math.pow(a, i) + 
							Math.pow(b, i) + 
							Math.pow(c, i));
		}
		
		
		return answer;
	}
	
	public static String binary32(int in) {
		return String.format("%32s", Integer.toBinaryString(in)).replace(' ', '0');
	}
	
	
}
