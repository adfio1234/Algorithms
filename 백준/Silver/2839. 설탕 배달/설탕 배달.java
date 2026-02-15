
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final int BIG_BAG=5;
	static final int SMALL_BAG=3;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int sugarWeight=Integer.parseInt(br.readLine());
		int result=0;
		
		while(sugarWeight>0) {
			
			//5로 나누어떨어질때까지 3을 뺀다.
			if(sugarWeight%BIG_BAG==0) {
				result+=sugarWeight/BIG_BAG;
				sugarWeight/=BIG_BAG;
				break;
			}
			sugarWeight-=SMALL_BAG;
			result+=1;
		}
		
		//만약 정확한 무게를 달 수 없으면 3을계속빼기때문에 sugarWeight는 음수
		if(sugarWeight>=0)System.out.println(result);
		else System.out.println(-1);
		
	}

}
