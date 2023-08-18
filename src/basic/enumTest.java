package basic;

public class enumTest {
	enum enumSample {
	    WHITE('W',0,"codeW"), BLUE('B',1,"codeB");
		
	    char codeA;
	    int codeB;
	    String str;
	    
	    enumSample(char codeA, int codeB, String str) {
	        this.codeA = codeA;
	        this.codeB = codeB;
	        this.str = str;
	    }
	    
	    public void setStr(String str) {
			this.str = str;
		}

		public static String getName(char codeA) {
	        for (enumSample sample : values()) {
	            if (sample.codeA == codeA) {
	                return sample.name();
	            }
	        }
	        return null;
	    }
	    
	    public static String getName(int codeB) {
	    	for (enumSample sample : values()) {
	    		if (sample.codeB == codeB) {
	    			return sample.name();
	    		}
	    	}
	    	return null;
	    }
	    
	    public static String getName(String str) {
	    	for (enumSample sample : values()) {
	    		if (sample.str == str) {
	    			return sample.name();
	    		}
	    	}
	    	return null;
	    }
	    
	    
	    //toString 오버라이드해서 str리턴하게 바꿈
	    @Override
	    public String toString() {
	        return this.str;
	    }
	    
//	    //이름을 string값으로 리턴
//	    @Override
//	    public String toString() {
//	    	return this.name();
//	    }
	}
	
	public static void main(String[] args) {
		
//		String testChar = enumSample.WHITE.toString();
//		System.out.println(  testChar );
		System.out.println(enumSample.WHITE);
		System.out.println(enumSample.WHITE.codeA);
		System.out.println();
		System.out.println(enumSample.WHITE.codeB);
		System.out.println(enumSample.WHITE.str);
		System.out.println();
		System.out.println(enumSample.getName('W'));
		System.out.println(enumSample.getName(0));
		System.out.println(enumSample.getName("codeW"));
		System.out.println(enumSample.WHITE.ordinal());
		
		enumSample.WHITE.setStr("testtesttest");
		
		System.out.println(enumSample.WHITE);
		
	}

}
