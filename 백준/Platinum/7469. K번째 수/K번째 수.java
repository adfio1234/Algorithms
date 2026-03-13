
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int[] num;
	static ArrayList<Integer>[] segmentTree;
	static StringBuilder sb=new StringBuilder();
	static ArrayList<Integer> init(int start,int end,int idx) {
		if(start==end) {
			segmentTree[idx].add(num[start]);
			return segmentTree[idx];
		}
		
		int mid=(start+end)/2;
		
		ArrayList<Integer> left=init(start,mid,idx*2);
		ArrayList<Integer> right=init(mid+1,end,idx*2+1);
		segmentTree[idx]=merge(left,right);
		return segmentTree[idx];
	}
	
	static ArrayList<Integer> merge(ArrayList<Integer> left,ArrayList<Integer> right)
	{
		ArrayList<Integer> sortList=new ArrayList<>();
		int leftMax=left.size();
		int rightMax=right.size();
		int leftIdx=0;
		int rightIdx=0;
		
		while(leftIdx!=leftMax&&rightIdx!=rightMax) {
			int leftValue=left.get(leftIdx);
			int rightValue=right.get(rightIdx);
			if(leftValue>rightValue) {
				sortList.add(rightValue);
				rightIdx++;
			}else {
				sortList.add(leftValue);
				leftIdx++;
			}
		}
		
		while(leftIdx!=leftMax)sortList.add(left.get(leftIdx++));
		while(rightIdx!=rightMax)sortList.add(right.get(rightIdx++));
		return sortList;
	}
	
	static int query(int start,int end,int idx,int left,int right,int kth) {
		if(end<left||right<start)return 0;
		
		if(left<=start&&end<=right) {
			return upperBound(segmentTree[idx],kth);
		}
		
		int mid=(start+end)/2;
		return query(start, mid, idx*2, left, right, kth)+
				query(mid+1, end, idx*2+1, left, right, kth);
	}
	
	static int upperBound(ArrayList<Integer>list,int kth) {
		int left=0;
		int right=list.size();
		
		while(left<right) {
			int mid=(left+right)/2;
			
			if(list.get(mid)<=kth)left=mid+1;
			else right=mid;
		}
		return left;
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int numCnt=Integer.parseInt(st.nextToken());
		int queryNum=Integer.parseInt(st.nextToken());
		
		num=new int[numCnt];
		segmentTree=new ArrayList[numCnt*4];
		for(int i=0;i<numCnt*4;i++)segmentTree[i]=new ArrayList<>();
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<numCnt;i++)num[i]=Integer.parseInt(st.nextToken());
		
		init(0,numCnt-1,1);
		for(int i=0;i<queryNum;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken())-1;
			int end=Integer.parseInt(st.nextToken())-1;
			int kth=Integer.parseInt(st.nextToken());
			
			int left = -1000000000;
			int right = 1000000000;
			int answer = 0;
			while(left<=right) {
				int mid=(left+right)/2;
				
				int count=query(0,numCnt-1,1,start,end,mid);
				
				if(count>=kth) {
					answer=mid;
					right=mid-1;
				}else left=mid+1;
			}
			sb.append(answer).append('\n');
		}
		System.out.println(sb);
	}

}
