
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static final long COL_BASE=37;
	static final long ROW_BASE=31;
	static final long MOD=1_000_000_007;
	
	
	static int dreamX;
	static int dreamY;
	static int drawX;
	static int drawY;
	static long dreamHash;
	static StringBuilder sb=new StringBuilder();
	
	//2차원해쉬를 합쳐줍니다.
	static long compute2DHash(char[][] dream) {
		long hash=0;
		
		for(int i=0;i<dreamY;i++) {
			hash=(hash*COL_BASE+dreamRowHash(dream,i))%MOD;
			
		}
		return hash;
	}
	
	//각행에 대한 해쉬
	static long dreamRowHash(char[][] dream,int depth) {
		
		long hash=0;
		for(int i=0;i<dreamX;i++) {
			hash=(hash*ROW_BASE+dream[depth][i])%MOD;
		}
		return hash;
	}
	
	
	//롤링해쉬
	static int sawDraw(char[][] draw) {
		int count=0;
		long rowPow=1;
		long colPow=1;
		long[][] rowHash=new long[drawY][drawX-dreamX+1];
		
		//sliding을 위한rowPow&colPow
		for(int i=1;i<dreamX;i++)rowPow=(rowPow*ROW_BASE)%MOD;
		for(int i=1;i<dreamY;i++)colPow=(colPow*COL_BASE)%MOD;
		
		//1.가로  rollingHash
		for(int i=0;i<drawY;i++) {
			long hash=0;
			
			for(int j=0;j<dreamX;j++)hash=(hash*ROW_BASE+draw[i][j])%MOD;
			
			rowHash[i][0]=hash;
			
			for(int j=1;j<drawX-dreamX+1;j++) {
				hash=(hash-draw[i][j-1]*rowPow)%MOD;
				hash=(hash+MOD)%MOD;
				hash=(hash*ROW_BASE+draw[i][j+dreamX-1])%MOD;
				
				rowHash[i][j]=hash;
			}
		}
		
		//2.세로 rollingHash
		for(int i=0;i<drawX-dreamX+1;i++) {
			long hash=0;
			
			for(int j=0;j<dreamY;j++)hash=(hash*COL_BASE+rowHash[j][i])%MOD;
			
			if(dreamHash==hash)count++;
			
			for(int j=1;j<drawY-dreamY+1;j++) {
				hash=(hash-(rowHash[j-1][i]*colPow))%MOD;
				hash=(hash+MOD)%MOD;
				hash=(hash*COL_BASE+rowHash[dreamY-1+j][i])%MOD;
				
				if(hash==dreamHash)count++;
			}
		}
		
		
		return count;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			st=new StringTokenizer(br.readLine());
			
			dreamY=Integer.parseInt(st.nextToken());
			dreamX=Integer.parseInt(st.nextToken());
			drawY=Integer.parseInt(st.nextToken());
			drawX=Integer.parseInt(st.nextToken());
			
			char [][]dream=new char[dreamY][dreamX];
			char[][] draw=new char[drawY][drawX];
			for(int i=0;i<dreamY;i++) {
				String input=br.readLine();
				for(int j=0;j<dreamX;j++) {
					dream[i][j]=input.charAt(j);
				}
			}
			
			//꿈에서본 그림을 하나의 long타입의 해쉬값으로 변환.
			dreamHash=compute2DHash(dream);
			
			for(int i=0;i<drawY;i++) {
				String input=br.readLine();
				for(int j=0;j<drawX;j++) {
					draw[i][j]=input.charAt(j);
				}
			}
			
			
			sb.append('#').append(t).append(' ').append(sawDraw(draw)).append('\n');
		}
		System.out.println(sb);
	}

}
