import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int MIN=Integer.MIN_VALUE;
	
	//numWood: 나무의 수
	//needWoodLen: 필요한 나무의 길이
	//woodLen: 나무의 길이 배열
	//maxLen: 제일 긴 나무의 길이
	static int numWood;
	static long needWoodLen;
	static int[] woodLen;
	static int maxLen=MIN;
	
	
	//최적의 높이를 찾는다.
	static long findOptimalLen() {
		long left=0;
		long right=maxLen;
		long mid=0;
		
		while(left<=right) {
			mid=(left+right)/2;
			//자른 나무가 원하는 나무개수보다 적으면 자르는 높이를 내린다.
			if(cutWood(mid)<needWoodLen) {
				right=mid-1;
			}
			//자른 나무의 개수가 원하는 나무개수보다 크거나 같으면 자르는 높이를 올린다.
			else {
				left=mid+1;
			}
			
		}		
		return left-1;
	}
	
	//height기준으로 잘랐을시 나오는 나무의 길이를 구한다
	//input: 설정한 높이
	//output: 나무를 잘랐을시 나오는 길이
	static long cutWood(long height) {
		
		
		long sumLen=0;
	
		for(int i=0;i<numWood;i++) {
			if(woodLen[i]>height)sumLen+=(woodLen[i]-height);
		}
		return sumLen;
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		numWood=Integer.parseInt(st.nextToken());
		needWoodLen=Integer.parseInt(st.nextToken());
		woodLen=new int[numWood];
		maxLen=MIN;
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<numWood;i++) {
			woodLen[i]=Integer.parseInt(st.nextToken());
			maxLen=maxLen<woodLen[i]?woodLen[i]:maxLen;
		}
		System.out.println(findOptimalLen());
		
	}

}
