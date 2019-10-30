class Solution {
    static boolean visited[];
    static int output[];
    static int th = 0;
    
    public static void perm(int n, int depth){
        if(th == 0){
            return;
        }
        if(depth == output.length){
            th--;
        }
        for(int i = 0; i < n; i++){
            if(!visited[i] && th > 0){
                visited[i] = true;
                output[depth] = i+1;
                perm(n, depth+1);
                visited[i] = false;
            }
        }
        
    }
    
    public String getPermutation(int n, int k) {
        output = new int[n];
        visited = new boolean[n];
        StringBuilder sb = new StringBuilder();
        th = k;
        perm(n, 0);
        for(int i = 0; i < n; i++){
            sb.append(output[i]);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	Solution solver = new Solution();
    	String result = solver.getPermutation(3, 3);
    	System.out.println(result);
    }
}
