import java.util.HashMap;
class LongestSubstringWithNonRepeatingCharacters{

    public static int solution(String s){
        int len = 0;

        int i = -1;
        int j = -1;

        HashMap<Character, Integer> map = new HashMap<>();
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;

            while(i<s.length()-1){
                flag1 = true;
                i++;
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0)+1);

                if(map.get(c) == 2){
                    break;
                }else{
                    int plen = i-j;
                    if(plen > len){
                        len = plen;
                    }
                }
            }

            while(j<i){
                flag2 = true;
                j++;
                char c = s.charAt(j);
                map.put(c, map.get(c)-1);

                if(map.get(c) == 1){
                    break;
                }
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