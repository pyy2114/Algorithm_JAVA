package org.study.w2;

/**
 * n과 m 입력
 * nxm 사이즈 배열 생성 - 초기 배열
 * nxm 사이즈 배열 생성 - 비교 배열
 * 
 * 해당 배열(복사된 배열 사용 필요)을 (0~n-2),(0~m-2) 좌표로 이동하면서 값 변경
 */

import java.io.*;
import java.util.*;

public class BOJ1080_행렬 {
	static int n;
	static int m;
	static int[][] initArr;
	static int[][] resultArr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 원본 배열 생성
		initArr = new int[n][m];
		
		// 정답 배열 생성
		resultArr = new int[n][m];
		
		//각 배열 값 입력
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				initArr[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				resultArr[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}

		int cnt = 0;
		for(int i = 0; i < n-2; i++){
			for(int j = 0; j < m-2; j++){

				if(initArr[i][j] != resultArr[i][j]) {
					reverse(i, j);
					cnt += 1;
				}
//				printArr(initArr);
//				System.out.println();
			}
		}

		if(check()){
			bw.write(cnt + "\n");
		}else{
			bw.write(-1 + " \n");
		}
		bw.flush();
		bw.close();
		
	}
	
	static void reverse( int x, int y) {
		for(int i = x; i < x + 3; i++) {
			for(int j = y; j < y + 3; j++) {
				initArr[i][j] = initArr[i][j] == 1? 0:1;
			}
		}
	}
	
	static boolean check() {
		// 결과 배열과 현재 배열 비교
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				// 다른 배열 찾으면 비교 종료
				if(initArr[i][j] != resultArr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	static void printArr(int[][] arr){
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
