

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static class Node{
		
		private Node[] child=new Node[26];
		private int include=0;
		boolean isEnd;
		
		Node(){
			
		}
		
		//소문자만 입력이므로 배열을사용한다.
		//해당글자가 있다고 include를 1더해준다.
		public void insert(String input) {
			Node cur=this;
			int isNew=0;
			for(int i=0;i<input.length();i++) {
				int letter=input.charAt(i)-'a';
				
				//새로운 단어가 삽입될때만 include를 증가시킨다.
				if(cur.child[letter]==null) {

					cur.child[letter]=new Node();
					cur.include++;
				}
				
				cur=cur.child[letter];

			}
			cur.isEnd=true;
		}
		
		public int autoInsert(String input) {
			Node cur=this;
			int cnt=0;
			for(int i=0;i<input.length();i++) {
				int letter=input.charAt(i)-'a';
				
				if(i==0||cur.include>1||cur.isEnd)cnt++;
				
				cur=cur.child[letter];
			}
			return cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while((line=br.readLine())!=null) {
			
			int textNum=Integer.parseInt(line);
			
			String[] inputList=new String[textNum];
			Node trie=new Node();
			
			double total=0;
			
			for(int i=0;i<textNum;i++) {
				String input=br.readLine();
				inputList[i]=input;
				trie.insert(input);
			}
			for(String s:inputList)total+=trie.autoInsert(s);

			System.out.printf("%.2f\n",total/textNum);
			
		}
	}

}
