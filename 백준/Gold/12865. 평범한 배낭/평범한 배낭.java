
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int numItem=Integer.parseInt(st.nextToken());
		int limitWeight=Integer.parseInt(st.nextToken());
		
		int[] dp=new int[limitWeight+1];
		
		dp[0]=0;
		for(int i=0;i<numItem;i++) {
			st=new StringTokenizer(br.readLine());
			int weight=Integer.parseInt(st.nextToken());
			int value=Integer.parseInt(st.nextToken());
			
			
			for(int j=limitWeight;j>=weight;j--) {
				dp[j]=Math.max(dp[j-weight]+value, dp[j]);
			}
		}
		System.out.println(dp[limitWeight]);
	}

}
