import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int tree[];
	static BufferedWriter bw;
	public static char toAlpha(int idx) {
		return (char) (idx + 'A');
	}
	
	public static int toIdx(char ch) {
		if(ch == '.') {
			return -1;
		}
		return ch - 'A';
	}
	
	public static void preOrder(int node) throws IOException {
		int leftChild = 2 * node;
		int rightChild = 2 * node + 1;
		
		bw.write(toAlpha(node) + "");
		if(tree[leftChild] >= 0) {
			preOrder(tree[leftChild]);
		}
		if(tree[rightChild] >= 0) {
			preOrder(tree[rightChild]);
		}
	}
	
	public static void inOrder(int node) throws IOException {
		int leftChild = 2 * node;
		int rightChild = 2 * node + 1;
		
		if(tree[leftChild] >= 0) {
			inOrder(tree[leftChild]);
		}
		bw.write(toAlpha(node) + "");
		if(tree[rightChild] >= 0) {
			inOrder(tree[rightChild]);
		}
	}
	
	public static void postOrder(int node) throws IOException {
		int leftChild = 2 * node;
		int rightChild = 2 * node + 1;
		if(tree[leftChild] >= 0) {
			postOrder(tree[leftChild]);
		}
		if(tree[rightChild] >= 0) {
			postOrder(tree[rightChild]);
		}
		bw.write(toAlpha(node) + "");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		tree = new int[2 * n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char node = st.nextToken().charAt(0);
			char leftChild = (st.nextToken().charAt(0));
			char rightChild = st.nextToken().charAt(0);
			tree[2 * toIdx(node)] = toIdx(leftChild);
			tree[2 * toIdx(node) + 1] = toIdx(rightChild);
		}
		
		preOrder(0);
		bw.write("\n");
		inOrder(0);
		bw.write("\n");
		postOrder(0);
		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}
}

