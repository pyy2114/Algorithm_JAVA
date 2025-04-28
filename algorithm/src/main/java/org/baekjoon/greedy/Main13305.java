package org.baekjoon.greedy;
/**
 * 플랫폼: 백준
 * 문제번호: 13305
 * 문제이름: 주유소
 * 유형: 그리디
 * 난이도: 실버3
 */

import java.util.*;
import java.io.*;

public class Main13305 {
    public static void main(String[] args) throws IOException {
        long answer = 0;
        ArrayList<Integer> loadArr = new ArrayList<>();
        ArrayList<Integer> cityArr = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //n 입력
        int n = Integer.parseInt(br.readLine());
        //거리값 파싱해서 arr로
        String loadStr = br.readLine();
        String[] loadStrArr = loadStr.split(" ");

        for(String s : loadStrArr){
            loadArr.add(Integer.parseInt(s));
        }
        //도시별 기름 값 파싱해서 arr로
        String cityStr = br.readLine();
        String[] cityStrArr = cityStr.split(" ");

        for(String s : cityStrArr){
            cityArr.add(Integer.parseInt(s));
        }

        //주요소 값 변경
        for(int i = 1; i < cityArr.size(); i++){
            if(cityArr.get(i-1) < cityArr.get(i)){
                cityArr.set(i, cityArr.get(i-1));
            }else{
                continue;
            }
        }

        //가격 계산
        for(int i = 0; i < loadArr.size(); i++){
            answer += (long) loadArr.get(i) * cityArr.get(i);
        }

        System.out.println(answer);
    }
}
