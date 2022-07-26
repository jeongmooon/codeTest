import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(answer=0; answer<d.length; answer++){
            budget -= d[answer];
            if(budget<0) break;
        }
        return answer;
    }
}