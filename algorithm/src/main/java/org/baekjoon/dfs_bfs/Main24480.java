package org.baekjoon.dfs_bfs;
/**
 * 플랫폼: 백준
 * 문제번호: 24480
 * 문제이름: 알고리즘 수업 - 깊이 우선 탐색 2
 * 유형: 그래프 탐색
 * 난이도: 실버2
 */

import java.io.*;
import java.util.*;

public class Main24480 {

    static ArrayList<Integer>[] arr;
    static int[] visit;
    static int cnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str1 = br.readLine().split(" ");

        int n = Integer.parseInt(str1[0]);
        int m = Integer.parseInt(str1[1]);
        int st = Integer.parseInt(str1[2]);

        arr = new ArrayList[n+1];

        for(int i = 1; i <= n; i++){
            arr[i] = new ArrayList<>();
        }

        visit = new int[n+1];

        for(int i = 0; i < m; i++){
            String[] str2 = br.readLine().split(" ");
            int u = Integer.parseInt(str2[0]);
            int v = Integer.parseInt(str2[1]);

            arr[u].add(v);
            arr[v].add(u);
        }

        //내림차순 정렬
        for(int i = 1; i <= n; i++){
            Collections.sort(arr[i], Collections.reverseOrder());
        }


        dfs(st);

        for(int i = 1; i <= n; i++){
            System.out.println(visit[i]);
        }
    }

    static void dfs(int node){
        cnt += 1;

        visit[node] = cnt;

        for(int i = 0; i < arr[node].size(); i++){
            if(visit[arr[node].get(i)] == 0){
                dfs(arr[node].get(i));
            }
        }

    }
}
