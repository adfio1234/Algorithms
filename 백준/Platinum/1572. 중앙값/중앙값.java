

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MAX=65_535;
	
	static int[] tempList;
 	static int[] segmentTree;
	
 	static void update(int start,int end,int idx,int target,int value) {
 		if(target<start||end<target)return;
 		
 		segmentTree[idx]+=value;
 		
 		if(start==end)return;
 		
 		int mid=(start+end)/2;
 		
 		update(start,mid,idx*2,target,value);
 		update(mid+1,end,idx*2+1,target,value);

 	}
 	static int midTemp(int start,int end,int idx,int median) {
 		if(start==end) return start;
 		
 		int mid=(start+end)/2;
 		
 		if(segmentTree[idx*2]>=median) {
 			return midTemp(start,mid,idx*2,median);
 		}else return midTemp(mid+1,end,idx*2+1,median-segmentTree[idx*2]);
 	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int tempNum=Integer.parseInt(st.nextToken());
		int startSec=Integer.parseInt(st.nextToken())-1;
		
		tempList=new int[tempNum];
		segmentTree=new int[(MAX+1)*4];
		
		for(int i=0;i<tempNum;i++) {
			tempList[i]=Integer.parseInt(br.readLine());
		}
		
		
		long sum=0;
		
		for(int i=0;i<tempNum;i++) {
			update(0,MAX,1,tempList[i],1);
			if(i>=startSec) {
				int meadian= midTemp(0,MAX,1,(startSec+2)/2);
				sum+=meadian;
				update(0,MAX,1,tempList[i-startSec],-1);
			}
		}
		System.out.println(sum);
	}

}
