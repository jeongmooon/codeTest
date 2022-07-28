class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int mon = 0;
        for(int i=1; i<a; i++){
            if(i==1||i==3||i==5||i==7||i==8||i==10||i==12){
                mon+=31;
                continue;
            } else if(i==2) {
                mon+= 29;
                continue;
            } else {
                mon+=30;
            }
        }
        mon+=b;
        
        int day = 5;
        for(int i=1; i<=mon; i++){
            day++;
            if(day>7)day = day%7;
        }
        if(day==1) answer = "SUN";
        if(day==2) answer = "MON";
        if(day==3) answer = "TUE";
        if(day==4) answer = "WED";
        if(day==5) answer = "THU";
        if(day==6) answer = "FRI";
        if(day==7) answer = "SAT";
        return answer;
    }
}