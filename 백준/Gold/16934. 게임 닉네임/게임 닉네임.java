

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static class Node{
		
		private Node[] child=new Node[26];
		private boolean isEnd;
		private int duplicateNum;
		
		Node(){
			duplicateNum=0;
		}
		
		public void insert(String name) {
			Node cur=this;
			boolean finish=true;
			
			for(int i=0;i<name.length();i++) {
				int letter=name.charAt(i)-'a';
			
				if(finish)sb.append(name.charAt(i));
				if(cur.child[letter]==null) {
					cur.child[letter]=new Node();
					finish=false;
				}
				cur=cur.child[letter];
			}
			cur.duplicateNum++;
			if(cur.duplicateNum>1)sb.append(cur.duplicateNum);
			sb.append('\n');
			cur.isEnd=true;
		}
	}
	
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int nickNum=Integer.parseInt(br.readLine());
		
		Node trie=new Node();
		for(int i=0;i<nickNum;i++) {
			String nickName=br.readLine();
			trie.insert(nickName);
		}
		System.out.println(sb);
	}

}
