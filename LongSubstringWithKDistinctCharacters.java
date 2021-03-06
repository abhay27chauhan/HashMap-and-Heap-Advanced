import java.util.HashMap;
class LongSubstringWithKDistinctCharacters{

    public static int solution(String str, int k){
        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int i =-1;
        int j = -1;

        while(true){
            boolean flag1 = false;
            boolean flag2 = false;

            while(i< str.length()-1){
                flag1 = true;
                i++;

                char c = str.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);

                if(map.size() < k){
                    continue;
                }else if(map.size() == k){
                    int len = i-j;
                    if(len > ans){
                        ans = len;
                    }
                }else{
                    break;
                }
            }

            while(j<i){
                flag2 = true;

                j++;
                char c= str.charAt(j);

                if(map.get(c) == 1){
                    map.remove(c);
                }else{
                    map.put(c, map.get(c) -1);
                }

                if(map.size() > k){
                    continue;
                }else if(map.size() == k){
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
        int k = 2;

        int ans = solution(str, k);
        System.out.println(ans);
    }
}