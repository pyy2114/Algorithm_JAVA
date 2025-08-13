package org.study.w1;

import java.io.*;
import java.sql.Array;
import java.util.*;

/**
 * 건물은 n개
 * -> 각 건물 옥상에서 양 옆에 존재하는 건물의 옆을 몇개 볼수 있는지
 * -> 출력
 *    해당 위치에서 볼 수 있는 건물, 그 건물들 중 가장 가까운 건물 번호(or 가장 작은)
 *
 */
public class Main22866 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        // 빌딩 높이 입력
        int[] buildings = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        //탐색
        // 왼, 오 스택 생성
        // 현재 인덱스 왼, 오 탐색해서 현재 값보다 크고 스택의 peek값 보다 크면 push(인덱스 값)
        // 두 스택에 들어있는 건물 개수 합이 건물 개수
        // 현재 인덱스와 각 스택 마지막에 있는 인덱스와의 차이 값 구해서 출력
        for(int i = 0; i < n; i++){
            Stack<Integer> left = new Stack<>();
            Stack<Integer> right = new Stack<>();
            //왼쪽 탐색
            for(int leftIdx = i-1; leftIdx >= 0 ; leftIdx--){
                // 현재 위치의 빌디보다 높고, 스택에 있는 끝에 값 보다 크면
                if(buildings[i] < buildings[leftIdx]){
                    if(left.isEmpty()){
                        left.push(leftIdx);
                    }else{
                        if(buildings[leftIdx] > buildings[left.peek()]){
                            left.push(leftIdx);
                        }
                    }

                }
            }
            //오른쪽 탐색
            for(int rightIdx = i+1; rightIdx < n; rightIdx++){
                // 현재 위치의 빌디보다 높고, 스택에 있는 끝에 값 보다 크면
                if(buildings[i] < buildings[rightIdx]){
                    if(right.isEmpty()){
                        right.push(rightIdx);
                    }else{
                        if(buildings[rightIdx] > buildings[right.peek()]){
                            right.push(rightIdx);
                        }
                    }
                }
            }

            //스택 갯수
            int total = left.size() + right.size();

            if(total == 0){
                System.out.println(total);
                continue;
            }

            int lastLeftIdx = (n+1) *(-1);
            int lastRightIdx = n*n;
            //왼쪽 비우기
            if(!left.isEmpty()){
                while(true){
                    if(left.size() == 1){
                        lastLeftIdx = left.pop();
                        break;
                    }
                    left.pop();
                }
            }


            //오른쪽 비우기
            if(!right.isEmpty()){
                while(true){
                    if(right.size() == 1){
                        lastRightIdx = right.pop();
                        break;
                    }
                    right.pop();
                }
            }

            //가까운 위치
            int leftDif = i - lastLeftIdx;
            int rightDif = lastRightIdx - i;
            int nearestIdx = 0;
            //System.out.println("lefDif: " + leftDif + ", riDif: " + rightDif);

            if(leftDif < rightDif){ //왼쪽이 더 작
                nearestIdx = lastLeftIdx + 1;
                System.out.println(total + " " + nearestIdx);
            }else if(leftDif > rightDif){ //오른쪽이 더 작
                nearestIdx = lastRightIdx + 1;
                System.out.println(total + " " + nearestIdx);
            }else{           //둘이 같
                nearestIdx = lastLeftIdx + 1;
                System.out.println(total + " " + nearestIdx);
            }

        }
    }

}
