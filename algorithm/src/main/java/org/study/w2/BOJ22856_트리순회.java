package org.study.w2;

/**
 * 1차원 배열에 넣고 탐색?
 * 일단 해보지뭐
 */
import java.io.*;
import java.util.*;
public class BOJ22856_트리순회 {
	static int n;
	static int[] tree;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		//1~n번 까지의 배열 생성
		tree = new int[n+1];
		
		//트리 값 입력
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int root = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			int pos = i+1;
			if(tree[pos] == 0) {
				tree[pos] = root;
			}
			
			if((pos *2) <= n) {
				if(tree[pos*2] == 0) {
					tree[pos*2] = left;	
				} 
			}
			
			if(((pos *2) + 1) <= n) {
				if(tree[(pos*2) + 1] == 0) {
					tree[(pos*2) + 1] = right;	
				} 
			}	
		}
		

		
	}
	
//	static int cnt = 0;
//	static void inorder(int index) {
////		cnt += 1;
//		System.out.println(index + " " + cnt);
//		if(index * 2 > n) {
//			return;
//		}
//		cnt += 1;
//		inorder(index * 2);
//		cnt += 1;
//		inorder((index * 2) + 1);
//		cnt += 1;
//	}
}
