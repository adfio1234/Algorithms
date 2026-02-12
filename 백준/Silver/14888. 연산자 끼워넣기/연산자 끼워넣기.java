import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	//NUM_OPERATOR:연산자 개수
	static final int NUM_OPERATOR=4;
	
	//arr: 수열에 들어가는 숫자
	//operator:연산자 개수 0:+, 1:-, 2:*, 3:/
	//MIN: 정수 최댓값
	//MAX: 오버플로우를 이용한 정수 최솟값
	static int[] arr;
	static int[] operator=new int[4];
	static int numNUMBER;
	static int countOperator;
	static int min=Integer.MAX_VALUE;
	static int max=min+1;
	
	static void makeMinCase(int cnt,int sum) {
		if(cnt==countOperator+1) {
			min=min>sum?sum:min;
			max=max>sum?max:sum;
			return;
		}
		
		//나누기를 사용했을때
		if(operator[3]>0)
		{
			operator[3]-=1;
			makeMinCase(cnt+1,sum/arr[cnt]);
			operator[3]+=1;
		}
		//빼기 사용했을때
		if(operator[1]>0)
		{
			operator[1]-=1;
			makeMinCase(cnt+1,sum-arr[cnt]);
			operator[1]+=1;
		}
		//더하기 사용했을때
		if(operator[0]>0)
		{
			operator[0]-=1;
			makeMinCase(cnt+1,sum+arr[cnt]);
			operator[0]+=1;
		}
		//곱하기를 사용했을때
		if(operator[2]>0)
		{
			operator[2]-=1;
			makeMinCase(cnt+1,sum*arr[cnt]);
			operator[2]+=1;
		}

	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		numNUMBER=Integer.parseInt(br.readLine());
		countOperator=numNUMBER-1;
		
		//수열 입력
		arr=new int[numNUMBER];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<numNUMBER;i++)arr[i]=Integer.parseInt(st.nextToken());
		
		//연산자 개수 입력
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<NUM_OPERATOR;i++) {
			operator[i]=Integer.parseInt(st.nextToken());
		}
		
		makeMinCase(1,arr[0]);
		System.out.println(max);
		System.out.println(min);
	}

}
