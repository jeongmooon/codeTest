class Solution {
    public int main(int[] numbers) {
        int answer = 0;
        int maxNum = 9;
        for(int i=0; i<= maxNum; i++){
            answer+=i;
        }
        for(int i=0; i<numbers.length; i++){
            answer-=numbers[i];            
        }
        return answer;
    }
}