// Smallest Substring of a String Containing All Unique Characters of itself

import java.util.HashMap;
import java.util.HashSet;
class MinWindowSubstring2{

    public static int solution(String s){
        int len = s.length();
        HashSet<Character> set = new HashSet<>();
        for(char c: s.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
            }
        }
        int i = -1;
        int j = -1;

        HashMap<Character, Integer> map = new HashMap<>();
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;

            while(i < s.length()-1 && map.size() < set.size()){
                i++;
                char c= s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);

                flag1 = true;
            }

            while(j<i && map.size() == set.size()){
                int plen = i-j;
                if(plen < len){
                    len = plen;
                }

                j++;
                char c= s.charAt(j);
                if(map.get(c) == 1){
                    map.remove(c);
                }else{
                    map.put(c, map.get(c) -1);
                }
                flag2 = true;
            }

            if(flag1 == false && flag2 == false){
                break;
            }
        } 

        return len;
    }

    public static void main(String[] args){
        String s = "aabcbcdbca";
        int len = solution(s);
        System.out.println(len);
    }
}