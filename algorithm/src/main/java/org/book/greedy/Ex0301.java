package org.book.greedy;
// 자바 기본 패키지 import
import java.util.*;

/** 예제 3-1. 거스름돈 - Greedy
 *  당신은 음식점의 계산을 도와주는 점원이다. 카운터에는 거스름돈으로 사용할 500원, 100원, 50원, 10원짜리 동전이 무한히 존재한다고 가정한다.
 *  손님에게 거슬러 줘야 할 돈이 N원일 때 거슬러 줘야 할 동전의 최소 개수를 구하라. 단, 거슬러 줘야 할 돈N은 항상 10의 배수이다.
 */
public class Ex0301 {

    public static void main(String[] args) {
        //자바 input
        Scanner sc = new Scanner(System.in);
        // 입력받을 N 변수
        int n = sc.nextInt();
        // 답안 변수
        int answer = 0;
        //문제에 주어진 동전 종류 배열
        int[] arr = {500, 100, 50, 10};

        // n = 1260
        //제일 큰 동전 부터 for 문으로 계산
        for (int j : arr) {
            //만약 입력받은 N이 0인 경우 더이상 for문을 진행하지 않고 종료
            if (n == 0)
                break;
            // 동전 갯수 카운트
            answer += n / j;
            //남은 돈 계산
            n = n % j;
        }

        System.out.println("answer = " + answer);

    }
}
