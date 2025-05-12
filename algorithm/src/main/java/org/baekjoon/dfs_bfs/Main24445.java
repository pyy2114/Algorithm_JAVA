package org.baekjoon.dfs_bfs;
/**
 * 플랫폼: 백준
 * 문제번호: 24445
 * 문제이름: 알고리즘 수업 - 너비 우선 탐색 2
 * 유형: 그래프 탐색
 * 난이도: 실버2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main24445 {

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

        for(int i = 1; i <= n; i++){
            Collections.sort(arr[i], Collections.reverseOrder());
        }

        bfs(st);

        for(int i = 1; i <= n; i++){
            System.out.println(visit[i]);
        }
    }

    static void bfs(int st){
        Queue<Integer> q = new LinkedList<>();

        q.add(st);
        cnt += 1;
        visit[st] = cnt;
        while(!q.isEmpty()){
            int node = q.remove();

            for(int i = 0; i < arr[node].size(); i++){
                int nextNode = arr[node].get(i);
                if(visit[nextNode] == 0){
                    q.add(nextNode);
                    cnt += 1;
                    visit[nextNode] = cnt;
                }
            }
        }
    }
}
