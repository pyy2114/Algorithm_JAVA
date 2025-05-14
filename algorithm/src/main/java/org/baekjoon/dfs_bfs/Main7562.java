package org.baekjoon.dfs_bfs;
/**
 * 플랫폼: 백준
 * 문제번호: 7562
 * 문제이름: 나이트의 이동
 * 유형: 그래프 탐색
 * 난이도: 실버1
 */
import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main7562 {
    static ArrayList<Integer> answers = new ArrayList<>();

    static void bfs(int n, int sx, int sy, int ex, int ey){
        int[] dx = {-2,-2,-1,-1, 1, 1, 2, 2};
        int[] dy = {-1, 1,-2, 2,-2, 2,-1, 1};

        int[][] map = new int[n][n];

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(sx, sy));

        while(!q.isEmpty()){
            Pair cur = q.remove();

            if(cur.x == ex && cur.y == ey){
                answers.add(map[cur.x][cur.y]);
                return;
            }

            for(int i = 0; i < 8; i++){
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];

                if((mx >= 0 && mx < n && my >= 0 && my < n)&&(map[mx][my] == 0)){
                    q.add(new Pair(mx, my));
                    map[mx][my] = map[cur.x][cur.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            int size = Integer.parseInt(br.readLine());
            String[] stPos = br.readLine().split(" ");
            String[] edPos = br.readLine().split(" ");

            bfs(size, Integer.parseInt(stPos[0]), Integer.parseInt(stPos[1]),
                      Integer.parseInt(edPos[0]), Integer.parseInt(edPos[1]));
        }

        for (Integer answer : answers) {
            System.out.println(answer);
        }
    }

    static class Pair{
        int x = 0;
        int y = 0;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
