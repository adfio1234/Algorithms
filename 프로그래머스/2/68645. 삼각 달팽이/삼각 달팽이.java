class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        int x=0;
		int y=-1;
		int content=1;
		
		//배열생성
		int[][] snail=new int[n][];
		for(int i=0;i<n;i++)snail[i]=new int [i+1];
		
		//달팽이 채우기
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				
				if(i%3==0)//아래로 내리는 경우
				{
					y+=1;
				}else if(i%3==1) {//오른쪽으로 가는 경우
					x+=1;
				}else {// 왼쪽 대각선으로 올라가는 경우
					y-=1;
					x-=1;
				}
				snail[y][x]=content++;
			}
			
		}
		
		
//		for(int[] i:snail) {
//			System.out.println(Arrays.toString(i));
//		}
		answer= new int[content-1];
        int idx=0;
		for(int[] i:snail) {
			for(int j:i)answer[idx++]=j;
		}
        return answer;
    }
}