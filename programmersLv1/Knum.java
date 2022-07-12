import java.util.Arrays;

class Solution {
    
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];      
        for(int i=0; i<commands.length; i++){
            int start = commands[i][0]-1;
            int end = commands[i][1]-commands[i][0]+1;
            int[] result = new int[end];
            System.arraycopy(array, start, result, 0, end);
            
            Arrays.sort(result);
            //System.out.println(Arrays.toString(result));
            int n = commands[i][2]-1;
            //System.out.println(result[n]);
            answer[i] = result[n];
        }       
        
        return answer;
    }
}