class Solution {
    public int solution(int num) {
        int answer = 0;
        
        while(num != 1){
            if(answer==500){
                answer = -1;
                break;
            }
            answer++;
            if(num%2==0){
                num /=2;
                continue;
            } 
            if(num%2==1){
                num = num*3+1;
                continue;
            }
        }
        
        
        return answer;
    }
}