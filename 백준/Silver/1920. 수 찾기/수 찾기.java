
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;



public class Main {
	static StringBuilder sb=new StringBuilder();
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int size=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		HashMap<Integer, Boolean> hm=new HashMap<>();
		
		for(int i=0;i<size;i++) {
			hm.put(Integer.parseInt(st.nextToken()),true);
		}
		
		
	
		int m=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<m;i++) {
			int tmp=Integer.parseInt(st.nextToken());
			if(!hm.containsKey(tmp)) {
				sb.append(0).append('\n');
				continue;
			}
			sb.append(1).append('\n');
		}
		System.out.println(sb);
	}

}
