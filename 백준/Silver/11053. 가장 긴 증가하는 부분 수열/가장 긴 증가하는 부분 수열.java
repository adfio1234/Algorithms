
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int arrSize=Integer.parseInt(br.readLine());
		int[] arr=new int[arrSize];
		int[] dp=new int[arrSize];
		int ans=0;
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<arrSize;i++)arr[i]=Integer.parseInt(st.nextToken());

		
		for(int i=0;i<arrSize;i++)
		{
			dp[i]=1;
			for(int j=0;j<i;j++)
			{
				if(arr[i]>arr[j])
				{
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
			ans=Math.max(dp[i], ans);
		}
		System.out.println(ans);
		
		
	}

}
