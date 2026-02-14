import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Fish implements Comparable<Fish>{
	
	//x,y: 물고기의 좌표
	//dist: 상어와의 거리
	public int x;
	public int y;
	public int dist;
	
	Fish(int x,int y,int dist){
		this.x=x;
		this.y=y;
		this.dist=dist;
	}

	//상어가 밥먹을때 우선순위가 존재한다.
	//1. 거리가 가까운것
	//2. 위에있는것
	//3. 왼쪽에 있는것
	@Override
	public int compareTo(Fish o) {
		// TODO Auto-generated method stub
		
		//더 가까운거리
		if(this.dist!=o.dist)return this.dist-o.dist;
		
		//더 위에있는것
		if(this.y!=o.y)return this.y-o.y;
		
		//더 왼쪽에 있는것
		return this.x-o.x;
	}
	
	
}

public class Main {
	
	static int size;
	static int babySharkX;
	static int babySharkY;
	static int babySharkSize=2;
	static int[][] grid;
	static boolean[][] visited;
	static int totalDistance=0;
	
	//먹을 물고기의 좌표를 찾는다.
	static Fish findFish() {
		
		visited=new boolean[size][size];
		int[] dx= {0,-1,0,1};
		int[] dy= {-1,0,1,0};
		
		//candiateList:먹을 수 있는 물고기 후보
		visited[babySharkY][babySharkX]=true;
		ArrayDeque<int[]> q=new ArrayDeque<>();
		ArrayList<Fish> candiateList=new ArrayList<>();
		
		q.add(new int[] {babySharkX,babySharkY,0});
		
		while(!q.isEmpty()) {
			int[] cur=q.pollFirst();
			
			int curX=cur[0];
			int curY=cur[1];
			int curdist=cur[2];
			
			//4방향 탐색
			for(int i=0;i<4;i++)
			{
				int nx=curX+dx[i];
				int ny=curY+dy[i];
				
				//범위 체크
				//방문 체크
				//상어의 크기보다 덩치가 큰물고기 칸은 못지나간다.
				if(nx<0||ny<0||nx>=size||ny>=size)continue;
				if(visited[ny][nx])continue;
				if(grid[ny][nx]>babySharkSize)continue;
				
				//방문한 칸은 체크해준다.
				visited[ny][nx]=true;
				
				//먹을 수 있는 물고기면
				if(grid[ny][nx]<babySharkSize&&grid[ny][nx]!=0) {
					candiateList.add(new Fish(nx,ny,curdist+1));
					continue;
				}
				q.add(new int[] {nx,ny,curdist+1});
			}
		}
		
		//먹을 수 있는 물고기가 없으면 null리턴
		if(candiateList.isEmpty())return null;
		
		//기준에 따라 정렬한다.
		Collections.sort(candiateList);
		
		//정렬된 기준의 첫번쨰가 아기 상어가 먹을 물고기
		return candiateList.get(0);
		
	}
	
	//탐색한 물고기를 먹는다.
	static void eat() {
		
		//eatSum: 상어가 식사한 횟수
		int eatSum=0;
		
		while(true){
			
			//목표 물고기를 찾아온다
			Fish target=findFish();
			
			//물고기를 못찾았으므로 엄마상어를 부른다.
			if(target==null)break;
			
			//물고기를 먹었으므로 target위치로 이동,이동 거리 추가
			babySharkX=target.x;
			babySharkY=target.y;
			totalDistance+=target.dist;
			grid[babySharkY][babySharkX]=0;
			
			//물고기를 먹는다.
			//먹은 횟수가 상어의 크기와 같아지면
			//상어의 크기는 한단계 커진다.
			eatSum+=1;
			if(eatSum>=babySharkSize) {
				babySharkSize+=1;
				eatSum=0;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		size=Integer.parseInt(br.readLine());
		
		//맵 상태 초기화
		grid=new int[size][size];
		for(int i=0;i<size;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<size;j++) {
				grid[i][j]=Integer.parseInt(st.nextToken());
				if(grid[i][j]==9) {
					grid[i][j]=0;
					babySharkX=j;
					babySharkY=i;
				}
			}
		}
		
		eat();
		System.out.println(totalDistance);
	}

}
