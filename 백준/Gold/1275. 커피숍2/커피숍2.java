

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long[] arr;
	static long[] segmentTree;
	static StringBuilder sb=new StringBuilder();
	
	
	static long init(int start,int end,int idx) {
		if(start==end)return segmentTree[idx]=arr[start];
		
		int mid=(start+end)/2;
		segmentTree[idx]=init(start,mid,idx*2)+init(mid+1,end,idx*2+1);
		return segmentTree[idx];
	}
	
	static long intervalSum(int start,int end,int idx,int left,int right) {
		//범위밖을 나갔을 경우
		if(end<left||right<start)return 0L;
		
		if(left<=start&&end<=right)return segmentTree[idx];

		int mid=(start+end)/2;
		
		return intervalSum(start,mid,idx*2,left,right)+intervalSum(mid+1,end,idx*2+1,left,right);
		
	}
	
	static void update(int start,int end,int idx,int target,int value) {
		if(target<start||target>end)return;
		if(start==end) {
			segmentTree[idx]=arr[target];
			return;
		}
		
		int mid=(start+end)/2;
		
		update(start,mid,idx*2,target,value);
		update(mid+1,end,idx*2+1,target,value);
		segmentTree[idx]=segmentTree[idx*2]+segmentTree[idx*2+1];
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int turnNum=Integer.parseInt(st.nextToken());
		
		arr=new long[N];
		segmentTree=new long[N*4];
		st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++)arr[i]=Long.parseLong(st.nextToken());
		
		init(0,N-1,1);
		
		for(int i=0;i<turnNum;i++) {
			st=new StringTokenizer(br.readLine());
			
			int left=Integer.parseInt(st.nextToken())-1;
			int right=Integer.parseInt(st.nextToken())-1;
			
			int tmp=Math.min(left,right);
			right=Math.max(left, right);
			left=tmp;
			
			int target=Integer.parseInt(st.nextToken())-1;
			int value=Integer.parseInt(st.nextToken());
			
			sb.append(intervalSum(0,N-1,1,left,right)).append('\n');
			arr[target]=value;
			update(0,N-1,1,target,value);
		}
		System.out.println(sb);
	}

}
