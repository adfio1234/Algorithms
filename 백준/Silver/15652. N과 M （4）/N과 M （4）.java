
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] input;
	static StringBuilder sb=new StringBuilder();
	
	public static void makeArr(int num,int len,int maxNum,int maxLen)
	{
		
		if(len==maxLen)
		{
			for(int i:input)sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=maxNum;i++)
		{
			if(i<num)continue;
			
			input[len]=i;
			makeArr(i,len+1,maxNum,maxLen);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int arrSize=Integer.parseInt(st.nextToken());
		int len=Integer.parseInt(st.nextToken());
		input=new int[len];
		
		makeArr(1,0,arrSize,len);
		System.out.println(sb);
	}

}
