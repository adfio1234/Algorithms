
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb=new StringBuilder();
	static int size;
	
	static void trip(int x,int y,int goalX,int goalY) {
		
		int[] dx= {1,-1,1,-1,2,-2,2,-2};
		int[] dy= {2,2,-2,-2,1,1,-1,-1};
		
		boolean[][] visited=new boolean[size+1][size+1];
		visited[y][x]=true;
		
		//dq에 x,y,distance정보를 넣는다.
		ArrayDeque<int[]> dq=new ArrayDeque<>();
		dq.add(new int[] {x,y,0});
		
		while(!dq.isEmpty()) {
			int[] cur=dq.pollFirst();
			int curX=cur[0];
			int curY=cur[1];
			int distance=cur[2];
			
			if(curX==goalX&&curY==goalY) {
				sb.append(distance).append('\n');
				break;
			}
			
			//나이트의 이동 가능한 거리를 다해본다.
			for(int i=0;i<8;i++) {
				int nx=curX+dx[i];
				int ny=curY+dy[i];
				
				//범위, 방문 체크
				if(nx<0||ny<0||nx>=size||ny>=size)continue;
				if(visited[ny][nx])continue;
				
				visited[ny][nx]=true;
				dq.add(new int[] {nx,ny,distance+1});
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		for(int i=0;i<TC;i++) {
			size=Integer.parseInt(br.readLine());
			
			st=new StringTokenizer(br.readLine());
			int curX=Integer.parseInt(st.nextToken());
			int curY=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine());
			int goalX=Integer.parseInt(st.nextToken());
			int goalY=Integer.parseInt(st.nextToken());
			trip(curX,curY,goalX,goalY);
		}
		System.out.println(sb);
	}

}
