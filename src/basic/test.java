package basic;

public class test {

	public static void main(String[] args) {
//		int intA = 2147483647*2;
		int intA = 2147483647;
		int midA = intA*4/4;
		int midB = intA*4 >>> 2;
		
		
		System.out.println("0"+Integer.toBinaryString(intA) + " --> " + intA);
		System.out.println(Integer.toBinaryString(intA*2) + " --> " + intA*2);
		System.out.println(""+Integer.toBinaryString(midA) + " --> " + midA);
		System.out.println("00"+Integer.toBinaryString(midB) + " --> " + midB);
		
		
		
		
		
		
		
		
//        byte value = 5;
//
//        // 왼쪽 시프트
//        byte leftShift = (byte) (value << 1);
//        System.out.println("5(0101) << 1 = " + leftShift + "(" + Integer.toBinaryString(leftShift & 0xFF) + ")");
//
//        // 부호 있는 오른쪽 시프트
//        byte negativeValue = -5;
//        byte rightShiftSigned = (byte) (negativeValue >> 1);
//        System.out.println("-5(11111011) >> 1 = " + rightShiftSigned + "(" + Integer.toBinaryString(rightShiftSigned & 0xFF) + ")");
//
//        // 부호 없는 오른쪽 시프트
//        int rightShiftUnsigned = (negativeValue & 0xFF) >>> 1;
//        System.out.println("-5(11111011) >>> 1 = " + rightShiftUnsigned + "(" + Integer.toBinaryString(rightShiftUnsigned) + ")");
		
		
	}
}
