import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	//arr: 정수로 이루어진 수열
	//num: num개의 정수
	//finalSum: 만들어야할합
	//result: 만들어야할 합을 만들었을때 더한다.
	static int[] arr;
	static int num;
	static int finalSum;
	static int result=0;
	
	//조합으로 합쳐서 0이되는 값을 더한다.
	static void permutation(int limit,int cnt,int sum,int idx) {
		if(limit==cnt) {
			if(sum==finalSum)result++;
			return;
		}
		
		for(int i=idx;i<num;i++) {
			permutation(limit,cnt+1,sum+arr[i],i+1);
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		num=Integer.parseInt(st.nextToken());
		finalSum=Integer.parseInt(st.nextToken());
		
		arr=new int[num];
		
		st=new StringTokenizer(br.readLine());
		
		int idx=0;
		while(st.hasMoreTokens())arr[idx++]=Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=num;i++) {
			permutation(i,0,0,0);
		}
		System.out.println(result);
	}

}
