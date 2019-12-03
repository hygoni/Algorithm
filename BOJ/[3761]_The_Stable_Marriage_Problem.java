import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void stableMatch(int N, Map<Character, LinkedList<Character>> malePref, Map<Character, Map<Character, Integer>> femalePref) {
		Map<Character, Boolean> manEngaged = new HashMap<>();
		Map<Character, Character> womanPartner = new HashMap<>();
		Map<Character, Character> manPartner = new HashMap<>();
		
		
		while(true) {
			boolean isAllManEngaged = true;
			Iterator<Character> manIter = malePref.keySet().iterator();
			while(manIter.hasNext()) {
				Character man = manIter.next();
				boolean isEngaged = manEngaged.getOrDefault(man, false);
				if(!isEngaged) {
					Character woman = malePref.get(man).poll();
					Character previousMan = womanPartner.get(woman);
					if(previousMan == null) {
						womanPartner.put(woman, man);
						manPartner.put(man, woman);
						manEngaged.put(man, true);
					} else {
						isAllManEngaged = false;
						if(femalePref.get(woman).get(previousMan) > femalePref.get(woman).get(man)) {
							womanPartner.put(woman, man);
							manPartner.put(man, woman);
							manEngaged.put(man, true);
							manEngaged.put(previousMan, false);
							isAllManEngaged = false;
						}
					}
				}
			}
			if(isAllManEngaged) {
				break;
			}
		}
		
		SortedSet<Character> set = new TreeSet<Character>(manPartner.keySet());
		Iterator<Character> manIter = set.iterator();
		while(manIter.hasNext()) {
			Character man = manIter.next();
			Character woman = manPartner.get(man);
			sb.append(String.format("%s %s\n", man, woman));
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			Map<Character, LinkedList<Character>> malePref = new HashMap<>();
			Map<Character, Map<Character, Integer>> femalePref = new HashMap<>();
			br.readLine();
			for(int i = 0; i < N; i++) {
				String line = br.readLine();
				char person = line.charAt(0);
				malePref.put(person, new LinkedList<>());
				for(int j = 2; j < 2 + N; j++) {
					malePref.get(person).add(line.charAt(j));
				}
			}
			for(int i = 0; i < N; i++) {
				String line = br.readLine();
				char person = line.charAt(0);
				femalePref.put(person, new HashMap<>());
				for(int j = 2; j < 2 + N; j++) {
					femalePref.get(person).put(line.charAt(j), j);
				}
			}
			stableMatch(N, malePref, femalePref);
			if(t != T-1) {
				sb.append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}
