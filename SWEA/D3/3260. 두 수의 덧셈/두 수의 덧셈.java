import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	//입력받은 String을 int로 변환하여 stack에 삽입하는 함수
	static Stack<Integer> pushConvertStringtoIntQueue(String s)
	{
		if(s.length()<=0)return null;
		Stack<Integer> tmp=new Stack<>();
		for(int i=0;i<s.length();i++)
		{
			tmp.add(s.charAt(i)-'0');
		}
		return tmp;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//1.stack에 A,B를 각각 푸쉬한다.
		//2.A+B를 계산해서 stack에 쌓는다
		//3.stack에서 꺼낸다.
		
		//입력선언부
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//Stack
		Stack<Integer> aStack;
		Stack<Integer> bStack;
		Stack<Integer> result=new Stack<>();
		
		String A,B;
		int ceil=0;//올림을 위한 변수
		int AB=0;//AB의 합을 저장
		int T=Integer.parseInt(br.readLine());
		
		//testCase순회
		for(int execution=1;execution<=T;execution++)
		{
			st=new StringTokenizer(br.readLine());
			
			A=st.nextToken();
			B=st.nextToken();
			//1
			aStack=pushConvertStringtoIntQueue(A);
			bStack=pushConvertStringtoIntQueue(B);
			
			//2
			while(!(aStack.isEmpty()||bStack.isEmpty())){
				AB=aStack.pop()+bStack.pop()+ceil;
				ceil=0;
				if(AB>=10)//AB의 합이 10보다크면 ceil로 값을 다음 자릿수에 1더해준다.
				{
					ceil++;
					AB-=10;
				}
				
				result.add(AB);

			}
			//stack에 남은값빼기
			while(!aStack.isEmpty()) {
				AB=aStack.pop()+ceil;
				ceil=0;
				if(AB>=10) {
					ceil=1;
					AB-=10;
				}
				result.add(AB);
			}
			while(!bStack.isEmpty()) {
				AB=bStack.pop()+ceil;
				ceil=0;
				if(AB>=10) {
					ceil=1;
					AB-=10;
				}
				result.add(AB);
			}
			//ceil남았으면 더해주기 10+90
			if(ceil!=0)result.add(ceil);
			System.out.printf("#%d ",execution);
			while(!result.isEmpty())System.out.print(result.pop());
			System.out.println();
			
			result.clear();
			aStack.clear();
			bStack.clear();
			AB=0;
		}
		
	}

}
