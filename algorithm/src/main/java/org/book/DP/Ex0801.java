package org.book.DP;

/**
 * 1 만들기
 * /5, /3, /2, -1 연산들을 사용해 최소횟수로 1만들기
 */
import java.io.*;

public class Ex0801 {
    static int[] dp = new int[30001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //System.out.println(topDown(n));
        System.out.println(bottomUp(n));
    }

    /**
     * Top-Down 방식
     * n부터 1로가는 최소 횟수를 탐색
     *
     */
    static int topDown(int n){
        if(n == 1){
            return 0;
        }
        if(dp[n] != 0)
            return dp[n];

        int min = Integer.MAX_VALUE;

        if(n % 5 == 0){
            min = Math.min(min, topDown(n / 5));
        }
        if(n % 3 == 0){
            min = Math.min(min, topDown(n / 3));
        }
        if(n % 2 == 0){
            min = Math.min(min, topDown(n / 2));
        }

        min = Math.min(min, topDown(n-1));

        dp[n] = min + 1;

        return dp[n];
    }

    /**
     * Bottom Up 방식
     * 1부터 n까지 올라가면서
     * 각 숫자(i)에 어떻게 도달했는지를 누적해서
     * 최소 횟수를 구함
     */
    static int bottomUp(int n){
        int[] dp = new int[30001];

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + 1;

            if(i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if(i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            if(i % 5 == 0)
                dp[i] = Math.min(dp[i], dp[i/5] + 1);
            System.out.println(i + " = " + dp[i]);
        }

        return dp[n];
    }
}
