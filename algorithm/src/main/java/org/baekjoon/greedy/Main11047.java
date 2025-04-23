package org.baekjoon.greedy;

import java.util.*;

/**
 * 플랫폼: 백준
 * 문제번호: 11047
 * 문제이름: 동전0
 * 유형: 그리디
 * 난이도: 실버4
 */
public class Main11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n과 k 입력
        int n = sc.nextInt();
        int k = sc.nextInt();

        //System.out.println(n + ", " + k);
        ArrayList<Integer> coins = new ArrayList<>();

        // 동전 종류 입력
        for(int i = 0; i < n; i++){
            int val = sc.nextInt();
            if(val > k)
                continue;
            coins.add(val);
        }
        int answer = 0;
        int idx = coins.size() - 1;

        while(k != 0) {
            answer += k/coins.get(idx);
            k = k % coins.get(idx);
            idx--;
        }
        System.out.println(answer);
    }
}
