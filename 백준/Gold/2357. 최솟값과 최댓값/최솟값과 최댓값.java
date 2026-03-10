
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long[] num;
	static long[] segmentTreeMax;
	static long[] segmentTreeMin;
	static StringBuilder sb=new StringBuilder();
	
	static long initMax(int start,int end,int idx) {
		if(start==end)return segmentTreeMax[idx]=num[start];
		
		int mid=(start+end)/2;

		segmentTreeMax[idx]=Math.max(initMax(start,mid,idx*2), initMax(mid+1,end,idx*2+1));
		return segmentTreeMax[idx];
	}
	
	static long intervalMax(int start,int end,int idx,int left,int right) {
		//범위 밖일떄
		if(left>end||right<start)return Long.MIN_VALUE;
		//범위 안에있을때
		if(left<=start&&end<=right)return segmentTreeMax[idx];
		
		int mid=(start+end)/2;
		return Math.max(intervalMax(start,mid,idx*2,left,right), intervalMax(mid+1,end,idx*2+1,left,right));
	}
	
	
	
	
	static long initMin(int start,int end,int idx) {
		if(start==end)return segmentTreeMin[idx]=num[start];
		
		int mid=(start+end)/2;
		
		segmentTreeMin[idx]=Math.min(initMin(start,mid,idx*2), initMin(mid+1,end,idx*2+1));
		return segmentTreeMin[idx];
	}
	
	static long intervalMin(int start,int end,int idx,int left,int right) {
		if(left>end||start>right)return Long.MAX_VALUE;
		
		if(left<=start&&end<=right)return segmentTreeMin[idx];
		
		int mid=(start+end)/2;
		return Math.min(intervalMin(start,mid,idx*2,left,right), intervalMin(mid+1,end,idx*2+1,left,right));
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int numCnt=Integer.parseInt(st.nextToken());
		int numRange=Integer.parseInt(st.nextToken());
		
		num=new long[numCnt];
		segmentTreeMax=new long[numCnt*4];
		segmentTreeMin=new long[numCnt*4];
		for(int i=0;i<numCnt;i++)num[i]=Integer.parseInt(br.readLine());
		
		initMax(0,numCnt-1,1);
		initMin(0,numCnt-1,1);
		
		for(int i=0;i<numRange;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken())-1;
			int end=Integer.parseInt(st.nextToken())-1;
			
			long max=intervalMax(0, numCnt-1, 1,start,end);
			long min=intervalMin(0, numCnt-1, 1,start,end);
			
			sb.append(min).append(' ').append(max).append('\n');
		}
		System.out.print(sb);
		
	}

}
