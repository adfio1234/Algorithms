
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			
			st=new StringTokenizer(br.readLine());
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
			sb.append('#').append(t).append(' ').append(dp[limitWeight]).append('\n');
		}
		System.out.println(sb);
	}
		

}
