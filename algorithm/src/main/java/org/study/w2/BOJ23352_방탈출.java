package org.study.w2;

/**
 * 각 방에서 다른 방(시작방과 끝방이 같아도됨)으로의 최단거리(bfs)를 구함
 * 그 중 가장 큰 거리값을 가진 방들의 시작방, 끝방 위치 저장
 * 해당 위치의 숫자 저장
 */
import java.io.*;
import java.util.*;
public class BOJ23352_방탈출 {
	static int n;
	static int m;
	static int curMaxDist;
	
	static Pair curMaxDistStart;
	static Pair curMaxDistEnd;
	
	static int[][] map;
	static int[][] visited;
	
	
	static int maxDist = Integer.MIN_VALUE;
	static int password = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 일단 bfs 값 찍어봐야지 - 모든 좌표에서 다 bfs돌려야 하니깐
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				//해당 좌표가 0이 아니면 탐색
				if(map[i][j] == 0) {
					continue;
				}
				
				curMaxDist = 0;
				curMaxDistStart = new Pair(i,j);
				
				bfs(i,j);
				
//				System.out.println("(" + i + ", " + j + ")");
//				printArr(visited);
//				System.out.println();
				
				//bfs가 끝나고 비교
				if(curMaxDist > maxDist) {
					maxDist = curMaxDist;
					
					password = map[curMaxDistStart.x][curMaxDistStart.y]
							+ map[curMaxDistEnd.x][curMaxDistEnd.y];
				}else if(curMaxDist == maxDist) {
					int curPassword = map[curMaxDistStart.x][curMaxDistStart.y]
							+ map[curMaxDistEnd.x][curMaxDistEnd.y];
					password = Math.max(password, curPassword);
				}
				
			}
		}
		
		
		bw.write(password +"\n");
		bw.flush();
		bw.close();
	}
	
	//bfs
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = { 0, 1, 0,-1};
	
	static void bfs(int x, int y) {
		
		
		
		//visited 배열 초기화
		visited = new int[n][m];
		//큐 생성
		Queue<Pair> q = new ArrayDeque<>();
		
		//큐에 시작점 넣고 시작
		q.offer(new Pair(x, y));
		visited[x][y] = 1;
		//while돌리기
		int curX = 0;
		int curY = 0;
		
		while(!q.isEmpty()) {
			//현재 시작 좌표 꺼내기
			Pair pos = q.poll();
			
			curX = pos.x;
			curY = pos.y;
			
			//거리값 계산 용
			int dist = visited[curX][curY];
			
			//최대 거리 구하기
			if(dist > curMaxDist) {				
				curMaxDist = dist;
				// 현재 비밀번호
				curMaxDistEnd = new Pair(curX, curY);
			}
			
			//4방 탐색
			for(int i =0; i < 4; i++) {
				int mx = dx[i] + curX;
				int my = dy[i] + curY;
				
				//벽 체크
				if(mx < 0 || mx >= n || my < 0 || my >= m) {
					continue;
				}
				
				//다음위치 넣기 방문배열0이라 방문한 적 없고, map에서도 0이 아닌경우
				if((visited[mx][my] == 0) && (map[mx][my]!= 0)) {
					//방문배열에 거리 값 넣기
					visited[mx][my] = dist + 1;
					//큐에 저장
					q.offer(new Pair(mx, my));
				}
				
			}
			
		}
		
	}
	
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return this.x + ", " + this.y;
		}
	}
	
	//디버깅용 출력
	static void printArr(int[][] arr) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
