
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	static class Node{
		
		private Map<String, Node> child=new TreeMap<>();
		private boolean isEnd;
		
		
		public void insert(String[] input) {
			Node cur=this;
			
			for(int i=0;i<input.length;i++) {
				String word=input[i];
				
				if(cur.child.get(word)==null)cur.child.put(word, new Node());
				
				cur=cur.child.get(word);
				cur.isEnd=true;
			}
		}
		
		public void search(Node next,int depth) {
			Node cur=next;
			
			for(String i:cur.child.keySet()) {
				for(int j=0;j<depth;j++)sb.append("--");
				sb.append(i);
				if(cur.child.get(i).isEnd)sb.append('\n');
				search(cur.child.get(i),depth+1);
			}
		}
	}
	
	static StringBuffer sb=new StringBuffer();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Node trie=new Node();
		
		
		int infoNum=Integer.parseInt(br.readLine());
		for(int i=0;i<infoNum;i++) {
			st=new StringTokenizer(br.readLine());
			int inputNum=Integer.parseInt(st.nextToken());
			
			String[] input=new String[inputNum];
			for(int j=0;j<inputNum;j++)input[j]=st.nextToken();
			trie.insert(input);
		}
		
		trie.search(trie,0);
		System.out.println(sb);
	}

}
