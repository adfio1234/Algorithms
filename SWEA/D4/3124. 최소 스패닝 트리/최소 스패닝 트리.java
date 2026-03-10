
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	
	public int start;
	public int end;
	public long weight;
	
	Edge(int start,int end,int weight){
		this.start=start;
		this.end=end;
		this.weight=weight;
	}

	@Override
	public int compareTo(Edge o) {
		return (int) (this.weight-o.weight);
	}
}

public class Solution {
	
	static Edge[] list;
	static int[] parent;
	static StringBuilder sb=new StringBuilder();
	
	static int[] makeSet(int size) {
		int[] node=new int[size];
		for(int i=0;i<size;i++)node[i]=i;
		return node;
	}
	
	//두집합이 같은 조상인지 확인한다.
	static boolean unionSet(int a,int b) {
		int parent1=findSet(a);
		int parent2=findSet(b);
		
		if(parent1==parent2)return false;
		parent[parent1]=parent2;
		return true;
	}
	
	//조상을 확인한다.
	static int findSet(int a) {
		if(a==parent[a])return a;
		else return parent[a]=findSet(parent[a]);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			st=new StringTokenizer(br.readLine());
			int vertexNum=Integer.parseInt(st.nextToken());
			int edgeNum=Integer.parseInt(st.nextToken());
			
			long distance=0;
			
			list=new Edge[edgeNum];
			
			for(int i=0;i<edgeNum;i++) {
				st=new StringTokenizer(br.readLine());
				int start=Integer.parseInt(st.nextToken())-1;
				int end=Integer.parseInt(st.nextToken())-1;
				int weight=Integer.parseInt(st.nextToken());
				list[i]=new Edge(start,end,weight);
			}
			
			Arrays.sort(list);
			parent=makeSet(vertexNum);
			
			for(int i=0;i<edgeNum;i++) {
				Edge cur=list[i];
				
				if(unionSet(cur.start,cur.end))distance+=cur.weight;
			}
			sb.append('#').append(t).append(' ').append(distance).append('\n');
			
		}
		System.out.println(sb);
		
	
	}

}
