package org.book.greedy;

import java.util.*;

/**
 * 실전문제3. 숫자 카드게임
 * n: 행
 * m: 열
 */
public class Ex0303 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //행 열 값 입력
        int n = sc.nextInt();
        int m = sc.nextInt();

        //최솟값들 중의 최댓값
        int answer = 0;

        //카드 값 입력
        int card = 0;
        for(int i = 0; i < n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++){
                card = sc.nextInt();
                if(card < min){
                    min = card;
                }
            }
            if(answer < min){
                answer = min;
            }
        }

        System.out.println("answer: " + answer);

    }
}
