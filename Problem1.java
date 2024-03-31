public class Solution {
    /**
     * @param s: Source string
     * @param target: Target string
     * @return: Number of subsequences that can be spliced into target
     */
     //TC: O(m*n)
     //SC: O(n)
    public int shortestWay(String s, String target) {
        // write your code here
        int m = s.length();
        int n = target.length(); 
        int count = 1;
        HashSet<Character> set = new HashSet<>();
        
        for( int i = 0; i < m; i++){
            char c = s.charAt(i);
            set.add(c);
        }
        int i = 0, j = 0; //j on target
        while( j < n){
            char tChar = target.charAt(j);
            if(!set.contains(tChar)) return -1;
            if(s.charAt(i) == target.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
            if(i == m && j < n){
                    i = 0;
                    count++;
                }
        }
        return count;
    }
}
