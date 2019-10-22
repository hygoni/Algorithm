import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static Map<String, String> parent;
	static Map<String, Integer> children;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			parent = new HashMap<String, String>();
			children = new HashMap<String, Integer>();

			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String left = st.nextToken();
				String right = st.nextToken();

				if(!parent.containsKey(left)) {
					parent.put(left, left);
				}
				if(!parent.containsKey(right)) {
					parent.put(right, right);
				}
				if(!children.containsKey(left)) {
					children.put(left, 1);
				}
				if(!children.containsKey(right)) {
					children.put(right, 1);
				}


				String leftRoot = find(left);
				String rightRoot = find(right);
				if(leftRoot.equals(rightRoot)) {
					sb.append(children.get(leftRoot)).append("\n");
				} else {
					union(left, right);
					sb.append(children.get(rightRoot)).append("\n");
				}
			}
		}
		System.out.println(sb);
		br.close();
	}

	private static String find(String x) {
		if(parent.get(x).equals(x)) {
			return x;
		} else {
			String root = find(parent.get(x));
			parent.put(x, root);
			return root;
		}
	}

	private static void union(String x, String y) {
		String xRoot = find(x);
		String yRoot = find(y);
		parent.put(xRoot, y);
		children.put(yRoot, children.get(xRoot) + children.get(yRoot));
	}
}
