package org.study.w1;
/**
 * 플랫폼: 백준
 * 문제번호: 2477
 * 문제이름: 참외밭
 * 유형: --
 * 난이도: 실버2
 */

import java.util.*;
import java.io.*;

public class Main2477 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());

        //참외밭 둘레 [0]: 방향, [1]: 길이
        int[][] arr = new int[6][2];

        //참외밭 둘레 입력받기
        //가로
        int row = Integer.MIN_VALUE;
        int checkRowIdx = 0;
        //세로
        int col = Integer.MIN_VALUE;
        int checkColIdx = 0;
        for(int i = 0; i < 6; i++){
            st = new StringTokenizer(br.readLine());

            //방향
            arr[i][0] = Integer.parseInt(st.nextToken());
            //길이
            arr[i][1] = Integer.parseInt(st.nextToken());

            //가로인지 세로인지 구분
            if(arr[i][0] == 4 || arr[i][0] == 3){
                //col
                if(col < arr[i][1]){
                    col = arr[i][1];
                    checkColIdx = i;
                }
            }else{
                //row
                if(row < arr[i][1]){
                    row = arr[i][1];
                    checkRowIdx = i;
                }
            }
        }

//        bw.write(col + " : " + checkColIdx + "\n");
//        bw.write(row + " : " + checkRowIdx + "\n");
//        bw.flush();

        int fullArea = row * col;

        //꺾이는 부분 탐색 -> 제일 긴 변 인덱스
        int curv1 = 0;
        int curv1Idx = 0;
        int curv2 = 0;
        int curv2Idx = 0;

        if(checkRowIdx > checkColIdx){
            if(checkColIdx == 0 && checkRowIdx == 5){
                //col인덱스에서 부터
                curv1Idx = (checkColIdx+2) % 6;
                curv2Idx = (checkColIdx+3) % 6;
            }else{
                //row인덱스에서 부터
                curv1Idx = (checkRowIdx+2) % 6;
                curv2Idx = (checkRowIdx+3) % 6;
            }
        }else{
            if(checkRowIdx == 0 && checkColIdx == 5){
                //row인덱스에서 부터
                curv1Idx = (checkRowIdx+2) % 6;
                curv2Idx = (checkRowIdx+3) % 6;
            }else{
                //col인덱스에서 부터
                curv1Idx = (checkColIdx+2) % 6;
                curv2Idx = (checkColIdx+3) % 6;
            }
        }
        curv1 = arr[curv1Idx][1];
        curv2 = arr[curv2Idx][1];

//        bw.write(curv1 + ", " + curv2 + "\n");
//        bw.flush();
        //꺾인 부분 면적
        int curvArea = curv1 * curv2;

        int answer = (fullArea - curvArea) * k;

        bw.write(answer + " ");
        bw.flush();

    }
}
