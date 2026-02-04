import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static final int INF=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		//입력
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)arr[i]=Integer.parseInt(st.nextToken());
		
		int left=0;
		int right=N-1;
		int tmp=0;
		int absTmp=0;
		int min=INF;
		int min1=0;
		int min2=0;
		
		//정렬
		Arrays.sort(arr);
		
		//투포인트 로직
		while(left<right) {
			tmp=arr[left]+arr[right];
			absTmp=Math.abs(tmp);
			
			if(absTmp<min) {
				min=absTmp;
				min1=arr[left];
				min2=arr[right];
			}
			
			if(tmp<0)left++;
			else if(tmp>0)right--;
			else break;
		}
		System.out.println(min1+" "+min2);
		
	}

}
