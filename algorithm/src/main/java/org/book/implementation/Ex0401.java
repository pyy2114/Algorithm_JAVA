package org.book.implementation;

/** 예제 4-1. 상하좌우 - 구현
 *  지도: NxN ((1,1) ~ (N,N))
 *  L,R,U,D로 이동
 *  주어지는 좌표값에 따라 이동 시 최종 도착하는 좌표 위치는?
 *  (단, 공간 범위를 넘어서면 무시)
 *  [입력조건]
 *  첫째줄 N
 *  두째줄: 이동 계획
 *  [출력 조건]
 *  최종 도착 좌표값
 */
import java.io.*;
import java.util.*;

public class Ex0401 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //n값 입력
        int n = Integer.parseInt(br.readLine());

        // 이동 좌표 값 입력
        String inputStr = br.readLine();
        String[] moveArr = inputStr.split(" ");

        int x = 1;      // 1~5
        int y = 1;      // 1~5
        for(int i = 0; i < moveArr.length; i++){
            String move = moveArr[i];
            int moveX = 0;
            int moveY = 0;

            if(move.equals("L")){
                moveY -= 1;
            }else if(move.equals("R")){
                moveY += 1;
            }else if(move.equals("U")){
                moveX -= 1;
            }else if(move.equals("D")){
                moveX += 1;
            }

            if((x+moveX < 1 || x+moveX > n)||(y+moveY < 1 || y+moveY > n)){
                continue;
            }
            x += moveX;
            y += moveY;
        }
        System.out.println(x + " " + y);
    }
}
