package org.baekjoon.greedy;
/**
 * 플랫폼: 백준
 * 문제번호: 1931
 * 문제이름: 회의실 배정
 * 유형: 그리디
 * 난이도: 골드5
 */
import java.io.*;
import java.util.*;

public class Main1931 {
    public static void main(String[] args) throws IOException{
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //회의 갯수 입력
        int n = Integer.parseInt(br.readLine());

        //짝 객체 만큼 배열 생성
        Meeting[] mt = new Meeting[n];
        //회의 값 입력
        for(int i = 0; i < n; i++){
            String meeting = br.readLine();
            String[] parseTime = meeting.split(" ");
            mt[i] = new Meeting(Integer.parseInt(parseTime[0]), Integer.parseInt(parseTime[1]));
        }

        //끝나는 시간으로 정렬
        Arrays.sort(mt, (m1, m2) ->{
            if(m1.endTime == m2.endTime){
                return m1.startTime - m2.startTime;
            }
            return m1.endTime - m2.endTime;
        });

        //그리디
        int curEd = mt[0].endTime;
        answer += 1;
        for(int i = 1; i < n; i++){
            if(mt[i].startTime >= curEd){
                curEd = mt[i].endTime;
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}

class Meeting{
    int startTime = 0;
    int endTime = 0;

    public Meeting(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}

