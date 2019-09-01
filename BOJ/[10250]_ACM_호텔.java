import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Room implements Comparable {
	int num, floor, ho;

	public Room(int num, int floor, int ho) {
		this.num = num;
		this.floor = floor;
		this.ho = ho;
	}

	@Override
	public int compareTo(Object o) {
		Room other = (Room) o;
		if(this.ho < other.ho) {
			return -1;
		} else if(this.ho == other.ho) {
			return Integer.compare(this.floor, other.floor);
		} else {
			return 1;
		}
	}


}

public class Main {

	public static int getRoomName(int floor, int ho) {
		String floor_ = Integer.toString(floor);
		String ho_ = String.format("%02d", ho);
		return Integer.parseInt(floor_ + ho_);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int T = Integer.parseInt(br.readLine());

		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			LinkedList<Room> rooms = new LinkedList<Room>();

			for(int ho = 1; ho <= w; ho++) {
				for(int floor = 1; floor <= h; floor++) {
					rooms.add(new Room(getRoomName(floor, ho), floor, ho));
				}
			}

			Collections.sort(rooms);
			System.out.println(rooms.get(n-1).num);
		}
		br.close();
	}
}

