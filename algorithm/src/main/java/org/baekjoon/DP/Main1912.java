package org.baekjoon.DP;

/**
 * 플랫폼: 백준
 * 문제번호: 1912
 * 문제이름: 연속합
 * 유형: dp
 * 난이도: 실버2
 */

import java.io.*;

public class Main1912 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        String[] str = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        int maxVal = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            dp[i] = Math.max(dp[i-1] + arr[i-1], arr[i-1]);
            System.out.print(dp[i] + " ");
            if(maxVal < dp[i])
                maxVal = dp[i];
        }

        System.out.println(maxVal);
    }
}
