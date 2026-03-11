
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] num;
	static int[] segmentTree;
	static StringBuilder sb=new StringBuilder();
	
	
	static int init(int start,int end,int idx) {
		if(start==end)return segmentTree[idx]=start;
		
		int mid=(start+end)/2;
		
		int left=init(start,mid,idx*2);
		int right=init(mid+1,end,idx*2+1);
		int input=0;
		if(num[left]==num[right])input=Math.min(left, right);
		else if(num[left]>num[right])input=right;
		else if(num[left]<num[right])input=left;
		
		segmentTree[idx]=input;
		return segmentTree[idx];
	}
	
	static void update(int start,int end,int idx,int target,int value) {
		if(target<start||target>end)return;
		
		if(start==end) {
			segmentTree[idx]=target;
			return;
		}
		
		
		int mid=(start+end)/2;
		update(start,mid,idx*2,target,value);
		update(mid+1,end,idx*2+1,target,value);
		
		int left=segmentTree[idx*2];
		int right=segmentTree[idx*2+1];
		
		int input=0;
		if(num[left]==num[right])input=Math.min(left, right);
		else if(num[left]>num[right])input=right;
		else if(num[left]<num[right])input=left;
		
		segmentTree[idx]=input;
		return;
	}
	
	static int intervalMin(int start,int end,int idx,int left,int right) {
		if(end<left||right<start)return -1;
		
		if(left<=start&&end<=right)return segmentTree[idx];
		
		int mid=(start+end)/2;
		
		int leftNum=intervalMin(start,mid,idx*2,left,right);
		int rightNum=intervalMin(mid+1,end,idx*2+1,left,right);
		
		if(leftNum==-1)return rightNum;
		if(rightNum==-1)return leftNum;
		
		int input=0;
		if(num[leftNum]==num[rightNum])input=Math.min(leftNum, rightNum);
		else if(num[leftNum]>num[rightNum])input=rightNum;
		else if(num[leftNum]<num[rightNum])input=leftNum;
		
		return input;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int len=Integer.parseInt(br.readLine());
		
		num=new int[len];
		segmentTree=new int[len*4];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<len;i++)num[i]=Integer.parseInt(st.nextToken());
		
		init(0,len-1,1);
	
		int queryLen=Integer.parseInt(br.readLine());
		for(int i=0;i<queryLen;i++) {
			st=new StringTokenizer(br.readLine());
			int command=Integer.parseInt(st.nextToken());
			
			//
			if(command==1) {
				int target=Integer.parseInt(st.nextToken())-1;
				int value=Integer.parseInt(st.nextToken());
				num[target]=value;
				update(0,len-1,1,target,value);
			}else if(command==2) {
				int left=Integer.parseInt(st.nextToken())-1;
				int right=Integer.parseInt(st.nextToken())-1;
				sb.append(intervalMin(0,len-1,1,left,right)+1).append('\n');
			}
		}
		System.out.println(sb);
		
	}

}
