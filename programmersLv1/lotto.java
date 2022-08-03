class Solution {
    public int ranking(int n){
        if(n==6){
            return 1;
        } else if(n==5){
            return 2;
        } else if(n==4){
            return 3;
        } else if(n==3){
            return 4;
        } else if(n==2){
            return 5;
        }
        return 6;
    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int n = 0;
        int zeroCount = 0;
        for(int i=0; i<win_nums.length; i++){
            if(lottos[i]==0){
                zeroCount++;
            }
            for(int j=0; j<lottos.length; j++){
                if(lottos[j]==0) {
                    continue;
                }
                if(win_nums[i]==lottos[j]){
                    win_nums[i] = 0;
                    n++;
                }
            }
        }
        int max = n+zeroCount;
        int min = n;
        
        System.out.println(ranking(max));
        System.out.println(ranking(min));
        
        answer[0] = ranking(max);
        answer[1] = ranking(min);
        return answer;
    }
}