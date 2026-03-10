import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int MOD=1_000_000_007;
	
	static int[] num;
	static long[] segmentTree;
	static StringBuilder sb=new StringBuilder();
	
	///구간 곱을 구한다.
	static long init(int start,int end,int idx) {
		if(start==end) {
			segmentTree[idx]=num[start];
			return segmentTree[idx];
		}
		
		int mid=(start+end)/2;
		segmentTree[idx]=init(start,mid,idx*2)*init(mid+1,end,idx*2+1)%MOD;
		return segmentTree[idx];
	}
	
	///구간의 곱을 구한다.
	static long intervalMulti(int start,int end,int idx,int left,int right) {
		
		//범위를 나갔을경우
		if(left>end||start>right)return 1;
		
		//범위 안에 있을 경우
		if(left<=start&&end<=right)return segmentTree[idx];
		
		int mid=(start+end)/2;
		
		return intervalMulti(start, mid, idx*2, left, right)*intervalMulti(mid+1, end, idx*2+1, left, right)%MOD;
	}
	
	///업데이트를 해준다.
	static void update(int start,int end,int idx,int target,int value) {
		//범위 밖에 있는 경우
		if(target<start||target>end)return;
		
		//MOD연산과 divisionZERO가 존재하므로
		//리프노드수정후 다시 부모노드 재계산
		if(start==end) {
			segmentTree[idx]=value;
			return;
		}
		int mid=(start+end)/2;
		update(start,mid,idx*2,target,value);
		update(mid+1,end,idx*2+1,target,value);
		segmentTree[idx]=segmentTree[idx*2]*segmentTree[idx*2+1]%MOD;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int numCnt=Integer.parseInt(st.nextToken());
		int modifyCnt=Integer.parseInt(st.nextToken());
		int multiCnt=Integer.parseInt(st.nextToken());
		
		num=new int[numCnt];
		segmentTree=new long[numCnt*4];
		for(int i=0;i<numCnt;i++)num[i]=Integer.parseInt(br.readLine());
		
		//초기화
		init(0,numCnt-1,1);

		for(int i=0;i<modifyCnt+multiCnt;i++) {
			st=new StringTokenizer(br.readLine());
			int command=Integer.parseInt(st.nextToken());
			
			
			//command:1 start번째를 end로 바꾼다.
			if(command==1) {
				int target=Integer.parseInt(st.nextToken())-1;
				int value=Integer.parseInt(st.nextToken());
				num[target]=value;
				update(0,numCnt-1,1,target,value);
			}
			//command:2 start부터 end까지의 곱을 구한다.
			else if(command==2) {
				int start=Integer.parseInt(st.nextToken())-1;
				int end=Integer.parseInt(st.nextToken())-1;
				sb.append(intervalMulti(0,numCnt-1,1,start,end)%MOD).append('\n');
			}
		}
		System.out.println(sb);
		
	}

}
