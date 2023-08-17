package basic;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class byteTr {
	
	public static void main(String[] args) {
		
		//========================//
		//==== string to byte ====//
		//========================//
//		String testStr = "한글";
		String testStr = "testStr";
		byte[] strToByteArr = testStr.getBytes();
		System.out.println("!!!String test!!!");
		System.out.println("<문자열> : " + testStr);
		
		
		System.out.print("<아스키> : ");
		for(int i : strToByteArr) System.out.print(i + " ");
		System.out.print("\n<아스키> : ");
		for(byte i : strToByteArr) System.out.print(i + " ");
		
		
		System.out.print("\n<바이너리> : ");
		for(int i : strToByteArr) System.out.print(Integer.toBinaryString(i) + " ");
		
		
		System.out.print("\n<8비트로> : ");
		for(byte b : strToByteArr) System.out.print(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0') + " ");
		
		
		System.out.print("\n<byte -> binary> : ");
		for(byte i : strToByteArr) {
			System.out.print(Integer.toBinaryString(i));
		}
		
		

		
		byte[] testArr = new byte[testStr.getBytes().length];
		for(int i = 0 ; i<testArr.length ; i++) {
			testArr[i] = testStr.getBytes()[i];
		}
		System.out.println("\n<스트링 -> 바이트어레이 -> 스트링> : " + new String(testArr).trim());

		System.out.print("<아스키 -> 스트링> : ");
		int[] asciiValues = {116, 101, 115, 116, 83, 116, 114};
		for(int i : asciiValues) System.out.print((char) i);
		
		
		System.out.print("\n<바이너리(int) -> 스트링> : ");
		int[] binaryInt = {1110100, 1100101, 1110011, 1110100, 1010011, 1110100, 1110010};
		for(int binary : binaryInt) {
			System.out.print((char) Integer.parseInt(Integer.toString(binary), 2));
		}
		
		
		System.out.print("\n<바이너리(String) -> 스트링> : ");
		String[] binaryString = {"01110100", "01100101", "01110011", "01110100", "01010011", "01110100", "01110010"};
//		String[] binaryString = {"1110100", "1100101", "1110011", "1110100", "1010011", "1110100", "1110010"};
		for(String binary : binaryString) {
			System.out.print((char) Integer.parseInt(binary, 2));
		}

		
		
		
		
		
		
		System.out.println("\n\n==== 인코딩 테스트 ====");
		String dddd = "a일b이c삼d사e오f육g칠";
		try {
			
			byte[] bbb = dddd.getBytes("EUC-KR");
			for(byte by : bbb) System.out.print(by + " ");
			System.out.println("\nbbb.length : " + bbb.length);
			System.out.println(new String(bbb, "EUC-KR") + "\n");
		
		
			byte[] www = dddd.getBytes("UTF-8");
			for(byte by : www) System.out.print(by + " ");
			System.out.println("\nwww.length : " + www.length);
			System.out.println(new String(www) + "\n");
		
		
			byte[] aaaa = dddd.getBytes();
			for(byte by : aaaa) System.out.print(by + " ");
			System.out.println("\naaaa.length : " + aaaa.length);
			System.out.println(new String(aaaa));
		
		} catch (UnsupportedEncodingException e) {}
		
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

	
	
	
	
    public static String convertBinaryArrayToString(int[] binaryValues) {
        StringBuilder sb = new StringBuilder();
        for (int binaryValue : binaryValues) {
            int charValue = Integer.parseInt(Integer.toString(binaryValue), 2);
            char character = (char) charValue;
            sb.append(character);
        }
        return sb.toString();
    }
	
	
	public static String binary32(int in) {
		return String.format("%32s", Integer.toBinaryString(in)).replace(' ', '0');
	}
	
	
}
