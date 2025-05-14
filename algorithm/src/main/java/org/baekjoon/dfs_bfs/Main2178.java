package org.baekjoon.dfs_bfs;
/**
 * 플랫폼: 백준
 * 문제번호: 2178
 * 문제이름: 미로 탐색
 * 유형: 그래프 탐색
 * 난이도: 실버1
 */
import java.io.*;
import java.util.*;

public class Main2178 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = { 0,-1, 0, 1};

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0,0));

        while(!q.isEmpty()){
            Pair cur = q.remove();

            if(cur.x == n-1 && cur.y == m-1){
                System.out.println(map[n-1][m-1]);
                break;
            }
            for(int i = 0; i < 4; i++){
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];

                //범위
                if((mx >= 0 && mx < n && my >= 0 && my < m) && (map[mx][my] == 1)){
                    q.add(new Pair(mx, my));
                    map[mx][my] = map[cur.x][cur.y] + 1;
                }

            }
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
