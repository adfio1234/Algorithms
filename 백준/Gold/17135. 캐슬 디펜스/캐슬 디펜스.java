import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int height;
	static int width;
	static int archerRange;
	static int[][] castle;
	static int maxCombo=0;
	static int[] input=new int[3];
	static int[][] copy;
	
	
	//총 height만큼의 wave가 주어진다.
	//몬스터 처치수는 combo로 기록한다.
	static void simulator() {
		int wave=height;
		int combo=0;
		
		//wave진행
		while(wave>0) {
			wave-=1;
			combo+=shoot(wave);	
		}
		
		maxCombo=maxCombo>combo?maxCombo:combo;
	}
	
	//궁수의 좌표를 찾고 궁수의 사정범위내에서 활을쏜다.
	static int shoot(int wave) {
		int kill=0;
		
		ArrayList<int[]> list=new ArrayList<>();
		
		for(int i=0;i<width;i++) {
			//해당 자리에 궁수가없으면 continue
			if(copy[height][i]==0)continue;
			
			//몬스터 발견하면 kill
			//궁수를 전진시켰다고 생각하고 한다.
			int[] point=BFS(wave+1,i);
			
			if(point==null)continue;
			list.add(point);
		}
		
		//모아둔 좌표 동시 공격
		for(int[] cur:list) {
			int x=cur[0];
			int y=cur[1];
			if(copy[y][x]==1) {
				kill+=1;
				copy[y][x]=0;
			}
		}
		
		
		return kill;
	}
	
	static int[] BFS(int y,int x) {
		
		//뒤는 볼필요가 없다.
		int[] dx= {-1,0,1};
		int[] dy= {0,-1,0};
		
		//궁수가 서있는곳은 볼필요가없다.
		boolean[][] visited=new boolean[y][width];
		
		ArrayDeque<int []> dq=new ArrayDeque<>();
		dq.add(new int[] {x,y});
		
		while(!dq.isEmpty()) {
			int cur[]=dq.pollFirst();
			int curX=cur[0];
			int curY=cur[1];
			
			for(int i=0;i<3;i++) {
				int nx=curX+dx[i];
				int ny=curY+dy[i];
				
				//몬스터가있는 범위밖탐색시 continue;
				if(nx<0||ny<0||nx>=width||ny>=y)continue;
				if(visited[ny][nx])continue;
				
				int distance=Math.abs(ny-y)+Math.abs(nx-x);
				
				//사거리 밖이면 continue;
				if(distance>archerRange)continue;
				if(copy[ny][nx]==1) {
					return new int[]{nx,ny};
				}
				visited[ny][nx]=true;
				dq.addLast(new int[] {nx,ny});
			}
		}
		return null;
	}
	
	//궁수 3명을 배치한다.
	//최대 width가 15일떄 455가지
	static void setPosition(int cnt,int idx,int numArcher) {
		if(numArcher==3) {
			//궁수 배치
			for(int i:input)castle[height][i]=2;
			
			//복사본 사용
			copy=new int[height+1][width];
			for(int i=0;i<height+1;i++)copy[i]=castle[i].clone();
			
			simulator();
			
			//다시 배치 해제
			for(int i:input)castle[height][i]=0;
			return;
		}
		
		for(int i=idx;i<width;i++) {
			input[numArcher]=i;
			setPosition(cnt+1,i+1,numArcher+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		height=Integer.parseInt(st.nextToken());
		width=Integer.parseInt(st.nextToken());
		archerRange=Integer.parseInt(st.nextToken());
		
		castle=new int[height+1][width];
		for(int i=0;i<height;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<width;j++)castle[i][j]=Integer.parseInt(st.nextToken());
		}
		
		
		setPosition(0,0,0);
		System.out.println(maxCombo);
	}

}
