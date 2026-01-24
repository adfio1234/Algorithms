

import java.util.Scanner;

public class Solution {
	//18이하의 소수 배열
	static int[] notPrime= {0,1,4,6,8,9,10,12,14,15,16,18};
	static double[] probablityOfLocation= {1,18,3060,18564,43758,48620,43758,18564,3060,816,153,1};
	public static double probablity(int success) {
		//각각의 성공확률과 실패확률 저장하는 변수
		double successProbablity=success/100.0;
		double failureProbablity=1-successProbablity;
		
		double total=0;
		double sum=1;
		
		for(int i=0;i<notPrime.length;i++) {
			//성공확률 n
			for(int j=0;j<notPrime[i];j++)
			{
				sum*=successProbablity;
			}
			//실패확률 n-1
			for(int j=0;j<18-notPrime[i];j++)
			{
				sum*=failureProbablity;
			}
			//자리배치하는 경우의 수 곱해준다.
			sum*=probablityOfLocation[i];
			total+=sum;
			sum=1;
		}
		return total;
	};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int r=1;r<=t;r++)
		{
			double result=1;
			int skillOfMasterA=sc.nextInt();
			int skillOfMasterB=sc.nextInt();
			//성공률 0%나 100%일떄는 어처피 소수가 안나와서 예외처리
			if(skillOfMasterA!=100&&skillOfMasterA!=0)
			{
				result*=probablity(skillOfMasterA);
				//System.out.println(probablity(skillOfMasterA));
			}
			if(skillOfMasterB!=100&&skillOfMasterB!=0)
			{
				result*=probablity(skillOfMasterB);
				//System.out.println(probablity(skillOfMasterB));
			}
			System.out.printf("#%d %.6f%n",r,1-result);
			
		}
	}

}
