package org.book.dfs_bfs;

/** 예제 5-1. 음료수 얼려 먹기 - DFS/BFS
 *  n과 m 사이즈의 배열에서 n:가로, m:세로
 *  1은 벽 0이 구멍
 *  0이 뭉쳐있는 구간 갯수 찾기
 */
import java.io.*;

public class Ex0501_DFS {
    //전역(스태틱)으로 선언
    static int[][] map;
    static int n;
    static int m;
                      //상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = { 0, 0, -1, 1};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //배열 사이즈 입력
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        //map값 입력
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        //map 탐색
        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0){
                    answer += 1;
                    dfs(i,j);
                }
            }
        }

        //답
        System.out.println(answer);
    }

    static void dfs(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m)
            return;
        //탈출 조건
        if(map[x][y] == 1)
            return;

        map[x][y] = 1;

        for(int i = 0; i < 4; i++){
            dfs(x + dx[i], y + dy[i]);
        }
    }


}
