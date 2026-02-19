import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	static final int[] DX= {0,0,-1,1};
	static final int[] DY= {-1,1,0,0};
	
	//visitedPublic: 적록색약이 아닌 사람 방문체크
	//visitedRedGreenMedicine: 적록색약인 사람 방문체크
	static int size;
	static char[][] grid;
	static boolean[][] visitedPublic=new boolean[size][size];
	static boolean[][] visitedRG=new boolean[size][size];
	static StringBuilder sb=new StringBuilder();
	
	//구역의 개수 차이를 찾는 메서드
	static void findAreaDiff() {
		//areaPublic: 적록색약이 아닌 사람이 보는 구역의 개수
		//areaRGMedicine: 적록색약인 사람이 보는 구역의 개수
		int areaPublic=0;
		int areaRG=0;

		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++)
			{
				//아직 방문을 안했을시
				//bfs는 한번에 구역을 다본다.
				//즉 bfs의 실행횟수가 구역의 개수이다.
				
				//적록색약이아닌 사람 BFS
				if(!visitedPublic[i][j]) {
					publicBFS(j,i);
					areaPublic+=1;
				}
				if(!visitedRG[i][j]) {
					RGBFS(j,i);
					areaRG+=1;
				}
			}
		}
		
		
		sb.append(areaPublic).append(' ').append(areaRG);
	}
	
	//적록색약이아닌 사람의 BFS
	static void publicBFS(int x,int y) {
		ArrayDeque<int[]> dq=new ArrayDeque<>();
		visitedPublic[y][x]=true;
		
		dq.add(new int[] {x,y});
		
		while(!dq.isEmpty()) {
			int cur[]=dq.pollFirst();
			int curX=cur[0];
			int curY=cur[1];
			
			for(int i=0;i<4;i++) {
				int nx=curX+DX[i];
				int ny=curY+DY[i];
				
				//범위체크 및 방문체크, 그리고 색깔 체크
				if(nx<0||ny<0||nx>=size||ny>=size)continue;
				if(visitedPublic[ny][nx])continue;
				if(grid[curY][curX]!=grid[ny][nx])continue;
				visitedPublic[ny][nx]=true;
				dq.addLast(new int[] {nx,ny});
			}
		}
		
	}
	
	//적록 생약인 사람의 BFS
	static void RGBFS(int x,int y) {
		ArrayDeque<int[]> dq=new ArrayDeque<>();
		visitedRG[y][x]=true;
		
		dq.add(new int[] {x,y});
		
		while(!dq.isEmpty()) {
			int cur[]=dq.pollFirst();
			int curX=cur[0];
			int curY=cur[1];
			
			for(int i=0;i<4;i++) {
				int nx=curX+DX[i];
				int ny=curY+DY[i];
				
				//범위체크 및 방문체크, 그리고 색깔 체크
				if(nx<0||ny<0||nx>=size||ny>=size)continue;
				if(visitedRG[ny][nx])continue;

				//원래 자리가 빨강이나 초록이었는데 다음이동할 좌표가 파랑이면 continue;
				if((grid[curY][curX]=='R'||grid[curY][curX]=='G')&&grid[ny][nx]=='B')continue;
				//원래 자리가 파랑이었는데 다음 이동할 좌표가 파랑이 아니면
				if(grid[curY][curX]=='B'&&grid[ny][nx]!='B')continue;
				visitedRG[ny][nx]=true;
				dq.addLast(new int[] {nx,ny});
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		size=Integer.parseInt(br.readLine());
		
		visitedPublic=new boolean[size][size];
		visitedRG=new boolean[size][size];
		//grid 색 칠하기
		grid=new char[size][size];
		for(int i=0;i<size;i++) {
			String tmp=br.readLine();
			for(int j=0;j<size;j++)grid[i][j]=tmp.charAt(j);
		}
		
		findAreaDiff();
		System.out.println(sb);
		
	}

}
