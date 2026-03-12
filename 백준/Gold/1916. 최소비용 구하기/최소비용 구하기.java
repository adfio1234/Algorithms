
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge{
		
		private int target;
		private int weight;
		
		Edge(int target,int weight){
			this.target=target;
			this.weight=weight;
		}
	}
	
	static final int INF=Integer.MAX_VALUE;
	
	static ArrayList<Edge>[] edgeList;
	
	
	static void minCost(int start,int end,int cityNum) {
		
		int[] dist=new int[cityNum];
		for(int i=0;i<cityNum;i++)dist[i]=INF;
		dist[start]=0;
		
		PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
		pq.add(new int[] {start,0});
		
		while(!pq.isEmpty()) {
			int[] cur=pq.poll();
			
			int curNode=cur[0];
			int distance=cur[1];
		
			if(dist[curNode]<distance)continue;
			
			for(Edge i:edgeList[curNode]) {
				int nextNode=i.target;
				int weight=i.weight;
				weight+=distance;
				if(dist[nextNode]<=weight)continue;
				dist[nextNode]=weight;
				pq.add(new int[] {nextNode,weight});
			}
		}
		System.out.println(dist[end]);
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int cityNum=Integer.parseInt(br.readLine());
		int edgeNum=Integer.parseInt(br.readLine());
		
		
		edgeList=new ArrayList[cityNum];
		for(int i=0;i<cityNum;i++)edgeList[i]=new ArrayList<>();
		
		for(int i=0;i<edgeNum;i++) {
			st=new StringTokenizer(br.readLine());
			
			int start=Integer.parseInt(st.nextToken())-1;
			int end=Integer.parseInt(st.nextToken())-1;
			int weight=Integer.parseInt(st.nextToken());
			edgeList[start].add(new Edge(end,weight));
		}
		st=new StringTokenizer(br.readLine());
		int start=Integer.parseInt(st.nextToken())-1;
		int end=Integer.parseInt(st.nextToken())-1;
		minCost(start,end,cityNum);
		
	}

}
