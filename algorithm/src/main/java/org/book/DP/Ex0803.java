package org.book.DP;

/**
 * 바닥 공사
 * nx2의 바닥을
 * 1x2, 2x1, 2x2 타일을 이용해서 채울 수 있는 경우의 수
 * 경우의 수를 796796으로 나눈 나머지값 출력
 */

import java.io.*;

public class Ex0803 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 3;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + 2*dp[i-2];
        }

        for(int i = 0; i < n+1; i++){
            System.out.print(dp[i] + " ");
        }
    }
}
