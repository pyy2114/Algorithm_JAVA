package org.baekjoon.feb2026;

import java.io.*;
import java.util.*;

public class D0226_BOJ_2667 {
    static int n;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = { 0,-1, 0, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지도 크기
         n = Integer.parseInt(br.readLine());

        // 지도 배열, 방문배열
        map = new int[n][n];
        visited = new boolean[n][n];

        // 지도 값 입력
        for(int i = 0; i < n; i ++){
            String inputStr = br.readLine();
            for(int j = 0; j < n; j++){
                char c = inputStr.charAt(j);

                if(c == '1'){
                    map[i][j] = 1;
                }else{
                    map[i][j] = 0;
                }
            }
        }

        ArrayList<Integer> ansList = new ArrayList<>();

        // 탐색 -> 1이면 집 0이면 땅
        // 방문배열로 방문한 위치는 제외
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    if(map[i][j] == 1){ // 현재 값이 1이고, 방문된적이 없다면 bfs
                        ansList.add(BFS(i,j));
                    }else{  // 현재 값이 0이고 방문된적이 없다면 방문처리
                        visited[i][j] = true;
                    }
                }
            }
        }

        // 어레이 정렬
        Collections.sort(ansList);

        // 어레이 사이즈 출력
        System.out.println(ansList.size());
        for(int a : ansList){
            System.out.println(a);
        }

    }


    // 단지 내 주택 갯수 리턴
    static int BFS(int x, int y){
        // 들어오자마자 현재 집 카운트
        int count = 1;
        int mx = 0;
        int my = 0;
        Queue<Pair> q = new ArrayDeque<>();

        // 큐에 넣고 방문처리
        q.add(new Pair(x, y));
        // 방문처리
        visited[x][y] = true;
        //while로 bfs 탐색
        while(!q.isEmpty()){
            Pair p  = q.poll();

            for(int dir = 0; dir < 4; dir++){
                mx = p.x + dx[dir];
                my = p.y + dy[dir];

                // 범위 벗어나면 패스
                if(mx < 0 || mx >= n || my < 0 || my >= n)  continue;

                // 방문된적 없고, 값이 1이면 -> 큐에 넣음
                if(!visited[mx][my] && map[mx][my] == 1){
                    // 방문처리
                    visited[mx][my] = true;
                    // 카운트
                    count++;
                    // 큐에 넣음
                    q.add(new Pair(mx, my));
                }
            }
        }

        // 현재위치에서 인접한 주택 탐색 종료
        return count;
    }

    static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y =y;
        }
    }
}
