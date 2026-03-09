
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static StringBuilder sb=new StringBuilder();
	
	//초기화 함수
	static int[] makeSet(int num) {
		int[] set=new int[num];
		for(int i=0;i<num;i++)set[i]=i;
		return set;
	}
	
	//집합을 합친다. true: 대포가 같다= 무리가 줄어들지않는다.
	//false: 대표가 다르다 = 무리가 줄어든다.
	static boolean unionSet(int[] set,int element1,int element2) {
		int parent1=findSet(set,element1);
		int parent2=findSet(set,element2);
		
		if(parent1==parent2)return true;
		set[parent1]=parent2;
		return false;
	}
	
	//부모를 찾아준다.
	static int findSet(int[] set,int element) {
		if(element==set[element])return element;
		else return set[element]=findSet(set,set[element]);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			st=new StringTokenizer(br.readLine());
			
			int numHuman=Integer.parseInt(st.nextToken());
			int numRelative=Integer.parseInt(st.nextToken());
			int total=numHuman;
			
			int[] set=makeSet(numHuman);
			
			for(int i=0;i<numRelative;i++) {
				st=new StringTokenizer(br.readLine());
				
				int element1=Integer.parseInt(st.nextToken())-1;
				int element2=Integer.parseInt(st.nextToken())-1;
			
				if(!unionSet(set,element1,element2))total-=1;
			}
			
			sb.append('#').append(t).append(' ').append(total).append('\n');
		}
		System.out.println(sb);
	
	}

}
