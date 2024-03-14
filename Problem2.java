class Solution {
    //tc: O(2n)
    //SC: O(1)
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = check(tops,bottoms,tops[0]);
        if(result != -1) return result;
        return check(tops,bottoms,bottoms[0]);
    }
    private int check(int[] tops, int[] bottoms, int target){
        int tRot = 0; int bRot = 0;
        for(int i = 0; i < tops.length; i++){
            if(tops[i] != target && bottoms[i] != target) return -1;
            if(tops[i] != target) tRot++;
            if(bottoms[i] != target) bRot++;
        }
        return Math.min(tRot,bRot);
    }
}
