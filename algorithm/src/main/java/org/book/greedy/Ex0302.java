package org.book.greedy;

import java.util.*;
/**
 * 실전문제2. 큰 수의 법칙
 * n: 배열 크기
 * m: 더하는 횟수
 * k: 반복 제한값
 */
public class Ex0302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        // 입력
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        // 배열 입력
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        //정렬 --> 가져다 쓰겠음
        //정렬: Arrays.sort
        //내림차순: Collections.reverseOrder() --> 를 쓰려면 int형이 아닌 Integer형
        Arrays.sort(arr, Collections.reverseOrder());

        // 큰 수 구하기 --> 수열 계산 버전
        int cnt = m/(k+1);
        answer = ((arr[0]*k + arr[1])*cnt) + (arr[0] *(m%(k+1)));

        System.out.println("answer: " + answer);
    }
}
