public class Solution {
    /**
     * @param s: Source string
     * @param target: Target string
     * @return: Number of subsequences that can be spliced into target
     */
     //TC: O(nlogm)
     //SC: O(1)
    public int shortestWay(String s, String target) {
        // write your code here
        int m = s.length();
        int n = target.length(); 
        int count = 1;
        HashMap<Character, List<Integer>> map = new HashMap<>();
        
        for( int i = 0; i < m; i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        int sp = 0, tp = 0; 
        while( tp < n){
            char tChar = target.charAt(tp);
            if(!map.containsKey(tChar)) return -1;
            List<Integer> list = map.get(tChar);
            int k = Collections.binarySearch(list,sp);
            if( k < 0){
                k = -k-1;
            }
            if(k == list.size()){
                count++;
                sp = list.get(0);
            }else{
                sp = list.get(k);
                sp++;
                tp++;
            }
        }
        return count;
    }
}
