import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> list = new ArrayList<Integer>();
        int count = 0;
        while(true){
            count++;
            list.add(n%3);
            n = n/3;
            if(n==0) break;
        }
        
        for(int i=0; i<count; i++){
            answer += list.get(count-1-i)*(Math.pow(3, i));
        }
        
        return answer;
    }
}