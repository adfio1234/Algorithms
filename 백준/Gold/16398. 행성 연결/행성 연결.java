
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final long INF=Long.MAX_VALUE;
	
	static long[][] cost;
	
	static long prim(int planet) {
		
		long[] minDist=new long[planet];
		for(int i=0;i<planet;i++)minDist[i]=INF;
		
		boolean[] visited=new boolean[planet];
		minDist[0]=0;
		
		long totalCost=0;
		
		for(int i=0;i<planet;i++) {
			
			int cur=-1;
			long dist=INF;
			for(int j=0;j<planet;j++) {
				if(!visited[j]&&minDist[j]<dist) {
					cur=j;
					dist=minDist[j];
				}
			}
			visited[cur]=true;
			totalCost+=dist;
			
			for(int j=0;j<planet;j++) {
				if(cost[cur][j]==0)continue;
				if(!visited[j]&&minDist[j]>cost[cur][j]) {
					minDist[j]=cost[cur][j];
				}
			}
		}
		return totalCost;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int planetNum=Integer.parseInt(br.readLine());
		
		cost=new long[planetNum][planetNum];
		
		
		for(int i=0;i<planetNum;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<planetNum;j++)cost[i][j]=Long.parseLong(st.nextToken());
		}
		
		System.out.print(prim(planetNum));
		
	}

}
