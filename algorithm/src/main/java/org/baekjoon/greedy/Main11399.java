package org.baekjoon.greedy;
/**
 * 플랫폼: 백준
 * 문제번호: 11399
 * 문제이름: ATM
 * 유형: 그리디
 * 난이도: 실버4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main11399 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        //한 줄로 받은 스트링 데이터를 공백으로 나눠서 토큰(단어)로 생성 -> 나눠진 값을 받아올 수 있음
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            //arr[i] = sc.nextInt();
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //배열 정렬
        Arrays.sort(arr);

        int answer = 0;
        int sum = 0;
        for(int a : arr){
            //누적합
            sum = sum + a;
            //최종 시간
            answer += sum;
        }

        System.out.println(answer);
    }
}
