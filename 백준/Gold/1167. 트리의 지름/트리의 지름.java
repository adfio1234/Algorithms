
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<int []>[] tree;
	static boolean[] visited;
	
	static int maxDistance=Integer.MIN_VALUE;
	static int farVertex=0;
	
	//true시 가장먼 노드번호 return, false시 가장먼 거리 return
	static void farNode(int vertex,int distance) {
		
		for(int[] cur:tree[vertex]) {
			int nextNode=cur[0];
			int weight=cur[1];
			
			if(visited[nextNode])continue;
			visited[nextNode]=true;
			farNode(nextNode,distance+weight);
			visited[nextNode]=false;
		}
		if(distance>maxDistance) {
			maxDistance=distance;
			farVertex=vertex;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int vertexNum=Integer.parseInt(br.readLine());
		
		tree=new ArrayList[vertexNum];
		for(int i=0;i<vertexNum;i++)tree[i]=new ArrayList<>();
		
		
		//트리에대한 정보를 넣는다.
		for(int i=0;i<vertexNum;i++) {
			st=new StringTokenizer(br.readLine());
			
			int vertexIdx=Integer.parseInt(st.nextToken())-1;
			while(st.hasMoreElements()) {
				int target=Integer.parseInt(st.nextToken())-1;
				
				if(target<0)break;
				int weight=Integer.parseInt(st.nextToken());
				tree[vertexIdx].add(new int[] {target,weight});
			}
		}
		
		visited=new boolean[vertexNum];
		visited[0]=true;
		
		farNode(0,0);
		
		maxDistance=Integer.MIN_VALUE;
		visited=new boolean[vertexNum];
		visited[farVertex]=true;
		farNode(farVertex,0);
		
		System.out.println(maxDistance);
		
		
	}

}

