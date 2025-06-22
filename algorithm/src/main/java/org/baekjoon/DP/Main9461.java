package org.baekjoon.DP;
/**
 * 플랫폼: 백준
 * 문제번호: 9461
 * 문제이름: 파도반 수열
 * 유형: dp
 * 난이도: 실버3
 */

import java.io.*;
import java.util.*;
public class Main9461 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp(n));
        }
    }

    static Long dp(int n){
        if(n < 4){
            return 1L;
        }else{
            Long[] dp = new Long[n+1];
            dp[0] = 0L;
            dp[1] = 1L;
            dp[2] = 1L;
            dp[3] = 1L;
            for(int i = 4; i <= n; i++){
                dp[i] = dp[i-3] + dp[i-2];
            }

            return dp[n];
        }
    }
}
