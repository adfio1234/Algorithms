import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int width;
	static int height;
	static int[][] tomatoBox;
	static ArrayDeque<int[]> dq=new ArrayDeque<>();

	
	//토마토에 익는 일수를 추적한다.
	//맵의 상태가 1,0 이므로 visited를 쓰지않고도 방문체크가가능하다.
	static int ripeTomato(){
		int time=0;
		
		int[] dx= {0,0,-1,1};
		int[] dy= {-1,1,0,0};
		
		while(!dq.isEmpty()) {
			int cur[]=dq.pollFirst();
			int curX=cur[0];
			int curY=cur[1];
			int day=cur[2];
			
			//결국 bfs가 끝나는 시점이 토마토가 다익은 시점이다.
			time=day;
			for(int i=0;i<4;i++) {
				int nx=curX+dx[i];
				int ny=curY+dy[i];
				
				//범위체크 및 토마토인지 확인, 그리고 방문체크
				if(nx<0||ny<0||nx>=width||ny>=height)continue;
				if(tomatoBox[ny][nx]!=0)continue;

				tomatoBox[ny][nx]=1;
				dq.addLast(new int[] {nx,ny,day+1});
			}
			
		}
		
		//익지 않은 토마토가있으면 -1 리턴
		for(int[] i:tomatoBox)for(int j:i)if(j==0)return -1;
		return time;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		width=Integer.parseInt(st.nextToken());
		height=Integer.parseInt(st.nextToken());

		
		//박스 상태 설정 및 dq에 x,y,일수 에대한 정보 및 visited를 설정해준다.
		tomatoBox=new int[height][width];
		for(int i=0;i<height;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<width;j++) {
				tomatoBox[i][j]=Integer.parseInt(st.nextToken());
				if(tomatoBox[i][j]==1) {
					dq.addLast(new int[] {j,i,0});

				}
			}
		}
		
		System.out.println(ripeTomato());
		
	}

}
