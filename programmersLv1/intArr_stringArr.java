class Solution {
    public int solution(String s) {
        int answer = 0;
        //String[] result = s.split("[0-9]");
        String[] result = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(int i=0; i<result.length; i++){
            s=s.replace(result[i],Integer.toString(i));
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}