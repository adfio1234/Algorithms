import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		
		HashSet<String> set=new HashSet<>();
		
		set.add("0123");
		set.add("0145");
		set.add("0246");
		set.add("1357");
		set.add("2367");
		set.add("4567");
		
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++)
		{
			StringBuilder sb1=new StringBuilder();
			int[] arr=new int[4];
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++)arr[j]=Integer.parseInt(st.nextToken());
			
			Arrays.sort(arr);
			for(int j=0;j<4;j++)sb1.append(arr[j]);
			if(set.contains(sb1.toString()))sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.println(sb);
		
		
	}

}
