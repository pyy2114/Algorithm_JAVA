package org.baekjoon.implementation;
/**
 * 플랫폼: 백준
 * 문제번호: 2578
 * 문제이름: 빙고
 * 유형: 구현
 * 난이도: 실버4
 */

import java.io.*;
import java.util.*;

public class Main2578 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] bingo = new int[5][5];
        //빙고판 입력
        for(int i = 0; i < 5; i++){
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < 5; j++){
                bingo[i][j] = Integer.parseInt(str[j]);
            }
        }

        //빙고판 위치값 저장
        Pos[] map = new Pos[26];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j <5; j++){
                int val = bingo[i][j];
                map[val] = new Pos(i,j);
            }
        }

        //숫자 입력받기
        ArrayList<Integer> numArr = new ArrayList<>();
        for(int i = 0; i < 5; i ++){
            String[] numStr = br.readLine().split(" ");
            for(int j = 0; j < 5; j++){
                numArr.add(Integer.parseInt(numStr[j]));
            }
        }

        //빙고 찾기
        int crossL = 0; //왼쪽 대각선 x+y = 4
        int crossR = 0; // 오른쪽 대각선 x == y
        int[] width = new int[5];   //가로줄 x
        int[] height = new int[5];  //세로줄 y

        //빙고 체크 여부
        boolean crossLCheck = false;
        boolean crossRCheck = false;
        boolean[] widthCheck = {false, false, false, false, false};
        boolean[] heightCheck = {false, false, false, false, false};

        //탐색 시작
        int bingoCnt = 0;
        for(int i = 0; i < 25; i++){
            //현재 숫자
            int curNum = numArr.get(i);

            //현재 숫자의 좌표값
            int x = map[curNum].x;
            int y = map[curNum].y;

            //빙고 카운트 체크
            if(x + y == 4)
                crossL += 1;
            if(x == y)
                crossR += 1;

            width[x] += 1;
            height[y] += 1;

            //빙고 카운트 후 초기화 필수
            if(crossL == 5 && !crossLCheck) {
                bingoCnt += 1;
                crossLCheck = true;
            }
            if(crossR == 5 && !crossRCheck) {
                bingoCnt += 1;
                crossRCheck = true;
            }
            if(width[x] == 5 && !widthCheck[x]) {
                bingoCnt += 1;
                widthCheck[x] = true;
            }
            if(height[y] == 5 && !heightCheck[y]){
                bingoCnt += 1;
                heightCheck[y] = true;
            }

            //빙고 3개 이상 -> 탈출
            if(bingoCnt >= 3){
                System.out.println(i+1);
                break;
            }
        }
    }

    static class Pos{
        int x;
        int y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
