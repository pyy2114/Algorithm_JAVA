package org.baekjoon.feb2026;

import java.io.*;
import java.util.*;

public class D0223_BOJ_1157 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열 입력 받기
        String str = br.readLine();

        // 아스키 배열 준비 -> 알파벳 26개
        int[] ascii = new int[26];

        // 문자열을 문자로 나눔 -> 해당 문자를 숫자로 변환해서 배열에 카운트
        for(int i = 0; i < str.length(); i++){
            // 문자
            char c = str.charAt(i);
            // 문자 숫자로 변환
            int num = (int)c;

           // 대문자인지 소문자인지 구별
            if(num >= 97){  // 소문자
                num -= 97;
            }else{  // 대문자
                num -= 65;
            }

            ascii[num] += 1;
        }

        // 배열 값들 중 제일 큰 값의 인덱스 선택 -> 여러개면 그냥 ? 출력
        // 일단 max인 인덱스 찾아 근데, 같은게 있으면 maxCnt 를 올려
        // 마지막에 이게 1이상이면 ?로
        int maxIndexVal = Integer.MIN_VALUE;
        int maxIndex = 0;
        int maxCnt = 0;
        for(int i = 0; i <  26; i++){
            if(ascii[i] > maxIndexVal){
                maxCnt = 1;
                maxIndex = i;
                maxIndexVal = ascii[i];
            }else if(ascii[i] == maxIndexVal){
                maxCnt++;
            }
        }

        if(maxCnt > 1){
            System.out.println("?");
        }else{
            System.out.println((char)(maxIndex + 65));
        }

    }
}
