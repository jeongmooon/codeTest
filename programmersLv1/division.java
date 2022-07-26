import java.util.Set;
import java.util.TreeSet;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        Set<Integer> set = new TreeSet<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor ==0){
                set.add(arr[i]);
            }
        }
        if(set.size()==0) set.add(-1);
        answer = set.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}