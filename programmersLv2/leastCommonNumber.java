class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i=0; i<arr.length; i++){
            int a1 = Math.max(answer,arr[i]);
            int b1 = Math.min(answer,arr[i]);
            int r= 0;
            
            while(a1%b1 !=0){
                r = a1%b1;
                a1 = b1;
                b1 = r;
            }
            answer = answer*arr[i]/b1;
        }
        
        
        return answer;
    }
}