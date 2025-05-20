package org.book.binarySearch;
//반복문

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 10 7
// 1 3 5 7 9 11 13 15 17 19
//=> 3
//
// 10 7
// 1 3 5 6 9 11 13 15 17 19
//=> 원소가 존재하지 않습니다.
public class BinarySearch2 {
    static int[] arr;
    static int t;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        //배열 사이즈
        int n = Integer.parseInt(input[0]);
        //찾은 값
        t = Integer.parseInt(input[1]);

        //배열 선언
        arr = new int[n];

        //배열 입력 -> 정렬된 상태로 입력됨
        String[] arrStr = br.readLine().split(" ");

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        int st = 0;
        int ed = n-1;
        int result = -1;

        while(st <= ed){
            int mid = (ed+st)/2;

            if(arr[mid] < t){
                st = mid + 1;
            }else if(arr[mid] > t){
                ed = mid - 1;
            }else{
                result = mid;
                break;
            }
        }

        if(result == -1){
            System.out.println("원소가 존재하지 않습니다.");
        }else{
            System.out.println(result);
        }
    }

}
