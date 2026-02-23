
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int height;
	static int width;
	static int[][] cheese;
	static StringBuilder sb=new StringBuilder();
	
	//좌표마다 치즈가있으면 주변에 빈공간이있는지 체크한다.
	static void meltCheese() {
		
		//prevCheese:이전시간으 치즈의 개수를 저장한다.
		//hour: 현재시간
		//cheeseCount: 현재 녹는 치즈의 양
		int prevCheese=0;
		int hour=0;
		int cheeseCount=1;
		
		while(cheeseCount!=0) {
			
			hour++;
			cheeseCount=BFS();
			
			//남아있는 치즈가 없으면 탈출
			if(cheeseCount==0)break;
			//이전 치즈의 개수 저장
			prevCheese=cheeseCount;
		}
		sb.append(hour-1).append('\n').append(prevCheese);
	}
	
	
	//현재 바깥쪽에 노출된 치즈를 제거한다.
	static int BFS() {
		int cheeseCount=0;

		int[] dx= {0,0,-1,1};
		int[] dy= {-1,1,0,0};
		
		boolean[][] visited=new boolean[height][width];
		visited[0][0]=true;
		
		ArrayDeque<int[]> dq=new ArrayDeque<>();
		dq.add(new int[] {0,0});
		
		
		while(!dq.isEmpty()) {
			int[] cur=dq.pollFirst();
			int curX=cur[0];
			int curY=cur[1];
			
			for(int i=0;i<4;i++) {
				int nx=curX+dx[i];
				int ny=curY+dy[i];
				
				if(nx<0||ny<0||nx>=width||ny>=height)continue;
				if(visited[ny][nx])continue;
				//공기와 닿아있는 치즈를 발견하면
				//방문체크는해놓고 0으로 바꾼다
				//이구간에 대해 탐색은 더이상하지않지만 치즈가 녹았다는것을 알 수 있다.
				if(cheese[ny][nx]==1) {
					visited[ny][nx]=true;
					cheeseCount++;
					cheese[ny][nx]=0;
					continue;
				}
				
				visited[ny][nx]=true;
				dq.add(new int[] {nx,ny});
				
				
			}
		}
		return cheeseCount;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		height=Integer.parseInt(st.nextToken());
		width=Integer.parseInt(st.nextToken());
		
		cheese=new int[height][width];
		for(int i=0;i<height;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<width;j++)cheese[i][j]=Integer.parseInt(st.nextToken());
		}
		
		meltCheese();
		System.out.println(sb);
	}

}
