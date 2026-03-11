
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static class Node{
		Map<Character,Node> child=new HashMap<>();
		boolean isEnd;
		
		Node(){
		}
		
		public void insert(String word) {
			Node cur=this;
			for(int i=0;i<word.length();i++) {
				char letter=word.charAt(i);
				
				//해당 글자가 없으면 추가 
				if(!cur.child.containsKey(letter))cur.child.put(letter, new Node());
				
				//다음 자식으로 내려간다.
				cur=cur.child.get(letter);
			}
		}
		
		public boolean contains(String word) {
			Node cur=this;
			
			for(int i=0;i<word.length();i++) {
				char letter=word.charAt(i);
				
				//key를 가지고 있지않으면 false리턴
				if(!cur.child.containsKey(letter))return false;
				cur=cur.child.get(letter);
			}
			return true;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int includeNum=Integer.parseInt(st.nextToken());
		int searchNum=Integer.parseInt(st.nextToken());
		int count=0;
		Node trie=new Node();
		
		for(int i=0;i<includeNum;i++) {
			String input=br.readLine();
			trie.insert(input);
		}
		
		for(int i=0;i<searchNum;i++) {
			String input=br.readLine();
			if(trie.contains(input))count++;
		}
		System.out.print(count);
	}

}
