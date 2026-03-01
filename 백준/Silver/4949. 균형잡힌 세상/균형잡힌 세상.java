
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	static StringBuilder sb= new StringBuilder();
	
	static void isBalance(String str) {
		ArrayDeque<Character> stack=new ArrayDeque<>();
		
		for(int i=0;i<str.length();i++) {
			char element=str.charAt(i);
			
			if(element!='['&&element!=']'&&element!='('&&element!=')')continue;
			if(element=='('||element=='[')stack.addLast(element);
			else if(element==')'||element==']') {
				if(stack.isEmpty()) {
					sb.append("no");
					return;
				}
				char stackTop=stack.pollLast();
				if(element==')'&&stackTop!='(') {
					sb.append("no");
					return;
				}
				else if(element==']'&&stackTop!='[') {
					sb.append("no");
					return;
				}
			}
		}
		if(!stack.isEmpty()) {
			sb.append("no");
			return;
		}
		sb.append("yes");
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str=br.readLine();
			if(str.equals("."))break;
			
			isBalance(str);
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
