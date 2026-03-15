
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	static ArrayList<int[]> edgeList=new ArrayList<>();
	
	static int[] makeSet(int vertexNum) {
		int[] set=new int[vertexNum];
		for(int i=0;i<vertexNum;i++)set[i]=i;
		return set;
	}
	
	static boolean unionSet(int start,int end) {
		int parent1=findSet(start);
		int parent2=findSet(end);
		
		if(parent1==parent2)return false;
		parent[parent1]=parent2;
		return true;
		
		
	}
	
	static int findSet(int element) {
		if(element==parent[element])return element;
		else return parent[element]=findSet(parent[element]);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int vertexNum=Integer.parseInt(st.nextToken());
		int edgeNum=Integer.parseInt(st.nextToken());
		
		int result=0;
		
		parent=makeSet(vertexNum);
		
		
		for(int i=0;i<edgeNum;i++) {
			st=new StringTokenizer(br.readLine());
			
			int start=Integer.parseInt(st.nextToken())-1;
			int end=Integer.parseInt(st.nextToken())-1;
			int weight=Integer.parseInt(st.nextToken());
			edgeList.add(new int[] {start,end,weight});
		}
		
		Collections.sort(edgeList,(a,b)->a[2]-b[2]);
		for(int[] edge:edgeList) {
			int start=edge[0];
			int end=edge[1];
			int weight=edge[2];
			if(unionSet(start,end))result+=weight;
		}
		
		
		System.out.println(result);
		
	}

}
