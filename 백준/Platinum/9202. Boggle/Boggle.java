

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	static class Node{
		
		private Node[] child=new Node[26];
		private boolean isEnd;
		private String data;
		private int len=0;
		private int childNum=0;
		private boolean found;
		public void insert(String word) {
			Node cur=this;
			int cnt=1;
			for(int i=0;i<word.length();i++) {
				int letter=word.charAt(i)-'A';
				
				if(cur.child[letter]==null) {
					cur.child[letter]=new Node();
					cur.childNum++;
				}
				
				cur=cur.child[letter];
				cur.len=cnt++;
			}
			cur.isEnd=true;
			cur.data=word;
		}
		
		public void contains(Node cur,int y,int x) {
			
			if(cur.isEnd&&!cur.found) {
				cur.found=true;
				foundList.add(cur);
				score+=SCORE[cur.len];
				count++;
				
				if(cur.len>maxLen) {
					maxLen=cur.len;
					maxWord=cur.data;
				}else if(cur.len==maxLen) {
					if(cur.data.compareTo(maxWord)<0)
					{
						maxWord=cur.data;
					}
				}
			}
			if(cur.len==8)return;
			if(cur.childNum==0)return;
			visited[y][x]=true;
			
			for(int i=0;i<8;i++) {
				int nx=x+DX[i];
				int ny=y+DY[i];
				
				if(nx<0||ny<0||nx>=BOGGLE_SIZE||ny>=BOGGLE_SIZE)continue;
				if(visited[ny][nx])continue;
				
				int next=boggle[ny][nx]-'A';
				if(cur.child[next]==null)continue;
				
				contains(cur.child[next],ny,nx);
			}
			visited[y][x]=false;
		}
		
	}
	
	
	static final int BOGGLE_SIZE=4;
	static final int[] DX= {-1,0,1,-1,1,-1,0,1};
	static final int[] DY={-1,-1,-1,0,0,1,1,1};
	static final int[] SCORE= {0,0,0,1,1,2,3,5,11};
	
	//시작점을 저장해둔다.
	static Set<Character> startPoint=new HashSet<>();
	static Node trie=new Node();
	static char[][] boggle;
	static StringBuilder sb=new StringBuilder();
	static boolean[][] visited;
	static int score;
	static int count;
	static int maxLen;
	static String maxWord;
	static List<Node> foundList;
	//static Set<Node> include=new HashSet<>();
	
	static void maxScore() {
		score=0;
		count=0;
		maxLen=0;
		maxWord="";
		for(int i=0;i<BOGGLE_SIZE;i++) {
			for(int j=0;j<BOGGLE_SIZE;j++) {
				int idx=boggle[i][j]-'A';
				if(trie.child[idx]==null)continue;
				trie.contains(trie.child[idx], i, j);
			}
		}
		for(Node i:foundList)i.found=false;
		sb.append(score).append(' ').append(maxWord).append(' ').append(count).append('\n');
		
	}
	
//	static void longestSentence() {
//		int cnt=include.size();
//		
//		int total=0;
//		int maxLen=0;
//		String max="";
//		for(Node n:include) {
//			if(n.len>maxLen) {
//				maxLen=n.len;
//				max=n.data;
//			}
//			if(n.len==maxLen) {
//				if(n.data.compareTo(max)<0) {
//					max=n.data;
//				}
//			}
//			total+=SCORE[n.len];
//		}
//		
//		sb.append(total).append(' ').append(max).append(' ').append(cnt).append('\n');
//	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int wordNum=Integer.parseInt(br.readLine());
		
		for(int i=0;i<wordNum;i++)
		{
			String input=br.readLine();
			trie.insert(input);
		}
		
		br.readLine();
		
		int boardNum=Integer.parseInt(br.readLine());
		for(int i=0;i<boardNum;i++) {
			
			boggle=new char[BOGGLE_SIZE][BOGGLE_SIZE];
			visited=new boolean[BOGGLE_SIZE][BOGGLE_SIZE];
			foundList=new ArrayList<>();
			for(int j=0;j<BOGGLE_SIZE;j++)
			{
				String input=br.readLine();
				for(int k=0;k<BOGGLE_SIZE;k++)boggle[j][k]=input.charAt(k);

			}
			
			maxScore();
			if(i!=boardNum-1)br.readLine();
		}
		System.out.println(sb);
		
		
	}

}
