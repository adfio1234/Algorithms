import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static final int NUM_POINT=100_001;
	static final int INF=Integer.MAX_VALUE;
	
	static StringBuilder sb=new StringBuilder();
	
	
	//순간이동하는 경우와 걷는 경우를 다 본다.
	static void move(int start,int target) {
		
		//visited를 도착시간으로 한다.
		//제일 먼저 좌표에 도달한게 최소 시간이므로, 갱신을위한 INF로 초기화해준다.
		int[] visited=new int[NUM_POINT];
		for(int i=0;i<NUM_POINT;i++)visited[i]=INF;
		
		ArrayDeque<int[]> dq=new ArrayDeque<>();
		int count=0;
		int minSec=INF;
				
		dq.add(new int[] {start,0});
		visited[start]=0;
		
		while(!dq.isEmpty()) {
			int[] cur=dq.pollFirst();
			int curLocate=cur[0];
			int sec=cur[1];
			
			//target위치에 도달했으면
			if(curLocate==target) {
				//처음에 도착하는 시간을 minSec로 바꾸어주고
				//동일시간에 들어오는 방법을 count해준다.
				if(minSec>=sec) {
					minSec=sec;
					count++;
				}
			}
			
			int back=curLocate-1;
			int front=curLocate+1;
			int teleport=curLocate*2;
			int nextSec=sec+1;
			
			//한걸음뒤로 갈수있으면
			if(0<=back&&back<NUM_POINT)
				if(visited[back]>=nextSec) {
					visited[back]=nextSec;
					dq.add(new int[] {back,sec+1});
				}
			//한걸음 앞으로 가는 경우
			if(0<=front&&front<NUM_POINT)
				if(visited[front]>=nextSec) {
					visited[front]=nextSec;
					dq.add(new int[] {front,sec+1});
				}
			//텔레포트 하는경우
			if(0<=teleport&&teleport<NUM_POINT)
				if(visited[teleport]>=nextSec) {
					visited[teleport]=nextSec;
					dq.add(new int[] {teleport,sec+1});
				}
		}
		
		
		sb.append(visited[target]).append('\n').append(count);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int start=Integer.parseInt(st.nextToken());
		int target=Integer.parseInt(st.nextToken());
		
		move(start,target);
		System.out.println(sb);
	}

}
