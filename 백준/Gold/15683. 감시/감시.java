import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	//우 하 좌 상 
	static final int[] DX= {1,0,-1,0};
	static final int[] DY= {0,1,0,-1};
	static final int WALL=6;
	static final int OBSERVED=7;
	
	//1 1방향
	//2 가로,세로
	//3 2방향
	//4 3방향
	//5 4방향
	//6 벽
	//7 감시중인 영역
	static int height;
	static int width;
	static int[][] grid;
	static ArrayList<int[]> CCTV=new ArrayList<>();
	static int emptyArea=Integer.MAX_VALUE;
	
	static void onCCTV(int cnt) {
		
		if(cnt==CCTV.size()) {
			int area=countBlind();
			emptyArea=emptyArea>area?area:emptyArea;
			return;
		}
		
		int[] curCCTV=CCTV.get(cnt);
		int curX=curCCTV[0];
		int curY=curCCTV[1];
			
		int numCCTV=grid[curY][curX];
		//CCTV를 고르는 경우
		for(int dir=0;dir<4;dir++)
		{
			int[][] backup=copyMap();
			//선택하는 경우
			selectedCCTV(numCCTV,curX,curY,dir);
			
			onCCTV(cnt+1);
			
			//백트래킹
			grid=backup;
		}
			
	}
	
	static int countBlind() {
		int count=0;
		for(int[] i:grid)
			for(int j:i) {
				if(j==0)count++;
			}
		return count;
	}
	
	//1~5번까지의 CCTV를 고른다.
	static int selectedCCTV(int idx,int x,int y,int dir) {
		int observe=0;
		
		if(idx==1) {
			goObserve(x,y,dir);
		}
		else if (idx==2) {
			goObserve(x,y,dir);
			goObserve(x,y,(dir+2)%4);
		}else if(idx==3) {
			goObserve(x,y,dir);
			goObserve(x,y,(dir+1)%4);
		}else if(idx==4) {
			goObserve(x,y,dir);
			goObserve(x,y,(dir+1)%4);
			goObserve(x,y,(dir+2)%4);
		}
		
		return observe;
	}
	
	//
	static void goObserve(int x,int y,int dir) {
		int nx=x+DX[dir];
		int ny=y+DY[dir];
		
		while(nx>=0&&ny>=0&&nx<width&&ny<height&&grid[ny][nx]!=6) {
			if(grid[ny][nx]==0)grid[ny][nx]=7;
			nx+=DX[dir];
			ny+=DY[dir];
		}
	}
	
	
	//맵을 복사한다.
	static int[][] copyMap(){
		int[][] copy=new int[height][width];
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++)copy[i][j]=grid[i][j];
		}
		return copy;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		height=Integer.parseInt(st.nextToken());
		width=Integer.parseInt(st.nextToken());
		
		ArrayList<int[]> idxFive=new ArrayList<>();
		
		grid=new int[height][width];
		for(int i=0;i<height;i++) {
			
			st=new StringTokenizer(br.readLine());
			
			for(int j=0;j<width;j++) {
				
				grid[i][j]=Integer.parseInt(st.nextToken());
				
				if(grid[i][j]<1)continue;
				else if(grid[i][j]==5)idxFive.add(new int[] {j,i});
				//cctv를 리스트에 저장한다.
				else if(1<=grid[i][j]&&grid[i][j]<=4) {
					CCTV.add(new int[] {j,i});
				}
				//cctv는 자리를 차지하므로 전체 구역에서 뺴줘서, 최소 넓이를 구한다.
			}
		}
		
		//5번CCTV는 설치하는 경우가 한가지 경우이므로 처리한다.
		for(int[] point:idxFive) {
			goObserve(point[0],point[1],0);
			goObserve(point[0],point[1],1);
			goObserve(point[0],point[1],2);
			goObserve(point[0],point[1],3);
		}
//		for(int[] i:grid) {
//			for(int j:i)System.out.printf("%2d  ",j);
//			System.out.println();
//		}
		
		onCCTV(0);
		System.out.println(emptyArea);
	}

}
