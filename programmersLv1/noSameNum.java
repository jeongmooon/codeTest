import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        int num=0;
        List<Integer> list = new ArrayList();
        for(int i=0; i<arr.length; i++){
            if(i==0){
                list.add(arr[i]);
                num = arr[i];
                continue;
            }
            if(num != arr[i]) list.add(arr[i]);
            num = arr[i];
        }
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}