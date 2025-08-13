package org.study.w2;

/**
 * NxN 도시
 * 구성요소:0: 빈칸, 1: 집, 2: 치킨집
 * 치킨거리: 집과 가장 가까운 치킨집 사이의 거리
 *          치킨거리는 집을 기준으로 정해지며, 각각의 집은 치킨 거리를 가지고 있음
 * 도시의 치킨거리: 모든 집의 치킨거리의 합
 *
 * * 치킨 거리 구하는 공식
 *      |row1 - row2| + |col1 - col2|
 *  이 도시의 치킨집을 M개로 제한, 그 외의 치킨집은 폐업
 *  -> 그렇게 고른 M개의 치킨집들 중 도시의 치킨 거리가 가장 작게 구현되는 경우
 */

/**
 * 1. n과 m 입력, 배열값 입력
 * 2. 입력받으면서 치킨집 갯수 체크해서 m이랑 같으면 줄일 필요 없
 *
 */

import java.io.*;
import java.util.*;

public class BOJ15686_치킨배달 {
    static int n;
    static int m;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Pair> housePos = new ArrayList<>();
    static ArrayList<Pair> chickenPos = new ArrayList<>();
    static int[] selectedArr;
    static int[][] distance;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        //입력받으면서 좌표값 배열에 넣
        for(int i = 0; i <n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(st.nextToken());
                if(val == 1){
                    housePos.add(new Pair(i,j));
                }else if(val ==2){
                    chickenPos.add(new Pair(i, j));
                }
            }
        }

        //거리 미리 계산
        distance = new int[housePos.size()][chickenPos.size()];

        for(int i = 0; i < housePos.size(); i++){
            for(int j = 0; j < chickenPos.size(); j++){
                distance[i][j] = Math.abs(housePos.get(i).x - chickenPos.get(j).x)
                                    + Math.abs(housePos.get(i).y - chickenPos.get(j).y);
            }
        }

        selectedArr = new int[m];
        //탐색- 조합 배열 - 치킨집 사이즈
        dfs(0,0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
    static void dfs(int chickenInt, int depth){
        if(depth == m){
            //최소값 계산
            int cityChickenDist = 0;
            for(int i = 0; i < housePos.size(); i++){
                int chickenDist = Integer.MAX_VALUE;
                for(int j = 0; j < m; j++){
                    int curDist = distance[i][selectedArr[j]];
                    chickenDist = Math.min(chickenDist, curDist);
                }
                cityChickenDist += chickenDist;
                //백트래킹 - 현재 계산하고있는 값이 최소값보다 크다면 탐색 불필요
                if(cityChickenDist > answer){
                    return;
                }
            }
            answer = Math.min(answer, cityChickenDist);
            return;
        }


        if(chickenInt == chickenPos.size()){
            return;
        }

        selectedArr[depth] = chickenInt;
        dfs(chickenInt + 1, depth + 1);

        selectedArr[depth] = 0;
        dfs(chickenInt + 1, depth);



    }
    static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
