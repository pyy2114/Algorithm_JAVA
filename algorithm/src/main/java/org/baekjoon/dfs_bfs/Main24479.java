package org.baekjoon.dfs_bfs;
/**
 * 플랫폼: 백준
 * 문제번호: 24479
 * 문제이름: 알고리즘 수업 - 깊이 우선 탐색 1
 * 유형: 그래프 탐색
 * 난이도: 실버2
 */

import java.io.*;
import java.util.*;

public class Main24479 {

    static ArrayList<Integer>[] arr;
    static int[]  visit;
    static int cnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        //정점의 수 n  ->  배열 사이즈
        int n = Integer.parseInt(str[0]);

        //간선의 수 m  ->  for문 횟수
        int m = Integer.parseInt(str[1]);

        int r = Integer.parseInt(str[2]);

        arr = new ArrayList[n+1];

        for(int i = 1; i < n+1; i++){
            arr[i] = new ArrayList<>();
        }

        visit = new int[n+1];
        //전부 -1로 초기화
        //Arrays.fill(visit, -1);

        for(int i = 0; i < m; i++){
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            arr[u].add(v);
            arr[v].add(u);
        }
        //오름차순 정렬
        for(int i = 1; i < n; i++){
            Collections.sort(arr[i]);
        }

        dfs(r);
        for(int i = 1; i < n+1; i++){
            System.out.println(visit[i]);
        }
    }

    static void dfs(int r){
        cnt += 1;
        //방문 체크
        visit[r] = cnt;

        for(int i = 0; i < arr[r].size(); i++){
            int node = arr[r].get(i);
            if(visit[node] == 0){
                dfs(node);
            }
        }

    }
}
