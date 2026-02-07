
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int sequenceLength;
	static int N;
	static int[] arr;
	static StringBuilder sb=new StringBuilder();
	
	//수열
	static void sequence(int cnt) {
		if(cnt==sequenceLength)
		{
			for(int i=0;i<sequenceLength;i++)sb.append(arr[i]+" ");
			sb.append("\n");
			return;
		}
		

		for(int i=1;i<=N;i++)
		{
			arr[cnt]=i;
			sequence(cnt+1);

		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
	
		N=Integer.parseInt(st.nextToken());
		sequenceLength=Integer.parseInt(st.nextToken());
		arr=new int[sequenceLength];
		sequence(0);
		
		System.out.println(sb);
		
	}

}
