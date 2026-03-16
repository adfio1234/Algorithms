import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	
	static final int INF=Integer.MAX_VALUE;
	
	static ArrayList<int[]>[] xToHome;
	static ArrayList<int[]>[] homeToX;

	//시작지점에서 다른지점들 까지의 최단 경로를 리턴한다.
	static int[] Dijk(int vertexNum,int start,ArrayList<int[]>[] edgeList) {
		
		int[] dist=new int[vertexNum];
		for(int i=0;i<vertexNum;i++)dist[i]=INF;
		dist[start]=0;
		
		PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[1], b[1]));
		pq.add(new int[] {start,0});
		
		while(!pq.isEmpty()) {
			int[] cur=pq.poll();
			int curNode=cur[0];
			int distance=cur[1];
			
			if(dist[curNode]<distance)continue;
			
			//해당노드와 연결된 간선을 다꺼내본다.
			for(int i=0;i<edgeList[curNode].size();i++) {
				int[] next=edgeList[curNode].get(i);
				int nextNode=next[0];
				int weight=next[1];
				if(dist[nextNode]<weight+distance)continue;
				dist[nextNode]=weight+distance;
				pq.add(new int[] {nextNode,distance+weight});
			}
		}

		return dist;
	}
	
	
	public static void main(String[] args) throws IOException {
		//------여기에 솔루션 코드를 작성하세요.------------
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int vertexNum=Integer.parseInt(st.nextToken());
		int edgeNum=Integer.parseInt(st.nextToken());
		int target=Integer.parseInt(st.nextToken())-1;
		
		xToHome=new ArrayList[vertexNum];
		homeToX=new ArrayList[vertexNum];
		
		for(int i=0;i<vertexNum;i++) {
			xToHome[i]=new ArrayList<>();
			homeToX[i]=new ArrayList<>();
		}

		
		//정방향 그래프와 역방향그래프를 만든다.
		for(int i=0;i<edgeNum;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken())-1;
			int end=Integer.parseInt(st.nextToken())-1;
			int weight=Integer.parseInt(st.nextToken());
			xToHome[start].add(new int[] {end,weight});
			homeToX[end].add(new int[] {start,weight});
		}
		
		//두번의 다익스트라로 나온 각각의 배열
		int[] goDist=Dijk(vertexNum,target,homeToX);
		int[] comeDist=Dijk(vertexNum,target,xToHome);
		int result=0;
		
		//그 배열들의 idx의 합이 제일 큰것을 고른다.
		for(int i=0;i<vertexNum;i++)result=Math.max(result, goDist[i]+comeDist[i]);
		System.out.println(result);
	}
}