import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i=0; i<participant.length; i++){
            if(i==completion.length){
                answer = participant[i];
                break;
            }
            if(!participant[i].equals(completion[i])){
                answer = participant[i];
                break;
            }
        }       
        
        System.out.println(answer);
        return answer;
    }
}