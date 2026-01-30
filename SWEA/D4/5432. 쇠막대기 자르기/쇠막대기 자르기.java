import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int countIronStick(String str) {
		//변수선언
		int sum=0;
		int cnt=0;//(의 개수를 추적한다.
		char prev=')';//i-1의 elements를 저장
		
		for(int i=0;i<str.length();i++)//str의 길이만큼 순회
		{
			if(str.charAt(i)=='('){//(를 만나면 cnt를 증가
				cnt++;
				prev='(';
			}else if(str.charAt(i)==')') {//)를만나면 
				cnt--;//pop
				if(prev==')')sum+=1;//이전에도 )였다면 하나의 막대가 끝났다고 생각해서 1을증가시킨다
				else if(prev=='(')sum+=cnt;//이전이(였다면 막대의 중간에서 잘랐으므로 (의 개수인 cnt만큼 더해준다(반으로자른거의 왼쪽부분의 개수를더한다.)
				prev=')';
			}
			//System.out.printf("%d :%d %d%n",i+1,cnt,sum);
			
		}
		return sum;
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		//쇠막대기와 레이저의 배치
		String laser;
		int result=0;
		for(int excution=1;excution<=T;excution++)
		{
			laser=br.readLine();
			
			System.out.printf("#%d %d%n",excution,countIronStick(laser));
		}
	}

}
