import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//과제는 가장최근에 나온순서대로, 또한 과제를 받으면 바로시작
		//과제를 하던도중 새로운 과제가 나오면 , 하던과제 중단하고 새로운 과제를 진행한다.
		//새로운 과제가 끝났다면, 이전에 하던 과제를 이전에 하던 부분부터 이어서한다.
		//변수선언
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N=Integer.parseInt(br.readLine());
		int isHomeWork=0;//과제가 나왔는지 유무
		int perfectScore=0;//과제의 만점
		int workedMin=0;//과제의 걸리는시간
		int scoreTotal=0;//총 받은점수
		int tmpArr[];
		ArrayDeque<int[]> dq=new ArrayDeque<>();
		for(int t=0;t<N;t++)
		{
			st=new StringTokenizer(br.readLine());
			
			isHomeWork=Integer.parseInt(st.nextToken());
			if(isHomeWork==1)//과제가 나왔을시
			{
				perfectScore=Integer.parseInt(st.nextToken());
				workedMin=Integer.parseInt(st.nextToken());
				workedMin--;
				if(workedMin<=0) {//만약 1분걸리는 과제라면 받은시점에 1분이지나므로 완료
					scoreTotal+=perfectScore;
					continue;
				}
				 dq.add(new int[] {perfectScore,workedMin});//덱에 만점점수와 작업시간을 push한다.	
			}else {//과제가 나오지 않았을시
				if(dq.isEmpty())continue;//과제 없는 사람이오면 그냥 보낸다
				tmpArr=dq.pollLast();//dq에 맨뒤에값을 뽑아온다.
				tmpArr[1]--;//1분일을 했다는 의미
				if(tmpArr[1]<=0)scoreTotal+=tmpArr[0];//일이 끝났다면 점수를 총합에 더한다.
				else dq.add(tmpArr);//일이 끝나지않았다면 다시 dq 
			}

			
		}
		System.out.println(scoreTotal);
	}

}
