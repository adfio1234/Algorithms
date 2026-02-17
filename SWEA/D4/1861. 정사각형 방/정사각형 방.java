
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	//DX,DY: 상하좌우 이동을 위한 배열
	//MAX: 정수 최댓값
	//MIN: 정수 최솟값
	static final int[] DX= {0,0,-1,1};
	static final int[] DY= {-1,1,0,0};
	static final int MAX=Integer.MAX_VALUE;
	static final int MIN=MAX+1;
	
	//size: 방의 길이
	//room: 방의 정보
	//maxLen: 방을 최대 이동거리
	//maxRoomNum: 최대이동할 수 있는 방의 번호
	static int size;
	static int[][] room;
	static int maxDistance=MIN;
	static int maxRoomNum=MAX;
	static StringBuilder sb=new StringBuilder();
	
	static boolean dfs(int x,int y,int distance,int startRoomNum) {
		int roomNum=room[y][x];
		for(int i=0;i<4;i++) {
			int nx=x+DX[i];
			int ny=y+DY[i];
			
			//범위 체크
			if(nx<0||ny<0||nx>=size||ny>=size)continue;
			
			//방번호가 1클때
			if(room[ny][nx]==(roomNum+1))
			{
				if(dfs(nx,ny,distance+1,startRoomNum))return true;
			}
		}
		
		//더이상 이동이 불가능할때 이동거리비교
		if(maxDistance<distance) {
			maxDistance=distance;
			maxRoomNum=startRoomNum;
		}
		//이동거리가 같으면 방번호가 더 적은쪽선택
		else if(maxDistance==distance) 
			maxRoomNum=maxRoomNum>startRoomNum?startRoomNum:maxRoomNum;
			
		
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			
			size=Integer.parseInt(br.readLine());
			room=new int[size][size];
			for(int i=0;i<size;i++)
			{
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<size;j++)room[i][j]=Integer.parseInt(st.nextToken());
			}
			
			maxDistance=MIN;
			maxRoomNum=MAX;
			//각 방마다 이동거리 측정
			for(int i=0;i<size;i++)
			{
				for(int j=0;j<size;j++) {
					dfs(j,i,1,room[i][j]);
				}
			}
			
			sb.append('#').append(t).append(' ').append(maxRoomNum)
						  .append(' ').append(maxDistance).append('\n');
		}
		System.out.println(sb);
		
	}

}
