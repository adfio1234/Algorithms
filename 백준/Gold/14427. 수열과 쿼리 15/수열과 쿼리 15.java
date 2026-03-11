
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] num;
	static int[] segmentTree;
	static StringBuilder sb=new StringBuilder();
	
	static int init(int start,int end,int idx) {
		if(start==end) {
			segmentTree[idx]=start;
			return segmentTree[idx];
		}
		int mid=(start+end)/2;
		
		int left=init(start,mid,idx*2);
		int right=init(mid+1,end,idx*2+1);
		
		//둘이 같으면 인덱스가 더 작은 쪽을 고른다.
		if(num[left]==num[right])segmentTree[idx]=left;
		else if(num[left]>num[right])segmentTree[idx]=right;
		else if(num[left]<num[right])segmentTree[idx]=left;
		return segmentTree[idx];
	}
	
	static void update(int start,int end,int idx,int target,int value) {
		//범위 밖일경우
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
		if(num[left]==num[right])input=left;
		else if(num[left]<num[right])input=left;
		else if(num[left]>num[right])input=right;
		segmentTree[idx]=input;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int numArr=Integer.parseInt(br.readLine());
		
		num=new int[numArr];
		segmentTree=new int[numArr*4];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<numArr;i++)num[i]=Integer.parseInt(st.nextToken());
		
		int queryNum=Integer.parseInt(br.readLine());
		
		
		init(0,numArr-1,1);

		
		for(int i=0;i<queryNum;i++) {
			st=new StringTokenizer(br.readLine());
			int command=Integer.parseInt(st.nextToken());
			
			if(command==1) {
				int target=Integer.parseInt(st.nextToken())-1;
				int value=Integer.parseInt(st.nextToken());
				num[target]=value;
				update(0,numArr-1,1,target,value);
			}else if(command==2)sb.append(segmentTree[1]+1).append('\n');
		}
		System.out.print(sb);
	}

}
