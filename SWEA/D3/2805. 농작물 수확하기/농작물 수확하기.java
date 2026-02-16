
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	
	//size:농장의 크기
	//farm: 농장
	static int size;
	static int[][] farm;
	static StringBuilder sb=new StringBuilder();
	
	//농장의 누적합을 만든다.
	static void makePrefixFarm() {
		
		for(int i=0;i<size;i++)
		{
			for(int j=1;j<=size;j++)farm[i][j]+=farm[i][j-1];
		}

	}
	
	//수익을 구한다
	static void findRevenue() {
		
		int revenue=0;
		int half=size/2;
		
		
		//절반까지의 수익을더한다
		for(int i=0;i<=half;i++) {
			
			revenue+=(farm[i][half+i+1]-farm[i][half-i]);
		}
		//나머지 절반의 수익을 더해준다.
		for(int i=1;i<=half;i++) {
			revenue+=(farm[i+half][size-i]-farm[i+half][i]);
		}
		sb.append(revenue).append('\n');
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			
			size=Integer.parseInt(br.readLine());
			
			//배열 생성
			farm=new int[size][size+1];

			//농장 채우기
			String tmp;
			for(int i=0;i<size;i++) {
				tmp=br.readLine();
				for(int j=0;j<size;j++)farm[i][j+1]=tmp.charAt(j)-'0';
			}
			
			sb.append('#').append(t).append(' ');
			makePrefixFarm();
			findRevenue();
		}
		System.out.println(sb);
	}

}
//for(int[] i:farm) {
//	for(int j:i)System.out.printf("%d ",j);
//	System.out.println();
//}
