
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final int MOD=1_000_000_007;
	
	///matrix를 만들어줍니다.
	public static long[][] makeMatrix(long a,long b,long c,long d)
	{
		long[][] matrix=new long[2][2];
		matrix[0][0]=a;
		matrix[0][1]=b;
		matrix[1][0]=c;
		matrix[1][1]=d;
		return matrix;
	}
	
	public static long[][] multipleMatrix(long[][]a, long[][]b)
	{
		long[][] result=new long[2][2];
		result[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
		result[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
		result[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
		result[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;
		return result;
	}
	
	public static long[][] solve(long N)
	{
		//단위 행렬을 만들어 줍니다.
		long[][] result=makeMatrix(1,0,0,1);
		long[][] base=makeMatrix(4,MOD-1,1,0);
		
		while(N>0)
		{
			if(N%2==1)result=multipleMatrix(result,base);
			base=multipleMatrix(base,base);
			N/=2;
		}
		return result;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		long N=Long.parseLong(br.readLine());
		if(N%2==1)System.out.println(0);
		else if(N==0)System.out.println(1);
		else if(N==2)System.out.println(3);
		else
		{
			long k=N/2;
			//기존의 점화식인
			//dp[n]=4dp[n-2]-dp[n-4]를 행렬의 곱으로 풀어냅니다.
			long[][] ans=solve(k-1);
			long answer=(ans[0][0]*3+ans[0][1]*1)%MOD;
			System.out.println(answer);

		}
		
	}

}
