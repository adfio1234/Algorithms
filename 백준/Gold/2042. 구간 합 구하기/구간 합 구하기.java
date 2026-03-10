
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb=new StringBuilder();
	static long[] num;
	static long[]prefixSum;
	
	static void modify(int target,long change,int sqrt) {
	    int boxIdx = target / sqrt;
	    prefixSum[boxIdx] -= num[target];
	    prefixSum[boxIdx] += change;
	    num[target] = change;
	}

	static void add(int start,int end,int sqrt) {
	    long sum=0;

	    int startBlock = start / sqrt;
	    int endBlock = end / sqrt;

	    if(startBlock == endBlock) {
	        for(int i=start;i<=end;i++)
	            sum += num[i];
	    }
	    else {
	        for(int i=start;i<(startBlock+1)*sqrt;i++)
	            sum += num[i];

	        for(int i=startBlock+1;i<endBlock;i++)
	            sum += prefixSum[i];

	        for(int i=endBlock*sqrt;i<=end;i++)
	            sum += num[i];
	    }

	    sb.append(sum).append('\n');
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int numCnt=Integer.parseInt(st.nextToken());
		long modifyCnt=Long.parseLong(st.nextToken());
		long sumCnt=Long.parseLong(st.nextToken());
		int sqrtSize=(int)Math.sqrt(numCnt)+1;
		
		num=new long[numCnt];
		prefixSum=new long[(numCnt+sqrtSize-1)/sqrtSize];
		int cnt=0;
		long idx=0;
		
		//누적합을 전체개수의 sqrt만큼 씩나눠서 저장한다.
		for(int i=0;i<numCnt;i++) {
			num[i]=Long.parseLong(br.readLine());
		
			prefixSum[cnt]+=num[i];
			idx++;
			if(idx==sqrtSize) {
				idx=0;
				cnt++;
			}
		}
		
		
		for(int i=0;i<modifyCnt+sumCnt;i++) {
			st=new StringTokenizer(br.readLine());
			
			//1: 변경, 2: 합계
			int command=Integer.parseInt(st.nextToken());
			if(command==1) {
				int target=Integer.parseInt(st.nextToken())-1;
				long change=Long.parseLong(st.nextToken());
				modify(target,change,sqrtSize);
				
			}else if(command==2) {
				int start=Integer.parseInt(st.nextToken())-1;
				int end=Integer.parseInt(st.nextToken())-1;
				add(start,end,sqrtSize);
			}

		}
		
		System.out.println(sb);
		
	}

}
//1 2 3 4 5
//3 7 5

//1 3 6
//1 2 6 4 5
//3 10 5
//
