
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
	
	static boolean[] visited;
	static ArrayList<Edge>[] edgeList;
	
	
	static int prim(int vertex) {
		
		//정렬및 거리 초기화
		int[] minDist=new int[vertex];
		for(int i=0;i<vertex;i++)minDist[i]=INF;

	
		//0부터 시작
		minDist[0]=0;
		
		int distance=0;
		
		
		for(int i=0;i<vertex;i++) {
			int cur=-1;
			int min=INF;
			
			for(int j=0;j<vertex;j++) {
				if(!visited[j]&&minDist[j]<min) {
					cur=j;
					min=minDist[j];
				}
			}
			visited[cur]=true;
			distance+=min;
			
			for(Edge j:edgeList[cur]) {
				if(!visited[j.target]&&minDist[j.target]>j.weight) {
					minDist[j.target]=j.weight;
				}
			}
		}
		return distance;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int vertexNum=Integer.parseInt(st.nextToken());
		int edgeNum=Integer.parseInt(st.nextToken());
		
		visited=new boolean[vertexNum];
		edgeList=new ArrayList[vertexNum];
		
		for(int i=0;i<vertexNum;i++)edgeList[i]=new ArrayList<>();
		
		for(int i=0;i<edgeNum;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken())-1;
			int end=Integer.parseInt(st.nextToken())-1;
			int weight=Integer.parseInt(st.nextToken());
			
			edgeList[start].add(new Edge(end,weight));
			edgeList[end].add(new Edge(start,weight));
		}
		
		System.out.println(prim(vertexNum));
	}

}
