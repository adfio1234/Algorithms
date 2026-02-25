

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int num=0;
		for(int i=0;i<3;i++) {
			String input=br.readLine();
			if(input.charAt(0)>='0'&&input.charAt(0)<='9') {
				num=Integer.parseInt(input);
				num+=3-i;
			}
		}
		
		if(num%3==0&&num%5==0)System.out.println("FizzBuzz");
		else if(num%3==0)System.out.println("Fizz");
		else if(num%5==0)System.out.println("Buzz");
		else System.out.println(num);
	
	}

}
