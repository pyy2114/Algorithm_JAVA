package org.baekjoon.DP;
/**
 * 플랫폼: 백준
 * 문제번호: 1149
 * 문제이름: RGB거리
 * 유형: dp
 * 난이도: 실버1
 */

import java.io.*;

public class Main1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //n개의 배열 생성
        int[][] rgb = new int[n][3];

        //rgb가격 입력
        for(int i = 0; i < n; i++){
            String[] valueStr = br.readLine().split(" ");
            for(int j = 0; j < 3; j++){
                rgb[i][j] = Integer.parseInt(valueStr[j]);
            }
        }

        int[][] dp = new int[n][3];
        //최적 값 계산
        int answer = Integer.MAX_VALUE;
        int preColor = 0;



    }
}
