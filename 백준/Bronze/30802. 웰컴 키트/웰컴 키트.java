import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	//parameter로 형변환 int ->double
	static int countShirtBundle(int[] size,double bundle)
	{
		//size별 신청자수에 묶음수를 나눠서 올림처리해준다.
		int total=0;
		for(int i=0;i<6;i++)
			total+=(int)Math.ceil(size[i]/bundle);
		return total;
	}
	
	static int countPanBundle(int N,int P) {
		return (int)(N/P);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N=Integer.parseInt(br.readLine());//참가자의 수
		int[] size=new int[6];//사이즈별 신청자의 수
		int T;//티셔츠의 묶음당 장수
		int P;//펜의 묶음당 개수
		int resultShirtBundle=0;//티셔츠의 구매 최소 묶음수
		int resultPanBundle=0;//펜의 묶음수
		
		//size별 신청자 수 입력
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<6;i++)size[i]=Integer.parseInt(st.nextToken());
		
		//묶음당 개수 입력
		st=new StringTokenizer(br.readLine());
		T=Integer.parseInt(st.nextToken());
		P=Integer.parseInt(st.nextToken());
		
		//티셔츠의 최소 묶음 구하는 로직
		resultShirtBundle=countShirtBundle(size,T);
		resultPanBundle=countPanBundle(N, P);
		
		System.out.println(resultShirtBundle);
		System.out.printf("%d %d",resultPanBundle,N-(resultPanBundle*P));
		
	}

}
