import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        List<String> list = Stream.of(strings).collect(Collectors.toList());
        list = list.stream().map(x -> x.substring(n,n+1)+x)
                .sorted().map(x->x.substring(1)).collect(Collectors.toList());
        answer = list.toArray(new String[0]);
        
        return answer;
    }
}