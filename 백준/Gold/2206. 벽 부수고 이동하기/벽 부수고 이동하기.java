
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	//최대값을 표현한다.
	static final int INF=Integer.MAX_VALUE;
	
	static int[][] grid;
	static ArrayList<int[]> stonePoint;
	
	//exceptStone을 하나씩 부숴본후 최소거리를 구한다.
	static int BFS(int height,int width) {
		int[] dx= {0,0,-1,1};
		int[] dy= {-1,1,0,0};
		
		
		boolean[][][] visited=new boolean [height][width][2];
		visited[0][0][0]=true;
		
		//x,y,distance,부술수있는 횟수
		ArrayDeque<int[]> dq=new ArrayDeque<>();
		dq.add(new int[] {0,0,0,1});
		
		while(!dq.isEmpty()) {
			int cur[]=dq.pollFirst();
			int curX=cur[0];
			int curY=cur[1];
			int curDist=cur[2];
			int curBreak=cur[3];
			
			if(curX==width-1&&curY==height-1) {
				return curDist+1;
			}
			
			for(int i=0;i<4;i++) {
				int nx=curX+dx[i];
				int ny=curY+dy[i];
				
				if(nx<0||ny<0||nx>=width||ny>=height)continue;
				if(grid[ny][nx]==1) {
					if(curBreak>0&&!visited[ny][nx][1]) {
						visited[ny][nx][1]=true;
						dq.addLast(new int[] {nx,ny,curDist+1,curBreak-1});
					}
				}else {
					if(visited[ny][nx][curBreak])continue;
					visited[ny][nx][curBreak]=true;
					dq.addLast(new int[] {nx,ny,curDist+1,curBreak});
				}
			}
		}
		return -1;
		
		

		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int height=Integer.parseInt(st.nextToken());
		int width=Integer.parseInt(st.nextToken());
		
		grid=new int[height][width];
		stonePoint=new ArrayList<>();
		for(int i=0;i<height;i++)
		{
			String input=br.readLine();
			for(int j=0;j<width;j++) {
				grid[i][j]=input.charAt(j)-'0';
				if(grid[i][j]==1)stonePoint.add(new int[] {j,i});
			}
		}
		System.out.println(BFS(height,width));
	
	}

}
