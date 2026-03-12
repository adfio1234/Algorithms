
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static class Node{
		
		private Node[] child=new Node[26];
		private boolean isEnd;
		
		Node() {
			
		}
		
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
				
				cur=cur.child[letter];
				if(cur.isEnd) {
					if(Name.contains(word.substring(i+1))) {
						return true;
						
					}
				}
			}
			return false;
		}
	}
	
	static StringBuilder sb=new StringBuilder();
	static HashSet<String> Name=new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int colorNum=Integer.parseInt(st.nextToken());
		int nickName=Integer.parseInt(st.nextToken());
		
		Node trieColor=new Node();
		
		
		for(int i=0;i<colorNum;i++) {
			String input=br.readLine();
			trieColor.insert(input);
		}
		for(int i=0;i<nickName;i++) {
			String input=br.readLine();
			Name.add(input);
		}
		
		int teamNum=Integer.parseInt(br.readLine());
		for(int i=0;i<teamNum;i++) {
			String input=br.readLine();
			
			if(!trieColor.contains(input))
			{
				sb.append("No").append('\n');
				continue;
			}

			
			
			sb.append("Yes").append('\n');
		}
		System.out.println(sb);
	}

}
