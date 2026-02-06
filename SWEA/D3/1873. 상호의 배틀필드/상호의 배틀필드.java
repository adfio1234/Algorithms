
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	//맵 상태 변수
	static int height;
	static int width;
	static char[][] grid;
	
	//tank 상태 변수
	static int tankX;
	static int tankY;
	static char tankDir;
	
	
	//tank 회전
	//현재 방향과 다를때
	static void rotate(char dir) {
		if(dir==tankDir)return;
		
		if(dir=='U')tankDir='^';		
		else if(dir=='D')tankDir='v';
		else if(dir=='L')tankDir='<';
		else if(dir=='R')tankDir='>';
	}
	
	//tank이동
	static void move(char dir) {
		grid[tankY][tankX]='.';
		if(dir=='U') {
			if(tankY-1>=0&&grid[tankY-1][tankX]=='.')grid[--tankY][tankX]='^';
			else grid[tankY][tankX]='^';
		}else if(dir=='D') {
			if(tankY+1<height&&grid[tankY+1][tankX]=='.')grid[++tankY][tankX]='v';
			else grid[tankY][tankX]='v';
		}else if(dir=='L') {
			if(tankX-1>=0&&grid[tankY][tankX-1]=='.')grid[tankY][--tankX]='<';
			else grid[tankY][tankX]='<';
		}else if(dir=='R') {
			if(tankX+1<width&&grid[tankY][tankX+1]=='.')grid[tankY][++tankX]='>';
			else grid[tankY][tankX]='>';
		}
	}
	
	//발사 로직
	//하나로 합칠수도있다
	static void shoot() {
		
		int dir=0;
		if(tankDir=='<'||tankDir=='>') {
			if(tankDir=='<')dir=-1;
			else dir=1;
			int bulletX=tankX+dir;
			
			while(0<=bulletX&&bulletX<width) {
				if(grid[tankY][bulletX]=='*') {
					grid[tankY][bulletX]='.';
					break;
				}else if(grid[tankY][bulletX]=='#')break;
				bulletX+=dir;
			}

		}else if(tankDir=='^'||tankDir=='v') {
			if(tankDir=='^')dir=-1;
			else dir=1;
			int bulletY=tankY+dir;
			
			while(0<=bulletY&&bulletY<height) {
				if(grid[bulletY][tankX]=='*') {
					grid[bulletY][tankX]='.';
					break;
				}else if(grid[bulletY][tankX]=='#')break;
				bulletY+=dir;
			}
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		
		//입력
		for(int t=1;t<=TC;t++)
		{
			st=new StringTokenizer(br.readLine());
			height=Integer.parseInt(st.nextToken());
			width=Integer.parseInt(st.nextToken());
			
			grid=new char[height][width];
			
			//grid정보 입력
			String tmp;
			for(int i=0;i<height;i++)
			{
				tmp=br.readLine();
				for(int j=0;j<width;j++) {
					grid[i][j]=tmp.charAt(j);
					
					if(grid[i][j]=='^') {
						tankX=j;
						tankY=i;
						tankDir='^';
					}else if(grid[i][j]=='v') {
						tankX=j;
						tankY=i;
						tankDir='v';
					}else if(grid[i][j]=='<') {
						tankX=j;
						tankY=i;
						tankDir='<';
					}else if(grid[i][j]=='>') {
						tankX=j;
						tankY=i;
						tankDir='>';
					}
					
				}
				
			}
			
			//command 입력
			int numCommand=Integer.parseInt(br.readLine());
			String command=br.readLine();
			
			for(int i=0;i<command.length();i++) {
	
				//명령 분류
				switch(command.charAt(i)) {
					case 'U':
						rotate('U');
						move('U');
						break;
					case 'D':
						rotate('D');
						move('D');
						break;					
					case 'L':
						rotate('L');
						move('L');
						break;
					case 'R':
						rotate('R');
						move('R');
						break;
					case 'S':
						shoot();
						break;		
				}
				
			}
			System.out.printf("#%d ",t);
			for(char[] i:grid) {
				for(char j:i)System.out.printf("%s",j);
				System.out.println();
			}
		}
		
	}

}
