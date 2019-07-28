import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Student implements Comparable {
	String name;
	int korean, english, math;
	
	public Student(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	@Override
	public int compareTo(Object o) {
		Student other = (Student) o;
		if(this.korean == other.korean) {
			if(this.english == other.english) {
				if(this.math == other.math)
					return this.name.compareTo(other.name);
				else if(this.math > other.math)
					return -1;
				else
					return 1;
			}
			else if(this.english > other.english) {
				return 1;
			} else {
				return -1;
			}
		} else if(this.korean > other.korean) {
			return -1;
		} else {
			return 1;
		}
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Student[] students = new Student[n];
		
		for(int i = 0; i < n; i++) {
			String[] str= br.readLine().split(" ");
			String name = str[0];
			int korean = Integer.parseInt(str[1]);
			int english = Integer.parseInt(str[2]);
			int math = Integer.parseInt(str[3]);
			students[i] = new Student(name, korean, english, math);
		}
		
		Arrays.sort(students);
		
		for(int i = 0; i < n; i++) {
			bw.write(students[i].name + "\n");
		}
		
		bw.flush();
	}

}
