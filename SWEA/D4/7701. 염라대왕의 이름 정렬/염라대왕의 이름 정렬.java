
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

class Name implements Comparable<Name>{
	
	public String name;
	public int len;
	
	Name(String name){
		this.name=name;
		this.len=name.length();
	}

	@Override
	public int compareTo(Name o) {
		if(this.len!=o.len)return this.len-o.len;
		
		return this.name.compareTo(o.name);
	}
	
}

public class Solution {

	static StringBuilder sb=new StringBuilder();
	static int size;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			
			Set<Name> set=new TreeSet<>();
			//이름의 개수
			int numName=Integer.parseInt(br.readLine());
			for(int i=0;i<numName;i++) {
				String input=br.readLine();
				set.add(new Name(input));
			}
			
			sb.append('#').append(t).append('\n');
			for(Name i:set)sb.append(i.name).append('\n');
			set.clear();
		}
		System.out.println(sb);
	}

}
