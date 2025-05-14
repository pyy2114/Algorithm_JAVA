package org.baekjoon.dfs_bfs;
/**
 * 플랫폼: 백준
 * 문제번호: 1697
 * 문제이름: 숨박꼭질
 * 유형: 그래프 탐색
 * 난이도: 실버1
 */

import java.util.*;
import java.io.*;

public class Main1697 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");


        //수빈 위치
        int n = Integer.parseInt(str[0]);
        //동생 위치
        int k = Integer.parseInt(str[1]);
        //설마 갖은 값을 줄까..?
        if(n == k){
            System.out.println(0);
            return;
        }

        //bfs용 큐
        Queue<Pair> q = new LinkedList<>();
        //방문처리?
        int[] visit = new int[100001];

        int[] dx = {1,-1, 2};

        //큐 삽입
        q.add(new Pair(0, n));
        visit[n] = 1;

        while(!q.isEmpty()){
            //큐 pop
            Pair cur = q.remove();

            if(cur.pos == k){
                //도달시 반복문 종료
                System.out.println(cur.cnt);
                break;
            }

            //탐색
            int mv = 0;
            for(int i = 0; i < 3; i++){
                if(i < 2)
                    mv = cur.pos + dx[i];
                else
                    mv = cur.pos * dx[i];

                //범위
                if((mv >= 0 && mv <= 100000) && (visit[mv] == 0)){
                    q.add(new Pair(cur.cnt + 1, mv));
                    visit[mv] = 1;
                }
            }

        }


    }

    static class Pair{
        int cnt = 0;
        int pos = 0;
        public Pair(int cnt, int pos){
            this.cnt = cnt;
            this.pos = pos;
        }

    }
}



