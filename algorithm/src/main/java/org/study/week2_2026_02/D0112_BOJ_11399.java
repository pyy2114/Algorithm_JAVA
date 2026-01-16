package org.study.week2_2026_02;

import java.io.*;
import java.util.*;

// 아 난다 그리디 냄새가 난다
public class D0112_BOJ_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        // n 사람 수
        int n = Integer.parseInt(st.nextToken());

        // 각 사람이 돈을 인출하는데 걸리는 시간 배열 n개
        int[] arr = new int[n];

        // 그냥 정렬때리고, 누적합 때리면됨
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        int answer = arr[0];
        for(int i = 1; i < n; i++){
            arr[i] += arr[i-1];
            answer += arr[i];
        }

        System.out.println(answer);

    }
}


