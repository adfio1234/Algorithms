import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static final int MAX=Integer.MAX_VALUE;
	
	static int heightShelf;
	static int[] employee;
	static int numEmployee;
	static int minDiff=MAX;
	static StringBuilder sb=new StringBuilder();
	
	static void bestHeight(int idx,int height){
		
		if(idx==numEmployee) {
			int diff=height-heightShelf;
			//점원의 탑이 선반의 높이보다 작으면 return
			if(height<heightShelf)return;
			
			//최솟값찾기
			if(minDiff>diff) {
				minDiff=diff;
			}
			return;
		}
		
		//해당 점원을 선택했을떄
		bestHeight(idx+1,height+employee[idx]);
		//해당 점원을 선택하지않았을때
		bestHeight(idx+1,height);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			
			
			st=new StringTokenizer(br.readLine());
			numEmployee=Integer.parseInt(st.nextToken());
			employee=new int[numEmployee];
			heightShelf=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<numEmployee;i++)employee[i]=Integer.parseInt(st.nextToken());
			
			bestHeight(0,0);
			sb.append('#').append(t).append(' ').append(minDiff).append('\n');
			minDiff=MAX;
		}
		System.out.println(sb);
		
	}

}
