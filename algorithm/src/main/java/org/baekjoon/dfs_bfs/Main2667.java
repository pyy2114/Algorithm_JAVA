package org.baekjoon.dfs_bfs;
/**
 * 플랫폼: 백준
 * 문제번호: 2667
 * 문제이름: 단지번호붙이기
 * 유형: 그래프 탐색
 * 난이도: 실버1
 */

import java.io.*;
import java.util.*;

public class Main2667 {
    static int n;
    static int[][] map;
    static ArrayList<Integer> answer = new ArrayList<>();

    static int[] dx = { -1, 0, 1, 0};
    static int[] dy = { 0, -1, 0, 1};
    static int answerCnt = 0;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1) {
                    dfs(i, j);
                    cnt += 1;
                    answer.add(answerCnt);
                    answerCnt = 0;
                }
            }
        }

        Collections.sort(answer);

        System.out.println(cnt);
        for (Integer i : answer) {
            System.out.println(i);
        }
    }

    static void dfs(int x, int y){
        answerCnt += 1;
        map[x][y] = 0;

        for(int i = 0; i < 4; i++){
            int mx = x + dx[i];
            int my = y + dy[i];

            if(mx >= 0 && mx < n && my >= 0 && my < n){
                if(map[mx][my] == 1){
                    dfs(mx, my);
                }else{
                    continue;
                }
            }
        }

    }

}
