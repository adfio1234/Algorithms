
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static final int[] DX= {0,0,-1,1};
	static final int[] DY= {-1,1,0,0};
	
	static char[][] grid;
	static int width;
	static int height;
	static int curX=0;
	static int curY=0;
	static int max=-1;
	static boolean[] used=new boolean[26];
	
	//used에 사용할 알파벳을 기록하면서 사방탐색 진행
	static void move(int x,int y,int distance) {
		
		for(int i=0;i<4;i++) {
			int nx=x+DX[i];
			int ny=y+DY[i];
			
			//범위체크, 사용체크
			if(nx<0||ny<0||nx>=width||ny>=height)continue;
			if(used[grid[ny][nx]-'A'])continue;
			
			used[grid[ny][nx]-'A']=true;
			move( nx, ny, distance+1);
			//백트래킹
			used[grid[ny][nx]-'A']=false;
		}
		//더이상 갈곳이없으면 대소비교
		max=distance>max?distance:max;
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		height=Integer.parseInt(st.nextToken());
		width=Integer.parseInt(st.nextToken());
		
		grid=new char[height][width];
		for(int i=0;i<height;i++) {
			String tmp=br.readLine();
			for(int j=0;j<width;j++)grid[i][j]=tmp.charAt(j);
		}
		
		used[grid[0][0]-'A']=true;
		move(curX,curY,1);
		System.out.println(max);
	}

}
