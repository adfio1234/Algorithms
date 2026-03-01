import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	//docDq: 문서를 저장하는 deque
	//docNum: 문서의 개수
	//docTarget: 몇번쨰인쇄인지 알고싶은 문서
	//docTargetNum: 알고싶은 문서의 중요도
	static int docNum;
	static int docTarget;
	static int docTargetPriority;
	static ArrayDeque<Integer> docDq;
	static StringBuilder sb=new StringBuilder();
	
	static void print() {
	    int cnt = 1;  // 출력은 1부터 시작

	    while (!docDq.isEmpty()) {

	        int priority = maxPriority();
	        int size = docDq.size();   // 🔥 size 고정

	        for (int i = 0; i < size; i++) {

	            int element = docDq.pollFirst();

	            if (element == priority) {  // 출력되는 경우

	                if (docTarget == 0) {   // 우리가 찾는 문서
	                    sb.append(cnt).append('\n');
	                    return;
	                }

	                cnt++;
	                docTarget--;   // 하나 빠졌으니 타겟 감소
	                break;         // 한 번만 출력됨
	            }

	            // 출력 안 되면 뒤로 이동
	            docDq.addLast(element);

	            // 타겟 위치 갱신
	            if (docTarget == 0)
	                docTarget = docDq.size() - 1;
	            else
	                docTarget--;
	        }
	    }
	}
	
	
    static int maxPriority() {

        int max = 0;
        for (int val : docDq) {
            max = Math.max(max, val);
        }
        return max;
    }
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=0;t<TC;t++)
		{
			//입력
			st=new StringTokenizer(br.readLine());
			docNum=Integer.parseInt(st.nextToken());
			docTarget=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine());
			docDq=new ArrayDeque<>();
			for(int i=0;i<docNum;i++) {
				docDq.addLast(Integer.parseInt(st.nextToken()));
				if(docTarget==i) {
					docTargetPriority=docDq.peekLast();
				}
			}
			
			//메서드 호출
			print();
			
		}
		System.out.println(sb);
	}

}
