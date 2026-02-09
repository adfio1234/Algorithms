import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb=new StringBuilder();
	
	//sourness: 신맛 배열
	//bitter: 쓴맛 배열
	static int[] sourness;
	static int[] bitter;
	static int MIN=Integer.MAX_VALUE;
	static int numIngredient;
	static boolean[] visited;
	
	static void cook(int cnt,int limit,int sumSourness,int sumBitter) {
		
		if(cnt==limit) {
			MIN=MIN>Math.abs(sumSourness-sumBitter)?Math.abs(sumSourness-sumBitter):MIN;
			return;
		}
		
		for(int i=0;i<numIngredient;i++) {
			if(visited[i])continue;
			visited[i]=true;
			cook(cnt+1,limit,sumSourness*sourness[i],sumBitter+bitter[i]);
			visited[i]=false;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		numIngredient=Integer.parseInt(br.readLine());
	
		sourness=new int[numIngredient];
		bitter=new int[numIngredient];
		visited=new boolean[numIngredient];
		
		for(int i=0;i<numIngredient;i++) {
			st=new StringTokenizer(br.readLine());
			
			sourness[i]=Integer.parseInt(st.nextToken());
			bitter[i]=Integer.parseInt(st.nextToken());
			
		}
		
		for(int i=1;i<=numIngredient;i++)
			cook(0,i,1,0);
		
		System.out.println(MIN);
	}

}
