package org.baekjoon.implementation;
/**
 * 플랫폼: 백준
 * 문제번호: 14501
 * 문제이름: 퇴사
 * 유형: 구현
 * 난이도: 실버3
 */
import java.io.*;
import java.util.*;

public class Main14501 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //n입력
        int n = Integer.parseInt(br.readLine());

        //기간이랑 비용받을 어레이 두개 생성
        //기간
        int[] t = new int[n];
        //비용
        int[] p = new int[n];

        //시간 비용 입력
        for(int i = 0; i < n; i++){
            String[] input  = br.readLine().split(" ");
            t[i] = Integer.parseInt(input[0]);
            p[i] = Integer.parseInt(input[1]);
        }

        //dp 배열 생성: n+1 사이즈로 자바 초기값은 0
        int[] dp = new int[n+1];

        //역dp 실행
        for(int i = n-1; i >= 0; i--){
            if(i+t[i] <= n){
                dp[i] = Math.max(p[i] + dp[i+t[i]], dp[i+1]);
            }else{
                dp[i] = dp[i+1];
            }
        }

        System.out.println(dp[0]);
    }
}
