import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		//N,M값 입력
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		int[] arr=new int [N+1];
		arr[0]=0;
		for(int i=1;i<=N;i++ )arr[i]=Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=N;i++)arr[i]+=arr[i-1];//누적합 저장

		int i=0;
		int j=0;
		//M번 반복
		for(int r=0;r<M;r++)
		{
			st=new StringTokenizer(br.readLine());
			i=Integer.parseInt(st.nextToken());
			j=Integer.parseInt(st.nextToken());
			System.out.println(arr[j]-arr[i-1]);//i~j번쨰의 합은 i의 누적합에서 j-1번쨰의 누적합을 뺀거와 같다.
			//0 5 9 12 14 15
		}
	}

}
