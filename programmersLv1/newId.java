class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1단계
        new_id= new_id.toLowerCase();
        
        // 2단계
        new_id=new_id.replaceAll("[^\\w\\-_.]*","");
        
        // 3단계
        new_id=new_id.replaceAll("[.]{2,}",".");
        //System.out.println(new_id.split("")[0]);
        
        // 4단계
        String n[] = new_id.split("");
        if(n[0].equals(".")){
            n[0]="";
        }
        if(n[n.length-1].equals(".")){
            n[n.length-1]="";
        }
        new_id=String.join("",n);
        
        // 5단계
        if(new_id.equals("")){
            new_id = "a";
        }
        
        //6단계
        if(new_id.length()>15){
            new_id=new_id.substring(0,15);
            n = new_id.split("");
            if(n[0].equals(".")){
                n[0]="";
            }
            if(n[n.length-1].equals(".")){
                n[n.length-1]="";
            }
            new_id=String.join("",n);
        }
        
        // 5단계
        if(new_id.equals("")){
            new_id = "a";
        }
        
        // 7단계
        if(new_id.length() <3){
            while(new_id.length()!=3){
                new_id += new_id.split("")[new_id.length()-1];
            }
        }
        
        System.out.println(new_id);
        answer = new_id;
        return answer;
    }
}