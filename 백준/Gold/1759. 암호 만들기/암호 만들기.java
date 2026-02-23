
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	//pwdLen: 암호의 길이
	//numAlphabet: 알파벳의 개수
	//candiate: 암호에 있을거라 생각하는 알파벳후보
	static int pwdLen;
	static int numAlphabet;
	static char[] candiate;
	static char[] input;
	static StringBuilder sb=new StringBuilder();
	
	//암호 후보군을 만드는 함수
	static void makePwd(int cnt,int len,int vowel,int consonant) {
		
		
		//현재길이가 패스워드길이이면 암호후보에 맞는지 검사
		if(len==pwdLen) {
			if(vowel>=1&&consonant>=2) {
				for(char i:input)sb.append(i);
				sb.append('\n');
			}
			return;
		}
		
		//더이상 고를 알파벳이없으면 리턴
		if(cnt==numAlphabet)return;
		
		//모음인지 판별
		if(candiate[cnt]=='a'||candiate[cnt]=='e'||candiate[cnt]=='i'||candiate[cnt]=='o'||candiate[cnt]=='u') {
			input[len]=candiate[cnt];
			makePwd(cnt+1,len+1,vowel+1,consonant);
		}
		//자음일경우
		else {
			input[len]=candiate[cnt];
			makePwd(cnt+1,len+1,vowel,consonant+1);
		}
		//해당 문자를 안골랐을 경우
		makePwd(cnt+1,len,vowel,consonant);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		pwdLen=Integer.parseInt(st.nextToken());
		numAlphabet=Integer.parseInt(st.nextToken());
		
		input=new char[pwdLen];
		candiate=new char[numAlphabet];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<numAlphabet;i++)candiate[i]=st.nextToken().charAt(0);
		
		Arrays.sort(candiate);
		
		makePwd(0,0,0,0);
		
		System.out.println(sb);
	}

}
