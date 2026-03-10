
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static final int NUM_ALPHABET=26;
	static final int MIN=Integer.MIN_VALUE;
	static final int[] DX= {0,0,-1,1};
	static final int[] DY= {-1,1,0,0};
	
	static boolean[] visited;
	static int maxSeen;
	static StringBuilder sb=new StringBuilder();
	
	//최대로 명물을 볼수있는 가지를 고른다.
	static void DFS(char[][]grid,int x,int y,int distance) {
		
		for(int i=0;i<4;i++) {
			int nx=x+DX[i];
			int ny=y+DY[i];
			
			maxSeen=maxSeen>distance?maxSeen:distance;
			if(nx<0||ny<0||nx>=grid[0].length||ny>=grid.length)continue;
			
			int see=grid[ny][nx]-'A';
			if(visited[see])continue;
			
			visited[see]=true;
			DFS(grid,nx,ny,distance+1);
			visited[see]=false;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			st=new StringTokenizer(br.readLine());
			
			int height=Integer.parseInt(st.nextToken());
			int width=Integer.parseInt(st.nextToken());
			
			char[][] grid=new char[height][width];
			
			
			for(int i=0;i<height;i++) {
				String input=br.readLine();
				for(int j=0;j<width;j++)grid[i][j]=input.charAt(j);
			}
			//알파벳 방문처리
			visited=new boolean[NUM_ALPHABET];
			maxSeen=MIN;
			visited[grid[0][0]-'A']=true;
			DFS(grid,0,0,1);
			sb.append('#').append(t).append(' ').append(maxSeen).append('\n');
		}
		System.out.println(sb);
	
	}

}
