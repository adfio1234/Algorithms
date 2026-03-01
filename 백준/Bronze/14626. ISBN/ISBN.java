import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final int ISBN_LEN=13;
	
	static int findCheckSum(int sum,int checkSum,int verification) {
		for(int i=0;i<=9;i++) {
			int sumCopy=sum+verification;
			
			if(checkSum%2!=0)sumCopy+=(i*3);
			else sumCopy+=i;
			
			if(sumCopy%10==0)return i;
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String ISBN=br.readLine();
		
		//*의 위치를 찾아준다.
		int checkSum=ISBN.indexOf('*');
		int sum=0;
		for(int i=0;i<ISBN_LEN-1;i++) {
			if(i==checkSum)continue;
			
			int num=ISBN.charAt(i)-'0';
			if(i%2==0)sum+=num;
			else if(i%2!=0)sum+=(num*3);
		}
		
		int result=findCheckSum(sum,checkSum,ISBN.charAt(ISBN_LEN-1)-'0');
		System.out.println(result);
	}

}
