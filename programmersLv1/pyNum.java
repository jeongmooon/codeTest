class Solution {
    boolean solution(String s) {
        boolean answer = true;
        // p = 112
        // P = 80
        // y = 121
        // Y = 89;
        int p = 0;
        int y = 0;
        for(int i=0; i<s.length(); i++){
            if(112 == s.charAt(i) || 80==s.charAt(i)) p++;
            if(121 == s.charAt(i) || 89==s.charAt(i)) y++;
        }
        answer = p==y ? true : false;
        return answer;
    }
}