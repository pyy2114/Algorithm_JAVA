package org.swea;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution1954 {
    static int[][] snail;
    static int[][] visit;
    static int n;
    static int[] dx = {0, 1, 0,-1};
    static int[] dy = {1, 0,-1, 0};
    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        for(int test_case = 1; test_case <= T; test_case++)
        {

            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////
            n = sc.nextInt();

            snail = new int[n][n];
            visit = new int[n][n];

            dfs(0,0, 1);

            //출력
            System.out.println("#" + test_case);
            for(int i = 0 ; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(snail[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    static void dfs(int x, int y, int cnt){
        if(visit[x][y] ==1)
            return;

        //System.out.println(x + ", " + y + " : " + cnt);
        snail[x][y] = cnt;
        visit[x][y] = 1;

        for(int i = 0; i < 4; i++){
            int mx = x + dx[i];
            int my = y + dy[i];

            if(mx >= 0 && mx < n && my >= 0 && my < n){
                dfs(mx, my, cnt+1);
            }
        }
    }
}
