package org.baekjoon.DP;

/**
 * 플랫폼: 백준
 * 문제번호: 24416
 * 문제이름: 알고리즘 수업 - 피보나치 수 1
 * 유형: dp
 * 난이도: 브론즈1
 */

import java.io.*;

public class Main24416 {
    static int cnt = 0;
    static int[] dp;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        fib(n);
        System.out.print(cnt + " ");

        cnt = 0;
        dp = new int[n+1];
        fibonacci(n);
        System.out.println(cnt);
    }

    static int fib(int n){
        if(n == 1 || n == 2){
            cnt += 1;
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }

    static void fibonacci(int n){
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            cnt += 1;
        }
    }
}
