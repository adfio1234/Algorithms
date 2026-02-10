
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int MAX=Integer.MAX_VALUE;
	static StringBuilder sb=new StringBuilder();
	static char[] permutation;
	static int lenString;
	
	static int factorial(int len) {
		int sum=1;
		for(int i=2;i<=len;i++)sum*=i;
		return sum;
	}
	
	//right와 left의 값을 바꾼다.
	static void swap(int right,int left) {
		char tmp=permutation[right];
		permutation[right]=permutation[left];
		permutation[left]=tmp;
	}
	
	static void nextPermutation(int cnt) {
		
		int pivot=0;
		int idx=0;
		int min=MAX;
		int right=0;
		int left=0;
		//cnt번 실행
		for(int c=0;c<cnt;c++) {
			
			//i보다 i-1이 작아지는 pivot탐색
			for(int i=lenString-1;i>0;i--) {
				if(permutation[i]>permutation[i-1]) {
					pivot=i-1;
					break;
				}
			}
			
			//permutation[pivot]보다 큰값중에 가장작은값을 찾는다.
			for(int i=pivot+1;i<lenString;i++) {
				if(permutation[pivot]<permutation[i]) {
					if(min>permutation[i]) {
						min=permutation[i];
						idx=i;
					}
				}
			}
			
			//pivot과 idx값을바꾼다.
			swap(pivot,idx);
			
			right=pivot+1;
			left=lenString-1;
			//피벗의 오른쪽 요소들을 swap하여 오름차순으로 정렬한다.
			while(right<=left) {
				swap(right++,left--);
			}
			
			min=MAX;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String line;
		//TC여러개 입력을 위한 while문
		while((line=br.readLine())!=null) {
			
			st=new StringTokenizer(line);
			if(!st.hasMoreTokens())break;
			
			String permutationString=st.nextToken();
			int cnt= Integer.parseInt(st.nextToken())-1;
			
			lenString=permutationString.length();
			
			//문자열의 길이! 보다 높으면 해당하는 순열이없다.
			if(factorial(lenString)<cnt) {
				sb.append(permutationString).append(' ').append(cnt+1)
											.append(" = No permutation");
			}else {
				
				//char배열 생성
				permutation=permutationString.toCharArray();
				
				nextPermutation(cnt);
				sb.append(permutationString).append(' ').append(cnt+1)
														.append(" = ");
				for(char i:permutation)sb.append(i);
				
			}
			sb.append('\n');	
		}
		System.out.println(sb);
	}

}
