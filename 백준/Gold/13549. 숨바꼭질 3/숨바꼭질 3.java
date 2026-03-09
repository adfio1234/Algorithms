
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static final int INF=Integer.MAX_VALUE;
	static final int MAX=100_001;
	
	
	static int hideSeek(int locate,int target) {
		ArrayDeque<int[]> dq= new ArrayDeque<>();
		dq.add(new int[] {locate,0});
		
		int[] visited=new int[MAX];
		for(int i=0;i<MAX;i++)visited[i]=INF;
		visited[locate]=0;
		
		
		
		while(!dq.isEmpty()) {
			int[] cur=dq.pollFirst();
			int curX=cur[0];
			int second=cur[1];
			
			if(curX==target)return second;
			
			int nx=curX-1;
			if(nx>=0&&visited[nx]>second+1)
			{
				visited[nx]=second+1;
				dq.addLast(new int[] {nx,second+1});
			}
			
			nx=curX+1;
			if(nx<MAX&&visited[nx]>second+1)
			{
				visited[nx]=second+1;
				dq.addLast(new int[] {nx,second+1});
			}
			
			
			nx=curX*2;
			if(nx<MAX&&visited[nx]>second)
			{
				visited[nx]=second;
				dq.addFirst(new int[] {nx,second});
			}
			
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int cur=Integer.parseInt(st.nextToken());
		int target=Integer.parseInt(st.nextToken());
		System.out.println(hideSeek(cur,target));
	}

}
