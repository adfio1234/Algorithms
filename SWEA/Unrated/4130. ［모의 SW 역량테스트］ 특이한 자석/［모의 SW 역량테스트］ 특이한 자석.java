import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static final int COUNT_MAGNET=8;
	static final int NUM_MAGNET=4;
	static final int[] SCORE= {1,2,4,8};
	static ArrayDeque<Integer>[] magnet = new ArrayDeque[NUM_MAGNET];
	
	
	//idxMagnet의 왼쪽 자성 판별
	static int searchLeft(int idxMagnet) {
		int tmp=magnet[idxMagnet].pollLast();
		int left=magnet[idxMagnet].peekLast();
		magnet[idxMagnet].add(tmp);
		return left;
	}
	
	//idxMagnet의 오른쪽 자성 판별
	static int searchRight(int idxMagnet) {
		int tmp=magnet[idxMagnet].poll();
		int tmp1=magnet[idxMagnet].poll();
		int right=magnet[idxMagnet].peekFirst();
		magnet[idxMagnet].addFirst(tmp1);
		magnet[idxMagnet].addFirst(tmp);
		return right;
	}
	
	//i==1 시계방향, i==-1 반시계
	//시계방향: 뒤에서 앞으로 삽입
	//반시계 : 앞에서 뒤로 삽입
	static void clockWiseRotate(int i,int idxMagnet) {
		int tmp=0;
		if(i==1) {
			tmp=magnet[idxMagnet].pollLast();
			magnet[idxMagnet].addFirst(tmp);
		}else if (i==-1) {
			tmp=magnet[idxMagnet].poll();
			magnet[idxMagnet].add(tmp);
		}
	}
	
	//idxMagnet기준으로 오른쪽 왼쪽 기어가 돌수있는지 확인
	static void rotate(int idxMagnet,int rotationDir,Boolean dir) {
		//rotationDir==1시계방향 -1반시계방향
		int left=idxMagnet-1;
		int right=idxMagnet+1;
		
		if(dir==null)
		{
			if(left>=0&&searchLeft(idxMagnet)!=searchRight(left))
				rotate(left,rotationDir*-1,true);
				
			if(right<NUM_MAGNET&&searchRight(idxMagnet)!=searchLeft(right))
				rotate(right,rotationDir*-1,false);
			
		}else if(left>=0&&dir&&(searchLeft(idxMagnet)!=searchRight(left))){
			rotate(left,rotationDir*-1,true);

		}else if(right<NUM_MAGNET&&!dir&&(searchRight(idxMagnet)!=searchLeft(right))) {
			rotate(right,rotationDir*-1,false);
		}
		clockWiseRotate(rotationDir,idxMagnet);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++)
		{
			int result=0;
			int K=Integer.parseInt(br.readLine());
			
			//자석의 자성
			//S:1 N:0
			for(int i=0;i<NUM_MAGNET;i++) {
				st=new StringTokenizer(br.readLine());
				magnet[i]=new ArrayDeque<>();
				for(int j=0;j<COUNT_MAGNET;j++)magnet[i].add(Integer.parseInt(st.nextToken()));
			}
			
			//회전
			for(int i=0;i<K;i++)
			{
				st=new StringTokenizer(br.readLine());

				int idxMagnet=Integer.parseInt(st.nextToken())-1;
				int rotationDir=Integer.parseInt(st.nextToken());
				
				rotate(idxMagnet,rotationDir,null);
				
				
			}
			//점수 판정
			for(int j=0;j<NUM_MAGNET;j++) {
				if(magnet[j].peekFirst()==1)result+=Math.pow(2, j);
			}
			System.out.printf("#%d %d%n",t,result);
			
		}
	}

}
