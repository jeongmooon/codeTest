class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int a = 0; // 큰길이
        int b = 0; // 작은길이
        
        if(sizes[0][0] >sizes[0][1]){
            a =sizes[0][0]; 
            b =sizes[0][1];
        } else {
            a =sizes[0][1];
            b =sizes[0][0];
        }
        
        for(int i=1; i<sizes.length; i++){
            
            if(sizes[i][0] >sizes[i][1]){
                if(a<sizes[i][0]) a = sizes[i][0];
                if(b<sizes[i][1]) b = sizes[i][1];
            } else {
                if(a<sizes[i][1]) a = sizes[i][1];
                if(b<sizes[i][0]) b = sizes[i][0];
            }
        }
        answer = a*b;
        
        
        return answer;
    }
}