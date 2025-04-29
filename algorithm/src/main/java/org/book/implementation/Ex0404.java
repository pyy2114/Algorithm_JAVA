package org.book.implementation;
/** 실전 4-4. 게임 개발 - 구현
 *  N: 맵의 세로 크기
 *  M: 맵의 가로 크기
 *  둘째 줄: 캐릭터 위치(a,b) 와 바라보는 방향
 *  방향: 동: 1, 서:  3, 남:  2. 북: 0
 *  셋째 줄: 맵 지형
 *  1: 바다, 0: 육지
 *
 *  [출력]
 *  이동을 마친 후 캐릭터가 방문한 칸의 수
 */
import java.io.*;
import java.util.*;

public class Ex0404 {
    public static void main(String[] args) throws IOException{
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //0: n, 1: m
        String[] size = br.readLine().split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);
        //0: x, 1: y, 2: dir
        String[] characterInfo = br.readLine().split(" ");
        int x = Integer.parseInt(characterInfo[0]);
        int y = Integer.parseInt(characterInfo[1]);
        int dir = Integer.parseInt(characterInfo[2]);

        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        //방향
        int[] dx = {-1, 0, 1, 0};
        int[] dy = { 0, 1, 0,-1};

        int turnCnt = 0;
        answer = 1;
        while(true){
            dir = turnLeft(dir);

            int moveX = x + dx[dir];
            int moveY = y + dy[dir];

            if(map[moveX][moveY] == 0){
                x = moveX;
                y = moveY;
                map[x][y] = 1;
                answer += 1;
                turnCnt = 0;
            }else{
                turnCnt += 1;
            }

            if(turnCnt == 4){
                x = x-dx[dir];
                y = y-dy[dir];
                if(map[x][y] == 1)
                    break;
            }

        }

        System.out.println(answer);


    }

    static public int turnLeft(int dir){
        dir -= 1;
        if(dir < 0){
            dir = 3;
        }
        return dir;
    }
}
