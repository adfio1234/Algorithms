
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//원자 클래스
class Atom implements Comparable<Atom>{
	
	public int x;
	public int y;
	public int dir;
	public int energy;
	
	Atom(int x,int y, int dir, int energy){
		this.x=x;
		this.y=y;
		this.dir=dir;
		this.energy=energy;
	}

	@Override
	public int compareTo(Atom o) {
		if(this.x!=o.x)return this.x-o.x;
		return this.y-o.y;
	}
}




public class Solution {

	static final int INF=Integer.MAX_VALUE;
	
	//atomList: 원소 배열
	//numAtom: 원소의 갯수
	//sumEnergy: 방출된 에너지의 합
	//dq: 충돌예상 원소들의 리스트 (원소1,원소2,충돌시간)
	static Atom[] atomList;
	static int numAtom;
	static int sumEnergy=0;
	static ArrayList<int[]> dq;
	static StringBuilder sb=new StringBuilder();
	
	//충돌예상 원소들끼리 충돌시간을 저장한다.
	static void makePair() {
		dq=new ArrayList<>();
		Arrays.sort(atomList);
		
		for(int i=0;i<numAtom;i++)
		{
			for(int j=i+1;j<numAtom;j++) {
				
				Atom first=atomList[i];
				Atom second=atomList[j];
				
				//위아래로 부딫치는 경우
				if(first.x==second.x) {
					if(first.dir==0&&second.dir==1)
						dq.add(new int[] {i,j,Math.abs(first.y-second.y)/2});
				}
				
				//같은 y좌표에서 좌우로 부딫치는 경우
				if(first.y==second.y) {
					if(first.dir==3&&second.dir==2)
						dq.add(new int[] {i,j,Math.abs(first.x-second.x)/2});
				}
				
				// \대각선 방향
				if((first.x+first.y)==(second.x+second.y)) {
					if(first.dir==3&&second.dir==0||first.dir==1&&second.dir==2)
						dq.add(new int[] {i,j,Math.abs(atomList[i].y-atomList[j].y)});
				}
				
				// /대각선 방향
				if((first.x-first.y)==(second.x-second.y)) {
					if(first.dir==0&&second.dir==2||first.dir==3&&second.dir==1)
						dq.add(new int[] {i,j,Math.abs(atomList[i].y-atomList[j].y)});
				}
			}
		}
		
	}
	
	//충돌시간이 같은 원소들끼리 이미 터졌으면 continue 안터졌으면 에너지를 계산한다.
	static void crashAtom() {
		
		//충돌시간 적은것부터 정렬
		Collections.sort(dq,(a,b)-> a[2]<=b[2]?-1:1);
		
		//충돌시간을 무한대로 초기화
		int[] crashTime=new int[numAtom];
		Arrays.fill(crashTime, INF);
		
		for(int[] pair:dq) {
			int first=pair[0];
			int second=pair[1];
			int crash=pair[2];
			
			//이미 전에 충돌한 원소면 continue
			if(crashTime[first]<crash||crashTime[second]<crash)continue;
			
			//아직 충돌전이라면 바꿔준다.
			if(crashTime[first]==INF) {
				crashTime[first]=crash;
				sumEnergy+=atomList[first].energy;
			}
			
			//아직 충돌전이라면 바꿔준다.
			if(crashTime[second]==INF) {
				crashTime[second]=crash;
				sumEnergy+=atomList[second].energy;
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;t++) {
			
			numAtom=Integer.parseInt(br.readLine());
			atomList=new Atom[numAtom];
			for(int i=0;i<numAtom;i++) {
				
				st=new StringTokenizer(br.readLine());
				
				//x,y= 좌표
				//dir: 방향 0:상, 1: 하 , 2: 좌, 3:우 
				//energy:충돌시 방출하는 에너지
				int x=Integer.parseInt(st.nextToken())*2;
				int y=Integer.parseInt(st.nextToken())*2;
				int dir=Integer.parseInt(st.nextToken());
				int energy=Integer.parseInt(st.nextToken());
				
				atomList[i]=new Atom(x,y,dir,energy);
			}
			
			makePair();
			crashAtom();
			sb.append('#').append(t).append(' ').append(sumEnergy).append('\n');
			sumEnergy=0;
		}
		System.out.println(sb);
	}

}
