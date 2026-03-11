
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static class Node{
		
		Node[] child=new Node[10];
		private boolean isEnd;
		
		Node() {
			
		}
		
		public void insert(String word) {
			Node cur=this;
			
			for(int i=0;i<word.length();i++) {
				int num=word.charAt(i)-'0';
				
				if(cur.child[num]==null)cur.child[num]=new Node();
				cur=cur.child[num];
				
			}
			//단어의 끝을알려준다.
			cur.isEnd=true;
		}
		
		public boolean contains(String word) {
			Node cur=this;
			for(int i=0;i<word.length();i++) {
				int num=word.charAt(i)-'0';
				
				if(cur.isEnd)return false;
				if(cur.child[num]==null)return true;
				cur=cur.child[num];
			}
			
			 // 순회하면서 자식이 존재하면 현재 번호가 기존의 prefix라는뜻
		    for(Node next : cur.child){
		        if(next != null) return false;
		    }
			return true;
		}
	}
	
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		int TC=Integer.parseInt(br.readLine());
		inCase:for(int t=1;t<=TC;t++) {
			int phoneNum=Integer.parseInt(br.readLine());
			Node trie=new Node();
			
			for(int i=0;i<phoneNum;i++) {
				String input=br.readLine();
				
				if(!trie.contains(input)) {
					sb.append("NO").append('\n');
					for(int j=i+1;j<phoneNum;j++)br.readLine();
					continue inCase;
				}
				trie.insert(input);
			}
			sb.append("YES").append('\n');
			
		}
		System.out.print(sb);
	}

}
