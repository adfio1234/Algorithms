
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static final int[] DX= {0,0,-1,1};
	static final int[] DY= {-1,1,0,0};
	
	static int[][] grid;
	static int longestLen=0;
	static boolean[][]visited;
	static StringBuilder sb=new StringBuilder();
	
	static int size;
	
	
	public static void solve(int x,int y,int dig,int len,boolean canDig)
	{
		
		for(int i=0;i<4;i++)
		{
			int nx=x+DX[i];
			int ny=y+DY[i];
			if(nx<0||ny<0||nx>=size||ny>=size)continue;
			if(visited[ny][nx])continue;
			//공사가 필요없는 경우
			if(grid[ny][nx]<grid[y][x])
			{
				visited[ny][nx]=true;
				solve(nx,ny,dig,len+1,canDig);
				visited[ny][nx]=false;
			}
			else
			{
				if(!canDig)continue;
				int needDig=grid[ny][nx]-grid[y][x]+1;
				if(needDig>dig)continue;
				else
				{
					visited[ny][nx]=true;
					grid[ny][nx]-=needDig;
					solve(nx,ny,dig,len+1,false);
					grid[ny][nx]+=needDig;
					visited[ny][nx]=false;
				}
			}
		}
		longestLen=Math.max(len,longestLen);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++)
		{
			st=new StringTokenizer(br.readLine());
			size=Integer.parseInt(st.nextToken());
			int dig=Integer.parseInt(st.nextToken());
			
			grid=new int [size][size];
			int max=0;
			longestLen=0;
			
			for(int i=0;i<size;i++)
			{
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<size;j++)
				{
					grid[i][j]=Integer.parseInt(st.nextToken());
					max=Math.max(grid[i][j], max);
				}
			}
			for(int i=0;i<size;i++)
			{
				for(int j=0;j<size;j++)
				{
					visited=new boolean[size][size];
					
					if(grid[i][j]==max)
					{
						visited[i][j]=true;
						solve(j,i,dig,1,true);
					}
				}
			}
			sb.append("#").append(t).append(" ").append(longestLen).append("\n");			
		}
		System.out.println(sb);
		
	}

}
