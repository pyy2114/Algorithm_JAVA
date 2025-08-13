package org.study.w2;

/**
 * n과 m 사이즈 주어짐
 * .은 빈칸, /\는 행성, c는 블랙홀
 * 맨 마지막 줄에 탐사선 위치 주어짐(1~n,1~m)
 * [종료조건]
 * - 블랙혹이 있는 칸을 만나거나, 항성계를 벗어남(벽을 넘어감)면 끝
 * URDL로 보내보고, 
 * 이 중 가장 오래 머문 방향과 시간 출력
 * 한 칸 이동시 카운트 1
 * 만약 무한 루프를 돈다면(원래 위치로 돌아온거겠지?) 이러면 Voyager를 출력(좋은거네)
 * -> 어느 방향으로 보냈는데 시작점으로 돌아왔다? 이러면 voyager 출력
 */

import java.io.*;
import java.util.*;

public class BOJ3987_보이저1호 {
	static int n;
	static int m;

	static char[][] space;

	//방향 종류
	static char[] direction = {'U', 'R', 'D', 'L'};

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = { 0, 1, 0, -1};


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		//nxm 사이즈 space
		space = new char[n][m];
		//배열 입력받기
		for(int i = 0; i < n; i++){
			String inputLine = br.readLine();
			for(int j = 0; j < m; j++){
				space[i][j] = inputLine.charAt(j);
			}
		}

		//탐사선 = probe
		st = new StringTokenizer(br.readLine());
		int probeX = Integer.parseInt(st.nextToken());
		int probeY = Integer.parseInt(st.nextToken());
		//--------------입력 끝

		// 탐색 시작
		/**
		 * 1. 처음 for문 -> 시작하는 4방향용
		 * 2. 1번 for문 안에서 while로 탐색 끝날때까지 탐색
		 * 3. 이동할때마다 1씩 카운트, 그중 max값 찾기
		 * 4. 이동시킬 때, 행성을 만나는 경우를  대비하여, 처리문 다 넣어놓기
		 */
		int maxTime = Integer.MIN_VALUE;
		int maxDir = 0;
		for(int dir = 0; dir < 4; dir++){
			// 각 방향마다 시간 측정
			int time = 0;

			//함수 호출?
			time = find(dir, probeX-1, probeY-1);

			if(time == -1) {
				//무한루프
				bw.write(direction[dir] + "\n");
				bw.write("Voyager");
				bw.flush();
				bw.close();
				return;
			}else{
				// 최댓값 비교
				//System.out.println(direction[dir] + " : " + time);
				if(maxTime < time){
					maxTime = time;
					maxDir = dir;
				}
			}
		}
		bw.write(direction[maxDir] + "\n");
		bw.write(maxTime + "\n");
		bw.flush();
		bw.close();
	}

	static int find(int dir, int startX, int startY){
		int cnt = 0;

		int mx = startX;
		int my = startY;
		while(true){
			// 방향으로 움직임
			mx = mx + dx[dir];
			my = my + dy[dir];
			// 시간 측정
			cnt += 1;

			//무한대 체크 - mx,my가 startX, startY와 동일
			// => 틀림. 그냥 지나가는 길일 수도 있음 -> 500x500 이상일때
			if(cnt > 2500000){
				return -1;
			}

			// 현재 위치 상황
			if(mx < 0 || mx >= n || my < 0 || my >= m){
				// while 탈출
				//System.out.println("항성계 탈출!");
				break;
			}else{
				if(space[mx][my] == 'C'){
					// while 탈출
					//System.out.println("블랙홀 만남!");
					break;
				}else if(space[mx][my] == '/'){
					// 현재 방향에 따라 방향전환 달라짐

					dir = findDirection(1, dir);

				}else if(space[mx][my] == '\\'){
					// 현재 방향에 따라 방향전환 달라짐

					dir = findDirection(2, dir);
				}
			}



		}

		return cnt;
	}

	public static int findDirection(int type, int curDir){

		if(type == 1){
			/** type 1.
			 * U면(0) -> R(1)
			 * R이면(1) -> U(0)
			 * D면(2) -> L(3)
			 * L이면(3) -> D(2)
			 */
			if(direction[curDir] == 'U'){
				return 1;
			}else if(direction[curDir] == 'R'){
				return 0;
			}else if(direction[curDir] == 'D'){
				return 3;
			}else if(direction[curDir] == 'L'){
				return 2;
			}
		}else{
			/** type 2.
			 * U면(0) -> L(3)
			 * R이면(1) -> D(2)
			 * D면(2) -> R(1)
			 * L이면(3) -> U(0)
			 */
			if(direction[curDir] == 'U'){
				return 3;
			}else if(direction[curDir] == 'R'){
				return 2;
			}else if(direction[curDir] == 'D'){
				return 1;
			}else if(direction[curDir] == 'L'){
				return 0;
			}
		}

		return -1;

	}
}
