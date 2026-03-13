
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Node{
		
		private Node[] child=new Node[26];
		private boolean isEnd;
		
		public void insert(String word) {
			Node cur=this;
			
			for(int i=0;i<word.length();i++) {
				int letter=word.charAt(i)-'a';
				
				if(cur.child[letter]==null)cur.child[letter]=new Node();
				
				cur=cur.child[letter];
			}
			cur.isEnd=true;
		}
		
		public boolean contains(String word) {
			Node cur=this;
			
			for(int i=0;i<word.length();i++) {
				int letter=word.charAt(i)-'a';
				
				if(cur.child[letter]==null)return false;
				//if(i==word.length()-1&&!cur.isEnd)return false;
				cur=cur.child[letter];
			}
			if(cur.isEnd)return true;
			return false;
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int setNum=Integer.parseInt(st.nextToken());
		int inputNum=Integer.parseInt(st.nextToken());
		int result=0;
		
		Node trie=new Node();
		
		for(int i=0;i<setNum;i++) {
			String input=br.readLine();
			trie.insert(input);
		}
		
		for(int i=0;i<inputNum;i++) {
			String input=br.readLine();
			if(trie.contains(input))result++;
		}
		System.out.println(result);
	}

}
