import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

class Coord implements Comparable {
	int x, y;
	
	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Object o) {
		Coord other = (Coord) o;
		if(this.y == other.y) {
			if(this.x > other.x)
				return 1;
			else if(this.x == other.x)
				return 0;
			else
				return -1;
		} else {
			if(this.y > other.y)
				return 1;
			else if(this.y == other.y)
				return 0;
			else
				return -1;
		}
	}
	
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Coord[] coords = new Coord[n];
		
		for(int i = 0; i < n; i++) {
			String[] str= br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			coords[i] = new Coord(x, y);
		}
		
		Arrays.sort(coords);
		
		for(int i = 0; i < n; i++) {
			bw.write(String.format("%d %d\n", coords[i].x, coords[i].y));
		}
		
		bw.flush();
	}

}
