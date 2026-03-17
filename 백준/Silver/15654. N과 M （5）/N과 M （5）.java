
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] num;
	static int[] input;
	static StringBuilder sb=new StringBuilder();
	static boolean[] visited;
	
	static void DFS(int cnt,int len) {
		
		if(cnt==len) {
			for(int i:input)sb.append(i).append(' ');
			sb.append('\n');
			return;
		}
		
		for(int i=0;i<num.length;i++) {
			
			if(visited[i])continue;
			
			input[cnt]=num[i];
			
			visited[i]=true;
			DFS(cnt+1,len);
			visited[i]=false;
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int numCnt=Integer.parseInt(st.nextToken());
		int len=Integer.parseInt(st.nextToken());
		
		num=new int[numCnt];
		visited=new boolean[numCnt];
		input=new int[len];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<numCnt;i++)num[i]=Integer.parseInt(st.nextToken());
		
		Arrays.sort(num);
		
		DFS(0,len);
		System.out.println(sb);
	}

}
