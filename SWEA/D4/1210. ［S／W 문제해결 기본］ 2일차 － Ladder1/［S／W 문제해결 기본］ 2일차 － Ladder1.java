import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static final int SIZE=100;
	static int[][] ladder=new int[SIZE][SIZE];
	
	static int searchStart(int goal) {
		int curY=SIZE-1;
		int curX=goal;
		
		//1.현재위치에서 오른쪽 사다리가있는지확인
		//2.현재위치에서 왼쪽사다리가 있는지확인
		//3.사다리없으면 위로 올라가기
		while(curY>0){
			if(curX+1<SIZE&&ladder[curY][curX+1]==1) {
				while(curX+1<SIZE&&ladder[curY][curX+1]==1)
				{
					ladder[curY][curX]=0;
					curX++;
				}
			}else if(curX-1>=0&&ladder[curY][curX-1]==1) {
				while(curX-1>=0&&ladder[curY][curX-1]==1)
				{
					ladder[curY][curX]=0;
					curX--;
				}

			}else if(ladder[curY-1][curX]==1) {
				ladder[curY][curX]=0;
				curY--;
			}
		}
		return curX;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		//testcase
		for(int t=1;t<=10;t++) {
			
			int num=Integer.parseInt(br.readLine());
			int goal=0;
			
			//배열초기화 및 goal설정
			for(int i=0;i<SIZE;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<SIZE;j++) {
					ladder[i][j]=Integer.parseInt(st.nextToken());
					if(i==SIZE-1&&ladder[i][j]==2)goal=j;
				}
			}
			System.out.printf("#%d %d%n",t,searchStart(goal));
			
			
		}
		
	}

}
