

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge implements Comparable<Edge>{
		private int start;
		private int end;
		private int weight;
		
		Edge(int start,int end,int weight){
			this.start=start;
			this.end=end;
			this.weight=weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}	
	}
	
	static int[] house;
	static Edge[] edgeList;
	static StringBuilder sb=new StringBuilder();
	
	
	static int[] makeSet(int size) {
		int[] set=new int[size];
		for(int i=0;i<size;i++)set[i]=i;
		return set;
	}
	
	static int minDist(int edgeNum) {
		int cost=0;
		
		for(int i=0;i<edgeNum;i++) {
			
			Edge cur=edgeList[i];
			int start=cur.start;
			int end=cur.end;
			int weight=cur.weight;
			
			if(!unionSet(start,end)) {
				cost+=weight;
			}
		}
		
		return cost;
	}
	
	static boolean unionSet(int element1,int element2) {
		int parent1=findSet(element1);
		int parent2=findSet(element2);
	
		if(parent1==parent2)return false;
		house[parent1]=parent2;
		return true;
	}
	
	static int findSet(int element) {
		if(element==house[element])return element;
		else return house[element]=findSet(house[element]);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st=new StringTokenizer(br.readLine());
			
			int numHouse=Integer.parseInt(st.nextToken());
			int numRoute=Integer.parseInt(st.nextToken());
			if(numHouse==0&&numRoute==0)break;
			
			house=makeSet(numHouse);
			edgeList=new Edge[numRoute];
			
			
			for(int i=0;i<numRoute;i++) {
				st=new StringTokenizer(br.readLine());
				int start=Integer.parseInt(st.nextToken());
				int end=Integer.parseInt(st.nextToken());
				
				int weight=Integer.parseInt(st.nextToken());
				edgeList[i]=new Edge(start,end,weight);
			}
			
			Arrays.sort(edgeList);
			
			sb.append(minDist(numRoute)).append('\n');
		}
		System.out.print(sb);
		
	}

}
