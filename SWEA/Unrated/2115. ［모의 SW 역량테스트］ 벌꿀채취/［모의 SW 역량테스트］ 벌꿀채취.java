import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] grid;
	static int[][] sumGrid;
	static int sizeHoney;
	static int cntHoney;
	static int maxHoney;
	static int max=0;
	static StringBuilder sb=new StringBuilder();
	
	static void cycleGird() {
		for(int i=0;i<sizeHoney;i++) {
			for(int j=0;j<=sizeHoney-cntHoney;j++) {
				maxRevenue(0,j,i,0,0);
			}
		}
	}
	
	static void maxRevenue(int cnt,int x,int y,int sum,int powSum) {
		//구역의 합이 maxHoney를 넘어서면 return
		if(sum>maxHoney)return;
		if(cnt==cntHoney) {
			if(sumGrid[y][x-cntHoney]<powSum)sumGrid[y][x-cntHoney]=powSum;
			return;
		}
		
		maxRevenue(cnt+1,x+1,y,sum+grid[y][x],powSum+grid[y][x]*grid[y][x]);
				
				//벌통을 안고를 경우
		maxRevenue(cnt+1,x+1,y,sum,powSum);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			st=new StringTokenizer(br.readLine());
			
			//sizeHoney=벌통 크기, cntHoney=벌통 개수, maxHoney=채취할 수 있는 꿀의 최대량
			sizeHoney=Integer.parseInt(st.nextToken());
			cntHoney=Integer.parseInt(st.nextToken());
			maxHoney=Integer.parseInt(st.nextToken());
			
			grid=new int[sizeHoney][sizeHoney];
			sumGrid=new int[sizeHoney][sizeHoney-cntHoney+1];
			for(int i=0;i<sizeHoney;i++)
			{
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<sizeHoney;j++)grid[i][j]=Integer.parseInt(st.nextToken());
			}
			
			cycleGird();
			int aBenefit=0;
			int bBenefit=0;
			int start=0;
			int sum=0;
			
			for(int i=0;i<sizeHoney;i++)
			{
				for(int j=0;j<=sizeHoney-cntHoney;j++)
				{
					aBenefit=sumGrid[i][j];
					bBenefit=0;
					for(int k=i;k<sizeHoney;k++) {
						start=(i==k)?j+cntHoney:0;
						for(int l=start;l<=sizeHoney-cntHoney;l++) {
							bBenefit=bBenefit<sumGrid[k][l]?sumGrid[k][l]:bBenefit;
						}
						sum=aBenefit+bBenefit;
						max=max>sum?max:sum;
					}
					
				}
			}
			sb.append("#"+t+" "+max+"\n");
			max=0;
			
//			for(int[] i: sumGrid) {
//				for(int j:i)System.out.printf("%d ",j);
//				System.out.println();
//			}
			
		}
		System.out.println(sb);
	}

}
