class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        char arr[] = s.toCharArray();
        if(!(arr.length ==4 || arr.length==6)){
            return false;
        }
        System.out.println(arr.length);
        for(int i=0; i < arr.length; i++){
            System.out.println(arr[i]);
            if(Character.isDigit(arr[i]) == false) {
                answer = false;
                break;
            }
            
        }
        
        
        return answer;
    }
}