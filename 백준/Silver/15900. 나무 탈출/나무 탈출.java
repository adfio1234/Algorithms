
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	//tree를관리한다.
	static ArrayList<Integer>[] tree;
	static int moveLength=0;
	static boolean[] visited;
	
	static void countNode(int nodeIdx,int move) {
		
		visited[nodeIdx]=true;
		boolean isLeaf=true;
		//자식을 순회
		for(int i:tree[nodeIdx]) {
			if(visited[i])continue;
			isLeaf=false;
			countNode(i,move+1);
		}
		if(isLeaf)moveLength+=move;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		int aNode;
		int bNode;
		String result="Yes";
		
		//인접리스트 생성
		tree=new ArrayList[N+1];
		visited=new boolean[N+1];
		
		//노드입력
		for(int i=0;i<N-1;i++)
		{
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			aNode=Integer.parseInt(st.nextToken());
			bNode=Integer.parseInt(st.nextToken());
	
			if(tree[aNode]==null)tree[aNode]=new ArrayList<>();
			if(tree[bNode]==null)tree[bNode]=new ArrayList<>();
		
			tree[aNode].add(bNode);
			tree[bNode].add(aNode);
			
		}
		countNode(1,0);
		if(moveLength%2==0)result="No";
		System.out.println(result);
//		for(ArrayList<Integer> a:tree) {
//			if(a==null)continue;
//			for(int b:a)System.out.printf("%d ",b);
//			System.out.println();
//		}

	}
}
