import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main{
	
	static boolean[][] grid;
	static StringBuilder sb=new StringBuilder();
	
	//각 좌표를 쭉 보면서 true면 BFS를 통해 덩어리를 캐낸다.
	//BFS를 한 횟수가 정답
	static void searchMana(int width,int height,int manaStoneNum) {
		
		int result=0;
		
		entire:for(int i=0;i<height;i++) {
			
			for(int j=0;j<width;j++) {
				//마력석이 없으면 continue;
				if(!grid[i][j])continue;
				result++;
				//채굴한 마력석의 개수를 구한다.
				int mined=BFS(j,i,width,height);
				manaStoneNum-=mined;
				//채굴한 마력석의 개수가 주어진 마력석의 개수와 같아지면 break;
				if(manaStoneNum==0)break entire;
			}
		}
		sb.append(result).append('\n');
	}
	
	//주변의 true칸을 false로 바꾼다.
	static int BFS(int x,int y,int width,int height) {
		
		int result=0;
		int[] dx= {0,0,-1,1};
		int[] dy= {-1,1,0,0};
		
		ArrayDeque<int[]> dq=new ArrayDeque<>();
		dq.add(new int[] {x,y});
		grid[y][x]=false;
		
		while(!dq.isEmpty()) {
			int[] cur=dq.pollFirst();
			int curX=cur[0];
			int curY=cur[1];
			
			for(int i=0;i<4;i++) {
				int nx=curX+dx[i];
				int ny=curY+dy[i];
				
				if(nx<0||ny<0||nx>=width||ny>=height)continue;
				if(!grid[ny][nx])continue;
				grid[ny][nx]=false;
				result++;
				dq.addLast(new int[] {nx,ny});
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//------여기에 솔루션 코드를 작성하세요.------------
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			st=new StringTokenizer(br.readLine());
			
			int width=Integer.parseInt(st.nextToken());
			int height=Integer.parseInt(st.nextToken());
			int manaStoneNum=Integer.parseInt(st.nextToken());
		
			grid=new boolean[height][width];
			
			for(int i=0;i<manaStoneNum;i++) {
				st=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				grid[y][x]=true;
			}
			
			searchMana(width,height,manaStoneNum);
		
		}
		System.out.print(sb);
	}
}