import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int stick=64;
		int cnt=0;
		
		int X=Integer.parseInt(br.readLine());
		if(X==stick)sb.append(1);
		else {
			while(X!=0) {
				if(stick>X) {
					stick=stick>>1;
				}else if(stick<X){
					X-=stick;
					cnt++;
				}else {
					sb.append(cnt+1);
					break;
				}
			}
		}
		System.out.println(sb);
		
	}

}
