
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	//NUM_OF_TICKET:티켓의 개수
	//YEAR: 1년의 개월수
	//DAILY: 일별가 격의 인덱스
	//MONTHLY: 달별 가격의 인덱스
	//MONTHLY_THREE: 3달 가격의 인덱스
	//YEARLY: 연별의 가격 인덱스
	//MAX: 최대값
	static final int NUM_OF_TICKET=4;
	static final int YEAR=12;
	static final int DAILY=0;
	static final int MONTHLY=1;
	static final int MONTHLY_THREE=2;
	static final int YEARLY=3;
	static final int MAX=Integer.MAX_VALUE;
	
	//priceTicket:티켓 가격표 1일권,1달권,3달권,1년권
	//planOfYear: 1년 동안의 달마다의 수영장 방문 횟수
	//MinPrice: 최솟값 1년 이용권 가격으로 초기화
	static int[] priceTicket=new int[NUM_OF_TICKET];
	static int[] planOfYear=new int[YEAR];
	static int minPrice;
	static StringBuilder sb=new StringBuilder();
	
	
	//구독권 종류별로 가격을계산한다.
	static void subscribe(int month,int sum) {
		
		//가지치기
		//달을 다안채웠는데 이미 가격이 최소를 넘으면 
		if(sum>=minPrice)return;
		
		//1년을 다봤으면
		if(month>=12) {
			if(minPrice>sum) {
				minPrice=sum;
			}
			return;
		}
		
		//1일권으로 하는 경우
		subscribe(month+1,sum+(planOfYear[month]*priceTicket[DAILY]));
		
		//1달권으로 하는 경우
		subscribe(month+1,sum+priceTicket[MONTHLY]);
		
		//3달권으로 하는 경우
		subscribe(month+3,sum+priceTicket[MONTHLY_THREE]);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;t++)
		{
			//이용권가격
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<NUM_OF_TICKET;i++)priceTicket[i]=Integer.parseInt(st.nextToken());
			
			//1년 이용계획
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<YEAR;i++) {
				planOfYear[i]=Integer.parseInt(st.nextToken());
			}
			
			minPrice=priceTicket[YEARLY];
			subscribe(0,0);
			sb.append('#').append(t).append(' ').append(minPrice).append('\n');
		}
		System.out.println(sb);
		
		
	}

}
