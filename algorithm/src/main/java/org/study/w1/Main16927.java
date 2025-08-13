package org.study.w1;
/**
 * 플랫폼: 백준
 * 문제번호: 16927
 * 문제이름: 배열 돌리기 2
 * 유형: --
 * 난이도: 골드5
 */

import java.io.*;
import java.util.*;

public class Main16927 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //행
        int n = Integer.parseInt(st.nextToken());
        //열
        int m = Integer.parseInt(st.nextToken());
        //횟수
        int r = Integer.parseInt(st.nextToken());

        // 입력 배열
        int[][] arr = new int[n][m];

        //배열 입력
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int tempN = n;
        int tempM = m;
        int posArrSize = 0;
        while(true){
            if(tempN < 2 || tempM < 2){
                posArrSize++;
                break;
            }
            posArrSize++;
            tempN -= 2;
            tempM -= 2;
        }

        int[] dx = {0,1,-1,0};
        int[] dy = {1,0,0,-1};

        int[][] visited = new int[n][m];

        ArrayList<Pair>[] posArr = new ArrayList[posArrSize];
        int x = 0;
        int y = 0;

        for(int i = 0; i < posArrSize; i++){
            int mx = x;
            int my = y;

            posArr[i] = new ArrayList<Pair>();

            for(int j = 0; j < 4; j++){
                while(true){
                    System.out.println(mx +", " + my + "  ");

                    visited[mx][my] = 1;
                    posArr[i].add(new Pair(mx, my));
                    if((mx + dx[j] < 0 || mx + dx[j] >= n || my + dy[j] < 0 || my + dy[j] >= m)||(visited[mx + dx[j]][my + dy[j]] == 1)){
                        break;
                    }

                    mx = mx + dx[j];
                    my = my + dy[j];
                }
            }
            System.out.println();
            x += 1;
            y += 1;
        }

        //위치값 확인
        for(int i = 0; i < posArrSize; i++){
            for(Pair p : posArr[i]){
                System.out.print("(" + p.x + ", " + p.y + ") ");
            }
            System.out.println();
        }


    }

    static class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}


