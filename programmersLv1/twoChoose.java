import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<numbers.length; i++){
            for(int j=0; j<numbers.length; j++){
                if(i != j){
                    //System.out.println(numbers[i]+numbers[j]);
                    set.add(numbers[i]+numbers[j]);
                }
            }
        }
        set.forEach(System.out::println);
        answer = set.stream().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}