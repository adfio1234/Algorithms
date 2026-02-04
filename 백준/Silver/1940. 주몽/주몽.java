import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//입력처리
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		//countIng= 재료의 개수
		//countRequireIng= 갑옷을 만드는데 필요한 재료의 수
		//uniqueNumIng= 재료의 고유번호 배열
		//mixIng= 재료의 혼합값
		int countIng=Integer.parseInt(br.readLine());
		int countRequireIng=Integer.parseInt(br.readLine());
		int[] uniqueNumIng=new int[countIng];
		int mixIng=0;
		int left=0;
		int right=countIng-1;
		int result=0;
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<countIng;i++)uniqueNumIng[i]=Integer.parseInt(st.nextToken());
		
		Arrays.sort(uniqueNumIng);
		
		while(left<right) {
			mixIng=uniqueNumIng[left]+uniqueNumIng[right];
			
			//mixIng이 필요량에 못미치면 left를 증가
			//mixIng이 필요량을 초과하면 result증가, right감소,
			if(mixIng<countRequireIng)left++;
			else if(mixIng>countRequireIng)right--;
			else {
				result++;
				left++;
				right--;
			}
			
		}
		System.out.println(result);
		
	}

}
