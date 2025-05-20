package org.book.binarySearch;

import java.util.*;
import java.io.*;

/**
 * 부품 갯수: n -> 리스트
 * 대량 구매할 부품 종류: m -> 리스트
 * n개의 부품들 중 m개의 리스트 안에 있는 부품이 모두 있는지 확인
 * 해당부품이 있으면 yes, 없으면 no 출력
 *
 */
public class Ex0701 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nArr = new int[n];
        String[] nStr = br.readLine().split(" ");

        for(int i = 0; i < n; i++){
            nArr[i] = Integer.parseInt(nStr[i]);
        }
        //정렬
        Arrays.sort(nArr);

        int m = Integer.parseInt(br.readLine());

        String[] mArr = br.readLine().split(" ");

        for(int i = 0; i < m; i++){
            int target = Integer.parseInt(mArr[i]);

            boolean result = binarySearch(nArr, 0, n-1, target);

            if(result){
                System.out.print("yes ");
            }else{
                System.out.print("no ");
            }

        }
    }

    static boolean binarySearch(int[] arr, int st, int ed, int target){

        while(st <= ed){
            int mid = (st+ed)/2;

            if(arr[mid] < target){
                st = mid + 1;
            }else if(arr[mid] > target){
                ed = mid - 1;
            }else{
                return true;
            }

        }

        return false;
    }
}
