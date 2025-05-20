package org.book.binarySearch;

import java.util.*;
import java.io.*;

public class Ex0702 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] str = br.readLine().split(" ");

        int[] arr = new int[n];

        int maxVal = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(str[i]);
            if(arr[i] > maxVal)
                maxVal = arr[i];
        }

        int st = 0;
        int ed = maxVal;
        int result = 0;
        while(st <= ed){
            int mid = (st+ed)/2;
            int total = 0;

            for(int i = 0; i < n; i++){
                if(arr[i] > mid){
                    total += arr[i] - mid;
                }
            }

            if(total > m){
                result = mid;
                st = mid + 1;
            }else if(total < m){
                result = mid;
                ed = mid - 1;
            }else{
                result = mid;
                break;
            }

        }

        System.out.println(result);

    }
}
