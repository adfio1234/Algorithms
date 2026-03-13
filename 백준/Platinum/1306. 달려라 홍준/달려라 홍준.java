
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthToggleButtonUI;

public class Main {

	static int[] course;
	static int[] segmentTree;
	static StringBuilder sb=new StringBuilder();
	
	
	static int init(int start,int end,int idx) {
		if(start==end)return segmentTree[idx]=course[start];
		
		int mid=(start+end)/2;
		
		int left=init(start,mid,idx*2);
		int right=init(mid+1,end,idx*2+1);
		
		segmentTree[idx]=Math.max(left, right);
		return segmentTree[idx];
	}
	
	static int intervalBig(int start,int end,int idx,int left,int right) {
		if(start>right||left>end)return -1;
		
		if(left<=start&&end<=right)return segmentTree[idx];
		
		int mid=(start+end)/2;
		
		int leftPart=intervalBig(start, mid, idx*2, left, right);
		int rightPart=intervalBig(mid+1, end, idx*2+1, left, right);
		return Math.max(leftPart,rightPart);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int courseLen=Integer.parseInt(st.nextToken());
		int viewRange=Integer.parseInt(st.nextToken());
		
		course=new int[courseLen];
		segmentTree=new int[courseLen*4];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<courseLen;i++)course[i]=Integer.parseInt(st.nextToken());
		
		init(0,courseLen-1,1);
		
		for(int i=viewRange-1;i<=courseLen-viewRange;i++) {
			int range=(2*viewRange-1)/2;
			sb.append(intervalBig(0, courseLen-1, 1, i-range, i+range)).append(' ');
		}
		
		System.out.println(sb);
	}

}
