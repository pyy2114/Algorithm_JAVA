package org.book.DP;

/**
 * 효율적인 화폐 구성
 * n가지 종류의 화폐
 * 합이 m원
 * m을 만들기 위한 최소 화폐 갯수
 * 불가능 시 -1 출력
 * 1 <= n <= 100
 * 1 <= m <= 10000
 */
import java.io.*;
import java.util.Arrays;

public class Ex0804 {
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] money = new int[n];

        for(int i = 0; i < n; i++){
            money[i] = Integer.parseInt(br.readLine());
        }

        // 0~m 의 금액동안 주어진 화폐로 만들 수 있는 최소갯수 저장
        int[] dp = new int[m+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        //dp 수행
        //금액 0은 만들 수 없으니깐 0으로 초기화
        dp[0] = 0;

        for(int i = 0; i < n; i++){
            for(int j = money[i]; j <= m; j++){
                if(dp[j - money[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j - money[i]] + 1);
                }
            }
//
//            for(int d : dp){
//                System.out.print(d + " ");
//            }
//            System.out.println();
        }

        if(dp[m] == Integer.MAX_VALUE){
            // 조합 불가
            System.out.println(-1);
        }else{
            System.out.println(dp[m]);
        }
    }
}
