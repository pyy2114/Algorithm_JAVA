package org.book.implementation;
/** 실전 4-3. 왕실의 나이트 - 구현
 *  8X8 사이즈 체스판에서 나이트의 위치값이 정해졌을 때
 *  나이트가 움직일 수 있는 경우의 수(범위를 벗어나지 않는 선에서)
 */
import java.io.*;
import java.util.*;

public class Ex0403 {
    public static void main(String[] args) throws IOException{
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pos = br.readLine();

        //[0] 문자 [1] 숫자 파싱
        int posX = (int)(pos.charAt(0) - 96);
        //character를 정수로 변환
        int posY = Character.getNumericValue(pos.charAt(1));

        //모든 경우의 수
        int[] dx = {-1, -1, 1, 1, -2, -2, 2, 2};
        int[] dy = {-2, 2, -2, 2, -1, 1, -1, 1};

        for(int i = 0; i < 8; i++){
            int addX = posX + dx[i];
            int addY = posY + dy[i];

            if(addX >= 1 && addX <= 8 && addY >= 1 && addY <= 8){
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}
