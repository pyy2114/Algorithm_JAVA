package org.book.greedy;

import java.util.*;

/**
 * 실전문제 4. 1이 될 때까지
 * n: 주어진 수
 * k: 나눌 값
 */
public class Ex0304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 값 입력
        int n = sc.nextInt();
        int k = sc.nextInt();

        // 조건문 작성
        int answer = 0;
        while(n != 1){
            if(n % k == 0){
                n /= k;
            }
            else{
                n -= 1;
            }
            answer += 1;
        }

        System.out.println("answer: " + answer);

    }
}
