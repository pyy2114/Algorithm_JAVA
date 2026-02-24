package org.baekjoon.feb2026;

import java.io.*;
import java.util.*;

public class D0224_BOJ_9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 갯수 입력
        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스 만큼 문자열 입력
        for(int i = 0; i < T; i++){
            // 문자열 입력
            String str = br.readLine();

            // 입력받은 문자가 VPS인지 탐색
            if(i != 0){
                sb.append("\n").append(checkVPS(str));
            }else{
                sb.append(checkVPS(str));
            }

        }

        System.out.println(sb);
    }

    static String checkVPS(String str){
        Stack<Character> stack = new Stack<>();

        // (면 스택에 넣고, )면 스택에 있는거 빼기
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if(c == '('){
                stack.push('(');
            }else{
                if(stack.empty()){
                    return "NO";
                }else{
                    stack.pop();
                }
            }
        }

        //마지막에 stack이 비어있으면 Yes고 남아있으면 NO
        if(stack.empty()){
            return "YES";
        }

        return "NO";
    }
}
