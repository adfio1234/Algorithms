import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final int MOD=1_000_000_007;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		if(N%2!=0)System.out.println(0);
		else if(N==2)System.out.println(3);
		else
		{
			int[] dp=new int[N+1];
			dp[0]=1;
			dp[2]=3;
			dp[4]=11;
			for(int i=4;i<=N;i+=2)
			{
				dp[i]=((dp[i-2]*4)%MOD-dp[i-4])%MOD;
			}
			System.out.println(dp[N]);
		}
				
	}

}
