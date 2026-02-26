import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//나이트의 이동방식
//나이트는 이동경로는 x,y축 대칭이다.
//정수인(|x|,|y|)에대해서는 모두 같은 최소이동횟수를 가진다.
//1.x,y를 양수로 바꾸어도된다.

//x,y에대해서 
//x가 -1 or +1하면 
//y가 +2 or -2한다.
//(x,y)와 (y,x)까지의 이동횟수는 동일하다.
//2.(x,y)중 큰값을 고정할 수 있다.
//3.x=1,y=2이동한다 한번이동하는데 이동하는 거리는 3이다.=> 최소x+y번 이동해야한다.

//단 y가 너무커서 (x+1,y+2)->(x-1,y+2)하면서 거리를 늘릴경우에는 2번동안 이동거리가 4이다.
//4. 따라서 y가 큰경우는 y/2이동하게된다.

//홀수 짝수이동
//1번 이동하면 좌표의 합은 홀수, 2번 이동 하면 좌표의 합은 짝수이다.
//n번 이동했을떄 좌표의 합이 홀수이면 n은 홀수이다.
//n번 이동했을때 좌표의 합이 짝수이면 n은 짝수이다.
//4. goal의 좌표값을 통해 이동횟수의 짝수 홀수를 알 수 있다.

public class Main {

	static int trip(int x,int y) {
		x=Math.abs(x);
		y=Math.abs(y);
		
		//y를 큰 값으로 고정한다.
		if(x>y) {
			int tmp=x;
			x=y;
			y=tmp;
		}
		
		//예외 케이스
		//x와 y가 너무 작은경우에는 예외 케이스가 생깁니다.
		if(x==0&&y==1)return 3;
		if(x==2&y==2)return 4;
		
		//y가 큰경우 
		//ceil연산에대해서
		//ceil(x/y) 연산을 하게되면
		//실제연산 작동은 (x+y-1)/y가 됩니다.
		//따라서 hasBigY=(y+1)/2;, distance=(x+y+2)/3;도 가능합니다.
		int hasBigY=(int) Math.ceil((double)y/2);
		
		int distance=(int) Math.ceil((double)(x+y)/3);
		 
		//둘중 더 큰값을 distance로 합니다.
		//y가 엄청 큰경우도 고려해야하기때문에
		distance=Math.max(distance, hasBigY);
		
		//x+y의 합을 통해 홀수or짝수번 이동을 알수있습니다.
		//하지만 distance의 값이 x+y%2와 다르다면 +1해줍니다.
		//위에서 계산한 연산이 최소거리이기때문에 -1을 하면 목표 좌표에 도달을 못합니다.
		if((x+y)%2!=distance%2)distance++;
		return distance;
	}
	

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st=new StringTokenizer(br.readLine());
			
			//END들어오면 종료
			String first=st.nextToken();
			if(first.equals("END"))break;
			
			//나이트의 이동은 좌우 대각선 대칭이므로 계산의 편의를 위해
			//양수로 다 바꾼다.
			//(-1,2)와 (1,2)의 이동 거리는 같다.
			int targetX=Integer.parseInt(first);
			int targetY=Integer.parseInt(st.nextToken());
			
			System.out.println(trip(targetX,targetY));
		}
		
	}

}
