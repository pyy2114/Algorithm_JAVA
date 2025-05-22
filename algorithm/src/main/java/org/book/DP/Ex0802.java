package org.book.DP;

import java.io.*;

public class Ex0802 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        //배열 입력
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        //dp테이블 생성
        int[] dp = new int[n];

        //규칙: dp 테이블에 i-2한 값과 i값의 합 vs i-1 값 중 큰값을 dp[i]에 넣음

        dp[0] = arr[0];
        dp[1] = Math.max(dp[0], arr[1]);
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1], arr[i] + dp[i-2]);
        }

        System.out.println(dp[n-1]);
    }
}
