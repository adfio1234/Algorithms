import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	//HORIZONTAL: 가로 방향
	//VERTICAL: 세로방향
	//DIAGONAL:대각선 방향
	static final int HORIZONTAL=0;
	static final int VERTICAL=1;
	static final int DIAGONAL=2;
	
	//size: 집의크기
	//grid: 집의 상태
	static int size;
	static int[][] grid;
	static int result=0;
	
	//전파이프의 정보를 바탕으로 파이프를 연결해나간다.
	static void dfs(int y,int x,int dir) {
		if(x==(size-1)&&y==(size-1)) {
			result+=1;
			return;
		}
		
		int nx=x+1;
		int ny=y+1;
		
		//대각선은 어느상태든 연결가능하므로 항상 연결해본다.
		
		//전의 파이프의 방향이 가로라면 가로와 대각선으로 연결가능하다
		if(dir==HORIZONTAL) {
			
			//size가 안넘어가고 빈칸이라면 연결
			if(nx<size&&grid[y][nx]==0)dfs(y,nx,HORIZONTAL);
		}
		//전의 파이프의 방향이 세로라면 세로와 대각선으로 연결 가능하다.
		else if(dir==VERTICAL) {

			//설치할 위치가 집안이고 벽이없다면 연결 가능하다.
			if(ny<size&&grid[ny][x]==0)dfs(ny,x,VERTICAL);
		}
		//전의 파이프의 방향이 대각선이라면 가로,세로,대각선 연결이 가능하다.
		else if(dir==DIAGONAL) {

			//체크후 가로와 세로로 연결한다.
			if(nx<size&&grid[y][nx]==0)dfs(y,nx,HORIZONTAL);
			if(ny<size&&grid[ny][x]==0)dfs(ny,x,VERTICAL);	
		}
		
		//대각선 파이프를 연결한다.
		//범위 체크및 공간이 비었는지 체크한다.
		if(nx<size&&ny<size) {
			if(grid[ny][nx]==0&&grid[y][nx]==0&&grid[ny][x]==0) {
				dfs(ny,nx,DIAGONAL);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//맵 초기화
		size=Integer.parseInt(br.readLine());
		grid=new int[size][size];
		for(int i=0;i<size;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<size;j++)grid[i][j]=Integer.parseInt(st.nextToken());
		}
		
		dfs(0,1,HORIZONTAL);
		System.out.println(result);
	}

}
