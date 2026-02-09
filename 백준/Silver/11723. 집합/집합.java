import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int set=0;
	static StringBuilder sb=new StringBuilder();
	
	//command를 실행하는 메서드
	static void operateCommand(String command,int x) {
		if(command.equals("add"))add(x);
		else if(command.equals("remove"))remove(x);
		else if(command.equals("check"))check(x);
		else if(command.equals("toggle"))toggle(x);
		else if(command.equals("all"))all();
		else if(command.equals("empty"))empty();
	}
	
	//x를 추가하는 메서드
	static void add(int x) {
		set=set|1<<(x-1);
	}
	
	//x를 제거하는 메서드
	static void remove(int x) {
		set=set&~(1<<(x-1));
	}
	
	//x가 존재하는지 확인 하는 메서드
	static void check(int x) {
		if((1<<(x-1))==(1<<(x-1)&set)) {
			sb.append(1+"\n");
		}else sb.append(0+"\n");
	}
	
	//x가 존재하면 제거, x가없으면 add
	static void toggle(int x) {
		if(1<<(x-1)==(1<<(x-1)&set)) {
			remove(x);
		}else add(x);
	}
	
	//1000일떄 -1을해주면
	//111로 바뀐다
	static void all() {
		set=set|(1<<20)-1;
	}
	
	//공집합으로 변환한다.
	static void empty() {
		set=0;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int numCommand=Integer.parseInt(br.readLine());
		int x=0;
		for(int i=0;i<numCommand;i++) {
			st=new StringTokenizer(br.readLine());
			
			//all, empty를 위한 if
			String command=st.nextToken();
			if(st.hasMoreTokens())x=Integer.parseInt(st.nextToken());
			
			operateCommand(command,x);
		}
		System.out.println(sb);
	}

}
