package org.book.implementation;
/** 예제 4-2. 시각 - 구현
 * 00시부터 N시 59분 59초까지의 시간 중에 3이 하나라도 들어간 시간 갯수
 * 완전탐색-- 이게 뭔문젠가 했는데
 * 삼중포문으로 노가다 뛰는 문제였... 허
 */
import java.io.*;
import java.util.*;

public class Ex0402 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String three = "3";
        int answer = 0;

        for(int i = 0; i <= n; i++){            //시
            for(int j = 0; j < 60; j++){        //분
                for(int k = 0; k < 60; k++){    //초
                    boolean checkH = String.valueOf(i).contains(three);
                    boolean checkM = String.valueOf(j).contains(three);
                    boolean checkS = String.valueOf(k).contains(three);

                    if(checkH || checkM || checkS){
                        answer += 1;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
