
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static StringBuilder sb=new StringBuilder();;
	
	static int[] makeSet(int num) {
		int[] set=new int[num];
		for(int i=0;i<num;i++)set[i]=i;
		return set;
	}
	
	static void unionSet(int[] set,int element1,int element2) {
		int parent1=findSet(set,element1);
		int parent2=findSet(set,element2);
		if(parent1==parent2)return;
		set[parent1]=parent2;
	
	}
	
	
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
			
			sb.append('#').append(t).append(' ');
			
			//setNum:집합의 개수
			//calNum:연산의 개수
			int setNum=Integer.parseInt(st.nextToken());
			int calNum=Integer.parseInt(st.nextToken());
			
			int[] set=makeSet(setNum);
			
			for(int i=0;i<calNum;i++) {
				st=new StringTokenizer(br.readLine());

				//command: 0: union 1: 포함되어있는지확인
				int command=Integer.parseInt(st.nextToken());
				int set1=Integer.parseInt(st.nextToken())-1;
				int set2=Integer.parseInt(st.nextToken())-1;
				
				if(command==0)unionSet(set,set1,set2);
				else if(command==1) {
					if(findSet(set,set1)==findSet(set,set2))sb.append(1);
					else sb.append(0);
				}
				
			}			
			sb.append('\n');
		}
		System.out.println(sb);
		
	}

}
