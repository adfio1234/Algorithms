
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int[] segmentTree;
	static StringBuilder sb=new StringBuilder();
	///세그먼트 트리 초기화
	static int init(int start,int end,int idx) {
		
		//끝에 도달시 arr삽입
		if(start==end) {
			segmentTree[idx]=arr[start];
			return segmentTree[idx];
		}
		int mid=(start+end)/2;
		
		//구간합 대신에 둘중에 더 작은 값을 저장한다.
		segmentTree[idx]=Math.min(init(start,mid,idx*2),init(mid+1,end,idx*2+1));
		return segmentTree[idx];
	}
	
	///구간안에서 가장 작은 값을구한다.
	static int findMin(int rangeStart,int rangeEnd,int idx,int start,int end) {
		
		//범위를 나갔을 경우
		if(rangeStart>end||rangeEnd<start)return Integer.MAX_VALUE;
		
		//범위 안에 존재할 경우
		if(rangeStart<=start&&end<=rangeEnd) {
			return segmentTree[idx];
		}
		
		int mid=(start+end)/2;
		return Math.min(findMin(rangeStart,rangeEnd,idx*2,start,mid),findMin(rangeStart,rangeEnd,idx*2+1,mid+1,end));
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int numCnt=Integer.parseInt(st.nextToken());
		int range=Integer.parseInt(st.nextToken());
		
		
		
		//정수 입력
		arr=new int[numCnt];
		for(int i=0;i<numCnt;i++)arr[i]=Integer.parseInt(br.readLine());

		//세그먼트 트리는 보통 n*4의 크기를 가진다.
		segmentTree=new int[numCnt*4];
		init(0,numCnt-1,1);
		
//		for(int i:segmentTree)System.out.printf("%d ",i);
//		System.out.println();
		
		//순서쌍 입력
		for(int i=0;i<range;i++) {
			st=new StringTokenizer(br.readLine());
			int rangeStart=Integer.parseInt(st.nextToken())-1;
			int rangeEnd=Integer.parseInt(st.nextToken())-1;
			
			sb.append(findMin(rangeStart,rangeEnd,1,0,numCnt-1)).append('\n');
		}
		System.out.print(sb);
	}

}
