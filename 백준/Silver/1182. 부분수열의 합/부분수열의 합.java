import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	static int[] manaStone;
	static int[] input;
	static int result=0;
	
	//부분집합의 개념을 이용해서 푼다.
	static void DFS(int idx,int stoneNum,int  curSum,int manaSum) {
		
		if(idx==stoneNum) {
			if(manaSum==curSum)result++;
			return;
		}
		
		
		int curMana=manaStone[idx];
		
		//선택하는 경우
		DFS(idx+1,stoneNum,curSum+curMana,manaSum);
		
		//선택 안하는 경우
		DFS(idx+1,stoneNum,curSum,manaSum);
		
	}
	
	public static void main(String[] args) throws IOException {
		//------여기에 솔루션 코드를 작성하세요.------------
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int stoneNum=Integer.parseInt(st.nextToken());
		int manaSum=Integer.parseInt(st.nextToken());
		
		manaStone=new int[stoneNum];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<stoneNum;i++)manaStone[i]=Integer.parseInt(st.nextToken());
		
		
		
		DFS(0,stoneNum,0,manaSum);
		
		//최소 1개는 고른다했으니까 목표 마나가 0이고 result가 1보다 높을떄
		//공집합을 처리해주기위해서 result를 1빼준다.
		if(result>0&&manaSum==0)result--;
		System.out.println(result);
	}
}