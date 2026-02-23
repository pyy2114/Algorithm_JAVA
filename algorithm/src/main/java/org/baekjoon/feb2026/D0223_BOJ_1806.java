package org.baekjoon.feb2026;

import java.io.*;
import java.util.*;

/**
 * n 수열 갯수
 * s 기준값
 *
 * 연속되는 수열들 중, 그 합이 s 이상인 수열 중 길이가 가장 짧은 것
 *
 * 1. 연속된 수열 찾기 =--> 이걸 모르겠는뎁
 * 2. 그 수열 내에서 부분합으로 s 이상인 구간의 길이 찾기
 * -> 그 부분을 다 더했을때  s 보다 작으면 그냥 패스, 크면 부분 찾기
 *
 * 무지성으로 풀어보고, 터지면 고쳐야징
 */
public class D0223_BOJ_1806 {
    static int n;
    static int s;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n과 s 입력
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        // n사이즈 배열 생성
        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        int[] sumArr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i == 0){
                sumArr[i] = arr[i];
            }else{
                sumArr[i] = sumArr[i-1] + arr[i];
            }
        }

//        for(int s : sumArr){
//            System.out.print(s + " ");
//        }
        int len = 0;
        int minVal = Integer.MAX_VALUE;

        for(int i = n - 1; i >= 0; i--){
//            int val = sumArr[i];
//            if(val == s){
//                len = n;
//            }else if(val < s){
//
//            }else{
//                for(int j = i - 1; j >= 0; j--){
//
//                }
//            }

        }


    }


}
