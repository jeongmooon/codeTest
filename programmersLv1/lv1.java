class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++){
            int n = 0;
            
            // 약수 갯수 찾기
            for(int j=1; j*j<=i; j++){
                if(j*j==i){
                    n++;
                } else if(i%j ==0){
                    n+=2;
                }      
            }
            System.out.println("n : "+n);
            
            // 결과 넣기
            if(n%2 ==0){
                answer+=i;
            } else {
                answer -=i;
            }
        }
        System.out.println(answer);
        return answer;
    }
}