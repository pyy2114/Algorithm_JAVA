package org.baekjoon.greedy;

/**
 * 플랫폼: 백준
 * 문제번호: 1541
 * 문제이름: 잃어버린 괄호
 * 유형: 그리디
 * 난이도: 실버2
 */

import java.io.*;
import java.util.*;

public class Main1541 {
    public static void main(String[] args) throws IOException{
        int answer = 0;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 식 입력
        String str = br.readLine();

        //문자열 파싱 시작
        ArrayList<Integer> numArr = new ArrayList<>();
        ArrayList<Character> opArr = new ArrayList<>();

        int st = 0;

        int strLength = str.length();
        for(int i = 0; i < strLength; i++){
            if(str.charAt(i) == '+'|| str.charAt(i) == '-'){
                opArr.add(str.charAt(i));
                String parseStr = str.substring(st,i);
                int strToInt = Integer.parseInt(parseStr);
                numArr.add(strToInt);
                st = i+1;
            }
        }
        //마지막 숫자
        int lastNum = Integer.parseInt(str.substring(st,strLength));
        numArr.add(lastNum);

        // 그리디 계산
        int idx = 0;
        answer += numArr.get(idx);
        boolean minusFlag = false;

        for(int i = 0; i < opArr.size(); i++){
            if(opArr.get(i) == '-'){
                minusFlag = true;
            }

            if(minusFlag){
                answer -= numArr.get(i+1);
            }else{
                answer += numArr.get(i+1);
            }

        }

        System.out.println(answer);

    }
}
