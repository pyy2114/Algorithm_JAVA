package org.swea;
/**
 * 플랫폼: swea
 * 문제번호: 5215
 * 문제이름: 햄버거 다이어트
 * 유형: dp(배낭문제)
 * 난이도: D3
 */

import java.util.*;

public class Solution5215 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 재료 갯수
        int n = sc.nextInt();
        // 칼로리 리밋
        int l = sc.nextInt();

        //0: 점수, 1: 칼로리
        int[][] arr = new int[n][2];

        //재료값 입력
        for(int i = 0;i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        //dp
        // 자 디피로 찾아보려무나
        // 칼로리 배열 갯수
        int m = l/100;
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                //현재 칼로리
                int cal = j * 100;

                if(cal < arr[i-1][1]){
                    //현재 재료의 칼로리가 기준 칼로리보다 낮은 경우 -> 넣지 않는다
                    dp[i][j] = dp[i-1][j];
                }else{
                    //현재 재료의 칼로리가 기준 칼로리보다 큰 경우
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i][1]] + arr[i-1][0]);
                }
            }
        }

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                System.out.printf("%d ", dp[i][j]);
            }
            System.out.println();
        }

    }
}
