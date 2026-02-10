import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	//MAX: min초기화를 위한 전역상수
	//permutation: 순열을 저장하는 배열
	//N: 순열의 길이
	static final int MAX=Integer.MAX_VALUE;
	static int[] permutation;
	static int N;
	static StringBuilder sb=new StringBuilder();
	
	//left와 right를 바꾸는 함수
	static void swap(int left,int right) {
		int tmp=permutation[left];
		permutation[left]=permutation[right];
		permutation[right]=tmp;
	}
	
	//사전순 마지막 순열인지 판별하고 탈출시키기윈한 boolean타입
	static boolean nextPermutation() {
		int pivot=0;
		int idx=0;
		int min=MAX;
		int right=0;
		int left=0;
		
		//뒤에서부터 i-1이 i보다 작아지는 인덱스를 pivot으로한다.
		for(int i=N-1;i>=0;i--){
			if(i==0)return false;
			if(permutation[i]>permutation[i-1]) {
				pivot=i-1;
				break;
			}
		}
		
		//pivot보다 큰 수중 가장 작은 값을 idx로 할당
		for(int i=pivot+1;i<N;i++) {
			if(permutation[pivot]<permutation[i]) {
				if(min>permutation[i]) {
					min=permutation[i];
					idx=i;
				}
			}
		}
		
		//pivot과 idx위치의 원소를 바꾼다.
		swap(pivot,idx);
		
		
		right=pivot+1;
		left=N-1;
		
		//right와 left의 위치를 계속 바꿔준다.
		while(right<=left) {
			swap(right++,left--);
		}
		
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N=Integer.parseInt(br.readLine());
		
		permutation=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)permutation[i]=Integer.parseInt(st.nextToken());
		

		if(!nextPermutation())
		{
			System.out.println(-1);
			return;
		}
		
		for(int i:permutation)sb.append(i).append(' ');
		System.out.println(sb);
	}

}
