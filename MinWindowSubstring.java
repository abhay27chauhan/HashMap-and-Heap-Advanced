import java.util.HashMap;
class MinWindowSubstring{

    public static String solution(String s1, String s2){
        String ans = "";
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char c: s2.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        int mc = 0;
        int tmc = s2.length();
        int i = -1;
        int j = -1;

        HashMap<Character, Integer> map1 = new HashMap<>();
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;

            while(i<s1.length()-1 && mc < tmc){
                i++;
                char c = s1.charAt(i);
                map1.put(c, map1.getOrDefault(c, 0) + 1);

                if(map1.get(c) <= map2.getOrDefault(c, 0)){
                    mc++;
                } 
                flag1 = true;
            }

            while(j<i && mc == tmc){
                String pans = s1.substring(j+1, i+1);
                if(ans.length()==0 || pans.length() < ans.length()){
                    ans = pans;
                }

                j++;
                char c = s1.charAt(j);
                if(map1.get(c) == 1){
                    map1.remove(c);
                }else{
                    map1.put(c, map1.get(c) -1);
                }
                if(map1.getOrDefault(c,0) < map2.getOrDefault(c,0)){
                    mc--;
                }
                flag2 = true;
            }

            if(flag1 == false && flag2 == false){
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        String s1 = "dbaecbbabdcaafbddcabgba";
        String s2 = "abbcdc";
        String ans = solution(s1, s2);
        System.out.println(ans);
    }
}