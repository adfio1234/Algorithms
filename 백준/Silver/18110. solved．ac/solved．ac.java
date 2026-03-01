
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static final int TRUNCATED=15;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int reviewNum=Integer.parseInt(br.readLine());
		int score=0;
		
		
		if(reviewNum!=0) {
			int[] review=new int[reviewNum];
			
			for(int i=0;i<reviewNum;i++)review[i]=Integer.parseInt(br.readLine());
			
			Arrays.sort(review);
			
			//round 절사평균 몇명인지 구한다.
			int exception=((reviewNum*TRUNCATED)+100/2)/100;
			
			for(int i=exception;i<reviewNum-exception;i++)score+=review[i];
			reviewNum-=exception*2;
			//반올림 (x+y/2)/y
			score=(score+(reviewNum)/2)/reviewNum;
		}	
		System.out.println(score);
	
	}

}
