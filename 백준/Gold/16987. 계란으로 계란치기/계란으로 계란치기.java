
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int MIN=Integer.MIN_VALUE;
	
	//numEgg: 계란 갯수
	//egg: 계란의 정보배열 0:내구도, 1:무게
	static int numEgg;
	static int[][] egg;
	static int crashedMax=MIN;
	
	static void crashEgg(int idx,int cnt) {

		boolean isHit=false;
		
		
		//지금 쥔 계란이깨졌으면, 다음계란으로 옮겨간다.
		
		//맨오른쪽 계란을 쥔경우
		if(numEgg==idx) {
			if(crashedMax<cnt) {
				crashedMax=cnt;
			}
			return;
		}

		if(egg[idx][0]<=0) {
			crashEgg(idx+1,cnt);
			return;
		}
		
	
			
		
		for(int i=0;i<numEgg;i++)
		{
			//동일계란이거나 이미 부숴진지 체크
			if(idx==i||egg[i][0]<=0)continue;
			
			isHit=true;
			int tmp=0;
			egg[idx][0]-=egg[i][1];
			egg[i][0]-=egg[idx][1];
			
			//상대가 깨졌는지 확인
			if(egg[idx][0]<=0)tmp+=1;
			if(egg[i][0]<=0)tmp+=1;
			
			crashEgg(idx+1,cnt+tmp);
			
			egg[idx][0]+=egg[i][1];
			egg[i][0]+=egg[idx][1];
			
		}
		if(!isHit)crashEgg(idx+1,cnt);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		numEgg=Integer.parseInt(br.readLine());
		
		egg=new int[numEgg][2];
		for(int i=0;i<numEgg;i++)
		{
			st=new StringTokenizer(br.readLine());
			int defence=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			egg[i][0]=defence;
			egg[i][1]=weight;
		}
		
		crashEgg(0,0);
		System.out.println(crashedMax);
	}

}
