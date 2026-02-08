import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	//cntCage: 햄스터 우리 개수
	//maxHamster: 우리당 햄스터 마리 수 0<=햄스터<=maxHamster
	//cntRecord: 기록의 개수
	static int cntCage;
	static int maxHamster;
	static int cntRecord;
	static boolean isPossible=false;
	static StringBuilder sb=new StringBuilder();
	static int bestSum=0;
	
	//record: 기록저장용 배열
	//numHamster: 우리마다 들어간 햄스터수
	static int[][] record;
	static int[] numHamster;
	static int[] resultHamster;
	
	
	
	//지금 우리에있는 hamster가 record와 맞는지 비교
	static boolean isSpillOut() {
		int sum=0;
		for(int i=0;i<cntRecord;i++)
		{
			for(int j=record[i][0];j<=record[i][1];j++) {
				sum+=numHamster[j];
				if(sum>record[i][2])return false;
			}
			sum=0;
		}
		return true;
	}
	
	//우리에 들어있는 총 햄스터의 마리수 계산
	static int sumHamster(int x,int y,int[] arr) {
		int sum=0;
		for(int i=x;i<=y;i++)sum+=arr[i];
		return sum;
	}
	
	//우리에 햄스터 채우는 완전탐색
	static void hamster(int cnt,int sum) {
		
		//지금 우리에있는 hamster가 record와 맞는지 비교
		if(!isSpillOut())return;
		
		//모든 케이지를 보았을떄
		if(cnt==cntCage) {
			for(int i=0;i<cntRecord;i++) {
				if(record[i][2]!=sumHamster(record[i][0],record[i][1],numHamster))return;
			}
			isPossible=true;
			
			//현재 조건에 맞게 채워진 결과 햄스터값보다 더 좋은값이 나오면 바꾸기
			if(sumHamster(0,cntCage-1,numHamster)>=bestSum ){
				int tmp=0;
				for(int i=0;i<cntCage;i++) {
					tmp+=numHamster[i];
					resultHamster[i]=numHamster[i];
				}
				bestSum=tmp;
			}
			return;
		}
		
		
		//최대 햄스터마리수에서 0마리까지 각 케이스에 있다고 가정
		for(int i=maxHamster;i>=0;i--) {
			numHamster[cnt]=i;
			hamster(cnt+1,sum+i);
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;t++) {
			
			st=new StringTokenizer(br.readLine());
			
			//cntCage: 햄스터 우리 개수
			//maxHamster: 우리당 햄스터 마리 수 0<=햄스터<=maxHamster
			//cntRecord: 기록의 개수
			cntCage=Integer.parseInt(st.nextToken());
			maxHamster=Integer.parseInt(st.nextToken());
			cntRecord=Integer.parseInt(st.nextToken());
			
			record=new int[cntRecord][3];
			numHamster=new int[cntCage];
			resultHamster=new int[cntCage];
			
			for(int i=0;i<cntRecord;i++) {
				st=new StringTokenizer(br.readLine());
				
				//첫번째 우리
				//마지막 우리
				//start와 end사이의 hamster수
				record[i][0]=Integer.parseInt(st.nextToken())-1;
				record[i][1]=Integer.parseInt(st.nextToken())-1;
				record[i][2]=Integer.parseInt(st.nextToken());
				
			}
			hamster(0,0);
			
			sb.append("#"+t);
			if(!isPossible)sb.append(" -1\n");
			else {
				for(int i=0;i<cntCage;i++)sb.append(" "+resultHamster[i]);
				sb.append("\n");
			}
			isPossible=false;
            bestSum=0;
		}
		System.out.println(sb);
	}

}
