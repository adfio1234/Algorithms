import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	//size: 맵크기
	//grid: 맵의 모
	//core: core의 위치 list {x,y}형태
	//dx,dy: 상, 하, 좌, 우 순서
	//connectedCoreMax:연결 가능 한 코어의 최대수
	//installedWireMin: 설치된 전선의 최소길이
	static int size;
	static int[][] grid;
	static ArrayList<int[]> core=new ArrayList<>();
	static int [] dx= {0,0,-1,1};
	static int [] dy= {-1,1,0,0};
	static int connectedCoreMax=-1;
	static int installedWireMin=Integer.MAX_VALUE;
	static StringBuilder sb=new StringBuilder();
	
	//4방향연결과 연결안됐을 경우를 따지므로 O(N^5)
	static void findMinWire(int idx,int sum,int connectCore) {
		
		
		//가지치기
		
		//현재 연결된 코어수+남은코어수 보다 최대연결가능 코어수가 크면 실패
		if(connectCore+(core.size()-idx)<connectedCoreMax)return;
		
		
		//core를 다 둘러보면 종료
		if(idx==core.size()) {
			
			//현재 재귀의 연결된 코어가 더많으면
			//전체의 최고연결코어의 수를 수정
			//코어는 될수록 많이깔아야하므로 최소전선도 무조건 수정!
			if(connectedCoreMax<connectCore) {
				connectedCoreMax=connectCore;
				installedWireMin=sum;
			
			//코어의 수가 같으면 최소전선의 길이 비교
			}else if(connectedCoreMax==connectCore) {
				installedWireMin=installedWireMin>sum?sum:installedWireMin;
			}
			return;
		}
		
		//core[idx]의 정보 로드
		int[] cur=core.get(idx);
		int curX=cur[0];
		int curY=cur[1];
		
		//core[idx]가 연결되었을때
		//4방향으로 연결되는 경우를다따져야함
		//상, 하,좌 ,우 순서
		for(int i=0;i<4;i++) {
			//해당 방향으로 보낼수 있는지 확인
			if(!isCan(curX,curY,i))continue;
			//해당방향으로 전선을 깔아버림
			int cntWire=wire(curX,curY,i,2);
			//다음번idxcore 연결하기위한 재귀
			findMinWire(idx+1,sum+cntWire,connectCore+1);
			//전선을 땐다.
			wire(curX,curY,i,0);
		}
		//core[idx]가 연결안됐을때
		findMinWire(idx+1,sum,connectCore);
	}
	
	//dir방향으로 전선을 깔 수 있는지 확인
	static boolean isCan(int x,int y,int dir) {
		int nx=x;
		int ny=y;
		while(true) {
			nx+=dx[dir];
			ny+=dy[dir];
			//범위를 성공적으로 벗어났다.
			//= 전선을 깔수있다.
			if(nx<0||ny<0||nx>=size||ny>=size)return true;
			if(grid[ny][nx]!=0)return false;
		}
	}
	
	
	//dir방향으로 실제로 status에 따라 전선을 변경
	//설치한 전설의 길이도 return
	static int wire(int x,int y,int dir,int status) {
		 int cnt=0;
		 int nx=x;
		 int ny=y;
		 
		 while(true) {
			 nx+=dx[dir];
			 ny+=dy[dir];
			 
			 if(nx<0||ny<0||nx>=size||ny>=size)return cnt;
			 grid[ny][nx]=status;
			 cnt++;	
		 }
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			
			size=Integer.parseInt(br.readLine());
			grid=new int[size][size];
			
			
			//grid 채우기
			for(int i=0;i<size;i++) 
			{	
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<size;j++) {
					grid[i][j]=Integer.parseInt(st.nextToken());
					
					//grid[i][j]가 1이면 core라는뜻
					if(grid[i][j]!=1)continue;
					//가장자리에 붙은 core면 pass
					if(i==0||j==0||i==size-1||j==size-1)continue;
					core.add(new int[]{j,i});
				}
			}
					
			findMinWire(0,0,0);
			
			sb.append('#').append(t).append(' ').append(installedWireMin).append('\n');
			//여러TC탐색을위한 초기화
			core.clear();
			connectedCoreMax=-1;
			installedWireMin=Integer.MAX_VALUE;
		}
		System.out.println(sb);
	}

}
