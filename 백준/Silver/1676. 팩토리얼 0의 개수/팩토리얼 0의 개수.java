import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int count=0;
		
		int num=Integer.parseInt(br.readLine());
		while(num>=5) {
			count+=num/5;
			num/=5;
		}
		System.out.println(count);
	}

}
