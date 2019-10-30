import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n]; //입력값
		int LIS[] = new int[n]; //i번째 인덱스보다 왼쪽에 있는 수열들 중에서 가장 긴 LIS의 길이
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxVal = -1;
		int maxIdx = 0;
		for(int i = 0; i < n; i++) {
			if(LIS[i] == 0) {
				LIS[i] = 1;
			}
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
					if(maxVal < LIS[i]) {
						maxIdx = i;
						maxVal = LIS[i];
					}
				}
			}
		}
		
		//LIS로 역으로 추적해가기
		LinkedList<Integer> seq = new LinkedList<Integer>();
		seq.add(arr[maxIdx]);
		for(int i = maxIdx - 1; seq.size() < maxVal; i--) {
			if(LIS[i] + 1 == LIS[maxIdx] && arr[i] < arr[maxIdx]) {
				seq.add(arr[i]);
				maxIdx = i;
			}
		}
		Collections.reverse(seq);
		
		System.out.println(seq.size());
		Iterator<Integer> iter = seq.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		br.close();
	}
}

