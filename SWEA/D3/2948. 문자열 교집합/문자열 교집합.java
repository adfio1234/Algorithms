
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Solution {

	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			
			Set<String> set1=new HashSet<>();
			Set<String> set2=new HashSet<>();
			
			st=new StringTokenizer(br.readLine());
			int first=Integer.parseInt(st.nextToken());
			int second=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<first;i++) {
				String input=st.nextToken();
				set1.add(input);
			}
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<second;i++) {
				String input=st.nextToken();
				set2.add(input);
			}
			set1.retainAll(set2);
			sb.append('#').append(t).append(' ').append(set1.size()).append('\n');
			set1.clear(); 
			set2.clear(); 
		}
		System.out.println(sb);
	}

}
