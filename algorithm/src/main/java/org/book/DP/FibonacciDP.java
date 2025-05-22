package org.book.DP;

/**
 * 피보나치 수열을 DP의 탑다운 방식을 이용해 풀이
 */
import java.util.*;
import java.io.*;

public class FibonacciDP {
    static long[] dp = new long[100];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

//        // 재귀 방식 실행 시간 측정
        long startRecur = System.nanoTime();
        int resultRecur = RecurFibonacci(n);
        long endRecur = System.nanoTime();
        System.out.println("Recursion: " + resultRecur);
        System.out.println("Recursion Time: " + (endRecur - startRecur) / 1_000_000.0 + " ms");

        // DP 방식 실행 시간 측정
        long startDp = System.nanoTime();
        long resultDp = DpFibonacci(n);
        long endDp = System.nanoTime();
        System.out.println("DP: " + resultDp);
        System.out.println("DP Time: " + (endDp - startDp) / 1_000_000.0 + " ms");
    }

    static int RecurFibonacci(int n){
        //탈출
        if(n == 1 || n == 2)
            return 1;

        return RecurFibonacci(n-1) + RecurFibonacci(n-2);
    }

    static long DpFibonacci(int n){
        if(n == 1 || n ==2)
            return 1;

        if(dp[n] != 0){
            return dp[n];
        }

        dp[n] = DpFibonacci(n-1) + DpFibonacci(n-2);
        return dp[n];
    }
}

/**
 * [실행 결과]
 * n = 40
 *
 * Recursion: 102334155
 * Recursion Time: 151.719458 ms
 * DP: 102334155
 * DP Time: 0.003833 ms
 *
 *
 * DP 변수 범위
 * int → F(46)까지 안전
 * long → F(92)까지 안전
 * BigInt -> 그 이상
 */