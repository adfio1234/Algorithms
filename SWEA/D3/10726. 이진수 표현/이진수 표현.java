
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++)
		{
			st=new StringTokenizer(br.readLine());
			
			//N: 마지막 비트수 N개
			//M: 정수
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			String result="ON";
			
			if(M%2==0)result="OFF";
			else {
				//(1<<N)-1 하고난 후의 정수
				int lastNBit=(1<<N)-1;
				
				//lastNBit의 값이 lastNBit&M과 달라지면 
				//M의 마지막N개의 비트 가 1이 아닌곳이 존재한다는걸 의미
				result=lastNBit==(lastNBit&M)?"ON":"OFF";
			}
			System.out.printf("#%d %s%n",t,result);
			
		}
	}

}
