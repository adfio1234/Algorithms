

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {

	static ArrayDeque<Integer> dq=new ArrayDeque<>();
	

	static void shuffle() {
		
		while(dq.size()!=1) {
			dq.pollFirst();
			dq.addLast(dq.pollFirst());
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int numCard=Integer.parseInt(br.readLine());
		for(int i=1;i<=numCard;i++)dq.add(i);
		
		shuffle();
		System.out.println(dq.peekFirst());
	}

}
