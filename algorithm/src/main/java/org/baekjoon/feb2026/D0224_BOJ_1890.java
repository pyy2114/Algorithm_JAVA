package org.baekjoon.feb2026;

import java.io.*;
import java.util.*;

public class D0224_BOJ_1890 {
    static int n;
    static int[][] map;

    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    static long ans = 0L;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n으로 맵 사이즈
        n = Integer.parseInt(br.readLine());
        // 맵, 방문배열 초기화
        map = new int[n][n];

        // nxn 사이즈 입력
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        System.out.println(ans);

    }

}
