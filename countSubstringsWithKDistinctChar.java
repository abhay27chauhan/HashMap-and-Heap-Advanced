import java.util.HashMap;
class countSubstringsWithKDistinctChar{

    public static void remove( HashMap<Character, Integer> map, char ch){
        if(map.get(ch) == 1){
            map.remove(ch);
        }else{
            map.put(ch, map.get(ch)-1);
        }
    }

    public static int solution(String s, int k){
        int ans = 0;

        HashMap<Character, Integer> smap = new HashMap<>(); 
        HashMap<Character, Integer> bmap = new HashMap<>(); 

        int is = -1;
        int ib = -1;
        int j = -1;

        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            boolean flag3 = false;

            while(ib < s.length()-1){
                flag1 = true;

                ib++;

                char ch = s.charAt(ib);
                bmap.put(ch, bmap.getOrDefault(ch, 0) + 1);

                if(bmap.size() == k+1){
                    ib--;
                    remove(bmap, ch);
                    break;
                }
            }

            while(is < ib){
                flag2 = true;

                is++;

                char ch = s.charAt(is);
                smap.put(ch, smap.getOrDefault(ch, 0) + 1);

                if(smap.size() == k){
                    is--;
                    remove(smap, ch);
                    break;
                }
            }

            while(j<is){
                flag3 =true;

                if(smap.size() == k-1 && bmap.size() == k){
                    ans += ib-is;
                }

                j++;
                char ch = s.charAt(j);
                remove(smap, ch);
                remove(bmap, ch);

                if(smap.size() < k-1 || bmap.size() < k){
                    break;
                }
            }

            if(flag1 == false && flag2 == false && flag3 == false){
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