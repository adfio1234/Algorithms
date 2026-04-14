
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	//대각선 visited를 만들어준다.
	static int size;
	static boolean[] visited;
	static int[][] grid;
	static int whiteMax=0;
	static int blackMax=0;
	
	//x+y의 합이 짝수 이면 흰색칸으로 생각한다.
	//x+y가 홀수 이면 검정 칸으로 간주한다.
	static void findMax(int identify,int idx,int sum)
	{
		if(sum>=2*size-1)
		{
			if(identify==0)whiteMax=Math.max(whiteMax, idx);
			else blackMax=Math.max(blackMax, idx);
			return;
		}
		for(int y=0;y<size;y++)
		{
			int x=sum-y;
			
			if(x<0||x>=size)continue;
			if(grid[y][x]==0)continue;
			
			int diag=y-x+(size-1);
			if(visited[diag])continue;
			
			visited[diag]=true;
			findMax(identify,idx+1,sum+2);
			visited[diag]=false;
		}
		findMax(identify,idx,sum+2);
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		size=Integer.parseInt(br.readLine());
		visited=new boolean[size*2-1];
		grid =new int[size][size];
		
		for(int i=0;i<size;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<size;j++)
			{
				grid[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		//흰색 칸에 먼저 넣는경우
		findMax(0,0,0);
		//검정칸에 최대로 넣는경우
		findMax(1,0,1);
		System.out.println(whiteMax+blackMax);
	}	

}
