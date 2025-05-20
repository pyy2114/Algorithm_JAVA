package org.book.binarySearch;
//재귀함수
import java.util.*;
import java.io.*;

// 10 7
// 1 3 5 7 9 11 13 15 17 19
//=> 3

// 10 7
// 1 3 5 6 9 11 13 15 17 19
//=> 원소가 존재하지 않습니다.
public class BinarySearch1 {
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

        int answer = binarySearchMethod(0, n-1);

        if(answer == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        }else{
            System.out.println(answer);
        }
    }

    static int binarySearchMethod(int st, int ed){

        if(st > ed){
            return -1;
        }

        int mid = (ed+st)/2;

        if(arr[mid] < t){
            return binarySearchMethod(mid + 1, ed);
        }else if(arr[mid] > t){
            return binarySearchMethod(st, mid - 1);
        }

        return mid;
    }

}
