import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int cinemaY=Integer.parseInt(st.nextToken());
		int cinemaX=Integer.parseInt(st.nextToken());
		int gallery=Integer.parseInt(st.nextToken());
		int sum=0;
		int result=0;
		
		if(cinemaX<gallery)
		{
			System.out.println(0);
			return;
		}
		int[][] cinema=new int[cinemaY][cinemaX];
		
		String tmp;
		for(int i=0;i<cinemaY;i++)
		{
			tmp=br.readLine();
			for(int j=0;j<cinemaX;j++)
				cinema[i][j]=tmp.charAt(j)-'0';
		}
		
		
		for(int i=0;i<cinemaY;i++) {
			int left=0;
			int right=gallery-1;
			
			for(int j=0;j<gallery;j++)sum+=cinema[i][j];
			
			if(sum==0)result++;
			
			//right가 끝에 닿을떄까지
			//window를 sliding
			while(right<cinemaX-1) {
				sum-=cinema[i][left++];
				sum+=cinema[i][++right];
				
				if(sum==0)result++;
			}
			sum=0;
		}
		System.out.println(result);
	}
	

}
