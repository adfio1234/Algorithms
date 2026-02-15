
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting>{
	public int start;
	public int end;
	
	Meeting(int start,int end){
		this.start=start;
		this.end=end;
	}

	@Override
	public int compareTo(Meeting o) {
		
		if (this.end!=o.end)return this.end-o.end;
		return this.start-o.start;
	}
}

public class Main {

	
	//numMeeting: 회의의 수
	//meetingList: 회의 배열
	static int numMeeting;
	static Meeting[] meetingList;
	
	static int maxMeeting() {
		
		//종료시간 기준으로 정렬 시킨다.
		Arrays.sort(meetingList);

		//prevEnd: 전의 회의가 끝나는시간
		int prevEnd=meetingList[0].end;
		int result=1;
		
		
		for(int i=1;i<numMeeting;i++) {
			int curStart=meetingList[i].start;
			int curEnd=meetingList[i].end;
			
			//만약 전에 회의가 끝나지않았다면 continue
			if(curStart<prevEnd)continue;
			//회의가 끝났다면 회의count증가한후 다음 종료시간을 옮긴다.
			result+=1;
			prevEnd=curEnd;
		}
		return result;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		numMeeting=Integer.parseInt(br.readLine());
		meetingList=new Meeting[numMeeting];
		
		//회의 배열 입력
		for(int i=0;i<numMeeting;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			
			meetingList[i]=new Meeting(start,end);
		}
		
		System.out.println(maxMeeting());
		
	}

}
