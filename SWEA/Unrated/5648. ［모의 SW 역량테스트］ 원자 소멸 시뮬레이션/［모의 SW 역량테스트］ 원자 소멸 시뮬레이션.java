
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//원소 클래스
class atom{
	public int x;
	public int y;
	public int dir;
	public int energy;
	
	atom(){};
	atom(int x,int y,int dir ,int energy){
		this.x=x;
		this.y=y;
		this.dir=dir;
		this.energy=energy;
	}
}
public class Solution {

	//DX,DY: 이동을 위한 배열 0:"상, 1:하, 2:좌, 3:우
	//size: grid의 크기 0.5초 충돌제어를 위한 좌표 2배
	static final int[] DX= {0,0,-1,1};
	static final int[] DY= {1,-1,0,0};
	static final int SIZE=4_001;
	
	//numAtom:원소의 개수
	//listAtom:원소의 정보를 담는 덱
	//grid: 월소의 개수를 저장한다
	//sumEnergy: 충돌시 방출하는 에너지의 합
	static int numAtom;
	static ArrayDeque<atom> dqAtom=new ArrayDeque<>();
	static int[][] grid=new int[SIZE][SIZE];
	static int sumEnergy; 
	static StringBuilder sb=new StringBuilder();
	
	//시뮬레이션 시작
	static void simulation(int cnt) {
		
		//덱에 값이없을때까지
		while(!dqAtom.isEmpty()) {
			atom cur=dqAtom.pollFirst();
			
			//원소하나만 있어야하는데 1이아니다.
			//다른 원소가 도착해서 1보다 커졌거나, 충돌해서 0이되었다.
			if(grid[cur.y][cur.x]!=1) {
				grid[cur.y][cur.x]=0;
				sumEnergy+=cur.energy;
				continue;
			}
			
			//현재원소의 정보 로드
			int dir=cur.dir;
			int nx=cur.x+DX[dir];
			int ny=cur.y+DY[dir];
			
			//범위 밖을 나감
			if(nx<0||ny<0||nx>=SIZE||ny>=SIZE) {
				grid[cur.y][cur.x]-=1;
				continue;
			}
			
			//지나간 좌표의 개수를줄이고
			//이동한 좌표의 개수를 늘린다.
			grid[cur.y][cur.x]-=1;
			grid[ny][nx]+=1;
			
			//이동을 한좌표를 다시 덱에 넣어준다.
			cur.y=ny;
			cur.x=nx;
			dqAtom.addLast(cur);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			
			numAtom=Integer.parseInt(br.readLine());
			
			for(int i=0;i<numAtom;i++)
			{
				st=new StringTokenizer(br.readLine());
				
				//x,y:원자의 위치 음수 경우를 제외하기위한 보정
				//dir: 이동방향 0:상, 1:하, 2:좌, 3:우
				//energy: 충돌시 방출하는 에너지 양
				int x=(Integer.parseInt(st.nextToken())+1000)<<1;
				int y=(Integer.parseInt(st.nextToken())+1000)<<1;
				int dir=Integer.parseInt(st.nextToken());
				int energy=Integer.parseInt(st.nextToken());
				
				dqAtom.add(new atom(x,y,dir,energy));
				grid[y][x]=1;
			}
			
			sumEnergy=0;
			simulation(0);
			sb.append("#").append(t).append(' ').append(sumEnergy).append('\n');
			
		}
		System.out.println(sb);
	}

}
