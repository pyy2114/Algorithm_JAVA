package org.baekjoon.feb2026;

import java.io.*;
import java.util.*;

public class D0225_BOJ_2015 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        // n은 배열 인덱스 갯수
        int n = Integer.parseInt(st.nextToken());

        // k 는 합 -> long 20억
        long k = Long.parseLong(st.nextToken());

        // 부분합 배열 생성
        long[] sumArr = new long[n];

        // 부분합 배열 입력
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            long num = Long.parseLong(st.nextToken());

            if(i != 0){
                sumArr[i] = sumArr[i-1] + num;
            }else{
                sumArr[i] = num;
            }
        }


        // for문 계산 시 시간 터짐
//        int cnt = 0;
//        long val = 0;
//
//        for(int i = 0; i < n; i++){
//            for(int j = i; j < n; j++){
//                if(i == 0){
//                    val = sumArr[j];
//                }else{
//                    val = sumArr[j] - sumArr[i-1];
//                }
//
//                if(val == k){
//                    cnt++;
//                }
//            }
//        }

        long cnt = 0;
        Map<Long, Long> map = new HashMap<>();

        map.put(0L, 1L);

        for(int i = 0; i < n; i++){
            long need = sumArr[i] - k;
            cnt += map.getOrDefault(need, 0L);
            map.put(sumArr[i], map.getOrDefault(sumArr[i], 0L) + 1);
        }

        System.out.println(cnt);

    }

}
