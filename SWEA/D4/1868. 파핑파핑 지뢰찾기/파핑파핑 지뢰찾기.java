
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Solution {

	static StringBuilder sb=new StringBuilder();
	
	//지뢰가아닌부분을 인접한 8곳의 지뢰의 개수로 업데이트한다.
	static void searchMine(char[][] grid,int size) {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(grid[i][j]=='.')countMine(j,i,grid,size);
			}
		}
	}
		
	static void countMine(int x,int y,char[][]grid,int size) {
		int[] dx= {-1,0,1,-1,1,-1,0,1};
		int[] dy= {-1,-1,-1,0,0,1,1,1};
		
		int mine=0;

		for(int i=0;i<8;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0||ny<0||nx>=size||ny>=size)continue;
			if(grid[ny][nx]=='*')mine++;
		}
		grid[y][x]=(char) (mine+'0');
	}
	
	//0과 인접한 칸들을 전부 열어두고, 그뒤에 닫힌칸을 누르는게 최소이다.
	static int click(char[][] grid,int size) {
		int clicked=0;
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(grid[i][j]!='0')continue;
				BFS(j,i,grid,size);
				clicked++;
					
			}
		}
		for(char[] i:grid)
			for(char j:i) {
				if(j!='*'&&j!='9')clicked++;
			}
		return clicked;
	}
	
	static void BFS(int x,int y,char[][]grid,int size) {
		int[] dx= {-1,0,1,-1,1,-1,0,1};
		int[] dy= {-1,-1,-1,0,0,1,1,1};
		
		ArrayDeque<int[]> dq=new ArrayDeque<>();
		dq.addLast(new int[] {x,y});
		
		while(!dq.isEmpty()) {
			int[] cur=dq.pollFirst();
			int curX=cur[0];
			int curY=cur[1];
			
			//자기자신을 열렸다는 표시로 9로 해준다.
			grid[curY][curX]='9';
			
			for(int i=0;i<8;i++) {
				int nx=curX+dx[i];
				int ny=curY+dy[i];
				
				if(nx<0||ny<0||nx>=size||ny>=size)continue;
				if(grid[ny][nx]=='*')continue;
				//0과인접한 칸도열리므로 9로 표시
				if(grid[ny][nx]!='0') {
					grid[ny][nx]='9';
					continue;
				}
				grid[ny][nx]='9';
				dq.addLast(new int[] {nx,ny});
				
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			int size=Integer.parseInt(br.readLine());
			
			char[][] grid=new char[size][size];
			for(int i=0;i<size;i++) {
				String input=br.readLine();
				for(int j=0;j<size;j++)grid[i][j]=input.charAt(j);
			}
			
			//주변 8방향의 지뢰의 개수로 업데이트한다.
			searchMine(grid,size);
			sb.append('#').append(t).append(' ').append(click(grid,size)).append('\n');
//			for(char[] i:grid) {
//				for(char j:i)System.out.printf("%s ",j);
//				System.out.println();
//			}
		}
		System.out.println(sb);
	}

}
