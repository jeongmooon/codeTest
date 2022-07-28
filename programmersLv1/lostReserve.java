import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        answer = n-lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 내체육복 있나 확인
        for(int i=0; i<reserve.length; i++){
            for(int j=0; j<lost.length; j++){
                if(reserve[i]==lost[j]){
                    answer++;
                    lost[j]=0;
                    reserve[i]=0;
                    break;
                }
            }
        }
        
        // 체육복 나눠주기
        for(int i=0; i<reserve.length; i++){
            if(reserve[i] ==0) continue;
            
            for(int j=0; j<lost.length; j++){
                if(lost[j] == 0) continue;
                
                if(lost[j]-1 == reserve[i] || lost[j]+1 == reserve[i]){
                    answer++;
                    lost[j]=0;
                    reserve[i]=0;
                    break;
                }
            }
            
        }
        return answer;
    }
}