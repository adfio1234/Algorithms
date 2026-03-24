
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static final int INF=Integer.MAX_VALUE;
	
	static int[][] grid;
	static int[][] dist;
	static boolean[][] visited;
	static StringBuilder sb=new StringBuilder();
	
	static void BFS(int x,int y,int width,int height) {
		
		int [] dx= {0,0,-1,1};
		int []dy= {-1,1,0,0};
		
		ArrayDeque<int[]> dq=new ArrayDeque<>();
		dq.add(new int[] {x,y,2});
		visited[y][x]=true;
		dist[y][x]=0;
		
		while(!dq.isEmpty()) {
			int[] cur=dq.pollFirst();
			int curX=cur[0];
			int curY=cur[1];
			int weight=cur[2];
			
			for(int i=0;i<4;i++) {
				int nx=curX+dx[i];
				int ny=curY+dy[i];
				
				if(nx<0||ny<0||nx>=width||ny>=height)continue;
				if(visited[ny][nx])continue;
				if(grid[ny][nx]==0)continue;
				dist[ny][nx]+=weight;
				visited[ny][nx]=true;
				dq.addLast(new int[] {nx,ny,weight+1});
			}
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int height=Integer.parseInt(st.nextToken());
		int width=Integer.parseInt(st.nextToken());
		int startX=0;
		int startY=0;
		
		
		grid=new int[height][width];
		visited=new boolean[height][width];
		dist=new int[height][width];
		
		
		for(int i=0;i<height;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<width;j++) {
				grid[i][j]=Integer.parseInt(st.nextToken());
				dist[i][j]=-1;
				if(grid[i][j]==2) {
					startX=j;
					startY=i;
				}else if(grid[i][j]==0)dist[i][j]=0;
				
			}
		}
		
		BFS(startX,startY,width,height);
		for(int[] i:dist) {
			for(int j:i)sb.append(j).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
