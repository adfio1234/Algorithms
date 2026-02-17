import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static StringBuilder sb=new StringBuilder();
	
	//num을 2로 만드는 최소횟수를 구한다.
	static int minCount(long num) {
		
		int count=0;
		
		while(num!=2) {
			
			//sqrt부터 할수있으면 해준다.
			long tmp=(long)Math.sqrt(num);
			if((tmp*tmp)==num) {
				num=tmp;
				count++;
				continue;
			}
			
			//sqrt할 수 없으면 다음 제곱수까지 더해준다.
			long nextPow=(tmp+1)*(tmp+1);
			count+=nextPow-num;
			num=nextPow;
		}
		return count;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			
			long num=Long.parseLong(br.readLine());
			
			sb.append('#').append(t).append(' ').append(minCount(num)).append('\n');
			
		}
		System.out.println(sb);
	}

}
