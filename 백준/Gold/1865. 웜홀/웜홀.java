
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	
	
	static ArrayList<Edge>[] edgeList;
	static StringBuilder sb=new StringBuilder();
	
	
	static boolean ford(int vertexNum) {
		int[] dist=new int[vertexNum];
		for(int i=0;i<vertexNum;i++)dist[i]=0;
		
		for(int i=0;i<vertexNum;i++) {
			boolean updated=false;
			
			for(int cur=0;cur<vertexNum;cur++) {
				for(Edge edge:edgeList[cur]) {
					int next=edge.target;
					int cost=edge.weight;
					
					if(dist[next]>dist[cur]+cost) {
						dist[next]=dist[cur]+cost;
						updated=true;
						//N번째에도 갱신되면 음수 사이클이 존재한다.
						if(i==vertexNum-1) {
							return true;
						}
					}
				}
			}
			//갱신이 없으면 종료
			if(!updated)break;
		}
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=0;t<TC;t++) {
			st=new StringTokenizer(br.readLine());
			
			int vertexNum=Integer.parseInt(st.nextToken());
			int edgeNum=Integer.parseInt(st.nextToken());
			int holeNum=Integer.parseInt(st.nextToken());
			
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
			
			for(int i=0;i<holeNum;i++) {
				st=new StringTokenizer(br.readLine());
				
				int start=Integer.parseInt(st.nextToken())-1;
				int end=Integer.parseInt(st.nextToken())-1;
				int weight=Integer.parseInt(st.nextToken());
				
				edgeList[start].add(new Edge(end,weight*-1));
			}
			if(ford(vertexNum))sb.append("YES").append('\n');
			else sb.append("NO").append('\n');
			
		}
		System.out.print(sb);
	}

}
