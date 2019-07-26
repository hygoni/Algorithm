import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Person implements Comparable {
	int age;
	String name;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo(Object o) {
		Person other = (Person) o;
		if(this.age > other.age)
			return 1;
		else if(this.age == other.age)
			return 0;
		else
			return -1;
	}
	
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Person[] people = new Person[n];
		
		for(int i = 0; i < n; i++) {
			String[] str= br.readLine().split(" ");
			String name = str[1];
			int age = Integer.parseInt(str[0]);
			people[i] = new Person(name, age);
		}
		
		Arrays.sort(people);
		
		for(int i = 0; i < n; i++) {
			bw.write(String.format("%d %s\n", people[i].age, people[i].name));
		}
		
		bw.flush();
	}

}
