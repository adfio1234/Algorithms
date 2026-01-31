import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Parameter Insert
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		String parentStr;//input string parameter
		String result="YES";//yes or no for result parameter
		Stack<Character> stack=new Stack<>();
		char stringElement;
		
		//reapt for testcase
		for(int execution=0;execution<T;execution++)
		{
			parentStr=br.readLine();
			
			//read parentStr elements
			for(int i=0;i<parentStr.length();i++)
			{
				//save String Elements to parameter
				stringElement=parentStr.charAt(i);
				//if: parameter equal '(', parameter push to stack
				//else: parameter equal ')' parameter pop to stack of top
				if(stringElement=='(')stack.add(stringElement);
				else {
					if(stack.isEmpty()) {
						result="NO";
						break;
					}
					else stack.pop();
				}
			}
			if(!stack.isEmpty())result="NO";
			
			System.out.println(result);
			result="YES";
			stack.clear();
		}
	}

}
