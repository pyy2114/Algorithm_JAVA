package org.study.week2_2026_02;

import java.io.*;
import java.util.*;

public class D0113_BOJ_15652 {
    static int n,m;
    static int[] arr;
    static int[] answer;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        arr = new int[n+1];

        for(int i = 1; i <= n; i++){
            arr[i] = i;
        }

        answer = new int[m];
        recursive(1, 0);

        System.out.print(sb.toString());
    }

    static void recursive(int cur, int idx){
        if(idx == m){
            for(int i = 0; i < m; i++){
                // 공백 안맞으면 틀렸다 나옴
                if(i > 0)
                    sb.append(" ");
                sb.append(answer[i]);
            }
            sb.append("\n");
            return;
        }

        for(int i = cur; i <= n; i++){
            answer[idx] = i;
            recursive(i, idx + 1);
        }

    }
}


