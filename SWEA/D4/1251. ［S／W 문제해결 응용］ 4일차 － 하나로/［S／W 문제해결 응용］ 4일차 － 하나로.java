
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;



class Edge implements Comparable<Edge>{
	public int start;
	public int end;
	public double weight;
	
	Edge(int start,int end,double weight){
		this.start=start;
		this.end=end;
		this.weight=weight;
	}

	@Override
	public int compareTo(Edge o) {
		return Double.compare(this.weight, o.weight);
	}
	
}
public class Solution {

	static double environmentalFee;
	static StringBuilder sb=new StringBuilder();
	static ArrayList<int[]> point;
	static Edge[] list;
	static int[] set;
	
	static void makeEdge() {
		int idx=0;
		
		//각 섬끼리의 가중치를 계산한다.
		for(int i=0;i<point.size();i++)
		{
			int[] cur=point.get(i);
			int curX=cur[0];
			int curY=cur[1];
			
			for(int j=i+1;j<point.size();j++) {
				int[] next=point.get(j);
				int nextX=next[0];
				int nextY=next[1];
				double nx=curX-nextX;
				double ny=curY-nextY;
				double weight=calFee(nx*nx+ny*ny);
				//간선 추가
				list[idx++]=new Edge(i,j,weight);
			}
		}
	}
	
	
	//환경 부담금을 계산한다.
	static double calFee(double distance) {
		return distance*environmentalFee;
	}
	
	static int[] makeSet(int size) {
		int[] set=new int[size];
		for(int i=0;i<size;i++)set[i]=i;
		return set;
	}
	
	static boolean unionSet(int start,int end) {
		int parent1=findSet(start);
		int parent2=findSet(end);
		
		if(parent1==parent2)return false;
		set[parent1]=parent2;
		return true;
	}
	
	static int findSet(int element) {
		if(element==set[element])return element;
		else return set[element]=findSet(set[element]);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1;
		StringTokenizer st2;
		
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			
			point=new ArrayList<>();
			
			int landNum=Integer.parseInt(br.readLine());
			int edgeNum=(landNum-1)*landNum/2;
			
			set=new int[landNum];
			list=new Edge[edgeNum];
			//st1, st2-> x,y 좌표
			st1=new StringTokenizer(br.readLine());
			st2=new StringTokenizer(br.readLine());
			
			//섬의 좌표를 채워주기
			for(int i=0;i<landNum;i++) {
				int x=Integer.parseInt(st1.nextToken());
				int y=Integer.parseInt(st2.nextToken());
				
				point.add(new int[] {x,y});
				
			}
			environmentalFee=Double.parseDouble(br.readLine());
			
			//각 섬을 잇는 간선을 만든다.
			makeEdge();
			
			//자기자신을 부모로하는 배열을 만든다.
			set=makeSet(landNum);
			
			//가중치 기준 오름차순
			Arrays.sort(list);
			
			int connect=0;
			double fee=0;
			int cnt=0;
			while(connect!=landNum-1) {
				Edge cur=list[cnt++];
				
				if(unionSet(cur.start,cur.end)) {
					fee+=cur.weight;
					connect++;
				}
			}
			
			sb.append('#').append(t).append(' ').append(Math.round(fee)).append('\n');
			
		}
		System.out.println(sb);
	}

}
