
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static public ArrayList<double []> starList=new ArrayList<>();
	
	static double getDistance(int idx,int target) {
		double[] start=starList.get(idx);
		double[] end=starList.get(target);
		double nx=Math.abs(start[0]-end[0]);
		double ny=Math.abs(start[1]-end[1]);
		
		return Math.sqrt(nx*nx+ny*ny);
	}
	
	static double prim(int size) {
		boolean[] visited=new boolean[size];
		
		PriorityQueue<double []>pq=new PriorityQueue<>((a,b)->Double.compare(a[1], b[1]));
		 pq.add(new double[] {0.0,0.0});
		 
		 double zodiac=0;
		 int connected=0;
		 
		 while(!pq.isEmpty()) {
			 double[] cur= pq.poll();
			 int idx=(int)cur[0];
			 
			 double weight=cur[1];
			 
			 if(visited[idx])continue;
			 
			 visited[idx]=true;
			 connected++;
			 zodiac+=weight;
			 
			 if(connected==size)break;
			 
			 for(int i=0;i<size;i++) {
				 if(i==idx)continue;
				 if(visited[i])continue;
				 pq.add(new double[] {i,getDistance(idx, i)});
			 }
		 }
		 
		 return zodiac;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int starNum=Integer.parseInt(br.readLine());
		
		for(int i=0;i<starNum;i++) {
			st=new StringTokenizer(br.readLine());
			double x=Double.parseDouble(st.nextToken());
			double y=Double.parseDouble(st.nextToken());
			starList.add(new double[] {x,y});
		}
		
		System.out.printf("%.2f",prim(starNum));
	}

}
