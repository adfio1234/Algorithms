
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static final int DEPTH=4;
	
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	
	static StringBuilder sb=new StringBuilder();
	
	
	static boolean dfs(int idx,int cnt) {
		if(cnt==DEPTH) {
			sb.append(1);
			return true;
		}
		
		for(int i:graph[idx]) {
			if(visited[i])continue;
			visited[i]=true;
			if(dfs(i,cnt+1))return true;
			visited[i]=false;
		}
		return false;
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int numHuman=Integer.parseInt(st.nextToken());
		int numRelative=Integer.parseInt(st.nextToken());
		
		
		graph=new ArrayList[numHuman];
		for(int i=0;i<numHuman;i++)graph[i]=new ArrayList<>();
		
		
		for(int i=0;i<numRelative;i++) {
			st=new StringTokenizer(br.readLine());
			
			int element1=Integer.parseInt(st.nextToken());
			int element2=Integer.parseInt(st.nextToken());
			graph[element1].add(element2);
			graph[element2].add(element1);
		}
		
		visited=new boolean[numHuman];
		for(int i=0;i<numHuman;i++) {
			visited[i]=true;
			if(dfs(i,0))break;
			visited[i]=false;
		}
		if(sb.isEmpty())sb.append(0);
		System.out.println(sb);
	}

}
