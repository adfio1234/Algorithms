
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node{
		
		private int target;
		private int weight;
		
		Node(int target,int weight){
			this.target=target;
			this.weight=weight;
		}
	}
	
	static final int INF=Integer.MAX_VALUE;
	
	static ArrayList<Node>[] edgeList;
	static int[] dist;
	
	static void dijkstra(int startNum,int vertex) {
		dist=new int[vertex];
		for(int i=0;i<vertex;i++)dist[i]=INF;
		dist[startNum]=0;
		
		PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
		pq.add(new int[] {startNum,0});
		
		while(!pq.isEmpty()) {
			
			int[] cur=pq.poll();
			int curNode=cur[0];
			int distance=cur[1];
			
			if(distance>dist[curNode])continue;
			
			for(Node n:edgeList[curNode]) {
				
				int nextNode=n.target;
				int weight=n.weight;
				weight+=distance;
				
				if(weight<dist[nextNode]) {
					dist[nextNode]=weight;
					pq.add(new int[] {nextNode,weight});
				}
		
			}
		}
		
		for(int i:dist) {
			if(i==INF)System.out.println("INF");
			else System.out.println(i);
		}
		
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int vertexNum=Integer.parseInt(st.nextToken());
		int edgeNum=Integer.parseInt(st.nextToken());
		
		int startNum=Integer.parseInt(br.readLine())-1;
		edgeList=new ArrayList[vertexNum];
		for(int i=0;i<vertexNum;i++)edgeList[i]= new ArrayList<>();
		
		for(int i=0;i<edgeNum;i++) {
			st=new StringTokenizer(br.readLine());
			
			int start=Integer.parseInt(st.nextToken())-1;
			int end=Integer.parseInt(st.nextToken())-1;
			
			int weight=Integer.parseInt(st.nextToken());
			edgeList[start].add(new Node(end,weight));
		}
		
		dijkstra(startNum,vertexNum);
	}

}
