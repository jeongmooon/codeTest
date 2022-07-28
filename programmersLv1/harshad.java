class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String num = Integer.toString(x);
        String[] numArr=num.split("");
        int has =0;
        for(int i=numArr.length-1; 0<=i; i--){
            has += Integer.parseInt(numArr[i]);
        }
        if(x%has!=0) answer = false;
        return answer;
    }
}