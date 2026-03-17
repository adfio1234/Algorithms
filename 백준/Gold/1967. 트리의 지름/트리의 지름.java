
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	
	static final int INF=Integer.MIN_VALUE;
	
	static ArrayList<Node>[] graph;
	static boolean[] visited;
	static int farMax;
	static int farNode;
	
	static void longNode(int start,int distance) {
		
		for(Node next:graph[start]) {
			int nextNode=next.target;
			int weight=next.weight;
			//이미 방문한경우 
			if(visited[nextNode])continue;
			visited[nextNode]=true;
			longNode(nextNode,distance+weight);
			visited[nextNode]=false;
		}
		if(farMax<distance) {
			farMax=distance;
			farNode=start;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int edgeNum=Integer.parseInt(br.readLine());
		
		graph=new ArrayList[edgeNum];
		for(int i=0;i<edgeNum;i++)graph[i]=new ArrayList<>();
		
		for(int i=0;i<edgeNum-1;i++) {
			st=new StringTokenizer(br.readLine());
			
			int start=Integer.parseInt(st.nextToken())-1;
			int end=Integer.parseInt(st.nextToken())-1;
			int weight=Integer.parseInt(st.nextToken());
			
			graph[start].add(new Node(end,weight));
			graph[end].add(new Node(start,weight));
		}
		
		visited=new boolean[edgeNum];
		
		farMax=INF;
		visited[0]=true;
		longNode(0,0);
		visited[0]=false;
		
		farMax=INF;
		visited[farNode]=true;
		longNode(farNode,0);
		System.out.println(farMax);
	}

}
