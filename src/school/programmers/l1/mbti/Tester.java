package school.programmers.l1.mbti;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/118666
public class Tester {
	public static void main(String[] args) {
		
		//survey의 원소는 "RT", "TR" / "FC", "CF" / "MJ", "JM" / "AN", "NA" 중 하나
		
		// 결과 : "TCMA"
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int [] choices = {5, 3, 2, 7, 5};
		
//		// 결과 : "RCJA"
//		String[] survey = {"TR", "RT", "TR"};
//		int [] choices = {7, 1, 3};
		
		
		String answer = new Solution().solution(survey, choices);
		System.out.println("\n========== 답 ==========\n" + answer);
		
	}
}



class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] pointInt  = { 0,  0,  0,  0,  0,  0,  0,  0};
        String pointStr = "RTCFJMAN";
        
        for(int i = 0 ; i < choices.length ; i++) {
        	if(choices[i] < 4) {
        		char tempChar = survey[i].charAt(1);
        		int index =  pointStr.indexOf(tempChar);
        		pointInt[index] += choices[i]-4;
        	}else {
        		char tempChar = survey[i].charAt(0);
        		int index =  pointStr.indexOf(tempChar);
        		pointInt[index] += 4-choices[i];
        	}
        }
        
        char[] ch = new char[4];
        for(int i = 0 ; i < 8 ; i += 2) {
        	if(pointInt[i]<pointInt[i+1]) {
        		ch[i/2] = pointStr.charAt(i+1);
        	}else {
        		ch[i/2] = pointStr.charAt(i);
        	}
        	
        }
        
        return new String(ch);
    }
}




