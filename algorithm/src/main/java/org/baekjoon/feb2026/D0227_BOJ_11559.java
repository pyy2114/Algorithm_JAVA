package org.baekjoon.feb2026;

import java.io.*;
import java.util.*;


/**
 * 색깔
 * R
 * G
 * B
 * P
 * Y
 *
 * [구현 순서]
 * 1. 전체를 탐색
 * 2. 깨질 블록 위치 체크
 * 3. 체크한 부분 한번에 제거 및 카운트
 * 4. 비어있는 부분에 블록 내리기
 *
 * 더이상 사라질 블록이 없으면 중단
 */
public class D0227_BOJ_11559 {

    static char[][] map = new char[6][12];
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = { 0,-1, 0, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // map 사이즈 고정 6x12
        // map 입력
        String input;
        int ans = 0;

        for(int row = 0; row < 12; row++){
            input = br.readLine();
            for(int col = 0; col < 6; col++){
                map[row][col] = input.charAt(col);
            }
        }

        // 중력의 영향을 받으니까 밑에서 부터 탐색하는게 더빠를듯
        // 탐색할때마다 방문배열 새로 생성
        // 큐가 비면 그만 탐색 -> 큐는 부술 블록이 있는경우 채움
        Queue<Pair> blockQueue = new ArrayDeque<>();

        do{

            // 큐가 null이 아니면 큐에있는 블럭좌표들 값 .으로 변경(부수기)
            for(int i = 0; i < blockQueue.size(); i++){
                Pair curPos = blockQueue.poll();

                map[curPos.x][curPos.y] = '.';


            }
            // 1. 그냥 찾아서 띄어있는 애들 내린다? -> 탐색양이 많진 않음 ㅇㅈ?


            // 방문 배열 새로 생성
            visited = new boolean[6][12];

            for(int row = 11; row >= 0; row--){
                for(int col = 0; col < 6; col++){
                    /**
                     * . 이면 탐색 x
                     *  방문전이고, 색깔블록이면 탐색
                     */
                    if((map[row][col] != '.')&&(!visited[row][col])){
                       ArrayList<Pair> blockList = findBlock(row, col);

                        // 블럭좌표들 큐에 넣기 null이 아니면 카운트 세기
                        if(blockList != null){
                            blockQueue.addAll(blockList);
                            ans++;
                        }

                    }
                }
            }

        }while(!blockQueue.isEmpty());


    }

    // 부술 블록들 좌표 반환
    static ArrayList<Pair> findBlock(int x, int y){
        Queue<Pair> q = new ArrayDeque<>();
        ArrayList<Pair> pairList = new ArrayList<>();

        int mx = 0;
        int my = 0;

        // bfs로 탐색
        q.add(new Pair(x, y));
        pairList.add(new Pair(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Pair pos = q.poll();

            char color = map[pos.x][pos.y];

            for(int dir = 0; dir < 4; dir++){
                mx = pos.x + dx[dir];
                my = pos.y + dy[dir];

                if(mx < 0 || mx >= 12 || my < 0 || my >= 6) continue;
                // 방문하지 않고, 같은 색깔의 배열있다면 큐에 넣기,
                if((!visited[mx][my])&&(map[mx][my] == color)){
                    q.add(new Pair(mx, my));
                    pairList.add(new Pair(mx, my));
                    visited[mx][my] = true;
                }
            }

        }

        if(pairList.size() >= 4){
            return pairList;
        }

        return null;    // 블록이 4개 미만
    }

    static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
