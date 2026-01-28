import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
	
	static int size;//지도의 크기를 저장하기 위한 변수
	static final int INF=Integer.MAX_VALUE;//int형의 최대를 저장하는 전역상수
	static int[][] dist;
	static int[] dx= {-1,1,0,0};//상하좌우 이동을위한 int 배열
	static int[] dy= {0,0,-1,1};
	//다익스트라 구현을위한 우선순위 queue
	//거리기준으로 정렬하기위한 comparator람다식?
	static PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		int nx=0;//이동할 좌표를 저장하기위한 xy변수
		int ny=0;
		int updateWeight=0;//업데이트된 가중치를 저장할변수
		int result=0;//결과를 저장할 변수
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		//N번 돌기위한 for
		for(int execution=1;execution<=N;execution++)
		{
			size=Integer.parseInt(br.readLine());
			

			int[][] arrMap= new int[size][size];//size*size 크기의 지도 선언
			String strTmp;//String형 임시변수
			dist=new int[size][size];//size*size크기만큼 거리맵을만든다.
			
			//dist에 INF채우기
			for(int i=0;i<size;i++)
				for(int j=0;j<size;j++)
					dist[i][j]=INF;
			
			//시작위치는 0으로 초기화
			dist[0][0]=0;
			
			//우선순위에 시작지점 채우기(X,Y,Weight)형식
			pq.add(new int[]{0,0,0});
			//지도에 값채우기
			for(int i=0;i<size;i++)
			{
				strTmp=br.readLine();
				for(int j=0;j<size;j++)
				{
					arrMap[i][j]=strTmp.charAt(j)-'0';
				}
			}
			
			//다익스트라 시작
			while(!pq.isEmpty())
			{
				int[] cur=pq.poll();
				int curX=cur[0];
				int curY=cur[1];
				int curWeight=cur[2];
				
				//도착점 도착하면 break;
				if(curX==size-1&&curY==size-1) {
					result=curWeight;
					break;
				}
					
				//만약에 우선순위큐에서 뽑아온 가중치가 이미 업데이트된 dist배열의 크면 의미없어진다.
				if(dist[curY][curX]<curWeight)continue;
				
				//상하좌우 탐색을위한 for문
				for(int i=0;i<4;i++)
				{
					//이동할좌표변수
					nx=curX+dx[i];
					ny=curY+dy[i];
					
					//이동할 좌표가 이차원 배열의 범위안에있는지 검사
					//범위밖에있으면 continue
					if(nx<0||ny<0||nx>=size||ny>=size)continue;
					
					//다음 지점으로 이동할때 (다음지점의 가중치+현재지점의 가중치)
					updateWeight=curWeight+arrMap[ny][nx];
					
					//updateWeight 값이 dist[][]에 저장된값보다 크면 이미 더빠른 길이있다는 의미이므로 추적 포기
					if(dist[ny][nx]<=updateWeight)continue;
					
					//dist[][]값을 업데이트된 가중치로 변경
					dist[ny][nx]=updateWeight;
					//다시 pq에 저장한다.
					pq.add(new int[] {nx,ny,updateWeight});
					
					
				}
				
			}

			//pq에 초기화
			pq.clear();
			System.out.printf("#%d %d%n",execution,result);
			
			
		}
	}

}
//class방식

//arrMap을 확인용
//for(int[] arr:arrMap) {
//	for(int r:arr)
//	{
//		System.out.printf("%d ",r);
//	}
//	System.out.println();
//}