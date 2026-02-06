
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int sequenceLength;
	static int N;
	static boolean[] visited;
	
	static void sequence(int cnt,String result) {
		if(cnt==sequenceLength)
		{
			System.out.println(result);
			return;
		}
		
		for(int i=1;i<=N;i++)
		{
			if(visited[i])continue;
			visited[i]=true;
			sequence(cnt+1,result+i+" ");
			visited[i]=false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
	
		N=Integer.parseInt(st.nextToken());
		sequenceLength=Integer.parseInt(st.nextToken());
		visited=new boolean[N+1];
		
		sequence(0,"");
		
	}

}
