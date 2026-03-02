
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static final int INF=Integer.MAX_VALUE;
	
	static int size;
	static int[][] grid;
	static int[][] price;
	static StringBuilder sb=new StringBuilder();
	
	static void lostMinRupee() {
		
		int[] dx= {0,0,-1,1};
		int[] dy= {1,-1,0,0};
		
		PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
		pq.add(new int[] {0,0,grid[0][0]});
		
		price[0][0]=grid[0][0];
		
		while(!pq.isEmpty()) {
			int[] cur=pq.poll();
			int curX=cur[0];
			int curY=cur[1];
			

			
			for(int i=0;i<4;i++) {
				int nx=curX+dx[i];
				int ny=curY+dy[i];
				
				if(nx<0||ny<0||nx>=size||ny>=size)continue;
				//이동했을시 비용
				int nPrice=price[curY][curX]+grid[ny][nx];
				
				if(price[ny][nx]<=nPrice)continue;
				
				price[ny][nx]=nPrice;
				pq.add(new int[] {nx,ny,nPrice});
			}
		}
		sb.append(price[size-1][size-1]).append('\n');
	
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt=1;
		while(true) {
			size=Integer.parseInt(br.readLine());
			
			if(size==0)break;
			
			grid=new int[size][size];
			price=new int[size][size];
			
			for(int i=0;i<size;i++) {
				for(int j=0;j<size;j++)price[i][j]=INF;
			}
			
			for(int i=0;i<size;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<size;j++)grid[i][j]=Integer.parseInt(st.nextToken());
			}
			sb.append("Problem ").append(cnt++).append(": ");
			lostMinRupee();

		}
		System.out.println(sb);
		
	}

}
