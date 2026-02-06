import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
//	static int numCountry;
//	static int numFlight;
//	static int[][] graph;
//	static int[] visited;
	
	//도착노드, 방문나라수 

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=N;t++) {
		
			st=new StringTokenizer(br.readLine());
			int numCountry=Integer.parseInt(st.nextToken());
			int numFlight=Integer.parseInt(st.nextToken());
			
//			graph=new int[numCountry+1][numCountry+1];
//			visited=new int[numCountry+1];
			
			
			for(int i=0;i<numFlight;i++) {
				
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
//			
//				graph[a][b]=1;
//				graph[b][a]=1;
			}
			System.out.println(numCountry-1);
				
		}
	}

}
