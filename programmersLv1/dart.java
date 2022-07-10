class Solution {
    public int solution(String dartResult) {
        int[] round = new int[3];
        char[] carr = dartResult.toCharArray();

        int idx = -1;
        for (int i=0;i<carr.length;i++) {
            if (carr[i] >= '0' && carr[i] <= '9') {
                idx++;
                // 추가점수
                round[idx] += Integer.parseInt(String.valueOf(carr[i]));
                // n번째 라운드에 쏜 점수가 10점인 경우
                if (i+1!=carr.length-1 && carr[i+1] == '0'&& carr[i] == '1') {
                    round[idx] -= Integer.parseInt(String.valueOf(carr[i]));
                    round[idx] = 10;
                    i++;                    
                }                
            } else if (carr[i] == 'D') { // 보너스 Double
                round[idx] *= round[idx]; // 제곱
            } else if(carr[i] == 'T') { // 보너스 Triple
                round[idx] *= round[idx] * round[idx]; // 세제곱
            } else if (carr[i] == '*') { // 이전 라운드와 현재 라운드에 *2
                if (idx > 0) round[idx-1] *=2;                
                round[idx] *= 2;
            } else if (carr[i] == '#') { // 현재 라운드에 * -1                
                round[idx] *= -1;
            }
        }
        return round[0] + round[1] + round[2];
    }
}