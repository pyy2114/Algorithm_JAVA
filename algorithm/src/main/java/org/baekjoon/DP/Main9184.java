package org.baekjoon.DP;

/**
 * 플랫폼: 백준
 * 문제번호: 9184
 * 문제이름: 신나는 함수 실행
 * 유형: dp
 * 난이도: 실버2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9184 {
    static int[][][] dp = new int[21][21][21];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = 0;
        int b = 0;
        int c = 0;

        dp[0][0][0] = 1;

        while(true){

            String[] str = br.readLine().split(" ");
            a = Integer.parseInt(str[0]);
            b = Integer.parseInt(str[1]);
            c = Integer.parseInt(str[2]);

            if(a == -1 && b ==-1 && c == -1){
                break;
            }

            int result = w(a,b,c);
            System.out.printf("w(%d, %d, %d) = %d\n",a,b,c,result);

        }
        //일단 재귀로


    }

    static int w(int a, int b, int c){
        if (a <= 0 || b <= 0 || c <= 0) {
            return dp[0][0][0];
        }

        if (a > 20 || b > 20 || c > 20) {
            dp[20][20][20] = w(20, 20, 20);
            return dp[20][20][20];
        }

        if(dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        //System.out.println("\t" + a + ", " + b + ", " + c);

        if (a < b && b < c) {
            dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

        return dp[a][b][c];

    }

}
