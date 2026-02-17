
import java.util.Scanner;

public class Solution {

	
	//numMountain: 산의 개수
	//heightMountain: 산의 높이배열
	static int numMountain;
	static int[] heightMountain;
	static StringBuilder sb=new StringBuilder();
	static int result=0;
	
	
	//우뚝 선 산의 갯수를 구한다.
	static void countStandingTall() {
		
		//우뚝 선 산 기준 왼쪽이 몇개인지 구한다.
		int left=0;
		
		for(int i=1;i<numMountain;i++) {
			
			//전의 산이 지금산보다 작다면 left++
			if(heightMountain[i-1]<heightMountain[i])left++;
			
			//전의 산 보다 현재산이 작으면 전의 산이 우뚝 선 산 후보
			else if(heightMountain[i-1]>heightMountain[i]) {
				
				//우뚝 선 산의 오른쪽이 몇개인지 구한다.
				int right=0;
				for(;i<numMountain;i++) {
					//현재의 산이 전의 산보다 작을때까지 right를 더한다.
					if(heightMountain[i-1]>heightMountain[i])right++;
					else if(heightMountain[i-1]<heightMountain[i]) {
						i--;
						break;						
					}
				}
				
				//결국 왼쪽에서 어디서 시작하냐 오른쪽에서 어디서 시작하냐의 문제이므로 left*right
				result+=left*right;
				left=0;
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int TC=sc.nextInt();
		for(int t=1;t<=TC;t++)
		{
			//산의 높이 채우기
			numMountain=sc.nextInt();
			heightMountain=new int [numMountain];
			for(int i=0;i<numMountain;i++)
			{
				heightMountain[i]=sc.nextInt();
			}
			
			countStandingTall();
			
			sb.append('#').append(t).append(' ').append(result).append('\n');
			result=0;
		}
		System.out.println(sb);
		
	}

}
