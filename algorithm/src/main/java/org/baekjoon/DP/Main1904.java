package org.baekjoon.DP;
/**
 * 플랫폼: 백준
 * 문제번호: 1904
 * 문제이름: 01타일
 * 유형: dp
 * 난이도: 실버3
 */

import java.io.*;
import java.util.*;

public class Main1904 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n < 3){
            System.out.println(n);
            return;
        }else{
            int[] dp = new int[n+1];

            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;


            for(int i = 3; i <= n; i++){
                dp[i] = (dp[i-1] + dp[i-2]) % 15746;
            }
            System.out.println(dp[n]);
        }
    }
}
