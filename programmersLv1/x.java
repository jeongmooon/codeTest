class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        Long y = Long.valueOf(x);
        for(int i=0; i<answer.length; i++){
            answer[i] = y*(i+1);
        }
        
        return answer;
    }
}