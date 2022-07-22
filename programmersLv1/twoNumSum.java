class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int c = 0;
        if(a<b){
            c =a;
        } else {
            c=b;
            b=a;
        }
        for(int i=c; i<=b; i++){
            answer += i;
        }
        return answer;
    }
}