import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int cntApp=Integer.parseInt(st.nextToken());
		int needMemory=Integer.parseInt(st.nextToken());
		
		int [] memory=new int[cntApp];
		int [] activateCost=new int[cntApp];
		int costTotal=0;
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<cntApp;i++)memory[i]=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer( br.readLine());
		for(int i=0;i<cntApp;i++)
		{
			activateCost[i]=Integer.parseInt(st.nextToken());
			costTotal+=activateCost[i];
		}
		
		int[] dp=new int[costTotal+1];
		
		for(int i=0;i<cntApp;i++)
		{
			for(int j=costTotal;j>=activateCost[i];j--)
			{
				dp[j]=Math.max(dp[j-activateCost[i]]+memory[i],dp[j]);
			}
		}
		
		//dp를 순회하면서 최대한 적은 비용으로 메모리를 끄는 갯수를찾는다.
		for(int i=0;i<=costTotal;i++)
		{
			if(dp[i]>=needMemory)
			{
				System.out.println(i);
				break;
			}
		}
	}

}
