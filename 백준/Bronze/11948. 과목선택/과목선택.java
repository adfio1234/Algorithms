
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int[] subject=new int[4];
		int max=-1;
		int total=0;
		for(int i=0;i<4;i++) {
			subject[i]=Integer.parseInt(br.readLine());
			total+=subject[i];
		}
		
		for(int i=0;i<2;i++) {
			int tmp=Integer.parseInt(br.readLine());
			for(int j:subject) {
				max=max>tmp+(total-j)?max:tmp+(total-j);
			}
		}
		System.out.println(max);
	}

}
