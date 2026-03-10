
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge>{
		public int start;
		public int end;
		public int weight;
		
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
	
	static int[] com;
	
	//자기자신을 조상으로 가지는 Set을 리턴한다.
	static int[] makeSet(int size) {
		int[] set=new int[size];
		for(int i=0;i<size;i++)set[i]=i;
		return set;
	}
	
	static boolean unionSet(int start,int end) {
		int parent1=findSet(start);
		int parent2=findSet(end);
		
		//둘의 조상이같으면 union실패
		if(parent1==parent2)return false;
		com[parent1]=parent2;
		return true;
	}
	
	//조상 노드의 값을 찾아준다.
	static int findSet(int element) {
		if(element==com[element])return element;
		else return com[element]=findSet(com[element]);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int numCom=Integer.parseInt(br.readLine());
		int numEdge=Integer.parseInt(br.readLine());
		
		//Edge리스트를 만든다.
		Edge[] edgeList=new Edge[numEdge];
		
		com=makeSet(numCom);
		
		
		//리스트에 Edge를 넣는다.
		for(int i=0;i<numEdge;i++) {
			st=new StringTokenizer(br.readLine());
			
			//0-based
			int start=Integer.parseInt(st.nextToken())-1;
			int end=Integer.parseInt(st.nextToken())-1;
			int weight=Integer.parseInt(st.nextToken());
			edgeList[i]=new Edge(start,end,weight);
			
		}

		//가중치기준 오름차순을 해줍니다.
		Arrays.sort(edgeList);
		int cost=0;
		int idx=0;
		int connected=0;
		while(connected!=numCom-1) {
			Edge edge=edgeList[idx++];
			
			//연결됐으면 비용을더하고 연결된간선의 개수를 증가
			if(unionSet(edge.start, edge.end)) {
				cost+=edge.weight;
				connected++;
			}
			
		}
		System.out.println(cost);
	}

}
