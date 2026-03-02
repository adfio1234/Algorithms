
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	
	static int height;
	static int width;
	static char[][] maze;
	static ArrayDeque<int[]> fireDeque= new ArrayDeque<>();
	static StringBuilder sb= new StringBuilder();
	
	static void escape(int x,int y) {
		
		int[] dx= {0,0,-1,1};
		int[] dy= {-1,1,0,0};
		
		boolean[][] visited=new boolean[height][width];
		visited[y][x]=true;
		
		ArrayDeque<int[]> dq=new ArrayDeque<>();
		dq.add(new int[] {x,y,0});
		
		while(!dq.isEmpty()) {
			int dqSize=dq.size();
			int fireSize=fireDeque.size();
			//초별로 나누기위한 반복문
			for(int k=0;k<dqSize;k++) {
				
				int[] cur=dq.pollFirst();
				int curX=cur[0];
				int curY=cur[1];
				int second=cur[2];
				
				//불에 탔음
				if(maze[curY][curX]=='F')continue;
				
				//가장자리 도달하면 탈출
				if(curX==width-1||curX==0||curY==height-1||curY==0) {
					sb.append(second+1);
					return;
				}
				
				for(int i=0;i<4;i++) {
					int nx=curX+dx[i];
					int ny=curY+dy[i];
					
					if(nx<0||ny<0||nx>=width||ny>=height)continue;
					if(visited[ny][nx])continue;
					if(maze[ny][nx]!='.')continue;
					
					visited[ny][nx]=true;
					dq.add(new int [] {nx,ny,second+1});
				}
			}
			for(int k=0;k<fireSize;k++) {
				int cur[]=fireDeque.pollFirst();
				int curX=cur[0];
				int curY=cur[1];
				
				for(int i=0;i<4;i++) {
					int nx=curX+dx[i];
					int ny=curY+dy[i];
					
					if(nx<0||ny<0||nx>=width||ny>=height)continue;
					if(maze[ny][nx]!='.')continue;
					
					maze[ny][nx]='F';
					fireDeque.add(new int [] {nx,ny});
				}
				
			}
			
		}
		sb.append("IMPOSSIBLE");
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		height=Integer.parseInt(st.nextToken());
		width=Integer.parseInt(st.nextToken());
		
		int x=0;
		int y=0;
		
		maze=new char[height][width];
		for(int i=0;i<height;i++)
		{
			String input=br.readLine();
			for(int j=0;j<width;j++) {
				maze[i][j]=input.charAt(j);
				//지훈이의 위치
				if(maze[i][j]=='J') {
					x=j;
					y=i;
				}
				//불이 붙은 위치
				else if(maze[i][j]=='F') {
					fireDeque.add(new int[] {j,i});
				}
			}
		}
		
		escape(x,y);
		System.out.println(sb);
	}

}
