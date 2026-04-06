import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final int MOD=10007;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		if(N==1)System.out.println(1);
		else if(N==2)System.out.println(2);
		else
		{
			int[] dp=new int[N+1];
			dp[0]=1;
			dp[1]=2;
			for(int i=2;i<N;i++)
			{
				dp[i]=(dp[i-1]+dp[i-2])%MOD;
			}
			System.out.println(dp[N-1]);
		}
		
		
	}

}
