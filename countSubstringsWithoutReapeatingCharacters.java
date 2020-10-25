import java.util.HashMap;
class countSubstringsWithoutReapeatingCharacters{

    public static int solution(String str){
        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;

        while(true){
            boolean flag1 = false;
            boolean flag2 = false;

            while(i < str.length() -1){
                flag1 = true;
                i++;
                char c = str.charAt(i);
                map.put(c, map.getOrDefault(c, 0)+1);

                if(map.get(c) == 2){
                    break;
                }else{
                    ans += i-j;
                }
            }

            while(j < i){
                flag2 = true;
                j++;

                char c = str.charAt(j);
                map.put(c, map.get(c) - 1);
                
                if(map.get(c) == 1){
                    ans += i-j;
                    break;
                }
            }

            if(flag1 == false && flag2 == false){
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        String str = "aabcbcdbca";
        int ans = solution(str);
        System.out.println(ans);
    }
}