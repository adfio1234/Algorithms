
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class List{
	
	private static final int DEFAULT_SIZE=10;
	private int size;
	
	int[] arr;
	
	//기본생성자
	public List() {
		this.size=0;
		this.arr=new int[DEFAULT_SIZE];
	}
	
	//동적할당
	private void resize() {
		int capacity=arr.length;
		
		//빈 배열일떄
		if(this.size==0) {
			arr=new int[DEFAULT_SIZE];
			return;
		}
		
		//용량이 최대일떄
		if(this.size==capacity) {
			int addCapacity=capacity*2;
			
			//용량을 2배늘려준다.
			arr=Arrays.copyOf(arr, addCapacity);
			return;
		}
		
		//용량을 적게 차지할떄
		if(this.size<(capacity/2)) {
			int lessCapacity=capacity/2;
			
			arr=Arrays.copyOf(arr, Math.max(lessCapacity, DEFAULT_SIZE));
			return;
		}
	}
	
	//값더하기
	public boolean add(int value) {
		//꽉찼을때
		if(size==arr.length) {
			resize();
		}
		arr[size++]=value;
		return true;
	}
	
	//포함유무
//	public boolean contain(int value) {
//		
//		for(int i=0;i<size;i++) {
//			if(arr[i]==value)return true;
//		}
//		return false;
//	}
	
	//인덱스 기반 값반환
	public int get(int idx) {
		if(idx<0||idx>=size)return -1;
		
		return arr[idx];
	}
	
	//길이반환
	public int getSize() {
		return size;
	}
	
}
public class Solution {

	static List[] BadCompatibility;
	static StringBuilder sb=new StringBuilder();
	
	//공집합을 고려한 1로 초기화
	static int countBurger=1;
	static int availableIngredients;
	static boolean[] visited;
	
	//햄버거 조합
	static void makeBurger(int limit,int cnt,int idx,boolean[] visited) {
		
		//escape조건
		if(cnt==limit) {
			countBurger+=1;
			return;
		}
		
		for(int i=idx;i<=availableIngredients;i++) {
			if(visited[i])continue;
			
			boolean[] newVisited=visited.clone();
			newVisited[i]=true;
			for(int j=0;j<BadCompatibility[i].getSize();j++) {
				int bad=BadCompatibility[i].get(j);
				newVisited[bad]=true;
			}

			makeBurger(limit,cnt+1,i+1,newVisited);
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;t++)
		{
			st=new StringTokenizer(br.readLine());
			
			//availableIngredients: 사용가능한 재료의 수
			//countBadCompatibility: 나쁜 재료 궁합수
			availableIngredients=Integer.parseInt(st.nextToken());
			int countBadCompatibility=Integer.parseInt(st.nextToken());
			
			//재료의 상성을 저장하는 List
			BadCompatibility=new List[availableIngredients+1];

			visited=new boolean[availableIngredients+1];
			
			for(int i=0;i<=availableIngredients;i++)
			{
				BadCompatibility[i]=new List();
			}
			
			for(int i=0;i<countBadCompatibility;i++) {
				
				st=new StringTokenizer(br.readLine());
				
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				
				//순서쌍을 만든다.
				BadCompatibility[a].add(b);
				BadCompatibility[b].add(a);
			}
			//들어가는 재료수마다 조합 탐색
			for(int i=1;i<=availableIngredients;i++)
			{
				makeBurger(i,0,1,visited);
			}
			
			sb.append("#"+t+" "+countBurger+"\n");
			countBurger=1;
		}
		System.out.println(sb);
	
	}

}
