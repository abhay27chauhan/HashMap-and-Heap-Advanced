import java.util.HashMap;
class FindAllAnagramsInString{

    public static boolean compare(HashMap<Character, Integer> smap, HashMap<Character, Integer> pmap){
        for(char c: smap.keySet()){
            if(pmap.getOrDefault(c, 0) != smap.get(c)){
                return false;
            }
        }

        return true;
    }

    public static void solution(String s, String p){
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> pmap = new HashMap<>();

        for(int i=0; i<p.length(); i++){
            char ch = p.charAt(i);
            pmap.put(ch, pmap.getOrDefault(ch, 0) +1);
        }

        for(int i=0; i<p.length(); i++){
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) +1);
        }

        int i = p.length();
        int count  = 0;
        String ans = "";

        while(i < s.length()){
            if(compare(smap, pmap) == true){
                count++;
                ans += (i-p.length()) + " ";
            }

            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) +1);

            ch = s.charAt(i-p.length());
            if(smap.get(ch) == 1){
                smap.remove(ch);
            }else{
                smap.put(ch, smap.get(ch) -1);
            }

            i++;
        }

        if(compare(smap, pmap) == true){
            count++;
            ans += (i-p.length()) + " ";
        }

        System.out.println(count);
        System.out.println(ans);
    }

    public static void main(String[] args){
        String s = "cbaebabacd";
        String p = "abc";

        solution(s, p);
    }
}