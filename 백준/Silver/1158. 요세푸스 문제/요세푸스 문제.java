import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//변수선언부
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		ArrayDeque<Integer> dq=new ArrayDeque<>();//dq을 사용해서 순열을 구현한다.
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int cnt=0;//K의 회수를 추적하는 변수
		int elements;//pop한 값을 저장하는 변수
		int[] result=new int[N];//결과를 저장하는 배열
		int idx=0;//result의 인덱스를 관리하는 변수

		//dq에 값을 푸쉬
		for(int i=1;i<=N;i++) {
			dq.add(i);
		}
		
		//dq에 값이 없을때까지
		while(!dq.isEmpty()) {
			elements=dq.poll();//elements에 dq의 앞에서 꺼낸값을 저장
			if(cnt==K-1) {//cnt가 K번째이면 result에저장하고 dq에 elements를 push하지않는다
				result[idx++]=elements;
				cnt++;
			}else {//cnt가 K번쨰가 아니라면 dq에 elements를 push
				cnt++;
				dq.add(elements);
			}
			cnt%=K;//cnt의 범위를 0~K-1까지 하기위한 코드 
		}
		
		//출력
		System.out.print("<");
		for(int i=0;i<result.length;i++)
		{
			if(i==result.length-1) {
				System.out.print(result[i]);
				break;
			}
			System.out.printf("%d, ",result[i]);
		}
		System.out.print(">");
	}

}
