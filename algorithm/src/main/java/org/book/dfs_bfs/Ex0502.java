package org.book.dfs_bfs;

/** 예제 5-2. 미로 탈출 - DFS/BFS
 *  NxM 크기의 직사각형 형태 미로에서 1,1 -> n,m 까지 이동
 *  이 중 0은 괴물이 있는 부분으로 가면안됨
 *  나가기 위해 움직여야하는 최소 칸의 갯수
 */

import java.io.*;
import java.util.*;

public class Ex0502 {
    static int n = 0;
    static int m = 0;
    static int[][] map;
    static int[] dx = { 1, 0, -1, 0};
    static int[] dy = { 0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        //map 사이즈
        map = new int[n][m];
        //map 입력
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        bfs(0,0);

    }
    //그냥 1인 부분만 탐색 시켜
    static void bfs(int x, int y){
        int mx = 0;
        int my = 0;

        // 큐 생성
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(x, y));

        while(!q.isEmpty()){

            Pair curPos = q.remove();
            if(curPos.x == n-1 && curPos.y == m-1)
                break;

            for(int i = 0; i < 4; i++){
                mx = curPos.x + dx[i];
                my = curPos.y + dy[i];

                if(mx < 0 || mx >= n || my < 0 || my >=m)
                    continue;

                if(map[mx][my] == 1){
                    //System.out.println("mx: " + mx + ", my: " + my);
                    map[mx][my] = map[curPos.x][curPos.y] + 1;
                    q.add(new Pair(mx, my));
                }
            }
        }

        System.out.println(map[n-1][m-1]);

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
