package basic;

import java.util.StringTokenizer;

public class Token_tr {

	public static void main(String[] args) {
//		String str="this string\tincludes\ndefault delims";
//		StringTokenizer stk=new StringTokenizer(str);
		
		String str="this-string-includes=delims";
		StringTokenizer stk=new StringTokenizer(str,"-=",true);
//		StringTokenizer stk=new StringTokenizer(str,"-=");
		System.out.println(str);
		System.out.println();
			
		System.out.println("total tokens:"+stk.countTokens());
		System.out.println("================tokens==================");
		while(stk.hasMoreTokens()){
			System.out.println(stk.nextToken());
		}
		System.out.println("total tokens:"+stk.countTokens());
		
	}

}
