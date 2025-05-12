package org.baekjoon.dfs_bfs;
/**
 * 플랫폼: 백준
 * 문제번호: 2606
 * 문제이름: 바이러스
 * 유형: 그래프 탐색
 * 난이도: 실버3
 */

import java.io.*;
import java.util.*;

public class Main2606 {
    static ArrayList<Integer>[] net;
    static int[] visit;
    static int cnt = 0;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        net = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            net[i] = new ArrayList<>();
        }

        visit = new int[n+1];

        for(int i = 0; i < m; i++){
            String[] input = br.readLine().split(" ");

            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            net[u].add(v);
            net[v].add(u);
        }

        dfs(1);

        System.out.println(cnt);
    }

    static void dfs(int cur){

        visit[cur] = 1;

        for(int i = 0; i < net[cur].size(); i++){
            int next = net[cur].get(i);
            if(visit[next] == 0){
                cnt += 1;
                dfs(next);
            }
        }
    }

}
